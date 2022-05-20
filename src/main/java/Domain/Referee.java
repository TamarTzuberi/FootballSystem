package Domain;

public class Referee extends Subscriber{

    private String refId;
    private String training;
    private static int id = 0;

    public Referee(String name, String userName, String password, String email, String training) {
        super(name, userName, password, email);
        if (training == null)
            throw new NullPointerException("One or more of the arguments are Null");
        this.training = training;
        refId = "referee" + id;
        id ++;
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        if (training != null )
            this.training = training;
        throw new NullPointerException("training argument is Null");

    }

    public String getRefId() {
        return refId;
    }
}
