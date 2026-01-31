package AttendanceSystem.services;

import java.util.*;

import AttendanceSystem.models.*;

public class StudentService {

    private final Map<Integer, Student> students = new HashMap<>();

    public void addStudent(String name, int roll, Department department) {
        if (students.containsKey(roll)) {
            throw new IllegalArgumentException("Student with roll already exists");
        }

        Student student = new Student(name, roll, department);
        students.put(roll, student);
    }

    public Student getStudentByRoll(int roll) {
        return students.get(roll);
    }

    public List<Student> getStudentsByDepartment(Department department) {
        List<Student> result = new ArrayList<>();

        for (Student s : students.values()) {
            if (s.getDepartment().equals(department)) {
                result.add(s);
            }
        }
        return result;
    }

    public void showAllStudents() {
        for (Student s : students.values()) {
            System.out.println(s);
        }
    }
}
