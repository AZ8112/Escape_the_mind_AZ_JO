package Level1;
import Level1.Items.Book;

public class SkeletonRoom extends Room {
    public  SkeletonRoom() {
        super(4, "Skeleton Room");
    }

    @Override
    public int enter() {
        while  (true){
            System.out.println("You enter an room with three piles of bones scattered across the room and a pile of debris in the corner");
            System.out.println("\nWhat will you choose to do?\n");

            System.out.println("\na) Go northwest to the statue room\n");
            System.out.println("b) Go around the corner\n");

            char choice = scanner.next().charAt(0);

            switch (choice){
                case 'a':
                    return 1;

                case 'b':
                    //put in logic to move ot the next room
                    break;

                default:
                    System.out.println("Try again");
                    break;
            }
        }
    }

    private void handleLookAround() {
        System.out.println("a) Approach locked door\n");
        System.out.println("b) Approach pile of random bones\n");
        System.out.println("c) Approach pile of skulls\n");
        System.out.println("d) Approach pile of kneecaps\n");
        System.out.println("e) Approach pile of debris\n");

        char pick = scanner.next().charAt(0);

        switch (pick) {
            case 'a':
                //put in logic to move ot the next room
                break;

            case 'b':
                System.out.println("A rat runs out of it and past you, startling you while your aura points got reduces by -10.");
                break;

            case 'c':
                System.out.println("The hollow eyes stare right back at you.");
                break;

            case 'd':
                //put in logic to move ot the next room
                break;

            case 'e':
                //put in logic to move ot the next room
                break;

            default:
                System.out.println("Choose either a or b.");
        }
    }
}
