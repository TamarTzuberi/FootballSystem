package Domain;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Team {

    private String teamId;
    private String name;
    //    private ArrayList<String> playersId;
//    private ArrayList<String> coachesId;
//    private ArrayList<String> teamOwnersId;
    private ArrayList<LocalDateTime> datesOfGames;

    public Team(String id, String name) {
        if (name == null || id == null) {
            throw new NullPointerException("One or more of the arguments are Null");
        }
        this.name = name;
//        this.playersId = playersId;
//        this.coachesId = coachesId;
//        this.teamOwnersId = teamOwnersId;
        this.datesOfGames = new ArrayList<>();
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

}
