package Domain;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Team {

    private static int id =0;
    private String teamId;
    private String name;
    private ArrayList<Player> players;
    private ArrayList<Coach> coaches;
    private ArrayList<TeamOwner> teamOwners;
    private Page page;
    private ArrayList<LocalDateTime> datesOfGames;

    public Team(String name, ArrayList<Player> players, ArrayList<Coach> coaches, ArrayList<TeamOwner> teamOwners) {
        this.name = name;
        this.players = players;
        this.coaches = coaches;
        this.teamOwners = teamOwners;
//        this.page = page;
        this.datesOfGames = new ArrayList<>();
        this.teamId = "team" + id;
        id++;
    }

    public String getTeamId() {
        return teamId;
    }

    public void addGameTime(LocalDateTime timeOfGame)
    {
        datesOfGames.add(timeOfGame);
    }

    public ArrayList<LocalDateTime> getDatesOfGames() {
        return datesOfGames;
    }
    public boolean checkAvailability(LocalDateTime time)
    {
        return !this.datesOfGames.contains(time);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(ArrayList<Coach> coaches) {
        this.coaches = coaches;
    }

    public ArrayList<TeamOwner> getTeamOwners() {
        return teamOwners;
    }

    public void setTeamOwners(ArrayList<TeamOwner> teamOwners) {
        this.teamOwners = teamOwners;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
