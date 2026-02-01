package AttendanceSystem.models;

import java.util.UUID;

public class Student {
    private UUID id;

    private String name;
    private int roll;
    private Department department;

    public Student(String name, int roll, Department department) {
        this.name = name;
        this.roll = roll;
        this.department = department;
        this.id = UUID.randomUUID();
    }

    public Student getById(UUID id) {
        return this;
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
        return "id: " + id + " | " + "Roll : " + roll + " | " + "Name: " + name + " | " + "Department: " + department;
    }
}
