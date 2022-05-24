package Multiplayer;


import Multiplayer.Message.Client.LoginMessage;
import Multiplayer.Message.MessageRegistry;

public class Main {
    public static void main(String[] args) {

        MessageRegistry messageRegistry = new MessageRegistry();

        messageRegistry.register(new LoginMessage());


        Server s = new Server(messageRegistry);

        s.start();
    }
}
