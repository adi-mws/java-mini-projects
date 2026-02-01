package AttendanceSystem.models;
import java.util.UUID;
public class Subject {
    private UUID id;
    private String name;
    private Department department;
    private Professor professor; 
    private int hoursPerLecture;   

    public Subject(String name, Department department, Professor professor, int hoursPerLecture) {
        if (name == null || department == null) {
            throw new IllegalArgumentException("Subject name and department cannot be null");
        }
        if (hoursPerLecture <= 0) {
            throw new IllegalArgumentException("Hours per lecture must be positive");
        }

        this.name = name;
        this.professor = professor;
        this.department = department;
        this.hoursPerLecture = hoursPerLecture;
        this.id = UUID.randomUUID();
    }
    public Subject getById(UUID id) {
        return this;
    }
    public String getName() {
        return name;
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public Department getDepartment() {
        return department;
    }

    public int getHoursPerLecture() {
        return hoursPerLecture;
    }

    @Override
    public String toString() {
        return "id: " + id + " | " + "Name: " +  name + " | " + "Department: " +  department + " | " + "Hours Per Lecture: " +  hoursPerLecture + " hrs";
    }
}
