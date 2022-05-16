package Domain;

import java.util.ArrayList;

public class League {

    private String name;
    private ArrayList<Team> teams;
    private ArrayList<LeagueInSeason> allLeagues;

    public League(String name, ArrayList<Team> teams, ArrayList<LeagueInSeason> allLeauges) {
        this.name = name;
        this.teams = teams;
        this.allLeauges = allLeauges;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public ArrayList<LeagueInSeason> getAllLeauges() {
        return allLeauges;
    }

    public void setAllLeauges(ArrayList<LeagueInSeason> allLeauges) {
        this.allLeauges = allLeauges;
    }
}
