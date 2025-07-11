package Level1;

import Game.PlayerState;
import Game.RoomTransitionException;
import Level1.Items.Book;

public class StatueRoom extends Room {

    public StatueRoom(PlayerState player) {
        super(2, "Statue Room", player);
    }

    @Override
    public void enter() {
        showOptions();
    }

    private void showOptions() {
        gui.printText("You enter the room. In front of you towers a giant statue, its eyes seemingly tracking your every move.");
        gui.printText("To your right (west), you hear the flow of water.");
        gui.printText("To your left (east) is a dark and narrow path.");
        gui.printText("The path in front of you (south) seems just as narrow.");
        gui.printText("There is also a bookshelf with one lone book taking up its only shelf.\n");

        gui.printText("What will you choose to do?");
        gui.printText("a) Go left (east)");
        gui.printText("b) Go right (west)");
        gui.printText("c) Walk south/forward");
        gui.printText("d) Look around");
        gui.printText("e) Walk over to the bookshelf and take the book");

        gui.setInputHandler(input -> {
            if (input == null || input.trim().isEmpty()) {
                gui.printText("You decide to stand there awkwardly. Try again.");
                showOptions();
                return;
            }

            char choice = input.trim().toLowerCase().charAt(0);

            switch (choice) {
                case 'a':
                    returnToNextRoom(4);
                    break;
                case 'b':
                    returnToNextRoom(3);
                    break;
                case 'c':
                    returnToNextRoom(6);
                    break;
                case 'd':
                    gui.printText("As you look around, you feel the statue's gaze burning into your soul. Or your back. Hard to tell.");
                    showOptions();
                    break;
                case 'e':
                    Book.BookII(gui);
                    showOptions();
                    break;
                default:
                    gui.printText("Invalid input. Choose a, b, c, d or e.");
                    showOptions();
                    break;
            }
        });
    }

    protected void returnToNextRoom(int roomId) {
        throw new RoomTransitionException(roomId);
    }
}
