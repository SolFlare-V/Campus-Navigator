package campusnavigator.webapp.model;

public class Student extends Person {
    private String major;

    public Student(String id, String name, String email, String major) {
        super(id, name, email);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public String getRole() {
        return "Student";
    }
}
