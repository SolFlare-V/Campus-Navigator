package campusnavigator.webapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Building {
    private final String name;
    private final String address;
    private final String description;
    private final int floorCount;
    private final List<Room> rooms = new ArrayList<>();

    public Building(String name, String address, String description, int floorCount) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.floorCount = floorCount;
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public Optional<Room> findRoomByNumber(String roomNumber) {
        return rooms.stream()
                .filter(room -> room.getRoomNumber().equalsIgnoreCase(roomNumber))
                .findFirst();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public int getFloorCount() {
        return floorCount;
    }
}
