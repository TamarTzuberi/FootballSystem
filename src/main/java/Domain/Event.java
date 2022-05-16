package Domain;

import java.time.LocalDateTime;

public class Event {

    enum eventType {goal, offside, yellowCard, redCard, injury, offence, substitution};
    private LocalDateTime dateTime;
    private String description;
    private int minute;
    private eventType eventType;

    public Event(LocalDateTime dateTime, String description, int minute, Event.eventType eventType) {
        this.dateTime = dateTime;
        this.description = description;
        this.minute = minute;
        this.eventType = eventType;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public Event.eventType getEventType() {
        return eventType;
    }

    public void setEventType(Event.eventType eventType) {
        this.eventType = eventType;
    }
}
