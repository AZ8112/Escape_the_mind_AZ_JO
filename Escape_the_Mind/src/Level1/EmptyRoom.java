package Level1;

import Game.PlayerState;
import Game.RoomTransitionException;

public class EmptyRoom extends Room {

    public EmptyRoom(PlayerState player) {
        super(8, "Empty Room", player);
    }

    @Override
    public void enter() {
        showRoomOptions();
    }

    private void showRoomOptions() {
        gui.printText("You enter an empty-looking room with only a piece of bread and some wooden planks.");
        gui.printText("\nWhat will you choose to do?\n");

        gui.printText("a) Go north to corridor (room 4)");
        gui.printText("b) Go west to spike pit (room 7)");
        gui.printText("c) Look around");

        gui.setInputHandler(input -> {
            char choice = input.trim().toLowerCase().charAt(0);

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
                    gui.printText("Pick an actual letter, alphabet hero.");
                    showRoomOptions();
            }
        });
    }

    private void handleLookAround() {
        gui.printText("What do you want to do?");
        gui.printText("a) Sniff the piece of bread");
        gui.printText("b) Eat the piece of bread");
        gui.printText("c) Take the piece of bread");
        gui.printText("d) Approach the wooden planks");
        gui.printText("e) Sniff the wooden planks");

        gui.setInputHandler(input -> {
            char pick = input.trim().toLowerCase().charAt(0);

            switch (pick) {
                case 'a':
                    gui.printText("You sniff the bread. Mmm. Smells like... days-old bread. Shocking.");
                    break;
                case 'b':
                    gui.printText("You eat the bread. Nothing happens, but you feel full. Emotional damage avoided.");
                    break;
                case 'c':
                    if (player.hasBread()) {
                        gui.printText("You already took the bread. You're not running a bakery.");
                    } else {
                        player.takeBread();
                        gui.printText("You take the bread. You now possess bread. The power of gluten is yours.");
                    }
                    break;
                case 'd':
                    gui.printText("You touch the wooden planks. Ouch. A tiny splinter jabs into your finger. You feel mildly inconvenienced.");
                    break;
                case 'e':
                    gui.printText("You sniff the wood. Smells like... wood. Did you expect lavender?");
                    break;
                default:
                    gui.printText("Invalid choice. Your indecision causes an existential crisis in the bread.");
            }


            showRoomOptions();
        });
    }

    protected void returnToNextRoom(int roomId) {
        throw new RoomTransitionException(roomId);
    }
}
