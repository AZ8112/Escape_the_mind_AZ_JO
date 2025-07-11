package Level1;

import Game.PlayerState;
import Game.RoomTransitionException;
import Level1.Items.Book;

public class SkeletonRoom extends Room {

    public SkeletonRoom(PlayerState player) {
        super(4, "Skeleton Room", player);
    }

    @Override
    public void enter() {
        showRoomOptions();
    }

    private void showRoomOptions() {
        gui.printText("You enter a room with three piles of bones scattered across the floor, a singular bookshelf, and a pile of debris in the corner.");
        gui.printText("\nWhat will you choose to do?\n");

        gui.printText("a) Go northwest to the statue room");
        gui.printText("b) Go around the corner");
        gui.printText("c) Check bookshelf");
        gui.printText("d) Look around");

        gui.setInputHandler(input -> {
            char choice = input.trim().toLowerCase().charAt(0);
            switch (choice) {
                case 'a':
                    returnToNextRoom(2);
                    break;

                case 'b':
                    handleCornerCheck();
                    break;

                case 'c':
                    gui.printText("You pick up a book and start reading it.");
                    Book.BookVI(gui);
                    showRoomOptions();
                    break;

                case 'd':
                    handleLookAround();
                    break;

                default:
                    gui.printText("Try again. Maybe this time read the letters like a functioning adventurer.");
                    showRoomOptions();
            }
        });
    }

    private void handleCornerCheck() {
        gui.printText("You walk around the corner and discover a locked door.");
        if (!player.hasKey()) {
            gui.printText("The door is locked.");
        } else if (player.isCursed()) {
            if (!player.hasWishbone()) {
                gui.printText("Your hand keeps slipping and you can’t seem to open the door.");
            } else {
                gui.printText("You manage to unlock the door with the help of your lucky wishbone.");
                returnToNextRoom(5);
                return;
            }
        } else {
            gui.printText("You unlock the door and step through.");
            returnToNextRoom(5);
            return;
        }

        showRoomOptions();
    }

    private void handleLookAround() {
        gui.printText("a) Approach pile of random bones");
        gui.printText("b) Approach pile of skulls");
        gui.printText("c) Approach pile of kneecaps");
        gui.printText("d) Approach pile of debris");

        gui.setInputHandler(input -> {
            char pick = input.trim().toLowerCase().charAt(0);

            switch (pick) {
                case 'a':
                    gui.printText("A rat runs out of it and past you, startling you while your aura points get reduced by -10.");
                    break;

                case 'b':
                    gui.printText("The hollow eyes stare right back at you. You feel very judged.");
                    break;

                case 'c':
                    gui.printText("You kneel beside the kneecaps. There's a shiny object partially buried.");
                    gui.printText("a) Pick it up\nb) Leave it alone");
                    gui.setInputHandler(sub -> {
                        char subPick = sub.trim().toLowerCase().charAt(0);
                        if (subPick == 'a') {
                            gui.printText("You pick it up. It's a pair of keys.");
                            player.giveKey();
                        } else {
                            gui.printText("You leave it. Probably cursed. Good call.");
                        }
                        showRoomOptions();
                    });
                    return;

                case 'd':
                    gui.printText("There's a clay pot.");
                    gui.printText("a) Pick it up\nb) Put it back\nc) Smash it");
                    gui.setInputHandler(sub -> {
                        char potPick = sub.trim().toLowerCase().charAt(0);
                        switch (potPick) {
                            case 'a':
                                gui.printText("You pick it up. It’s heavier than it looks.");
                                break;
                            case 'b':
                                gui.printText("You place it gently back down. Polite adventuring.");
                                break;
                            case 'c':
                                gui.printText("You smash the pot. A bone falls out of the ashes. You feel luckier.");
                                player.giveWishbone();
                                if (player.isCursed()) {
                                    gui.printText("You feel a warmth in your chest, as if a bad omen has passed.");
                                    player.liftCurse();
                                }
                                break;
                            default:
                                gui.printText("The pot is confused by your indecision.");
                        }
                        showRoomOptions();
                    });
                    return;

                default:
                    gui.printText("Choose a valid option before the bones rearrange themselves out of boredom.");
                    handleLookAround();
                    return;
            }

            showRoomOptions();
        });
    }

    protected void returnToNextRoom(int roomId) {
        throw new RoomTransitionException(roomId);
    }
}
