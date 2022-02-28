import java.util.ArrayList;

public class PhoneBook {
    
    private ArrayList<Contact> contacts;

    public PhoneBook() {

        contacts = new ArrayList<Contact>();
    }

    public boolean addContact(Contact contact) {    
        if (contacts.contains(contact)) {
            return false;
        } else {
            contacts.add(contact);
            return true;
        }
    }
    public boolean deleteContact(String firstName, String lastName) {

        boolean condition = false;

        for (int i = 0; i < contacts.size(); i++) {
            if (firstName.equals(contacts.get(i).getFirstName()) && lastName.equals(contacts.get(i).getLastName())) {
                condition = true;
                contacts.remove(i);
                return condition;
            }
        }
        return condition;
    }

    public ArrayList<Contact> findContacts(String group) {
        ArrayList<Contact> groupContacts = new ArrayList<>();
        for (Contact contact : contacts) {
            if (group.equals(contact.getGroup())) {
                groupContacts.add(contact);
            }
        }

        if (groupContacts.size() == 0) {
            return null;
        } else {
            return groupContacts;
        }
    }

    public Contact findContacts(String firstName, String lastName) {
        for (int i = 0; i < contacts.size(); i++) {
            if (firstName.equals(contacts.get(i).getFirstName()) && lastName.equals(contacts.get(i).getLastName())) {
                return contacts.get(i);
            }
        }
        return null;
    }
    public void printContacts() {
        if (contacts.size() == 0) {
            System.out.println("The phonebook is empty!");
        } else {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("contact{");
            System.out.println("\tname : " + contacts.get(i).getFirstName() + " " + contacts.get(i).getLastName());
            System.out.println("\temail : " + contacts.get(i).getEmail());
            System.out.println("\tgroup : " + contacts.get(i).getGroup());
            System.out.println("\t" + contacts.get(i).getPhoneNumber().toString());
            System.out.println("\t" + contacts.get(i).getAddress().toString());
            System.out.println("}");
        }
    }
}

    public void printContacts(ArrayList<Contact> contacts) {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("contact{");
            System.out.println("\tname : " + contacts.get(i).getFirstName() + " " + contacts.get(i).getLastName());
            System.out.println("\temail : " + contacts.get(i).getEmail());
            System.out.println("\tgroup : " + contacts.get(i).getGroup());
            System.out.println("\t" + contacts.get(i).getPhoneNumber().toString());
            System.out.println("\t" + contacts.get(i).getAddress().toString());
            System.out.println("}");
        }
    }

    public void printContacts(Contact contact) {
        System.out.println("contact{");
        System.out.println("\tname : " + contact.getFirstName() + " " + contact.getLastName());
        System.out.println("\temail : " + contact.getEmail());
        System.out.println("\tgroup : " + contact.getGroup());
        System.out.println("\t" + contact.getPhoneNumber().toString());
        System.out.println("\t" + contact.getAddress().toString());
        System.out.println("}");
    }
}
