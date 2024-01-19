import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            ContactManager contactManager = new ContactManager();
            Scanner sc = new Scanner(System.in);


            while (true) {
                System.out.println("\n===========  ============");
                System.out.println("        PHONE BOOK          ");
                System.out.println("===========  ============");
                System.out.println("1. Create a contact");
                System.out.println("2. View contacts");
                System.out.println("3. Delete a contact");
                System.out.println("4. Update a contact");
                System.out.println("5. Search for a contact");
                System.out.println("6. Save contacts to file");
                System.out.println("7. Load contacts from file");
                System.out.println("8. Exit");
                System.out.println("9. SearchByPhoneNumber7");
                System.out.print("Choose an action: ");

                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        ContactManager.createContact();
                        break;
                    case 2:
                        ContactManager.viewContacts();
                        break;
                    case 3:
                        ContactManager.deleteContact();
                        break;
                    case 4:
                        ContactManager.updateContact();
                        break;
                    case 5:
                        ContactManager.searchContacts();
                        break;
                    case 6:
                        ContactManager.saveContactsToFile();
                        break;
                    case 7:
                        ContactManager.loadContactsFromFile();
                        break;
                    case 8:
                        System.out.println("Exiting...");
                        System.exit(0);
                    case 9:
                        System.out.println("Enter number to search");
                        String scanByNumber = sc.nextLine();
                        contactManager.searchContactsByPhoneNumber(scanByNumber);
                    default:
                        System.out.println("Invalid choice. Please choose again.");
                }
            }
        }
    }
