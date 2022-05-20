package Domain;

import java.util.ArrayList;
import java.util.Date;

public class Season {

    private Date startDate;
    private Date endDate;
    private ArrayList<String> allLeagues;

    public Season(Date startDate, Date endDate, ArrayList<String> allLeagues) {
        if ( startDate == null || endDate == null || allLeagues == null)
            throw new NullPointerException("One or more of the arguments are Null");
        this.startDate = startDate;
        this.endDate = endDate;
        this.allLeagues = allLeagues;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        if ( startDate != null)
            this.startDate = startDate;
        else
            throw new NullPointerException("startDate argument is Null");

    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        if ( endDate != null)
            this.endDate = endDate;
        else
            throw new NullPointerException("endDate argument is Null");

    }

    public ArrayList<String> getAllLeagues() {
        return allLeagues;
    }

    public void setAllLeagues(ArrayList<String> allLeagues) {
        if (allLeagues != null )
            this.allLeagues = allLeagues;
        else
            throw new NullPointerException("allLeagues argument is Null");
    }
}
