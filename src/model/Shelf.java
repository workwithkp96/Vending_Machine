package model;

import java.util.ArrayList;
import java.util.List;

public class Shelf {
    private final List<Rack> racks;

    public Shelf(int numberOfRacks, int rackCapacity) {
        racks = new ArrayList<>();
        for (int i = 0; i < numberOfRacks; i++) {
            racks.add(new Rack(rackCapacity));
        }
    }

    public List<Rack> getRacks() {
        return racks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < racks.size(); i++) {
            sb.append("  Rack ").append(i).append(": ").append(racks.get(i)).append("\n");
        }
        return sb.toString();
    }
}