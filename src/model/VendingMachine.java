package model;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private static VendingMachine instance; // Singleton instance
    private final Map<Integer, Shelf> shelves;
    private int totalShelves;

    // Private constructor to prevent instantiation
    private VendingMachine() {
        this.shelves = new HashMap<>();
    }

    // Public method to get the singleton instance
    public static VendingMachine getInstance() {
        if (instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }

    public void setShelves(int totalShelves, int numberOfRacks, int rackSize){
        this.totalShelves = totalShelves;
        for(int i=0;i<totalShelves;i++){
            shelves.put(i, new Shelf(numberOfRacks, rackSize));
        }
    }

    public boolean addItem(int row, int rackIndex, Item item, int quantity) {
        Shelf shelf = shelves.get(row);
        if (shelf == null) {
            System.out.println("Shelf does not exist at row: " + row);
            return false;
        }

        if (rackIndex >= shelf.getRacks().size()) {
            System.out.println("Rack does not exist at index: " + rackIndex);
            return false;
        }

        Rack rack = shelf.getRacks().get(rackIndex);

        if (!rack.addItem(item, quantity)) {
            System.out.println("Failed to add item. Check capacity or item mismatch.");
            return false;
        }
        return true;
    }

    public boolean removeItem(int row, int rackIndex, int quantity) {
        Shelf shelf = shelves.get(row);
        if (shelf == null) {
            System.out.println("Shelf does not exist at row: " + row);
            return false;
        }

        if (rackIndex >= shelf.getRacks().size()) {
            System.out.println("Rack does not exist at index: " + rackIndex);
            return false;
        }

        Rack rack = shelf.getRacks().get(rackIndex);

        if (!rack.removeItem(quantity)) {
            System.out.println("Failed to remove item. Not enough quantity in rack.");
            return false;
        }
        return true;
    }

    // New Method: Buy an item from the vending machine
    public double buyItem(int row, int rackIndex, int quantity) {
        Shelf shelf = shelves.get(row);
        if (shelf == null) {
            throw new IllegalArgumentException("Shelf does not exist at row: " + row);
        }

        if (rackIndex >= shelf.getRacks().size()) {
            throw new IllegalArgumentException("Rack does not exist at index: " + rackIndex);
        }

        Rack rack = shelf.getRacks().get(rackIndex);

        if (rack.isEmpty()) {
            throw new IllegalArgumentException("Rack is empty. No items available for purchase.");
        }

        if (rack.getSize() < quantity) {
            throw new IllegalArgumentException("Not enough items available. Current quantity: " + rack.getSize());
        }

        double totalCost = rack.getItem().getPrice() * quantity;

        // Remove the purchased items from the rack
        rack.removeItem(quantity);

        System.out.println("Successfully purchased " + quantity + " " + rack.getItem().getName() + "(s) for $" + totalCost);
        return totalCost;
    }

    public void displayInventory() {
        System.out.println("Vending Machine Inventory:");
        for (Map.Entry<Integer, Shelf> entry : shelves.entrySet()) {
            System.out.println("Shelf Row: " + entry.getKey());
            System.out.print(entry.getValue());
        }
    }
}