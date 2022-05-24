package Multiplayer;

import Multiplayer.Message.ClientMessage;
import Multiplayer.Message.MessageRegistry;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.json.JSONObject;

import java.net.InetSocketAddress;
import java.util.HashMap;

public class Server extends WebSocketServer {

    public static HashMap<WebSocket, Client> CLIENTS = new HashMap<>();

    private MessageRegistry messageRegistry;

    public Server(MessageRegistry messageRegistry) {
        super(new InetSocketAddress(1337));

        this.messageRegistry = messageRegistry;
    }

    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        CLIENTS.put(webSocket, new Client(webSocket));
    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
        CLIENTS.remove(webSocket);
    }

    @Override
    public void onMessage(WebSocket webSocket, String s) {
        if (CLIENTS.containsKey(webSocket)) {
            JSONObject json = new JSONObject(s);

            ClientMessage p = messageRegistry.getIngoingById(json.getInt("id"));

            if (p != null) {
                p.call(CLIENTS.get(webSocket), (JSONObject) json.get("payload"));
            }

        } else {
            CLIENTS.remove(webSocket);
        }
    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {

    }

    @Override
    public void onStart() {

    }
}
