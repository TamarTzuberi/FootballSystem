package Domain;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Team {

    private String teamId;
    private String name;
    private ArrayList<String> playersId;
    private ArrayList<String> coachesId;
    private ArrayList<String> teamOwnersId;
    private ArrayList<LocalDateTime> datesOfGames;

    public Team(String id, String name) {
        if (name == null || id == null) {
            throw new NullPointerException("One or more of the arguments are Null");
        }
        this.name = name;
        this.playersId = new ArrayList<String>();
        this.coachesId = new ArrayList<String>();
        this.teamOwnersId = new ArrayList<String>();
        this.datesOfGames = new ArrayList<LocalDateTime>();
        this.teamId = id;
    }

    public String getTeamId() {
        return teamId;
    }

    public void addGameTime(LocalDateTime timeOfGame)
    {
        if ( timeOfGame != null)
            datesOfGames.add(timeOfGame);
        else
            throw new NullPointerException("timeOfGame argument is Null");

    }

    public ArrayList<LocalDateTime> getDatesOfGames() {
        return datesOfGames;
    }

    public void setDatesOfGames(ArrayList<LocalDateTime> datesOfGames) {
        this.datesOfGames = datesOfGames;
    }

    public boolean checkAvailability(LocalDateTime time)
    {
        if ( time != null )
            return !this.datesOfGames.contains(time);
        else
            throw new NullPointerException("time argument is Null");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null)
            this.name = name;
        else
            throw new NullPointerException("name argument is Null");
    }


    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public ArrayList<String> getPlayersId() {
        return playersId;
    }

    public void setPlayersId(ArrayList<String> playersId) {
        this.playersId = playersId;
    }

    public ArrayList<String> getCoachesId() {
        return coachesId;
    }

    public void setCoachesId(ArrayList<String> coachesId) {
        this.coachesId = coachesId;
    }

    public ArrayList<String> getTeamOwnersId() {
        return teamOwnersId;
    }

    public void setTeamOwnersId(ArrayList<String> teamOwnersId) {
        this.teamOwnersId = teamOwnersId;
    }
}
