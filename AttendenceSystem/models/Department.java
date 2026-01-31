package AttendenceSystem.models;

public class Department {
    String name;
    int maxStudents;

    public Department(String name, int maxStudents) {
        this.name = name; 
        this.maxStudents = maxStudents;
    }

    public int getMaxStudents() {
        return this.maxStudents;
    }
    
    @Override
    public String toString() {
        return name + " | "  +  maxStudents;
    }
}
