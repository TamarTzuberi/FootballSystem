package Domain;

public class Subscriber extends User{

    private String ID;
    private String userName;
    private String password;
    private String email;
    private String type;

    //add type to constructor
    public Subscriber(String ID, String name, String userName, String password, String email) {
        super(name);
        if (name == null || userName == null || password == null || email == null) {
            throw new NullPointerException("One or more of the arguments are Null");
        }
        this.ID = ID;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public String getType() {
        return type;
    }

    public void setUserName(String userName) {
        if( userName != null)
            this.userName = userName;
        else
            throw new NullPointerException("user Name argument is Null");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if ( password != null)
            this.password = password;
        else
            throw new NullPointerException("password argument is Null");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if( email != null)
            this.email = email;
        else
            throw new NullPointerException("email argument is Null");
    }
}
