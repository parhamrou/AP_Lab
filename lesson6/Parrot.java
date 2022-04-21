public class Parrot extends Bird implements Prey{
    public Parrot(String name, int age, String specialDetails, double flyHeight) {
        super(name, age, specialDetails, flyHeight);
    }

    @Override
    public String getName() {
        return ShowName();
    }
}
