package Domain;

public class ClubStaff extends Subscriber{

    private Team team;

    public ClubStaff(String name, String userName, String password, String email) {
        super(name, userName, password, email);
//        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
