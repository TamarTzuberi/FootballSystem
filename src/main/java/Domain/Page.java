package Domain;

import java.util.ArrayList;

public class Page {

    private int pID;
    private String userName;
    private ArrayList<String> editors;

    public Page(int pID, String userName, ArrayList<String> editor) {
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

    public ArrayList<String> getEditor() {
        return editors;
    }

    public void setEditor(ArrayList<String> editors) {
        this.editors = editors;
    }
}
