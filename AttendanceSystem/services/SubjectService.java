package AttendanceSystem.services;

import AttendanceSystem.models.Subject;
import AttendanceSystem.models.Department;
import java.util.*;

public class SubjectService {
    private List<Subject> subject_list = new ArrayList<>();

    public void addSubject(Department department, String name, int weightage) {
        subject_list.add(new Subject(name, department, weightage));
    }
    
    public Subject getSubjectByNameAndDepartment(String name, Department department) {
            for (Subject subject : subject_list) {
                if (subject.getDepartment().equals(department) && subject.getName().equals(name)) {
                    return subject;
                }
            }
           throw new Error("Subject not found");
    }
    public int getAllSubjectCount() {
        return subject_list.size();
    }

    public int getAllDepartmentSubjectsCount(Department department) {
        int count = 0;
        for (Subject subject : subject_list) {
            if (subject.getDepartment().equals(department)) {
                count++;
            }
        }
        return count;
    }

    public List<Subject> getAllDepartmentSubjects(Department department) {
        List<Subject> filteredSubjectlList = new ArrayList<>();
        for (Subject subject : subject_list) {
            if (subject.getDepartment().equals(department)) {
                filteredSubjectlList.add(subject);
            }
        }
        return filteredSubjectlList;
    }

    public void showSubject() {
        for (Subject sub : subject_list) {
            System.out.println(sub);
        }
    }
}
