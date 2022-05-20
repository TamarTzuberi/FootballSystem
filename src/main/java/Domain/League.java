package Domain;

import java.util.ArrayList;

public class League {

    private String name;
    private ArrayList<String> teamsId;
    private ArrayList<String> allLeaguesId;

    public League(String name, ArrayList<String> teamsId, ArrayList<String> allLeaguesId) {
        if(name == null || teamsId == null || allLeaguesId == null)
            throw new NullPointerException("One or more of the arguments are Null");
        this.name = name;
        this.teamsId = teamsId;
        this.allLeaguesId = allLeaguesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if ( name != null)
            this.name = name;
        else
            throw new NullPointerException("name argument is Null");
    }

    public ArrayList<String> getTeams() {
        return teamsId;
    }

    public void setTeamsId(ArrayList<String> teamsId) {
        if ( teamsId != null)
            this.teamsId = teamsId;
        else
            throw new NullPointerException("teamsId argument is Null");
    }

    public ArrayList<String> getAllLeaguesId() {
        return allLeaguesId;
    }

    public void setAllLeaguesId(ArrayList<String> allLeaguesId) {
        if ( allLeaguesId != null)
            this.allLeaguesId = allLeaguesId;
        else
            throw new NullPointerException("allLeaguesId argument is Null");
    }
}
