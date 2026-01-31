package AttendanceSystem.services;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

import AttendanceSystem.models.Attendance;
import AttendanceSystem.models.Student;
import AttendanceSystem.models.Subject;

public class AttendanceService {

    private final List<Attendance> attendanceList = new ArrayList<>();

    public void addAttendance(
            Map<Student, String> studentAttendance,
            Subject subject,
            LocalDate date) {

        if (isAttendanceAlreadyMarked(subject, date)) {
            throw new IllegalArgumentException("Attendance already marked for subject on this date");
        }
        attendanceList.add(new Attendance(studentAttendance, subject, date));
    }

    public Map<Student, String> getPerStudentAttendanceByDate(Subject subject, LocalDate date) {

        Attendance a = findAttendance(subject, date);
        return new HashMap<>(a.getSubjectAttendance());
    }

    public double getSubjectAttendancePercentageByDate(Subject subject, LocalDate date) {

        Attendance a = findAttendance(subject, date);
        return a.getPercentage();
    }

    public double getStudentAttendancePercentage(Student student, Subject subject) {
        int presentHours = 0;
        int totalHours = 0;
        int weight = subject.getHoursPerLecture();

        for (Attendance a : attendanceList) {
            if (!a.getSubject().equals(subject))
                continue;
            String status = a.getSubjectAttendance().get(student);
            if (status == null)
                continue;
            totalHours += weight;
            if ("P".equals(status)) {
                presentHours += weight;
            }
        }

        if (totalHours == 0)
            return 0;

        return (presentHours * 100.0) / totalHours;
    }

    public double getMonthlyStudentAttendancePercentage(Student student, Subject subject, YearMonth month) {
        int presentHours = 0;
        int totalHours = 0;
        int weight = subject.getHoursPerLecture();

        for (Attendance a : attendanceList) {
            if (!a.getSubject().equals(subject))
                continue;
            if (!YearMonth.from(a.getDate()).equals(month))
                continue;
            String status = a.getSubjectAttendance().get(student);
            if (status == null)
                continue;
            totalHours += weight;
            if ("P".equals(status)) {
                presentHours += weight;
            }
        }

        if (totalHours == 0)
            return 0;

        return (presentHours * 100.0) / totalHours;
    }

    public double getMonthlySubjectAttendancePercentage(Subject subject, YearMonth month) {
        double totalPercentage = 0;
        int lectureCount = 0;

        for (Attendance a : attendanceList) {
            if (a.getSubject().equals(subject) && YearMonth.from(a.getDate()).equals(month)) {
                lectureCount++;
                totalPercentage += a.getPercentage();
            }
        }
        if (lectureCount == 0)
            return 0;

        return totalPercentage / lectureCount;
    }

    public String getAttendanceStatus(
            Subject subject,
            LocalDate date) {

        return findAttendance(subject, date).getStatus();
    }

    private Attendance findAttendance(Subject subject, LocalDate date) {
        for (Attendance a : attendanceList) {
            if (a.getSubject().equals(subject) && a.getDate().equals(date)) {
                return a;
            }
        }
        throw new NoSuchElementException("Attendance not found");
    }

    public boolean isAttendanceAlreadyMarked(Subject subject, LocalDate date) {
        for (Attendance a : attendanceList) {
            if (a.getSubject().equals(subject) && a.getDate().equals(date)) {
                return true;
            }
        }
        return false;
    }
}
