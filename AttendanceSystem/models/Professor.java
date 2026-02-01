package AttendanceSystem.models;

import java.util.UUID;

public class Professor {
    private UUID id;
    String name;
    Department department;

    public Professor(String name, Department department) {
        this.name = name;
        this.department = department;
        this.id = UUID.randomUUID();
    }

    public Professor getById(UUID id) {
        return this;
    }

    @Override
    public String toString() {
        return "id: " + id + " | " + "Name: " + this.name + " | " + this.department.getName();
    }
}
