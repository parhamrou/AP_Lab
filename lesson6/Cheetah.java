public class Cheetah extends Mammal implements Hunter {
    
    public Cheetah(String name, int age, String specialDetails, double runningSpeed) {
        super(name, age, specialDetails, runningSpeed);
    }

    @Override
    public void hunt(Prey prey) {
        System.out.println(ShowName() + " hunted " + prey.getName());
    }
}
