package Game;

import Level1.*;

import java.util.HashMap;
import java.util.Map;

public class RoomManager {
    private final Map<Integer, Room> rooms = new HashMap<>();

    public RoomManager(PlayerState player) {
        rooms.put(1, new StartingRoom(player));
        rooms.put(2, new StatueRoom(player));
        rooms.put(3, new PoolRoom(player));
        rooms.put(4, new SkeletonRoom(player));
        rooms.put(5, new BarrelRoom(player));
        rooms.put(6, new ThroneRoom(player));
        rooms.put(7, new SpikePitRoom(player));
        rooms.put(8, new EmptyRoom(player));

    }

    public Room getRoom(int id) {
        return rooms.get(id);
    }
}
