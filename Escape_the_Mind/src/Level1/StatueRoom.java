package Level1;

import Game.PlayerState;
import Game.RoomTransitionException;
import Level1.Items.Book;

public class StatueRoom extends Room{

    public  StatueRoom(PlayerState player) {
        super(2, "Statue Room", player);
    }

    @Override
    public int enter() {
        while  (true){
            System.out.println("You enter the room, in front of you a giant statue towering over you, like it’s watching you, its eyes following you wherever you move." +
                    "\n" +
                    "to your right(west) you can here the flow of water, to your left (east) is a dark and narrow path, same for the path infront of you (south) seems just as narrow.\n");

            System.out.println("There is one other thing in this room, a bookshelf with one single book taking up its empty space");


            System.out.println("\nWhat will you choose to do?\n");
            System.out.println("a) Go left (east)");
            System.out.println("b) Go right (west)");
            System.out.println("c) Walk south/forward");
            System.out.println("d) Look around");
            System.out.println("e) Walk over to the bookshelf and take the book");


            char choice = scanner.next().charAt(0);

            switch (choice){
                case 'a':
                    returnToNextRoom(4);

                case 'b':
                    returnToNextRoom(3);

                case 'c':
                    returnToNextRoom(6);

                case 'd':
                    System.out.println("As you look around you can feel the statues gaze on you.\n");
                    break;

                case 'e':
                    Book.BookII();
                    break;

                default:
                    System.out.println("Invalid input. Choose a, b, c, d or e.\n");
                    break;
            }
        }
    }
    private void returnToNextRoom(int roomId) {
        throw new RoomTransitionException(roomId);
    }
}
