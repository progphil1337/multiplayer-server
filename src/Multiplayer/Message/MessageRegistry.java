package Multiplayer.Message;

import java.util.ArrayList;

public class MessageRegistry {
    private ArrayList<Message> messages = new ArrayList<>();


    public void register(Message p) {
        this.messages.add(p);
    }

    public ClientMessage getIngoingById(int id) {

        for (Message p : messages) {
            if (p.getId() == id && p instanceof ClientMessage) {
                return (ClientMessage) p;
            }
        }

        return null;

    }
}
