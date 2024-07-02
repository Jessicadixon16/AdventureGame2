/**
 * Author: Jessica Dixon
 * Date: June 30, 2024
 * Sources: W3Schools, Stack Overflow, Codecademy
 */

package mini2.controller;/*

    The mini2.controller.Room class stores the attributes necessary for mini2.controller.Room objects

*/

import java.util.ArrayList;

public class Room {
    private int roomID;
    private int northID;
    private int southID;
    private int eastID;
    private int westID;
    private String roomName;
    private String roomDescription;
    private ArrayList<Item> inventory;


    public Room(int roomID, String roomName, String roomDescription, int northID, int southID, int eastID, int westID) {
        this.roomID = roomID;
        this.northID = northID;
        this.southID = southID;
        this.eastID = eastID;
        this.westID = westID;
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.inventory = new ArrayList<>();
    }

    public Room(int roomID, String roomName, String roomDescription, int northID, int southID, int eastID, int westID, Item roomItem) {
        this.roomID = roomID;
        this.northID = northID;
        this.southID = southID;
        this.eastID = eastID;
        this.westID = westID;
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.inventory = new ArrayList<>();
        this.inventory.add(roomItem);
    }

    public ArrayList<Item> explore() {
        if (!this.inventory.isEmpty()) {
            System.out.println("You see the following item(s):");

            for (Item item: this.inventory) {
                System.out.println(item.getName());
            }
        } else {
            System.out.println("There is nothing of interest in this room.");
        }

        return getInventory();
    }

    public ArrayList<Item> getInventory() { return this.inventory; }

    public int getNorthID() {
        return this.northID;
    }

    public int getSouthID() {
        return this.southID;
    }

    public int getWestID() {
        return this.westID;
    }

    public int getEastID() {
        return this.eastID;
    }

    public int getRoomId() {
        return this.roomID;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public String getRoomDescription() {
        return this.roomDescription;
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

}
