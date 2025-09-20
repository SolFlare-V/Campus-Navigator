package campusnavigator.webapp.controller;

import campusnavigator.webapp.model.Building;
import campusnavigator.webapp.model.Faculty;
import campusnavigator.webapp.model.Person;
import campusnavigator.webapp.model.Room;
import campusnavigator.webapp.model.Schedule;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CampusNavigator {
    private final Map<String, Building> buildings = new HashMap<>();
    private final Map<String, Person> people = new HashMap<>();
    private final Map<String, Schedule> schedules = new HashMap<>();

    public void addBuilding(Building building) {
        buildings.put(building.getName().toLowerCase(), building);
    }

    public void addPerson(Person person) {
        people.put(person.getId(), person);
    }

    public Optional<String> getDirections(String buildingName, String roomNumber) {
        Building building = buildings.get(buildingName.toLowerCase());
        if (building == null) {
            return Optional.of("Building not found: " + buildingName);
        }

        Optional<Room> roomOpt = building.findRoomByNumber(roomNumber);
        if (roomOpt.isEmpty()) {
            return Optional.of("Room '" + roomNumber + "' not found in " + building.getName());
        }

        Room room = roomOpt.get();
        return Optional.of("Directions to Room " + room.getRoomNumber() + " in " + building.getName() + ":\n" +
                "--------------------------------------------------\n" +
                "Building Location: " + building.getAddress() + "\n" +
                "Building Info: " + building.getDescription() + "\n" +
                "Floor: " + room.getFloor() + "\n" +
                "Room Info: " + room.getLocationHint());
    }

    public void createScheduleForPerson(String personId) {
        if (!schedules.containsKey(personId)) {
            schedules.put(personId, new Schedule(personId));
        }
    }

    public Optional<Schedule> getScheduleForPerson(String personId) {
        return Optional.ofNullable(schedules.get(personId));
    }

    public List<Faculty> getAvailableFaculty() {
        List<Faculty> availableFaculty = new ArrayList<>();
        for (Person person : people.values()) {
            if (person instanceof Faculty && ((Faculty) person).isAvailable()) {
                availableFaculty.add((Faculty) person);
            }
        }
        return availableFaculty;
    }

    // NEW METHOD to find the next class
    public String findNextEventForPerson(String personId) {
        Optional<Schedule> scheduleOpt = getScheduleForPerson(personId);
        if (scheduleOpt.isEmpty()) {
            return "No schedule found for ID: " + personId;
        }

        LocalTime now = LocalTime.now();
        Schedule schedule = scheduleOpt.get();

        // Iterate through the sorted map of events to find the next one
        for (Map.Entry<String, Room> entry : schedule.getEvents().entrySet()) {
            LocalTime eventTime = LocalTime.parse(entry.getKey());
            if (eventTime.isAfter(now)) {
                Room room = entry.getValue();
                String directions = getDirections(room.getBuildingName(), room.getRoomNumber()).orElse("");
                return "Your next class is at " + entry.getKey() + ".\n\n" + directions;
            }
        }

        return "You have no more classes scheduled for today.";
    }
}
