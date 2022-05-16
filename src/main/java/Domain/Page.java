package Domain;

import java.util.ArrayList;

public class Page {

    private int pID;
    private String userName;
    private ArrayList<Subscriber> editors;

    public Page(int pID, String userName, ArrayList<Subscriber> editor) {
        this.pID = pID;
        this.userName = userName;
        this.editors = editor;
    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<Subscriber> getEditor() {
        return editors;
    }

    public void setEditor(ArrayList<Subscriber> editors) {
        this.editors = editors;
    }
}
