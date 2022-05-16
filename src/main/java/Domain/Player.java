package Domain;

import java.util.Date;

public class Player extends ClubStaff{

    private Page page;
    private Date birthDate;
    private String role;

    public Player(String name, String userName, String password, String email, Team team, Page page, Date birthDate, String role) {
        super(name, userName, password, email, team);
        this.page = page;
        this.birthDate = birthDate;
        this.role = role;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
