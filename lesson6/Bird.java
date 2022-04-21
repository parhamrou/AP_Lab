
public abstract class Bird extends Animal{
    private double flyHeight;

    public Bird(String name, int age, String specialDetails, double flyHeight) {
        super(name, age, specialDetails);
        this.flyHeight = flyHeight;
    }

    @Override
    public void show() {
        System.out.printf("name: %s, speed: %.2f, %s\n", ShowName(), flyHeight, getSpecialDetails());
    }
}
