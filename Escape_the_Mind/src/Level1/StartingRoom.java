package Level1;
import Game.PlayerState;
import Game.RoomTransitionException;
import Level1.Items.Book;


public class StartingRoom extends Room{

    public StartingRoom(PlayerState player) {
        super(1, "Starting Room", player);
    }

    @Override
    public int enter() {
        while (true) {
            System.out.println("You open your eyes, you’re in a small room, infront of you a pit opened up in the ground and a bookshelf in the corner." +
                    "\n" +
                    "To your right a door which felt eerie and looked old and rotten." +
                    "\n" +
                    "To your left another door, this one significantly less rotten but you could hear something coming from behind it, it sounded like flowing water\n");



            System.out.println("\nWhat will you choose to do?\n");
            System.out.println("a) Go left (west)");
//            System.out.println("b) Go right (east)");
            System.out.println("b) Walk north/forward");
            System.out.println("c) Check out bookshelf");


            char choice = scanner.next().charAt(0);

            switch (choice) {
                case 'a':
                    returnToNextRoom(2);

                case 'b':
                    System.out.println("You fall into the dark pit infront of you.");
                    System.out.println("END\n");
                    System.out.println("Note: You fell into the pit and died, by breaking your neck.");
                    returnToDeath();

                case 'c':
                    System.out.println("There is one singular book and you take it and read it\n");
                    Book.BookI();
                    break;

                default:
                    System.out.println("Invalid input. Choose a, b, or c.\n");
                    break;
            }
        }
    }
    private void returnToDeath() {
        throw new RoomTransitionException(-1); // or use a game over flag
    }

    private void returnToNextRoom(int roomId) {
        throw new RoomTransitionException(roomId);
    }
}
