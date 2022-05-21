package Domain;

public class Coach extends ClubStaff{

    private Page page;
    private String training;
    private String role;
    private Team team;

    public Coach(String name, String userName, String password, String email, String training, String role) {
        super(name, userName, password, email);
//        this.page = page;
        this.training = training;
        this.role = role;

    }

    @Override
    public void setTeam(Team team) {
        this.team = team;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
