package Domain;

public abstract class User {

    private String name;

    public User(String name){
        if (name ==  null)
            throw new NullPointerException("name argument is Null");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name!=null)
            this.name = name;
        else
            throw new NullPointerException("name argument is Null");
    }
}
