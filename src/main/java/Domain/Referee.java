package Domain;

public class Referee extends Subscriber{

    private String refId;
    private String training;
    private static int id = 0;

    public Referee(String name, String userName, String password, String email, String training) {
        super(name, userName, password, email);
        this.training = training;
        refId = "referee" + id;
        id ++;
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public String getRefId() {
        return refId;
    }
}
