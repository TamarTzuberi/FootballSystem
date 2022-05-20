package Domain;

public abstract class Policy {

    private String name;
    private String description;

    public Policy(String name, String description) {
        if ( name == null || description == null)
            throw new NullPointerException("One or more of the arguments are Null");
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if ( name != null)
            this.name = name;
        else
            throw new NullPointerException("name argument is Null");
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if ( description != null)
            this.description = description;
        else
            throw new NullPointerException("coaches argument is Null");
    }
}
