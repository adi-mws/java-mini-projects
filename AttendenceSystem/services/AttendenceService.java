package AttendenceSystem.services;

import AttendenceSystem.models.Attendence;
import AttendenceSystem.models.Student;
import AttendenceSystem.models.Subject;

import java.time.LocalDate;
import java.util.*;

public class AttendenceService {
    List<Attendence> attendence_list = new ArrayList<>();

    public void addAttendence(Map<Student, String> studentAttendence, Subject subject, LocalDate date) {
        attendence_list.add(new Attendence(studentAttendence, subject, date));
    }

    public Map<Student, String> getPerStudentSubjectAttendenceByDate(LocalDate date, Subject subject) {
        for (Attendence a : attendence_list) {
            if (a.getDate().equals(date) && a.getSubject().equals(subject)) {
                return a.getSubjectAttendence();
            }
        }
        throw new Error("Attendence not found");
    }

    public double getSubjectAttendencePercentageByDate(LocalDate date, Subject subject) {
        for (Attendence a : attendence_list) {
            if (a.getDate().equals(date) && a.getSubject().equals(subject))
                return a.getPercentage();
        }
        throw new Error("Attendence not found");
    }

    public String getAttendenceStatus(LocalDate date, Subject subject) {
        for (Attendence a : attendence_list) {
            if (a.getDate().equals(date) && a.getSubject().equals(subject)) {
                return a.getStatus();
            }
        }
        return null;
    }

}
