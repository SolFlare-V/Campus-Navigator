package campusnavigator.webapp.model;

public class Lab extends Room {
    private final int computerCount;

    public Lab(String roomNumber, int capacity, String buildingName, int floor, String locationHint, int computerCount) {
        super(roomNumber, capacity, buildingName, floor, locationHint);
        this.computerCount = computerCount;
    }

    @Override
    public String getRoomType() {
        return "Lab";
    }

    public int getComputerCount() {
        return computerCount;
    }
}
