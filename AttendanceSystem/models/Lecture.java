package AttendanceSystem.models;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

public class Lecture {

    private UUID id;

    // Student -> PRESENT / ABSENT / NA
    private Map<Student, StudentAttendanceStatus> attendance;

    private Subject subject;
    private AttendanceStatus attendanceStatus;
    private LectureStatus status;
    private Period period;

    public Lecture(
            Subject subject,
            Period period) {

        this.id = UUID.randomUUID();
        this.attendance = new HashMap<>();
        this.subject = subject;
        this.attendanceStatus = AttendanceStatus.PENDING;
        this.period = period;
        this.status = LectureStatus.SCHEDULED;
    }

    public Period getPeriod() {
        return this.period;
    }

    // Lecture status update helpers

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

    // Count present students
    public int presentCount() {

        int count = 0;

        for (StudentAttendanceStatus value : attendance.values()) {
            if (value == StudentAttendanceStatus.PRESENT) {
                count++;
            }
        }

        return count;
    }

    public void addAttendance(Map<Student, StudentAttendanceStatus> attendance) {
        this.attendance = attendance;
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

        if (attendance.isEmpty()) {
            return 0;
        }

        return (presentCount() * 100.0) / attendance.size();
    }

    public Subject getSubject() {
        return subject;
    }

    public String getStudentAttendance(Student stud) {
        return attendance.getOrDefault(stud, StudentAttendanceStatus.NA).toString();
    }

    public String getStatus() {
        return status.toString();
    }

    public Map<Student, StudentAttendanceStatus> getAttendance() {
        return attendance;
    }

    @Override
    public String toString() {

        return "ID: " + id +
                "\nSubject: " + subject +
                "\nPresent: " + presentCount() + "/" + attendance.size() +
                "\nAttendance: " +
                String.format("%.2f", getPercentage()) + "%" +
                "\nAttendance Status: " + attendanceStatus +
                "\nLecture Status: " + status;
    }
}