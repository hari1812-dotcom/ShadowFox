package Task2_ContactManager;
import java.util.Scanner;
import java.util.ArrayList;
public class ContactManager {
    private ArrayList<Contact> contacts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    public void addContacts()
    {
        System.out.println("Enter Name:");
        String name = scanner.nextLine();
        System.out.println("Enter phone:");
        String phone = scanner.nextLine();
        System.out.println("Enter email:");
        String email = scanner.nextLine();

        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact added succesfully.");
    }
    public void viewContacts()
    {
        if(contacts.isEmpty())
        {
            System.out.println("Contact is Empty.No contact is found!");
            return;
        }
        System.out.println("\n Contact List:");
        for(Contact contact : contacts)
        {
            contact.display();
        }
    }
    public void updateContacts() {
        System.out.print("Enter name to update: ");
        String name = scanner.nextLine();
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter new phone: ");
                contact.setPhone(scanner.nextLine());
                System.out.print("Enter new email: ");
                contact.setEmail(scanner.nextLine());
                System.out.println("Contact updated successfully!\n");
                return;
            }
        }
        System.out.println("Contact not found.\n");
    }
    public void deleteContacts() {
        System.out.print("Enter name to delete: ");
        String name = scanner.nextLine();
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contacts.remove(contact);
                System.out.println("Contact deleted successfully!\n");
                return;
            }
        }
        System.out.println("Contact not found.\n");
    }
}
