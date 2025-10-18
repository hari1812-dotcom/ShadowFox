package Task3_InventoryManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InventoryFrame extends JFrame {
    private InventoryManager manager;
    private DefaultListModel<String> listModel;
    private JList<String> itemList;
    private JTextField nameField, quantityField, priceField;

    public InventoryFrame() {
        manager = new InventoryManager();
        listModel = new DefaultListModel<>();

        setTitle("Inventory Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(245, 245, 245));


        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Item Details"));

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        inputPanel.add(quantityField);

        inputPanel.add(new JLabel("Price:"));
        priceField = new JTextField();
        inputPanel.add(priceField);


        itemList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(itemList);


        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");


        addButton.setBackground(new Color(76, 175, 80));
        addButton.setForeground(Color.WHITE);
        updateButton.setBackground(new Color(33, 150, 243));
        updateButton.setForeground(Color.WHITE);
        deleteButton.setBackground(new Color(244, 67, 54));
        deleteButton.setForeground(Color.WHITE);

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);


        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);


        addButton.addActionListener(e -> addItem());
        updateButton.addActionListener(e -> updateItem());
        deleteButton.addActionListener(e -> deleteItem());

        setVisible(true);
    }

    private void addItem() {
        try {
            String name = nameField.getText().trim();
            int qty = Integer.parseInt(quantityField.getText().trim());
            double price = Double.parseDouble(priceField.getText().trim());
            InventoryItem item = new InventoryItem(name, qty, price);
            manager.addItem(item);
            listModel.addElement(item.toString());
            clearFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input! Please enter valid values.");
        }
    }

    private void updateItem() {
        int index = itemList.getSelectedIndex();
        if (index != -1) {
            try {
                String name = nameField.getText().trim();
                int qty = Integer.parseInt(quantityField.getText().trim());
                double price = Double.parseDouble(priceField.getText().trim());
                InventoryItem item = new InventoryItem(name, qty, price);
                manager.updateItem(index, item);
                listModel.set(index, item.toString());
                clearFields();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter valid values.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select an item to update!");
        }
    }

    private void deleteItem() {
        int index = itemList.getSelectedIndex();
        if (index != -1) {
            manager.deleteItem(index);
            listModel.remove(index);
        } else {
            JOptionPane.showMessageDialog(this, "Select an item to delete!");
        }
    }

    private void clearFields() {
        nameField.setText("");
        quantityField.setText("");
        priceField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InventoryFrame::new);
    }
}
