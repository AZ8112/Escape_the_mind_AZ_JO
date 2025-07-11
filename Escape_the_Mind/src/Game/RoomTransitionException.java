package Game;

public class RoomTransitionException extends RuntimeException {
    public final int nextRoom;
    public final boolean isGameOver;

    public RoomTransitionException(int nextRoom) {
        this.nextRoom = nextRoom;
        this.isGameOver = false;
    }

    private RoomTransitionException() {
        this.nextRoom = -1;
        this.isGameOver = true;
    }

    public static RoomTransitionException finishGame() {
        return new RoomTransitionException();
    }
}
