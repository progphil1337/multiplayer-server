package Multiplayer.Message.Client;

import Multiplayer.Client;
import Multiplayer.Message.ClientMessage;
import Multiplayer.Message.Server.PlayerListMessage;
import Multiplayer.Player.Player;
import org.json.JSONObject;

public class LoginMessage extends ClientMessage {
    @Override
    public int getId() {
        return 1;
    }

    @Override
    public void call(Client socket, JSONObject payload) {
        socket.setPlayer(new Player((String) payload.get("username")));

        socket.sendMessage(new PlayerListMessage());
    }
}
