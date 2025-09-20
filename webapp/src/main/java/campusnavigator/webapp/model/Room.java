package campusnavigator.webapp.model;

public abstract class Room {
    private final String roomNumber;
    private final int capacity;
    private final String buildingName;
    private final int floor;
    private final String locationHint;

    public Room(String roomNumber, int capacity, String buildingName, int floor, String locationHint) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.buildingName = buildingName;
        this.floor = floor;
        this.locationHint = locationHint;
    }

    public abstract String getRoomType();

    public String getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public int getFloor() {
        return floor;
    }

    public String getLocationHint() {
        return locationHint;
    }
}
