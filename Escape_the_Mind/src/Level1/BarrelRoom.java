package Level1;
import Game.PlayerState;
import Game.RoomTransitionException;
import Level1.Items.Book;


public class BarrelRoom extends Room{

    public BarrelRoom(PlayerState player) {
        super(5, "Barrel Room", player);
    }

    @Override
    public int enter() {
        while (true) {
            System.out.println("You enter an room the formerly locked room.");


            System.out.println("\nWhat will you choose to do?\n");
            System.out.println("a) Go south through a narrow path leading to the pool room");
            System.out.println("b) Go back out the door");
            System.out.println("c) Look around");


            char choice = scanner.next().charAt(0);

            switch (choice) {
                case 'a':
                    returnToNextRoom(3);

                case 'b':
                    returnToNextRoom(4);

                case 'c':
                    handleLookAround();
                    break;

                default:
                    System.out.println("Invalid input. Choose a, b, or c.\n");
                    break;
            }
        }
    }

    private void handleLookAround() {
        System.out.println("a) Approach wooden crates");
        System.out.println("b) Approach heavy looking bags");
        System.out.println("c) Approach treasure chest");

        char pick = scanner.next().charAt(0);

        switch (pick) {
            case 'a':
                System.out.println("You look at the wooden crates.");
                System.out.println("a) Open the wooden crates\nb) Leave it alone");
                char subPick = scanner.next().charAt(0);
                if (subPick == 'a') {
                    System.out.println("At the very bottom of the crate which you were hardly able to make out was something written like “don’... open the ________ _____”");
                    player.giveKey();
                } else {
                    System.out.println("You leave it. Probably nothing.");
                }
                break;

            case 'b':
                System.out.println("Some nice sand bags.");
                break;

            case 'c':
                System.out.println("You open the treasure chest.");
                System.out.println("You suddenly feel very tired and heavy, your eyelids closing as your mind drifts off...");
                System.out.println("...");
                System.out.println("You have reached the successful end of this floor.. floor 2 still in progress");
                returnToDeath();


            default:
                System.out.println("Choose either a, b or c.");
        }
    }

    private void returnToDeath() {
        throw new RoomTransitionException(-1);
    }

    private void returnToNextRoom(int roomId) {
        throw new RoomTransitionException(roomId);
    }
}
