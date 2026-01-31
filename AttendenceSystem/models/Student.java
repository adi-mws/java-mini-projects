package AttendenceSystem.models;

public class Student {
    String name; 
    int roll; 
    Department department; 
    Attendence attendence;
    

    Student(String name, int roll, Department department, Attendence attendence) {
        this.name = name; 
        this.roll = roll; 
        this.department = department; 
        this.attendence = attendence;
    }
}
