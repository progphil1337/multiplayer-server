package Multiplayer.Player;

public class Player {
    private String name;
    private int x = 0;
    private int y = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
