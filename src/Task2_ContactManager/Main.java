package Task2_ContactManager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        ContactManager manager = new ContactManager();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            System.out.println("\n =======Contact Management System======= ");
            System.out.println("1. Add Contacts");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contacts");
            System.out.println("4. Delete Contacts");
            System.out.println("5. Exit...");
            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice)
            {
                case 1 -> manager.addContacts();
                case 2 -> manager.viewContacts();
                case 3 -> manager.updateContacts();
                case 4 -> manager.deleteContacts();
                case 5 -> System.out.println("Existing.....");
                default -> System.out.println("Enter valid choice.\n");
            }
        }while(choice != 5);
    }
}
