package AttendenceSystem.models;

import java.time.LocalDate;
import java.util.*;

enum AttendanceStatus {
    PENDING,
    UPLOADED,
    REUPLOADED
}

public class Attendence {

    private Map<Student, String> subject_attendence;
    private LocalDate date;
    private Subject subject;
    private AttendanceStatus status;

    public Attendence(
            Map<Student, String> subject_attendence,
            Subject subject,
            LocalDate date) {

        this.subject_attendence = new HashMap<>(subject_attendence);
        this.subject = subject;
        this.status = AttendanceStatus.PENDING;
        this.date = date;
    }

    public int presentCount() {
        int count = 0;
        for (String value : subject_attendence.values()) {
            if ("P".equals(value)) {
                count++;
            }
        }
        return count;
    }

    public void updateStatus(String status) {
        this.status = AttendanceStatus.valueOf(status);
    }

    public double getPercentage() {
        if (subject_attendence.isEmpty())
            return 0;
        return (presentCount() * 100.0) / subject_attendence.size();
    }

    public Subject getSubject() {
        return subject;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStatus() {
        return status.toString();
    }

    public Map<Student, String> getSubjectAttendence() {
        return subject_attendence;
    }

    @Override
    public String toString() {
        return "Date: " + date +
                "\nSubject: " + subject +
                "\nPresent: " + presentCount() + "/" + subject_attendence.size() +
                "\nAttendance: " + String.format("%.2f", getPercentage()) + "%" +
                "\nStatus: " + status;
    }
}
