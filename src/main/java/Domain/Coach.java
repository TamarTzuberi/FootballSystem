package Domain;

public class Coach extends ClubStaff{

    private Page page;
    private String training;
    private String role;

    public Coach(String name, String userName, String password, String email, Team team, Page page, String training, String role) {
        super(name, userName, password, email, team);
        this.page = page;
        this.training = training;
        this.role = role;
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
