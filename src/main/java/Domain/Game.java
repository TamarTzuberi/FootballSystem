package Domain;

import java.time.LocalDateTime;

public class Game {


    private static int id = 0;
    private String gameId;
    private LocalDateTime time;
    private Team hostTeam;
    private Team guestTeam;
    private String field;
    private int hostScore;
    private int guestScore;
    private EventCalender calender;

    public Game(Team hostTeam, Team guestTeam) {
//        this.time = time;
        this.hostTeam = hostTeam;
        this.guestTeam = guestTeam;
//        this.field = field;
//        this.hostScore = hostScore;
//        this.guestScore = guestScore;
//        this.calender = calender;
        this.gameId = "Game" + id;
        id++;
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

    public Team getHostTeam() {
        return hostTeam;
    }

    public void setHostTeam(Team hostTeam) {
        this.hostTeam = hostTeam;
    }

    public Team getGuestTeam() {
        return guestTeam;
    }

    public void setGuestTeam(Team guestTeam) {
        this.guestTeam = guestTeam;
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
