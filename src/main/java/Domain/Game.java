package Domain;

import java.time.LocalDateTime;

public class Game {


    private String gameId;
    private LocalDateTime time;
    private String hostTeamID;
    private String guestTeamID;
    private String field;
    private int hostScore;
    private int guestScore;
    private EventCalender calender;

    public Game(String id, String hostTeam, String guestTeam) {
        this.hostTeamID = hostTeam;
        this.guestTeamID = guestTeam;
        this.gameId = id;
    }

    public String getGameId() {
        return gameId;
    }

    public void gamePlacement(LocalDateTime time, String place)
    {
        this.field = place;
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getHostTeamID() {
        return hostTeamID;
    }

    public String getGuestTeamID() {
        return guestTeamID;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getHostScore() {
        return hostScore;
    }

    public void setHostScore(int hostScore) {
        this.hostScore = hostScore;
    }

    public int getGuestScore() {
        return guestScore;
    }

    public void setGuestScore(int guestScore) {
        this.guestScore = guestScore;
    }

    public EventCalender getCalender() {
        return calender;
    }

    public void setCalender(EventCalender calender) {
        this.calender = calender;
    }
}
