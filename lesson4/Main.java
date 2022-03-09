import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        VotingSystem votingsystem = new VotingSystem();

        // voting 1
        String question1 = "Which team do you support in champioms league this year? :)";
        ArrayList<String> choices1 = new ArrayList<>();
        choices1.add("Real Madrid");
        choices1.add("Masnchester City");
        choices1.add("PSG");
        choices1.add("Liverpool");
        choices1.add("Other teams");
        votingsystem.createVoting(question1, false, 1, choices1);
        Voting voting1 = votingsystem.getVoting(1);
        
        // voting 2
        String question2 = "Where do you live?";
        ArrayList<String> choices2 = new ArrayList<>();
        choices2.add("Tehran");
        choices2.add("Isfahan");
        choices2.add("Tabriz");
        choices2.add("Rasht");
        choices2.add("Other cities");
        votingsystem.createVoting(question2, true, 0, choices2);
        Voting voting2 = votingsystem.getVoting(2);
        
        
        // Person 1
        Person parham = new Person("Parham", "Roufarshbaf");
        // Person2
        Person ali = new Person("Ali", "Hatami");
        // Person 3
        Person mahdi = new Person("Mahdi", "Rahimi");
        // Person 4
        Person shayan = new Person("Shayan", "Shafaghi");

        // votes of Parham for voting 1
        ArrayList<String> q1ParhamChoices = new ArrayList<>();
        q1ParhamChoices.add("Real Madrid");
        q1ParhamChoices.add("PSG");
        voting1.vote(parham, q1ParhamChoices, "2021");

        // votes of Ali for voting 1
        ArrayList<String> q1Alichoices = new ArrayList<>();
        q1Alichoices.add("Other teams");
        q1Alichoices.add("PSG");
        voting1.vote(ali, q1Alichoices, "2019");

        // printing the results for voting 1
        System.out.println("-------------------------");
        voting1.printResults();
        voting1.printVoters();


        //votes of Mahdi for voting 2
        voting2.vote(mahdi, "2017"); // mahdi votes randomly
        
        // votes of Shayan for voting 2
        ArrayList<String> q2ShayanChoices = new ArrayList<>();
        q2ShayanChoices.add("Tehran");
        voting2.vote(shayan, q2ShayanChoices, "2016");


        // printing the results for voting 2
        System.out.println("\n-------------------------\n");
        voting2.printResults();
    }
}
