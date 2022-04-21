import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // creating different animals
        Eagle eagle = new Eagle("Eagle", 15, "fastest bird", 30);
        Parrot parrot = new Parrot("Parrot", 12, "It can talk", 10);
        Girafe girafe = new Girafe("Girafe", 17, "The tallest animal", 5);
        Cheetah cheetah = new Cheetah("Cheetah", 12, "The fastest animal.", 70);
        
        // creating a Arraylist which extends this animals
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(eagle);
        animals.add(parrot);
        animals.add(girafe);
        animals.add(cheetah);

        for (Animal animal : animals) {
            animal.show();
        }

        // hunting
        Prey prey = parrot;
        cheetah.hunt(prey);
    }
}
