package Domain;

public class Referee extends Subscriber{

    private String training;
    private static int idCounter = 0;
    private String refId;

    public Referee(String name, String userName, String password, String email, String training) {
        super("", name, userName, password, email, "Referee");
        this.refId = "Referee" + idCounter;
        idCounter ++;
        this.setID(refId);
        if (training == null)
            throw new NullPointerException("One or more of the arguments are Null");
        this.training = training;
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        if (training != null )
            this.training = training;
        throw new NullPointerException("training argument is Null");

    }

}
