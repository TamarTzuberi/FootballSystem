package Domain;

import java.util.ArrayList;

public class Team {

    private String name;
    private ArrayList<Player> players;
    private ArrayList<Coach> coaches;
    private ArrayList<TeamOwner> teamOwners;
    private Page page;

    public Team(String name, ArrayList<Player> players, ArrayList<Coach> coaches, ArrayList<TeamOwner> teamOwners, Page page) {
        this.name = name;
        this.players = players;
        this.coaches = coaches;
        this.teamOwners = teamOwners;
        this.page = page;
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
