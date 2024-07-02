/**
 * Author: Jessica Dixon
 * Date: June 30, 2024
 * Sources: W3Schools, Stack Overflow, Codecademy
 */

package mini2.controller;/*

    The GameMap class reads the given file and creates a list of mini2.controller.Room objects

    getRoom(int roomId) returns the mini2.controller.Room object with the given roomId
    createRooms(String filePath) reads the input file and creates mini2.controller.Room objects with the data in the file

*/

import mini2.model.RoomDB;
import java.util.ArrayList;

public class Map {
    private RoomDB roomDB;

    public Map() {
        this.roomDB = new RoomDB();
    }

    public boolean createRooms() {
        return roomDB.readRoomData();
    }

    public Room getRoom(int roomId) {
        return roomDB.getRoom(roomId);
    }

    public ArrayList<Room> getRooms() {
        return roomDB.getAllRooms();
    }
}


