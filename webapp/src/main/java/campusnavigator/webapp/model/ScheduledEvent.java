package campusnavigator.webapp.model;

// Import the Room class to make it visible to this file
import campusnavigator.webapp.model.Room;

public class ScheduledEvent {
    private String eventName;
    private String eventType; // e.g., "Lecture", "Lab", "Seminar", "Office Hours"
    private Room location;

    public ScheduledEvent(String eventName, String eventType, Room location) {
        this.eventName = eventName;
        this.eventType = eventType;
        this.location = location;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public Room getLocation() {
        return location;
    }
}

