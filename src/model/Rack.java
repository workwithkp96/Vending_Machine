package model;

public class Rack {
    private int size;
    private final int capacity;
    private Item item;

    public Rack(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.item = null;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean addItem(Item item, int quantity) {
        if (!isEmpty() && !this.item.getName().equals(item.getName())) {
            return false; // Rack holds a different item
        }
        if (this.size + quantity > capacity) {
            return false; // Not enough capacity
        }
        this.item = item;
        this.size += quantity;
        return true;
    }

    public boolean removeItem(int quantity) {
        if (this.size < quantity) {
            return false; // Not enough items
        }
        this.size -= quantity;
        if (this.size == 0) {
            this.item = null; // Clear the rack if empty
        }
        return true;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Empty Rack (Capacity: " + capacity + ")";
        }
        return item.getName() + " (Quantity: " + size + ", Capacity: " + capacity + ")";
    }
}