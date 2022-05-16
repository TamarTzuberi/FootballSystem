package Domain;

public class Referee extends Subscriber{

    private String training;

    public Referee(String name, String userName, String password, String email) {
        super(name, userName, password, email);
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
    }
}
