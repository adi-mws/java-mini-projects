package AttendenceSystem.models;

import java.time.LocalDate;
import java.util.*;

enum AttendanceStatus {
    PENDING,
    UPLOADED,
    REUPLOADED
}

public class Attendence {
    Map<Student, String> subject_attendence = new HashMap<>();
    LocalDate date;
    Subject subject;
    AttendanceStatus status;

    public Attendence(
            Map<Student, String> subject_attendence,
            Subject subject,
            AttendanceStatus status) {
        this.subject_attendence = subject_attendence;
        this.subject = subject;
        this.status = status;
        this.date = LocalDate.now();
    }
    // Present count 
    int presentCount() {
        int count = 0;
        for (String value : subject_attendence.values()) {
            if ("P".equals(value)) {
                count++;
            }
        }
        return count;
    }
    // Attendance percentange 
    double getPercentage() {
        if (subject_attendence.isEmpty())
            return 0;
        return (presentCount() * 100.0) / subject_attendence.size();
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
