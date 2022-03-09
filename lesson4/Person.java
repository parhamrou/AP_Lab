

public class Person {

    private String firstName;
    private String lastName;

    public Person(String firstName, String lasString) {
        this.firstName = firstName;
        this.lastName = lasString;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return firstName + " " + lastName;        
    }
}