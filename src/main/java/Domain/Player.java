package Domain;

import java.util.Date;

public class Player extends ClubStaff{

    private String playerId;
    private Page page;
    private Date birthDate;
    private String role;
    private Team team;

    public Player(String id, String name, String userName, String password, String email, Date birthDate, String role) {
        super(name, userName, password, email);
//        this.page = page;
        this.birthDate = birthDate;
        this.role = role;
        this.playerId = id;
    }

    @Override
    public void setTeam(Team team) {
        this.team = team;
    }

    public String getPlayerId() {
        return playerId;
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
