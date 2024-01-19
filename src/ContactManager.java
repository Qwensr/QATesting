import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ContactManager {
    private static List<Contact> contacts = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);



    public static void createContact() {
        System.out.println("Enter contact details:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Surname: ");
        String surname = sc.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        int count = 100;
        if (contacts.size() >= count)
            System.out.println("Phone Book is full");
        if (name.isEmpty() || surname.isEmpty() || phoneNumber.isEmpty() || email.isEmpty()) {
            System.out.println("All fields must be filled. Contact not created.");
        } else {
            Contact contact = new Contact(name, surname, phoneNumber, email);
            contacts.add(contact);
            System.out.println("Contact created successfully.");
        }
    }

    public static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available for viewing.");
        } else {
            System.out.println("Contacts:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }
    public static void deleteContact() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available for deletion.");
            return;
        }

        System.out.println("Enter the name of the contact you want to delete: ");
        String searchName = sc.nextLine();
        boolean contactFound = false;

        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getName().equalsIgnoreCase(searchName)) {
                iterator.remove();
                contactFound = true;
                System.out.println("Contact deleted successfully.");
                break;
            }
        }

        if (!contactFound) {
            System.out.println("Contact not found.");
        }
    }

    public static void updateContact() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available for updating.");
            return;
        }

        System.out.println("Enter the name of the contact you want to update: ");
        String searchName = sc.nextLine();
        boolean contactFound = false;

        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Enter new details for the contact:");
                System.out.print("Name: ");
                contact.setName(sc.nextLine());
                System.out.print("Surname: ");
                contact.setSurname(sc.nextLine());
                System.out.print("Phone Number: ");
                contact.setPhoneNumber(sc.nextLine());
                System.out.print("Email: ");
                contact.setEmail(sc.nextLine());

                contactFound = true;
                System.out.println("Contact updated successfully.");
                break;
            }
        }

        if (!contactFound) {
            System.out.println("Contact not found.");
        }
    }

    public static void searchContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available for searching.");
            return;
        }

        System.out.println("Enter the name or phone number to search: ");
        String searchTerm = sc.nextLine().toLowerCase();
        boolean contactFound = false;

        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(searchTerm) ||
                    contact.getPhoneNumber().contains(searchTerm)) {
                System.out.println(contact);
                contactFound = true;
            }
        }

        if (!contactFound) {
            System.out.println("No matching contacts found.");
        }
    }

    public static void saveContactsToFile() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available for saving to file.");
            return;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter("contacts.txt"))) {
            for (Contact contact : contacts) {
                writer.println(contact.getName() + "," + contact.getSurname() + "," +
                        contact.getPhoneNumber() + "," + contact.getEmail());
            }
            System.out.println("Contacts saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error saving contacts to file: " + e.getMessage());
        }
    }

    public static void loadContactsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("contacts.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    Contact contact = new Contact(data[0], data[1], data[2], data[3]);
                    contacts.add(contact);
                } else {
                    System.out.println("Invalid data format in file. Skipping a line.");
                }
            }
            System.out.println("Contacts loaded from file successfully.");
        } catch (IOException e) {
            System.out.println("Error loading contacts from file: " + e.getMessage());
        }
    }
    public void searchContactsByPhoneNumber(String searchByPhoneNumber) {
        try {
            File file = new File("contacts.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            if (line==(searchByPhoneNumber)){
                System.out.println(searchByPhoneNumber);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
