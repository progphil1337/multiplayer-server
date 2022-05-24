package Multiplayer;

import Multiplayer.Message.ServerMessage;
import Multiplayer.Player.Player;
import org.java_websocket.WebSocket;

public class Client {

    private WebSocket socket;
    private Player player = null;

    public Client(WebSocket socket) {
        this.socket = socket;
    }

    public void setPlayer(Player player) {
        if (this.player == null) {
            this.player = player;
        }
    }

    public void sendMessage(ServerMessage p) {
        System.out.println(p.getJSONString());
        send(p.getJSONString());
    }

    public void send(String msg) {
        socket.send(msg);
    }

    public Player getPlayer() {
        return player;
    }
}
