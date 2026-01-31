package AttendenceSystem.models;

public class Department {

    private String name;
    private int maxStudents;

    public Department(String name, int maxStudents) {
        this.name = name;
        this.maxStudents = maxStudents;
    }

    public String getName() {
        return name;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    @Override
    public String toString() {
        return name + " | max=" + maxStudents;
    }
}
