package campusnavigator.webapp.model;

public class Admin extends Person {
    public Admin(String id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public String getRole() {
        return "Admin";
    }
}
