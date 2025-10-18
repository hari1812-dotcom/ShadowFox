package Task3_InventoryManagement;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InventoryFrame(); // Launches the Inventory GUI
        });
    }
}
