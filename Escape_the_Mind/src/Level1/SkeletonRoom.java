package Level1;

import Game.PlayerState;
import Game.RoomTransitionException;
import Level1.Items.Book;

public class SkeletonRoom extends Room {

    public SkeletonRoom(PlayerState player) {
        super(4, "Skeleton Room", player);
    }

    @Override
    public int enter() {
        try {
            while (true) {
                System.out.println("You enter a room with three piles of bones scattered across the floor, a singular bookshelf, and a pile of debris in the corner.");
                System.out.println("\nWhat will you choose to do?\n");

                System.out.println("a) Go northwest to the statue room");
                System.out.println("b) Go around the corner");
                System.out.println("c) Check bookshelf");
                System.out.println("d) Look around");

                char choice = scanner.next().charAt(0);

                switch (choice) {
                    case 'a':
                        returnToNextRoom(2);

                    case 'b':
                        System.out.println("You walk around the corner and discover a locked door.");
                        if (!player.hasKey()) {
                            System.out.println("The door is locked.");
                        } else if (player.isCursed()) {
                            if (!player.hasWishbone()) {
                                System.out.println("Your hand keeps slipping and you can’t seem to open the door.");
                            } else {
                                System.out.println("You manage to unlock the door with the help of your lucky wishbone.");
                                returnToNextRoom(5);
                            }
                        } else {
                            System.out.println("You unlock the door and step through.");
                            returnToNextRoom(5);
                        }
                        break;


                    case 'c':
                        System.out.println("You pick up a book and start reading it.");
                        Book.BookVI();
                        break;

                    case 'd':
                        handleLookAround();
                        break;

                    default:
                        System.out.println("Try again. Maybe this time read the letters like a functioning adventurer.");
                        break;
                }
            }
        } catch (RoomTransitionException e) {
            return e.nextRoom;
        }
    }

    private void handleLookAround() {
        System.out.println("a) Approach pile of random bones");
        System.out.println("b) Approach pile of skulls");
        System.out.println("c) Approach pile of kneecaps");
        System.out.println("d) Approach pile of debris");

        char pick = scanner.next().charAt(0);

        switch (pick) {

            case 'a':
                System.out.println("A rat runs out of it and past you, startling you while your aura points get reduced by -10.");
                break;

            case 'b':
                System.out.println("The hollow eyes stare right back at you. You feel very judged.");
                break;

            case 'c':
                System.out.println("You kneel beside the kneecaps. There's a shiny object partially buried.");
                System.out.println("a) Pick it up\nb) Leave it alone");
                char subPick = scanner.next().charAt(0);
                if (subPick == 'a') {
                    System.out.println("You pick it up. It's a pair of keys.");
                    player.giveKey();
                } else {
                    System.out.println("You leave it. Probably cursed. Good call.");
                }
                break;

            case 'd':
                System.out.println("There's a clay pot.");
                System.out.println("a) Pick it up\nb) Put it back\nc) Smash it");
                char potPick = scanner.next().charAt(0);
                switch (potPick) {
                    case 'a':
                        System.out.println("You pick it up. It’s heavier than it looks.");
                        break;
                    case 'b':
                        System.out.println("You place it gently back down. Polite adventuring.");
                        break;
                    case 'c':
                        System.out.println("You smash the pot. A bone falls out of the ashes. You feel luckier.");
                        player.giveWishbone();
                        if (player.isCursed()) {
                            System.out.println("You feel a warmth in your chest, as if a bad omen has passed.");
                            player.liftCurse();
                        }

                        break;
                    default:
                        System.out.println("The pot is confused by your indecision.");
                }
                break;

            default:
                System.out.println("Choose a valid option before the bones rearrange themselves out of boredom.");
        }
    }

    private void returnToNextRoom(int roomId) {
        throw new RoomTransitionException(roomId);
    }



}
