package campusnavigator.webapp.model;

public class Faculty extends Person {
    private String department;
    private boolean isAvailable;

    public Faculty(String id, String name, String email, String department) {
        super(id, name, email);
        this.department = department;
        this.isAvailable = true; // Available by default
    }

    public String getDepartment() {
        return department;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String getRole() {
        return "Faculty";
    }
}
