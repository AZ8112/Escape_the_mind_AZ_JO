package Level1;
import Game.PlayerState;
import Game.RoomTransitionException;

public class BarrelRoom extends Room {

    public BarrelRoom(PlayerState player) {
        super(5, "Barrel Room", player);
    }

    @Override
    public void enter() {
        showRoomOptions();
    }

    private void showRoomOptions() {
        gui.printText("You enter the formerly locked room.");
        gui.printText("\nWhat will you choose to do?\n");
        gui.printText("a) Go south through a narrow path leading to the pool room");
        gui.printText("b) Go back out the door");
        gui.printText("c) Look around");

        gui.setInputHandler(input -> {
            char choice = input.trim().toLowerCase().charAt(0);

            switch (choice) {
                case 'a':
                    returnToNextRoom(3);
                    break;
                case 'b':
                    returnToNextRoom(4);
                    break;
                case 'c':
                    handleLookAround();
                    break;
                default:
                    gui.printText("Invalid input. Choose a, b, or c.");
                    showRoomOptions();
            }
        });
    }

    private void handleLookAround() {
        gui.printText("a) Approach wooden crates");
        gui.printText("b) Approach heavy looking bags");
        gui.printText("c) Approach treasure chest");

        gui.setInputHandler(input -> {
            char pick = input.trim().toLowerCase().charAt(0);

            switch (pick) {
                case 'a':
                    handleCrates();
                    break;
                case 'b':
                    gui.printText("Some nice sand bags.");
                    showRoomOptions();
                    break;
                case 'c':
                    gui.printText("You open the treasure chest.");
                    gui.printText("You suddenly feel very tired and heavy, your eyelids closing as your mind drifts off...");
                    gui.printText("...");
                    gui.printText("You have reached the successful end of this floor.. floor 2 still in progress");
                    returnToDeath();
                    break;
                default:
                    gui.printText("Choose either a, b, or c.");
                    handleLookAround();
            }
        });
    }

    private void handleCrates() {
        gui.printText("You look at the wooden crates.");
        gui.printText("a) Open the wooden crates\nb) Leave it alone");

        gui.setInputHandler(input -> {
            char subPick = input.trim().toLowerCase().charAt(0);

            switch (subPick) {
                case 'a':
                    gui.printText("At the very bottom of the crate you can hardly make out: “don’... open the ________ _____”.");
                    player.giveKey();
                    gui.printText("You obtained a key. Hopefully not cursed.");
                    break;
                case 'b':
                    gui.printText("You leave it. Probably nothing. (But was it?)");
                    break;
                default:
                    gui.printText("Invalid input. Choose a or b.");
                    handleCrates();
                    return;
            }
            showRoomOptions();
        });
    }

    protected void returnToDeath() {
        throw new RoomTransitionException(-1);
    }

    protected void returnToNextRoom(int roomId) {
        throw new RoomTransitionException(roomId);
    }
}
