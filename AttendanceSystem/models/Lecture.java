package AttendanceSystem.models;

import java.util.UUID;
import java.time.LocalDate;
import java.util.*;

enum AttendanceStatus {
    PENDING,
    UPLOADED,
    REUPLOADED
}

enum LectureStatus {
    SCHEDULED,
    RESCHEDULED,
    CANCELLED,
    COMPLETED,
    ACTIVE
}

// Per Lecture Attendance system
public class Lecture {
    private UUID id;
    private Map<Student, String> subject_attendance;
    private Subject subject;
    private AttendanceStatus attendanceStatus;
    private LectureStatus status;
    private Period period;

    public Lecture(
            Subject subject,
            Period period) {

        this.subject_attendance = new HashMap<>();
        this.subject = subject;
        this.attendanceStatus = AttendanceStatus.PENDING;
        this.period = period;
        this.status = LectureStatus.SCHEDULED;
    }

    public String getPeriod() {
        return this.period.toString();
    }

    // Lecture Status Upating Helpers
    public void rescheduleLecture() {
        this.status = LectureStatus.RESCHEDULED;
    }

    public void cancelLecture() {
        this.status = LectureStatus.CANCELLED;
    }

    public void activeLecture() {
        this.status = LectureStatus.ACTIVE;
    }

    public void completeLecture() {
        this.status = LectureStatus.COMPLETED;
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

    public void addAttendance(Map<Student, String> subject_attendance) {
        this.subject_attendance = subject_attendance;
    }

    public String getAttendanceStatus() {
        return this.attendanceStatus.toString();
    }

    public void uploadAttendance() {
        this.attendanceStatus = AttendanceStatus.UPLOADED;
    }

    public void reuploadAttendance() {
        this.attendanceStatus = AttendanceStatus.REUPLOADED;
    }

    public double getPercentage() {
        if (subject_attendance.isEmpty())
            return 0;
        return (presentCount() * 100.0) / subject_attendance.size();
    }

    public Subject getSubject() {
        return subject;
    }

    public String getStatus() {
        return status.toString();
    }

    public Map<Student, String> getSubjectAttendance() {
        return subject_attendance;
    }

    @Override
    public String toString() {
        return "id: " + id +
                "Subject: " + subject +
                "\nPresent: " + presentCount() + "/" + subject_attendance.size() +
                "\nAttendance: " + String.format("%.2f", getPercentage()) + "%" +
                "\nAttedance Status: " + attendanceStatus.toString() +
                "\nLecture Status: " + this.status.toString();
    }
}

// date subject
// 1/1/26 RDBMS (1)
// 1/1/26 RDBMS (2)