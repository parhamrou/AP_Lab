public abstract class Mammal extends Animal{
    private double runningSpeed;

    public Mammal(String name, int age, String specialDetails, double runningSpeed) {
        super(name, age, specialDetails);
        this.runningSpeed = runningSpeed;
    }

    @Override
    public void show() {
        System.out.printf("name: %s, speed: %.2f, %s\n", ShowName(), runningSpeed, getSpecialDetails());
    }
}
