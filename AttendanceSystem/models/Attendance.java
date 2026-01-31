package AttendanceSystem.models;

import java.time.LocalDate;
import java.util.*;

enum AttendanceStatus {
    PENDING,
    UPLOADED,
    REUPLOADED
}

// Per Lecture Attendance system
public class Attendance {

    private Map<Student, String> subject_attendance;
    private LocalDate date;
    private Subject subject;
    private AttendanceStatus status;

    public Attendance(
            Map<Student, String> subject_attendance,
            Subject subject,
            LocalDate date) {

        this.subject_attendance = new HashMap<>(subject_attendance);
        this.subject = subject;
        this.status = AttendanceStatus.PENDING;
        this.date = date;
    }

    // Total attendance percent of the particular lecture
    public int presentCount() {
        int count = 0;
        for (String value : subject_attendance.values()) {
            if ("P".equals(value)) {
                count++;
            }
        }
        return count;
    }

    public void uploadAttendance() {
        this.status = AttendanceStatus.UPLOADED;
    }

    public void reuploadAttendance() {
        this.status = AttendanceStatus.REUPLOADED;
    }

    public double getPercentage() {
        if (subject_attendance.isEmpty())
            return 0;
        return (presentCount() * 100.0) / subject_attendance.size();
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

    public Map<Student, String> getSubjectAttendance() {
        return subject_attendance;
    }

    @Override
    public String toString() {
        return "Date: " + date +
                "\nSubject: " + subject +
                "\nPresent: " + presentCount() + "/" + subject_attendance.size() +
                "\nAttendance: " + String.format("%.2f", getPercentage()) + "%" +
                "\nStatus: " + status;
    }
}
