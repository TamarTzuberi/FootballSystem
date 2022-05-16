package Domain;

import java.util.ArrayList;

public class EventCalender {

    private ArrayList<Event> gameEvent;

    public EventCalender(ArrayList<Event> gameEvent) {
        this.gameEvent = gameEvent;
    }

    public ArrayList<Event> getGameEvent() {
        return gameEvent;
    }

    public void setGameEvent(ArrayList<Event> gameEvent) {
        this.gameEvent = gameEvent;
    }
}
