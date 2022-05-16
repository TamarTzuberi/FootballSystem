package Domain;

public class LeagueInSeason {

    private Policy policy;
    private Season season;
    private League league;

    public LeagueInSeason(Policy policy, Season season, League league) {
        this.policy = policy;
        this.season = season;
        this.league = league;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public Season getSeason() {
        return season;
    }
}
