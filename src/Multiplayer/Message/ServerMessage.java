package Multiplayer.Message;

import org.json.JSONObject;

abstract public class ServerMessage implements Message {
    abstract public JSONObject getData();

    public String getJSONString() {
        JSONObject o = new JSONObject();

        o.put("id", getId());
        o.put("payload", getData());

        return o.toString();
    }
}
