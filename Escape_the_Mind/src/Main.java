import Game.GUI;
import Game.PlayerState;
import Game.RoomManager;
import Game.RoomTransitionException;
import Level1.Room;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI();
            PlayerState player = new PlayerState();
            RoomManager roomManager = new RoomManager(player);

            gui.printText("Welcome to the Dungeon. Time to escape your own mistakes.");
            gui.printText("You awaken in a strange room...\n");

            startGameLoop(gui, roomManager, 1);
        });
    }

    private static void startGameLoop(GUI gui, RoomManager roomManager, int startRoomId) {
        final int[] currentRoomId = {startRoomId};

        gui.setRoomTransitionHandler(nextRoomId -> {
            if (nextRoomId == -1) {
                gui.printText("\nYour journey has ended. You did your best. Probably.");
                gui.setInputHandler(null); // stop input
            } else {
                currentRoomId[0] = nextRoomId;
                launchRoom(gui, roomManager, currentRoomId[0]);
            }
        });

        launchRoom(gui, roomManager, currentRoomId[0]);
    }

    private static void launchRoom(GUI gui, RoomManager manager, int roomId) {
        try {
            Room room = manager.getRoom(roomId);
            room.setGUI(gui);
            gui.setInputHandler(null); // Clear previous handler
            room.enter(); // Set up new handler
        } catch (Exception e) {
            gui.printText("💥 Something exploded: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
