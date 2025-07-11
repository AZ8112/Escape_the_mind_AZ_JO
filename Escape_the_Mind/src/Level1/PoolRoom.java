package Level1;

import Game.PlayerState;
import Game.RoomTransitionException;
import Level1.Items.Book;

public class PoolRoom extends Room {
    public PoolRoom(PlayerState player) {
        super(3, "Pool Room", player);
    }

    @Override
    public void enter() {
        showRoomOptions();
    }

    private void showRoomOptions() {
        gui.printText("You follow the sound of flowing water and enter a room with a giant pool of water taking up most of the space.");
        gui.printText("In the corner, there’s a single bookshelf.\n");

        gui.printText("\nWhat will you choose to do?");
        gui.printText("a) Go left (east) and back to the statue room");
        gui.printText("b) Go front right (south-west)");
        gui.printText("c) Walk forward left (south-east)");
        gui.printText("d) Look around");

        gui.setInputHandler(input -> {
            char choice = input.trim().toLowerCase().charAt(0);

            switch (choice) {
                case 'a':
                    returnToNextRoom(2);
                    break;
                case 'b':
                    returnToNextRoom(5);
                    break;
                case 'c':
                    returnToNextRoom(6);
                    break;
                case 'd':
                    handleLookAround();
                    break;
                default:
                    gui.printText("Invalid input. Choose a, b, c, or d.");
                    showRoomOptions(); // retry
            }
        });
    }

    private void handleLookAround() {
        gui.printText("a) Approach the bookshelf");
        gui.printText("b) Jump into the pool");

        gui.setInputHandler(input -> {
            char pick = input.trim().toLowerCase().charAt(0);
            switch (pick) {
                case 'a':
                    handleBookshelf();
                    break;
                case 'b':
                    gui.printText("Great, now you're wet.\n");
                    showRoomOptions();
                    break;
                default:
                    gui.printText("Choose either a or b.");
                    handleLookAround();
            }
        });
    }

    private void handleBookshelf() {
        gui.printText("There are two books in front of you:");
        gui.printText("1) First book");
        gui.printText("2) Second book");

        gui.setInputHandler(input -> {
            try {
                int bookChoice = Integer.parseInt(input.trim());
                switch (bookChoice) {
                    case 1:
                        Book.BookIII(gui);
                        break;
                    case 2:
                        Book.BookV(gui);
                        break;
                    default:
                        gui.printText("Choose either 1 or 2.");
                        handleBookshelf();
                        return;
                }
            } catch (NumberFormatException e) {
                gui.printText("You must type a number. Back to pool reality.");
            }
            showRoomOptions();
        });
    }

    protected void returnToNextRoom(int roomId) {
        throw new RoomTransitionException(roomId);
    }
}
