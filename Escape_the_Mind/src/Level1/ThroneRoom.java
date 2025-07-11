package Level1;

import Game.PlayerState;
import Game.RoomTransitionException;
import Level1.Items.Book;

public class ThroneRoom extends Room {
    public ThroneRoom(PlayerState player) {
        super(6, "Throne Room", player);
    }

    @Override
    public int enter() {
        while (true) {
            System.out.println("You enter a dimly lit dining hall. South of the room is a throne, in the north-east corner lies a pile of bones,");
            System.out.println("on the east wall is a bookshelf and on the west wall are crossed axes.");
            System.out.println("In the middle of the room is a long stretched dining table.");
            System.out.println("Behind it, on the north wall, is a tapestry.");

            System.out.println("\nWhat will you choose to do?");
            System.out.println("a) Go north-east");
            System.out.println("b) Go north-west");
            System.out.println("c) Go south-west");
            System.out.println("d) Look around");

            char choice = scanner.next().charAt(0);

            switch (choice) {
                case 'a':
                    System.out.println("You approach the bones. They don’t respond. But you feel judged.");
                    break;

                case 'b':
                    returnToNextRoom(2);

                case 'c':
                    returnToNextRoom(3);

                case 'd':
                    handleLookAround();
                    break;

                default:
                    System.out.println("Try again.");
                    break;
            }
        }
    }

    private void handleLookAround() {
        System.out.println("To each side of the throne are statues—knights holding their swords low.");
        System.out.println("In front of the throne are two piles: a pile of gold and a pile of mushrooms.");
        System.out.println("Between the two piles is a broken sword.");

        System.out.println("a) Take a seat on the throne");
        System.out.println("b) Take mushrooms");
        System.out.println("c) Take broken sword");
        System.out.println("d) Take bag of gold");

        char pick = scanner.next().charAt(0);

        switch (pick) {
            case 'a':
                System.out.println("You hear the sound of stone slabs grinding against each other, as you see a flash.");
                System.out.println("That was the last thing you saw before your head dropped to the ground and rolled away...");
                System.out.println("GAME OVER: You were beheaded by the King’s guards.");
                returnToDeath();

            case 'b':
                System.out.println("You eat the mushrooms. Everything seems fine...");
                System.out.println("But the tapestry on the north wall... it's moving.");
                System.out.println("You walk toward it and reach out.");
                System.out.println("You lose your balance and fall through the tapestry into a narrow hallway.");
                player.seeTapestryMove();
                returnToNextRoom(7);

            case 'c':
                System.out.println("You pick up the broken sword fragments. A sharp sting shoots through your chest.");
                System.out.println("You drop the pieces, letting them shatter on the ground.");
                System.out.println("The sting subsides... but something feels wrong.");
                player.curse();
                break;

            case 'd':
                System.out.println("You reach for the bag of gold.");
                System.out.println("As you touch it, your hand begins to turn gold. You can't move your fingers.");
                System.out.println("Your hands have turned to solid gold.");
                player.turnHandsToGold();
                break;

            default:
                System.out.println("Try again. Use a, b, c, or d—unless your gold fingers can't reach the keys.");
        }
    }

    private void returnToDeath() {
        throw new RoomTransitionException(-1);
    }

    private void returnToNextRoom(int roomId) {
        throw new RoomTransitionException(roomId);
    }
}
