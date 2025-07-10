package Level1;

public class StatueRoom extends Room{

    public  StatueRoom() {
        super(1, "Statue Room");
    }

    @Override
    public int enter() {
        while  (true){
            System.out.println("You enter the room, infront of you a giant statue towering over you, like it’s watching you, its eyes following you wherever you move." +
                    "\n" +
                    "to your right(west) you can here the flow of water, to your left (east) is a dark and narrow path, same for the path infront of you (south) seems just as narrow.\n");

            System.out.println("\nWhat will you choose to do?\n");
            System.out.println("\na) Go left (west)\n");
            System.out.println("b) Go right (east)\n");
            System.out.println("c) Walk south/forward\n");
            System.out.println("d) Look around\n");

            char choice = scanner.next().charAt(0);

            switch (choice){
                case 'a':
                    //put in logic to move ot the next room
                    break;

                case 'b':
                    //put in logic to move ot the next room
                    break;

                case 'c':
                    //put in logic to move ot the next room
                    break;

                case 'd':
                    System.out.println("As you look around you can feel the statues gaze on you.");
                    break;

                default:
                    System.out.println("Try again");
                    break;
            }
        }
    }
}
