public abstract class Animal {
    private String name;
    private int age;
    private String specialDetails;

    // constructor
    public Animal(String name, int age, String specialDetails) {
        this.name = name;
        this.age = age;
        this.specialDetails = specialDetails;
    }

    public abstract void show();

    public int getAge() {
        return age;
    }
    
    public String ShowName() {
        return name;
    }

    public String getSpecialDetails() {
        return specialDetails;
    }
}