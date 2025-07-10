package Level1;
import Level1.Items.Book;


public class StartingRoom extends Room{

    public StartingRoom() {
        super(0, "Starting Room");
    }

    @Override
    public int enter() {
        while (true) {
            System.out.println("You open your eyes, you’re in a small room, infront of you a pit opened up in the ground and a bookshelf in the corner." +
                    "\n" +
                    "To your right a door which felt eerie and looked old and rotten." +
                    "\n" +
                    "To your left another door, this one significantly less rotten but you could hear something coming from behind it, it sounded like flowing water\n");



            System.out.println("\nWhat will you choose to do?\n");
            System.out.println("a) Go left (west)\n");
            System.out.println("b) Go right (east)\n");
            System.out.println("c) Walk north/forward\n");
            System.out.println("d) Check out bookshelf\n");


            char choice = scanner.next().charAt(0);

            switch (choice) {
                case 'a':
                    //put in logic to move ot the next room
                    break;

                case 'b':
                    //put in logic to move ot the next room
                    break;

                case 'c':
                    System.out.println("You fall into the dark pit infront of you.\n");
                    System.out.println("END\n");
                    System.out.println("Note: You fell into the pit and died, by breaking your neck.");
                    return -1;

                case 'd':
                    System.out.println("There is one singular book and you take it and read it");
                    Book.BookI();
                    break;


                default:
                    System.out.println("Try again");
                    break;
            }
        }
    }
}
