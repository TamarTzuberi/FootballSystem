package Domain;

import java.util.ArrayList;

public class Fan extends Subscriber{

    private ArrayList<Page> favoritePages;

    public Fan(String name, String userName, String password, String email) {
        super(name, userName, password, email);
    }
}
