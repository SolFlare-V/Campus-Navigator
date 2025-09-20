package campusnavigator.webapp.controller;

// Import all the model classes needed for setup
import campusnavigator.webapp.model.*;
// Explicitly import the CampusNavigator class
import campusnavigator.webapp.controller.CampusNavigator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
public class CampusApiController {

    private final CampusNavigator navigator;

    public CampusApiController() {
        this.navigator = new CampusNavigator();
        // Call the method to load our sample campus data
        setupInitialData();
    }

    // This creates a URL: /api/directions?building=...&room=...
    @GetMapping("/api/directions")
    public String getDirections(@RequestParam String building, @RequestParam String room) {
        Optional<String> directions = navigator.getDirections(building, room);
        return directions.orElse("Directions not found for the specified room.");
    }

    // NEW ENDPOINT for the schedule feature
    @GetMapping("/api/myschedule")
    public String getMySchedule(@RequestParam String personId) {
        return navigator.findNextEventForPerson(personId);
    }

    // This method is copied from your original Main.java file to load sample data
    private void setupInitialData() {
        Building techBuilding = new Building("Technology Center", "123 Tech Way", "The glass building with the large clock tower.", 3);
        Building scienceBuilding = new Building("Science Hall", "456 Discovery Ave", "The older brick building across from the main quad.", 4);

        Room cs101 = new LectureHall("101", 150, techBuilding.getName(), 1, "First floor, main auditorium to the left of the entrance.", true);
        Room csLab = new Lab("102", 30, techBuilding.getName(), 1, "First floor, past the auditorium.", 30);
        Room profAdaOffice = new Office("210", techBuilding.getName(), 2, "Second floor, in the faculty wing.", "Dr. Ada Lovelace");
        techBuilding.addRoom(cs101);
        techBuilding.addRoom(csLab);
        techBuilding.addRoom(profAdaOffice);

        Room phy201 = new LectureHall("201", 200, scienceBuilding.getName(), 2, "Second floor, largest hall.", true);
        Room bioLab = new Lab("105", 25, scienceBuilding.getName(), 1, "First floor, near the west entrance.", 0);
        scienceBuilding.addRoom(phy201);
        scienceBuilding.addRoom(bioLab);

        navigator.addBuilding(techBuilding);
        navigator.addBuilding(scienceBuilding);

        Person studentJohn = new Student("S001", "John Doe", "john.d@university.edu", "Computer Science");
        Person facultyAda = new Faculty("F101", "Dr. Ada Lovelace", "ada.l@university.edu", "Computer Science");
        ((Faculty) facultyAda).setAvailable(false);
        Person adminBoss = new Admin("A500", "Admin Boss", "admin@university.edu");

        navigator.addPerson(studentJohn);
        navigator.addPerson(facultyAda);
        navigator.addPerson(adminBoss);

        navigator.createScheduleForPerson(studentJohn.getId());
        Optional<Schedule> johnSchedule = navigator.getScheduleForPerson("S001");
        johnSchedule.ifPresent(schedule -> {
            schedule.addEvent("09:00", cs101);
            schedule.addEvent("11:00", csLab);
            schedule.addEvent("15:00", phy201); // Added one more class for testing
        });

        navigator.createScheduleForPerson(facultyAda.getId());
        Optional<Schedule> adaSchedule = navigator.getScheduleForPerson("F101");
        adaSchedule.ifPresent(schedule -> {
            schedule.addEvent("09:00", cs101);
            schedule.addEvent("14:00", profAdaOffice);
        });
    }
}
