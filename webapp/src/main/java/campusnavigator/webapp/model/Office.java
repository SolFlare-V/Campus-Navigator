package campusnavigator.webapp.model;

public class Office extends Room {
    private final String occupantName;

    public Office(String roomNumber, String buildingName, int floor, String locationHint, String occupantName) {
        super(roomNumber, 1, buildingName, floor, locationHint); // Capacity is always 1 for an office
        this.occupantName = occupantName;
    }

    @Override
    public String getRoomType() {
        return "Office";
    }

    public String getOccupantName() {
        return occupantName;
    }
}
