package Level1;

import Game.GUI;
import Game.PlayerState;
import java.util.function.IntConsumer;

public abstract class Room {
    protected int id;
    protected String name;
    protected PlayerState player;
    protected GUI gui;
    private IntConsumer transitionHandler;

    public Room(int id, String name, PlayerState player) {
        this.id = id;
        this.name = name;
        this.player = player;
    }

    public void setGUI(GUI gui) {
        this.gui = gui;
    }

    public void setRoomTransitionHandler(IntConsumer handler) {
        this.transitionHandler = handler;
    }

    protected void returnToNextRoom(int roomId) {
        if (transitionHandler != null) {
            transitionHandler.accept(roomId);
        } else {
            throw new RuntimeException("No transition handler set.");
        }
    }

    protected void returnToDeath() {
        returnToNextRoom(-1);
    }

    public abstract void enter();
}
