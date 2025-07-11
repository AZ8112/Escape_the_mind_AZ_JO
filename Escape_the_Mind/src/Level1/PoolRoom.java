package Level1;

import Game.PlayerState;
import Game.RoomTransitionException;
import Level1.Items.Book;

public class PoolRoom extends Room {
    public PoolRoom(PlayerState player) {
        super(3, "Pool Room", player);
    }

    @Override
    public int enter() {
        while (true) {
            System.out.println("You follow the sound of flowing water and enter a room with a giant pool of water taking up most of the space.");
            System.out.println("In the corner, there’s a single bookshelf.\n");

            System.out.println("\nWhat will you choose to do?\n");
            System.out.println("a) Go left (east) and back to the statue room");
            System.out.println("b) Go front right (south-west)");
            System.out.println("c) Walk forward left (south-east)");
            System.out.println("d) Look around");

            char choice = scanner.next().charAt(0);

            switch (choice) {
                case 'a':
                    returnToNextRoom(2);

                case 'b':
                    returnToNextRoom(5);

                case 'c':
                    returnToNextRoom(6);

                case 'd':
                    handleLookAround();
                    break;

                default:
                    System.out.println("Invalid input. Choose a, b, c, or d.\n");
            }
        }
    }

    private void handleLookAround() {
        System.out.println("a) Approach the bookshelf");
        System.out.println("b) Jump into the pool");

        char pick = scanner.next().charAt(0);

        switch (pick) {
            case 'a':
                System.out.println("There are two books in front of you:");
                System.out.println("1) First book");
                System.out.println("2) Second book");

                try {
                    int bookChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (bookChoice) {
                        case 1:
                            Book.BookIII();
                            break;
                        case 2:
                            Book.BookV();
                            break;
                        default:
                            System.out.println("Choose either 1 or 2.\n");
                    }
                } catch (Exception e) {
                    System.out.println("You must type a number. Back to pool reality.\n");
                    scanner.nextLine();
                }
                break;

            case 'b':
                System.out.println("Great, now you're wet.\n");
                break;

            default:
                System.out.println("Choose either a or b.\n");
        }
    }

    private void returnToNextRoom(int roomId) {
        throw new RoomTransitionException(roomId);
    }
}
