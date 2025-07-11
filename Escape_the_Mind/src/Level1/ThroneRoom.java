package Level1;

import Game.PlayerState;
import Game.RoomTransitionException;
import Level1.Items.Book;

public class ThroneRoom extends Room {
    public ThroneRoom(PlayerState player) {
        super(6, "Throne Room", player);
    }

    @Override
    public void enter() {
        showOptions();
    }

    private void showOptions() {
        gui.printText("You enter a dimly lit dining hall. South of the room is a throne, in the north-east corner lies a pile of bones,");
        gui.printText("on the east wall is a bookshelf and on the west wall are crossed axes.");
        gui.printText("In the middle of the room is a long stretched dining table.");
        gui.printText("Behind it, on the north wall, is a tapestry.");

        gui.printText("\nWhat will you choose to do?");
        gui.printText("a) Go north-east");
        gui.printText("b) Go north-west");
        gui.printText("c) Go south-west");
        gui.printText("d) Look around");

        gui.setInputHandler(input -> {
            char choice = input.trim().toLowerCase().charAt(0);
            switch (choice) {
                case 'a':
                    gui.printText("You approach the bones. They don’t respond. But you feel judged.");
                    showOptions();
                    break;
                case 'b':
                    returnToNextRoom(2);
                    break;
                case 'c':
                    returnToNextRoom(3);
                    break;
                case 'd':
                    handleLookAround();
                    break;
                default:
                    gui.printText("Try again.");
                    showOptions();
                    break;
            }
        });
    }

    private void handleLookAround() {
        gui.printText("To each side of the throne are statues—knights holding their swords low.");
        gui.printText("There is a lonely bookshelf in the corner of the room");
        gui.printText("In front of the throne are two piles: a pile of gold and a pile of mushrooms.");
        gui.printText("Between the two piles is a broken sword.");

        gui.printText("a) Take a seat on the throne");
        gui.printText("b) Take mushrooms");
        gui.printText("c) Take broken sword");
        gui.printText("d) Take bag of gold");
        gui.printText("e) Approach bookshelf");

        gui.setInputHandler(input -> {
            char pick = input.trim().toLowerCase().charAt(0);
            switch (pick) {
                case 'a':
                    gui.printText("You hear the sound of stone slabs grinding against each other, as you see a flash.");
                    gui.printText("That was the last thing you saw before your head dropped to the ground and rolled away...");
                    gui.printText("GAME OVER: You were beheaded by the King’s guards.");
                    returnToDeath();
                    break;
                case 'b':
                    gui.printText("You eat the mushrooms. Everything seems fine...");
                    gui.printText("But the tapestry on the north wall... it's moving.");
                    gui.printText("You walk toward it and reach out.");
                    gui.printText("You lose your balance and fall through the tapestry into a narrow hallway.");
                    player.seeTapestryMove();
                    returnToNextRoom(7);
                    break;
                case 'c':
                    gui.printText("You pick up the broken sword fragments. A sharp sting shoots through your chest.");
                    gui.printText("You drop the pieces, letting them shatter on the ground.");
                    gui.printText("The sting subsides... but something feels wrong.");
                    player.curse();
                    break;
                case 'd':
                    gui.printText("You reach for the bag of gold.");
                    gui.printText("As you touch it, your hand begins to turn gold. You can't move your fingers.");
                    gui.printText("Your hands have turned to solid gold.");
                    player.turnHandsToGold();
                    break;
                case 'e':
                    gui.printText("You approach the bookshelf and take out the book which was in there to read");
                    Book.BookIV(gui);
                    break;
                default:
                    gui.printText("Try again. Use a, b, c, d, or e.");
                    break;
            }
            showOptions();
        });
    }

    protected void returnToDeath() {
        throw new RoomTransitionException(-1);
    }

    protected void returnToNextRoom(int roomId) {
        throw new RoomTransitionException(roomId);
    }
}
