package Level1;

import Game.PlayerState;
import Game.RoomTransitionException;

public class SpikePitRoom extends Room {

    public SpikePitRoom(PlayerState player) {
        super(7, "Spike Pit Room", player);
    }

    @Override
    public int enter() {
        try {
            System.out.println("You enter a dim hallway with suspiciously uneven tiles... and a pungent, metallic smell.");
            System.out.println("Below you lies a pit of spikes. Lovely.");

            // Gold hands = auto-fail
            if (player.handsAreGold()) {
                System.out.println("Your golden hands can’t grip the ledge. You slip.");
                System.out.println("You flail. You fail.");
                System.out.println("You fall.");
                returnToDeath();
            }

            // Mushroom wanderers get roulette
            if (player.sawTapestryMove()) {
                System.out.println("The room wobbles slightly. You're definitely still tripping.");
                System.out.println("Do you:");
                System.out.println("a) Try to carefully move through the hallway");
                System.out.println("b) Nope out and go back to the throne room");

                char choice = scanner.next().charAt(0);

                switch (choice) {
                    case 'a':
                        boolean safe = Math.random() < 0.5;
                        if (safe) {
                            System.out.println("You waver but find footing. You move past the pit.");
                            returnToNextRoom(8);
                        } else {
                            System.out.println("You misstep.");
                            System.out.println("The pit accepts your offering.");
                            System.out.println("GAME OVER");
                            System.out.println("Note: Your poor decisions lead you here, so you fell and got turned into a skewer");
                            returnToDeath();
                        }
                        break;

                    case 'b':
                        System.out.println("You backtrack into the throne room, heart pounding.");
                        returnToNextRoom(6);
                        break;

                    default:
                        System.out.println("You stand there doing nothing. Bold choice.");
                        break;
                }
            } else {
                System.out.println("You're not hallucinating and you don't have gold hands... What are you even doing here?");
                System.out.println("There’s nothing more for you. Back you go.");
                returnToNextRoom(6);
            }

        } catch (RoomTransitionException e) {
            return e.nextRoom;
        }

        System.out.println("Something went wrong. Probably you.");
        returnToNextRoom(6);

        return 0;
    }

    private void returnToDeath() {
        throw new RoomTransitionException(-1);
    }

    private void returnToNextRoom(int roomId) {
        throw new RoomTransitionException(roomId);
    }
}
