/**
 * Author: Jessica Dixon
 * Date: June 30, 2024
 * Sources: W3Schools, Stack Overflow, Codecademy
 */

package mini2.model;

import mini2.controller.Item;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ItemDB {
    private static HashMap<String, HashMap<String, String>> itemData;

    public ItemDB() {
        if (itemData == null) {
            readItemData();
        }
    }

    private boolean readItemData() {
        if (itemData != null) {
            return true;
        }

        itemData = new HashMap<>();

        try {
            Scanner file = new Scanner(new File("src/Items.txt"));
            file.useDelimiter("~");

            while (file.hasNext()) {
                String[] data = file.next().trim().split("\n");
                HashMap<String, String> itemMap = new HashMap<>();

                String itemName = data[0].trim();
                String description = data[1];

                itemMap.put("description", description);

                itemData.put(itemName, itemMap);
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

    public String getItemDescription(String itemName) {
        if (itemData.containsKey(itemName)) {
            return itemData.get(itemName).get("description");
        } else {
            return "Description not found.";
        }
    }
}
