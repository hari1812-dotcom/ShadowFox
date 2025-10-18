package Task3_InventoryManagement;

import java.util.ArrayList;

public class InventoryManager {
    private ArrayList<InventoryItem> itemList;

    public InventoryManager() {
        itemList = new ArrayList<>();
    }

    public void addItem(InventoryItem item) {
        itemList.add(item);
    }

    public void updateItem(int index, InventoryItem newItem) {
        if (index >= 0 && index < itemList.size()) {
            itemList.set(index, newItem);
        }
    }

    public void deleteItem(int index) {
        if (index >= 0 && index < itemList.size()) {
            itemList.remove(index);
        }
    }

    public ArrayList<InventoryItem> getAllItems() {
        return itemList;
    }
}
