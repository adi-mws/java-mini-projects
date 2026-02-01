package AttendanceSystem.models;

import java.util.UUID;

public class Department {
    private UUID id;
    private String name;
    private int maxStudents;
    public Department(String name, int maxStudents) {
        this.name = name;
        this.maxStudents = maxStudents;
        this.id = UUID.randomUUID();
    }

    public Department getById(UUID id) {
        return this;
    }

    public String getName() {
        return name;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    @Override
    public String toString() {
        return "id: " +  id + " Name: " + name + " | Max Student = " + maxStudents;
    }
}
