package Domain;

public class Referee extends Subscriber{

    private String training;

    public Referee(String name, String userName, String password, String email, String training) {
        super(name, userName, password, email);
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
