import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        PhoneBook phoneBook = new PhoneBook();
        String choice;
        do {
            Main.clear();
            showMenu();
            System.out.println("Type your choice : ");
            choice = input.nextLine();
                if (choice.equals("show")) {
                    Main.clear();
                    phoneBook.printContacts();
                    System.out.println("Press Enter to back to menu...");
                    input.nextLine();
                } else if (choice.equals("exit")) {
                    break;
                
                } else if (choice.startsWith("contacts -a")) {
                    String[] stringArray = choice.split(" ");
                    // to split first name and last name
                    Main.clear();
                    String firstName = stringArray[2];
                    String lastName = stringArray[3];
                    System.out.println("Please Enter contact's group");
                    String group = input.nextLine();
                    System.out.println("Please enter contact's email");
                    String email = input.nextLine();
                    System.out.println("Please enter contact's country code");
                    String countryCode = input.nextLine();
                    System.out.println("Please enter contact's phone number");
                    String number = input.nextLine();
                    
                    // creating a "PhoneNumber" object
                    PhoneNumber phoneNumber = new PhoneNumber(countryCode, number);
                    System.out.println("Please enter contact's zip code");
                    String zipcode = input.nextLine();
                    System.out.println("Please enter contact's country");
                    String country = input.nextLine();
                    System.out.println("Please enter contact's city");
                    String city = input.nextLine();

                    // creating a "Address" object
                    Address address = new Address(zipcode, country, city);

                    // creating a "Contact object and adding to "PhoneBook"
                    Contact contact = new Contact(group, email, firstName, lastName, phoneNumber, address);
                    phoneBook.addContact(contact);
                    System.out.println("Contact Saved!");
                    System.out.println("Press Enter to back to menu...");
                    input.nextLine();

                } else if (choice.startsWith("contacts -r")) {
                    String[] stringArray = choice.split(" ");
                    String firstName = stringArray[2];
                    String lastName = stringArray[3];
                    Main.clear();
                    
                    if (phoneBook.deleteContact(firstName, lastName) == true) {
                        System.out.println("The contact is removed!");
                    } else {
                        System.out.println("Not found!");
                    }
                    System.out.println("Press Enter to back to menu...");
                    input.nextLine();

                } else if (choice.startsWith("show -g")) {
                    String[] stringArray = choice.split(" ");
                    String group = stringArray[2];
                    ArrayList<Contact> temp = phoneBook.findContacts(group);
                    Main.clear();
                    if (temp == null) {
                        System.out.println("There is no contact in this group!");
                    } else {
                        phoneBook.printContacts(temp);
                    }
                    System.out.println("Press Enter to back to menu...");
                    input.nextLine();

                } else if (choice.startsWith("show -c")) {
                    String[] stringArray = choice.split(" ");
                    Main.clear();
                    String firstName = stringArray[2];
                    String lastName = stringArray[3];
                    Contact contact = phoneBook.findContacts(firstName, lastName);
                    if (contact == null) {
                        System.out.println("Thhis contact is not in phoneBook!");
                    } else {
                        phoneBook.printContacts(contact);
                    }
                    System.out.println("Press Enter to back to menu...");
                    input.nextLine();
                }
        } while (true);
    }
    public static void showMenu() {
        System.out.println("1- contacts -a <contact firstName> <contact lastName>");
        System.out.println("2- contacts -r <contact firstName> <contact lastName>");
        System.out.println("3- show -g <group name>");
        System.out.println("4- show -c <contact firstName> <contact lastName>");
        System.out.println("5- show");
        System.out.println("6- exit");
    }

    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}