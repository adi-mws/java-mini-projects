package AttendenceSystem.services;

import java.util.*;
import AttendenceSystem.models.Department;

public class DepartmentService {
    List<Department> department_list = new ArrayList<>();

    List<Department> getDepartments() {
        return this.department_list;
    }

    public void addDepartment(String name, int maxStudents) {
        for (Department d : department_list) {
            if (d.getName().equals(name)) {
                throw new IllegalArgumentException("Department already exists");
            }
        }
        department_list.add(new Department(name, maxStudents));
    }

    public Department getDepartmentByName(String name) {
        for (Department d : department_list) {
            if (d.getName().equals(name)) {
                return d;
            }
        }
        return null;
    }

    public void showAllDepartments() {
        for (Department d : department_list) {
            System.out.println(d);
        }
    }

}
