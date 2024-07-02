/**
 * Author: Jessica Dixon
 * Date: June 30, 2024
 * Sources: W3Schools, Stack Overflow, Codecademy
 */

package mini2.controller;
import mini2.model.ItemDB;

public class Item {
    private static ItemDB itemDB = new ItemDB();
    String itemName;

    public Item(String itemName) {
        this.itemName = itemName;
    }

    public String getName() {
        return this.itemName;
    }

    public void inspect() {
        String description = itemDB.getItemDescription(this.itemName);
        System.out.println(description);
    }

    public String getDescription() {
        return itemDB.getItemDescription(this.itemName);
    }
}


