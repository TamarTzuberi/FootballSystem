package Domain;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Team {

    private String teamId;
    private String name;
    private ArrayList<String> playersId;
    private ArrayList<String> coachesId;
    private ArrayList<String> teamOwnersId;
    private Page page;
    private ArrayList<LocalDateTime> datesOfGames;

    public Team(String id, String name, ArrayList<String> playersId, ArrayList<String> coachesId, ArrayList<String> teamOwnersId) {
        if (name == null || id == null || playersId == null || coachesId == null || teamOwnersId == null) {
            throw new NullPointerException("One or more of the arguments are Null");
        }
        this.name = name;
        this.playersId = playersId;
        this.coachesId = coachesId;
        this.teamOwnersId = teamOwnersId;
//        this.page = page;
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
    public boolean checkAvailability(LocalDateTime time)
    {
        if ( time != null)
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

    public ArrayList<String> getPlayers() {
        return playersId;
    }

    public void setPlayers(ArrayList<String> playersId) {
        if (playersId != null)
            this.playersId = playersId;
        else
            throw new NullPointerException("players argument is Null");
    }

    public ArrayList<String> getCoaches() {
        return coachesId;
    }

    public void setCoaches(ArrayList<String> coachesId) {
        if (coachesId != null)
            this.coachesId = coachesId;
        else
            throw new NullPointerException("coaches argument is Null");

    }

    public ArrayList<String> getTeamOwners() {
        return teamOwnersId;
    }

    public void setTeamOwners(ArrayList<String> teamOwnersId) {
        if ( teamOwnersId != null)
            this.teamOwnersId = teamOwnersId;
        else
            throw new NullPointerException("teamOwners argument is Null");
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        if (page != null)
            this.page = page;
        else
            throw new NullPointerException("page argument is Null");

    }
}
