package Multiplayer.Message;

import Multiplayer.Client;
import org.json.JSONObject;

public abstract class ClientMessage implements Message {
    abstract public void call(Client socket, JSONObject payload);
}
