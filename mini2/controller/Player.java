/**
 * Author: Jessica Dixon
 * Date: June 30, 2024
 * Sources: W3Schools, Stack Overflow, Codecademy
 */

package mini2.controller;/*

    The Character class handles movement and stores important values relevant to the character of the game.

    setRoom(mini2.controller.Room newRoom) sets the currentRoom of the character and records that the room has been visited
    move(String direction) gets the correct room based on the given direction, then calls setRoom() if the room is valid

*/

import java.util.ArrayList;

public class Player {
    private Map gameMap;
    public Room currentRoom;
    private ArrayList<Integer> visitedRooms;
    private ArrayList<Item> inventory;

    public Player(Map gameMap) {
        this.gameMap = gameMap;
        this.currentRoom = gameMap.getRoom(1);
        visitedRooms = new ArrayList<Integer>();
        inventory = new ArrayList<Item>();
        setRoom(gameMap.getRoom(1));
    }

    private void setRoom(Room newRoom) {
        if (newRoom == null) {
            System.out.println("You cannot go this way.");
            return;
        }

        this.currentRoom = newRoom;
        System.out.println(newRoom.getRoomName());
        System.out.println(newRoom.getRoomDescription());


        if (!visitedRooms.contains(newRoom.getRoomId())) {
            visitedRooms.add(newRoom.getRoomId());
        } else {
            System.out.println("[You have visited this area before.]");
        }
    }

    public void moveNorth() {
        Room nextRoom = gameMap.getRoom(currentRoom.getNorthID());
        setRoom(nextRoom);
    }

    public void moveEast() {
        Room nextRoom = gameMap.getRoom(currentRoom.getEastID());
        setRoom(nextRoom);
    }

    public void moveSouth() {
        Room nextRoom = gameMap.getRoom(currentRoom.getSouthID());
        setRoom(nextRoom);
    }
    public void moveWest() {
        Room nextRoom = gameMap.getRoom(currentRoom.getWestID());
        setRoom(nextRoom);
    }

    public void pickupItem(String itemName) {
        Item correctItem = null;
        for (Item item: this.currentRoom.getInventory()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                correctItem = item;
                break;
            }
        }

        if (correctItem != null) {
            this.currentRoom.removeItem(correctItem);
            this.inventory.add(correctItem);
            System.out.println(correctItem.getName() + " has been picked up from the room and successfully added to the player's inventory.");
        } else {
            System.out.println("There is no item named " + itemName + " in this room.");
        }
    }

    public void dropItem(String itemName) {
        Item correctItem = null;
        for (Item item: this.inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                correctItem = item;
                break;
            }
        }

        if (correctItem != null) {
            this.currentRoom.addItem(correctItem);
            this.inventory.remove(correctItem);
            System.out.println(correctItem.getName() + " has been dropped successfully from the player's inventory and placed in " + this.currentRoom.getRoomName());
        } else {
            System.out.println("There is no item named " + itemName + " in your inventory.");
        }
    }

    public ArrayList<Item> getInventory() {
        return this.inventory;
    }

    public void printInventory() {
        if (this.inventory.isEmpty()) {
            System.out.println("You haven't picked up any items yet.");
        } else {
            System.out.println("Items:");
            for (Item item : this.inventory) {
                System.out.println(item.getName());
            }
        }
    }
}
