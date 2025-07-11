package Level1;

import Game.PlayerState;
import Game.RoomTransitionException;
import Level1.Items.Book;

public class StartingRoom extends Room {

    public StartingRoom(PlayerState player) {
        super(1, "Starting Room", player);
    }

    @Override
    public void enter() {
        showOptions();
    }

    private void showOptions() {
        gui.printText("You open your eyes, you’re in a small room. In front of you, a pit yawns open in the ground.");
        gui.printText("To your right, a door looks eerie and rotten.");
        gui.printText("To your left, another door seems less rotten... but from behind it, you hear flowing water.");
        gui.printText("In the corner stands a lonely bookshelf.");

        gui.printText("\nWhat will you choose to do?");
        gui.printText("a) Go left (west)");
        gui.printText("b) Walk north/forward");
        gui.printText("c) Check out bookshelf");

        gui.setInputHandler(input -> {
            if (input == null || input.trim().isEmpty()) {
                gui.printText("You decide to do nothing. Classic.");
                showOptions();
                return;
            }

            char choice = input.trim().toLowerCase().charAt(0);

            switch (choice) {
                case 'a':
                    returnToNextRoom(2);
                    break;

                case 'b':
                    gui.printText("You fall into the dark pit in front of you.");
                    gui.printText("END\n");
                    gui.printText("Note: You fell into the pit and died, by breaking your neck.");
                    returnToDeath();
                    break;

                case 'c':
                    gui.printText("There is one singular book and you take it and read it.\n");
                    Book.BookI(gui);
                    showOptions();
                    break;

                default:
                    gui.printText("Invalid input. Choose a, b, or c.\n");
                    showOptions();
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
