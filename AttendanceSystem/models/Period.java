package AttendanceSystem.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Period {

    private UUID id;
    LocalDateTime startDateTime;
    LocalDateTime endDateTime;

    public Period(LocalDateTime sDateTime, LocalDateTime eDateTime) {
        this.startDateTime = sDateTime;
        this.endDateTime = eDateTime;
        this.id = UUID.randomUUID();
    }

    public Period getById(UUID id) {
        return this;
    }

    public LocalDateTime getStartTime() {
        return startDateTIme
    }

    // We are not adding duration because it is subject-based attendance subject
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        return "id: " + this.id +
                "Start: " + startDateTime.format(formatter) +
                " | End: " + endDateTime.format(formatter);
    }

}