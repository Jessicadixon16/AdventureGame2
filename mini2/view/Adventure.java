/**
 * Author: Jessica Dixon
 * Date: June 30, 2024
 * Sources: W3Schools, Stack Overflow, Codecademy
 */



package mini2.view;
import mini2.controller.GameController;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Adventure {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();

        System.out.println("Welcome to the Adventure Game!");
        System.out.println("Type 'exit' to quit the game.");

        while (true) {
            System.out.println("\nWhat do you want to do?");
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for playing the adventure game. Goodbye!");
                break;
            }

            gameController.processCommand(command);
        }
    }
}
