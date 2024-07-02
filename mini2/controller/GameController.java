/**
 * Author: Jessica Dixon
 * Date: June 30, 2024
 * Sources: W3Schools, Stack Overflow, Codecademy
 */

package mini2.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GameController {
    private Player player;

    public GameController() {
        initializeGame();
    }

    private void initializeGame() {
        System.out.println();
        Scanner input = new Scanner(System.in);

        // Initialize and populate the gameMap
        Map gameMap = new Map();

        try {
            gameMap.createRooms();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Create a character
        player = new Player(gameMap);
    }

    public void processCommand(String commandLine) {
        String[] inputString = commandLine.split("\\s+");
        String command = inputString[0];
        System.out.println(" ");

        if (command.equalsIgnoreCase("move")) {
            if (inputString.length == 1) {
                System.out.println("Type 'move direction' (north, south, east, west)");
                return;
            }

            String direction = inputString[1];
            if (direction.equalsIgnoreCase("north")) {
                player.moveNorth();
            } else if (direction.equalsIgnoreCase("south")) {
                player.moveSouth();
            } else if (direction.equalsIgnoreCase("east")) {
                player.moveEast();
            } else if (direction.equalsIgnoreCase("west")) {
                player.moveWest();
            }
        } else if (command.equalsIgnoreCase("explore")) {
            player.currentRoom.explore();
        } else if (command.equalsIgnoreCase("inventory")) {
            player.printInventory();
        } else if (command.equalsIgnoreCase("drop")) {
            String itemName = String.join(" ", Arrays.copyOfRange(inputString, 1, inputString.length));
            player.dropItem(itemName);
        } else if (command.equalsIgnoreCase("pickup")) {
            String itemName = String.join(" ", Arrays.copyOfRange(inputString, 1, inputString.length));
            player.pickupItem(itemName);
        } else if (command.equalsIgnoreCase("inspect")) {
            String itemName = String.join(" ", Arrays.copyOfRange(inputString, 1, inputString.length));
            // check if the item is in the room
            ArrayList<Item> roomItems = player.currentRoom.getInventory();
            Item correctItem = null;
            for (Item item : roomItems) {
                if (item.getName().equalsIgnoreCase(itemName)) {
                    correctItem = item;
                    break;
                }
            }

            if (correctItem == null) {
                // if not, check if the item is in the player's inventory
                ArrayList<Item> playerItems = player.getInventory();
                for (Item item : playerItems) {
                    if (item.getName().equalsIgnoreCase(itemName)) {
                        correctItem = item;
                        break;
                    }
                }
            }

            if (correctItem != null) {
                correctItem.inspect();
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        // You can optionally leave the main method here if you want to run GameController directly
    }
}