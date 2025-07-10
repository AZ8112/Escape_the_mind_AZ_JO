package Level1;

public class StatueRoom extends Room{

    public  StatueRoom() {
        super(2, "Statue Room");
    }

    @Override
    public int enter() {
        while  (true){
            System.out.println("You enter the room, infront of you a giant statue towering over you, like it’s watching you, its eyes following you wherever you move." +
                    "\n" +
                    "to your right(west) you can here the flow of water, to your left (east) is a dark and narrow path, same for the path infront of you (south) seems just as narrow.\n");

            System.out.println("\nWhat will you choose to do?\n");
            System.out.println("\na) Go left (east)\n");
            System.out.println("b) Go right (west)\n");
            System.out.println("c) Walk south/forward\n");
            System.out.println("d) Look around\n");
            System.out.println("e) Go back through the door to the statue room");

            char choice = scanner.next().charAt(0);

            switch (choice){
                case 'a':
                    return 4;

                case 'b':
                    return 3;

                case 'c':
                    //put in logic to move ot the next room
                    break;

                case 'd':
                    System.out.println("As you look around you can feel the statues gaze on you.");
                    break;

                case 'e':
                    return 2;

                default:
                    System.out.println("Try again");
                    break;
            }
        }
    }
}
