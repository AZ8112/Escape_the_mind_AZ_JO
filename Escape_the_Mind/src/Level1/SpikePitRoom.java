package Level1;

import Game.PlayerState;
import Game.RoomTransitionException;

public class SpikePitRoom extends Room {

    public SpikePitRoom(PlayerState player) {
        super(7, "Spike Pit Room", player);
    }

    @Override
    public void enter() {
        gui.printText("You enter a dim hallway with suspiciously uneven tiles... and a pungent, metallic smell.");
        gui.printText("Below you lies a pit of spikes. Lovely.");

        if (player.handsAreGold()) {
            gui.printText("Your golden hands can’t grip the ledge. You slip.");
            gui.printText("You flail. You fail.");
            gui.printText("You fall.");
            returnToDeath();
            return;
        }

        if (player.sawTapestryMove()) {
            gui.printText("The room wobbles slightly. You're definitely still tripping.");
            gui.printText("Do you:");
            gui.printText("a) Try to carefully move through the hallway");
            gui.printText("b) Nope out and go back to the throne room");

            waitForTripChoice();
        } else {
            gui.printText("You're not hallucinating and you don't have gold hands... What are you even doing here?");
            gui.printText("There’s nothing more for you. Back you go.");
            returnToNextRoom(6);
        }
    }

    private void waitForTripChoice() {
        gui.setInputHandler(input -> {
            if (input == null || input.isEmpty()) {
                gui.printText("You stare into the pit, pondering your life. Try again.");
                waitForTripChoice();
                return;
            }

            char choice = input.trim().toLowerCase().charAt(0);
            switch (choice) {
                case 'a':
                    boolean safe = Math.random() < 0.5;
                    if (safe) {
                        gui.printText("You waver but find footing. You move past the pit.");
                        returnToNextRoom(8);
                    } else {
                        gui.printText("You misstep.");
                        gui.printText("The pit accepts your offering.");
                        gui.printText("GAME OVER");
                        gui.printText("Note: Your poor decisions lead you here, so you fell and got turned into a skewer.");
                        returnToDeath();
                    }
                    break;

                case 'b':
                    gui.printText("You backtrack into the throne room, heart pounding.");
                    returnToNextRoom(6);
                    break;

                default:
                    gui.printText("You stand there doing nothing. Bold choice. Try a or b.");
                    waitForTripChoice(); // retry only this part, not the full room
                    break;
            }
        });
    }

    protected void returnToDeath() {
        throw new RoomTransitionException(-1);
    }

    protected void returnToNextRoom(int roomId) {
        throw new RoomTransitionException(roomId);
    }
}
