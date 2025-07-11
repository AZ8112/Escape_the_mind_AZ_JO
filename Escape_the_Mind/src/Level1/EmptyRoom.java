package Level1;

import Game.PlayerState;
import Game.RoomTransitionException;

public class EmptyRoom extends Room {

    public EmptyRoom(PlayerState player) {
        super(8, "Empty Room", player);
    }

    @Override
    public int enter() {
        try {
            while (true) {
                System.out.println("You enter an empty-looking room with only a piece of bread and some wooden planks.");
                System.out.println("\nWhat will you choose to do?\n");

                System.out.println("a) Go north to corridor (room 4)");
                System.out.println("b) Go west to spike pit (room 7)");
                System.out.println("c) Look around");

                char choice = scanner.next().charAt(0);

                switch (choice) {
                    case 'a':
                        returnToNextRoom(4);
                        break;

                    case 'b':
                        returnToNextRoom(7);
                        break;

                    case 'c':
                        handleLookAround();
                        break;

                    default:
                        System.out.println("Pick an actual letter, alphabet hero.");
                }
            }

        } catch (RoomTransitionException e) {
            return e.nextRoom;
        }
    }

    private void handleLookAround() {
        System.out.println("What do you want to do?");
        System.out.println("a) Sniff the piece of bread");
        System.out.println("b) Eat the piece of bread");
        System.out.println("c) Take the piece of bread");
        System.out.println("d) Approach the wooden planks");
        System.out.println("e) Sniff the wooden planks");

        char pick = scanner.next().charAt(0);

        switch (pick) {
            case 'a':
                System.out.println("You sniff the bread. Mmm. Smells like... days-old bread. Shocking.");
                break;

            case 'b':
                System.out.println("You eat the bread. Nothing happens, but you feel full. Emotional damage avoided.");
                break;

            case 'c':
                if (player.hasBread()) {
                    System.out.println("You already took the bread. You're not running a bakery.");
                } else {
                    player.takeBread();
                    System.out.println("You take the bread. You now possess bread. The power of gluten is yours.");
                }
                break;


            case 'd':
                System.out.println("You touch the wooden planks. Ouch. A tiny splinter jabs into your finger. You feel mildly inconvenienced.");
                break;

            case 'e':
                System.out.println("You sniff the wood. Smells like... wood. Did you expect lavender?");
                break;

            default:
                System.out.println("Invalid choice. Your indecision causes an existential crisis in the bread.");
        }
    }

    private void returnToNextRoom(int roomId) {
        throw new RoomTransitionException(roomId);
    }
}
