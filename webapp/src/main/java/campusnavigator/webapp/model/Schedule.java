package campusnavigator.webapp.model;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Schedule {
    private final String personId;
    // Using a SortedMap to keep events in chronological order automatically
    private final SortedMap<String, Room> events = new TreeMap<>();

    public Schedule(String personId) {
        this.personId = personId;
    }

    public String getPersonId() {
        return personId;
    }

    public void addEvent(String time, Room room) {
        events.put(time, room);
    }

    /**
     * Returns the map of events for this schedule.
     * This is the method that was missing.
     * @return A map where the key is the time (e.g., "09:00") and the value is the Room object.
     */
    public Map<String, Room> getEvents() {
        return events;
    }
}
