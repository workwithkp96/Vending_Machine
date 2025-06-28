import model.Item;
import model.VendingMachine;

public class Main {
    public static void main(String[] args) {
        // Get the singleton instance of the vending machine
        VendingMachine vendingMachine = VendingMachine.getInstance();

        vendingMachine.setShelves(2,4,5);

        // Add items
        Item chips = new Item("Chips", 20.0);
        Item soda = new Item("Soda", 50.00);
        Item candy = new Item("Candy", 5.00);

        vendingMachine.addItem(0, 0, chips, 5); // Add 5 Chips to row 0, rack 0
        vendingMachine.addItem(0, 1, soda, 4);  // Add 8 Soda to row 0, rack 1
        vendingMachine.addItem(1, 0, candy, 3); // Add 3 Candy to row 1, rack 0

        // Display inventory
        vendingMachine.displayInventory();

        // Buy items
        vendingMachine.buyItem(0, 0, 2); // Buy 2 Chips from row 0, rack 0
        vendingMachine.buyItem(0, 1, 1); // Buy 1 Soda from row 0, rack 1

        // Display inventory after purchase
        vendingMachine.displayInventory();
    }
}