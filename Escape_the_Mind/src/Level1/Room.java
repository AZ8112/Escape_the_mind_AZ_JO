package Level1;
import Level1.Items.Book;
import java.util.Scanner;
// cyan \u001B[36m

public abstract class Room {
    protected int id;
    protected String name;
    protected Scanner scanner = new Scanner(System.in);

    public Room(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public abstract int enter(); // Returns ID of next room
}





