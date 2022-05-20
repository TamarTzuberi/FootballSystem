package Domain;

public class LeagueInSeason {

    private Policy policy;
    private Season season;
    private League league;

    public LeagueInSeason(Policy policy, Season season, League league) {
        if (policy == null || season == null || league == null)
            throw new NullPointerException("One or more of the arguments are Null");
        this.policy = policy;
        this.season = season;
        this.league = league;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        if ( policy != null)
            this.policy = policy;
        else
            throw new NullPointerException("policy argument is Null");
    }

    public Season getSeason() {
        return season;
    }
    public void setSeason(Season season) {
        if ( season != null)
            this.season = season;
        else
            throw new NullPointerException("season argument is Null");
    }


    public League getLeague() {
        return league;
    }
    public void setLeague(League league) {
        if ( league != null)
            this.league = league;
        else
            throw new NullPointerException("league argument is Null");
    }
}
