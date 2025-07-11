package Level1;
import Game.PlayerState;
import java.util.Scanner;
// cyan \u001B[36m

public abstract class Room {
    protected int id;
    protected String name;
    protected Scanner scanner = new Scanner(System.in);
    protected PlayerState player;

    public Room(int id, String name, PlayerState player) {
        this.id = id;
        this.name = name;
        this.player = player;
    }

    public int getId() {
        return id;
    }

    public abstract int enter(); // Returns ID of next room
}





