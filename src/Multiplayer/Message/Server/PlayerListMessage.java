package Multiplayer.Message.Server;

import Multiplayer.Client;
import Multiplayer.Message.ServerMessage;
import Multiplayer.Server;
import org.json.JSONArray;
import org.json.JSONObject;

public class PlayerListMessage extends ServerMessage {
    @Override
    public int getId() {
        return 1;
    }

    @Override
    public JSONObject getData() {
        JSONObject o = new JSONObject();

        JSONArray arr = new JSONArray();

        for (Client c : Server.CLIENTS.values()) {
            arr.put(c.getPlayer().getName());
        }

        o.put("names", arr);

        return o;
    }
}
