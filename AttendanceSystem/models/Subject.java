package AttendanceSystem.models;

public class Subject {
    private String name;
    private Department department;
    private int hoursPerLecture;   

    public Subject(String name, Department department, int hoursPerLecture) {
        if (name == null || department == null) {
            throw new IllegalArgumentException("Subject name and department cannot be null");
        }
        if (hoursPerLecture <= 0) {
            throw new IllegalArgumentException("Hours per lecture must be positive");
        }

        this.name = name;
        this.department = department;
        this.hoursPerLecture = hoursPerLecture;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public int getHoursPerLecture() {
        return hoursPerLecture;
    }

    @Override
    public String toString() {
        return name + " | " + department + " | " + hoursPerLecture + " hrs";
    }
}
