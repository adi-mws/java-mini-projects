package AttendanceSystem.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.*;

import AttendanceSystem.models.Lecture;
import AttendanceSystem.models.Student;
import AttendanceSystem.models.Subject;
import AttendanceSystem.models.Period;

public class LectureService {

    private final List<Lecture> lectures_list = new ArrayList<>();

    // Creation and status changes for the lecture
    public void createLecture(Subject subject, Period period) {
        lectures_list.add(new Lecture(subject, period));
    }

    public void rescheduleLecture(Lecture lect) {
        lect.rescheduleLecture();
    }

    public void cancelLecture(Lecture lect) {
        lect.cancelLecture();
    }

    public void completeLecture(Lecture lect) {
        lect.completeLecture();
    }

    public void activeLecture(Lecture lect) {
        lect.activeLecture();
    }

    // Attendance services (creation and status updates)
    public void saveAttendance(Lecture lecture, Map<Student, String> list) {
        for (Lecture lect : lectures_list) {
            if (lect == lecture) {
                lect.addAttendance(list);
            }
        }
    }

    public void uploadAttendance(Lecture lecture) {
        lecture.uploadAttendance();
    }

    public void reuploadAttendance(Lecture lecture, Map<Student, String> list) {
        boolean isUploaded = lecture.getAttendanceStatus().equals("UPLODED");
        if (isUploaded) {
            lecture.addAttendance(list);
            lecture.reuploadAttendance();
        } else {
            throw new Error("Attendance is not uploaded");
        }

    }
    // Lecture services helpers 
    private int totalLectureCount() {
        return this.lectures_list.size();
    }
   private int totalLectureCountInMonth(YearMonth month) {
    int count = 0;

    for (Lecture lecture : lectures_list) {
        LocalDateTime start = lecture.getPeriod().getStartTime();

        if (YearMonth.from(start).equals(month)) {
            count++;
        }
    }
    return count;
}

    // Attendance services (statistics and reteriving data)

}
