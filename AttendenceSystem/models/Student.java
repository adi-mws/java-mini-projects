package AttendenceSystem.models;

public class Student {

    private String name;
    private int roll;
    private Department department;

    public Student(String name, int roll, Department department) {
        this.name = name;
        this.roll = roll;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getRoll() {
        return roll;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return roll + " | " + name + " | " + department;
    }
}
