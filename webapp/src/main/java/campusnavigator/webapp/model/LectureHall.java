package campusnavigator.webapp.model;

public class LectureHall extends Room {
    private final boolean hasProjector;

    public LectureHall(String roomNumber, int capacity, String buildingName, int floor, String locationHint, boolean hasProjector) {
        super(roomNumber, capacity, buildingName, floor, locationHint);
        this.hasProjector = hasProjector;
    }

    @Override
    public String getRoomType() {
        return "Lecture Hall";
    }

    public boolean hasProjector() {
        return hasProjector;
    }
}
