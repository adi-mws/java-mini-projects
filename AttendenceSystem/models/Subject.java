package AttendenceSystem.models;

public class Subject {
    String name;
    Department department;
    int weightage;

    public Subject(String name, Department department, int weightage) {
        this.name = name;
        this.department = department;
        this.weightage = weightage;
    }

    @Override
    public String toString() {
        return name + " | " + department.toString();
    }
}
