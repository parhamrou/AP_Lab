public class Eagle extends Bird implements Hunter {

    public Eagle(String name, int age, String specialDetails, double flyHeight) {
        super(name, age, specialDetails, flyHeight);
    }

    @Override
    public void hunt(Prey prey) {
        System.out.println(ShowName() + " hunted " + prey.getName());
    }
}
