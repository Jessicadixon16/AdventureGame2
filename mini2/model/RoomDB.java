/**
 * Author: Jessica Dixon
 * Date: June 30, 2024
 * Sources: W3Schools, Stack Overflow, Codecademy
 */

package mini2.model;
import mini2.controller.Room;
import mini2.controller.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RoomDB {
    private static HashMap<Integer, Room> roomData;

    public RoomDB() {
        if (roomData == null) {
            readRoomData();
        }
    }

    public boolean readRoomData() {
        if (roomData != null) {
            return true;
        }

        roomData = new HashMap<>();

        try {
            Scanner file = new Scanner(new File("src/Rooms.txt"));
            file.useDelimiter("~");

            while (file.hasNext()) {
                String[] roomsData = file.next().trim().split("\n");

                int roomId = Integer.parseInt(roomsData[0].trim());
                String roomName = roomsData[1];
                String roomDescription = roomsData[2];
                String itemName = roomsData[3].trim();
                String[] directions = roomsData[4].split(",");

                int northId = Integer.parseInt(directions[0]);
                int southId = Integer.parseInt(directions[1]);
                int eastId = Integer.parseInt(directions[2]);
                int westId = Integer.parseInt(directions[3]);

                Room newRoom;
                if (!itemName.equals("None")) {
                    Item roomItem = new Item(itemName);
                    newRoom = new Room(roomId, roomName, roomDescription, northId, southId, eastId, westId, roomItem);
                } else {
                    newRoom = new Room(roomId, roomName, roomDescription, northId, southId, eastId, westId);
                }

                roomData.put(roomId, newRoom);
            }

            return true;
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
    }

    public Room getRoom(int roomId) {
        return roomData.get(roomId);
    }

    public ArrayList<Room> getAllRooms() {
        return new ArrayList<>(roomData.values());
    }
}
