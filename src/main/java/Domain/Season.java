package Domain;

import java.util.ArrayList;
import java.util.Date;

public class Season {

    private Date startDate;
    private Date endDate;
    private ArrayList<LeagueInSeason> allLeagues;

    public Season(Date startDate, Date endDate, ArrayList<LeagueInSeason> allLeagues) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.allLeagues = allLeagues;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ArrayList<LeagueInSeason> getAllLeagues() {
        return allLeagues;
    }

    public void setAllLeagues(ArrayList<LeagueInSeason> allLeagues) {
        this.allLeagues = allLeagues;
    }
}
