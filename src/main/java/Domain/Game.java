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

    public Game(String id, String hostTeamId, String guestTeamId) {
        if (id == null || hostTeamId == null || guestTeamId == null) {
            throw new NullPointerException("One or more of the arguments are Null");
        }
        this.hostTeamID = hostTeamId;
        this.guestTeamID = guestTeamId;
        this.gameId = id;
    }


    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        if ( time!= null)
            this.time = time;
        else
            throw new NullPointerException("time is Null");

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
        if ( field!= null)
            this.field = field;
        else
            throw new NullPointerException("field is Null");
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        if (gameId != null)
            this.gameId = gameId;
        else
            throw new NullPointerException("game id is Null");

    }

}
