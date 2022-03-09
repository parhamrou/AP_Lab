import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

public class Voting {

    private int type; 
    private String question;
    private HashMap<String, HashSet<Vote>> choices;
    private boolean isAnonymous;
    private  ArrayList<Person> voters;


    public Voting(int type, String question, boolean isAnonymous) {
        this.type = type;
        this.question = question;
        this.isAnonymous = isAnonymous;
        this.choices = new HashMap<>();
        this.voters = new ArrayList<>();
    }


    public void setQuestion(String question) {
        this.question = question;
    }


    public ArrayList<String> getChoices() {

        // going throug the keySet of the HashMap and adding keys to the ArrayList
        ArrayList<String> arraylist = new ArrayList<>();
        for (String choice : choices.keySet()) {
            arraylist.add(choice);
        }
        
        return arraylist;
    }


    public String getQuestion() {
        return question;
    }


    public void createChoice(String choice) {
        HashSet<Vote> votes = new HashSet<>();
        choices.put(choice, votes);
    }


    public void vote(Person voter, ArrayList<String> voter_choices, String date) { // voting is not anonymous 
        
        
        
        // cheking if the type of voting is 1 or 
        if (voter_choices.size() > 1 && this.type == 0) {
            System.out.println("In this voting you can choose just one choice!");
            return;
        }

        // adding voter to the voters list
        voters.add(voter);
        // creating a new vote and adding to the choices
        for (int i = 0; i < voter_choices.size(); i++) {
            Vote vote = new Vote(voter, date); 
            choices.get(voter_choices.get(i)).add(vote);
        }
    }


    public void vote(Person person, String date) {  // voting is anonymous & random
        Random rand = new Random();

        // adding voter to the voters list
        voters.add(person);

        // arraylist for saving all choices
        ArrayList<String> options = new ArrayList<>();
        for (String key : choices.keySet()) {
            options.add(key);
        }

        String choice = options.get(rand.nextInt(options.size()));
        Vote vote = new Vote(person, date);
        choices.get(choice).add(vote);
    }


    public void printResults() {
        System.out.printf("Question: ");
        System.out.println(question);

        int index = 1;
        for (Map.Entry<String, HashSet<Vote>> entry : this.choices.entrySet()) {
            System.out.println(index + "- "+ entry.getKey() + ": " + entry.getValue().size());
            index++;
        }
    }


    public void printVoters() {
        if (isAnonymous == false) {
            System.out.println("\nVoters for each choice: ");
            for (Map.Entry<String, HashSet<Vote>> entry : this.choices.entrySet()) {
                System.out.printf(entry.getKey() + ":  ");
                HashSet<Vote> votes = entry.getValue();
                if (votes.size() != 0) {
                    for (Vote vote : votes) {
                        System.out.printf(vote.getVoter().getFirstName() + " " + vote.getVoter().getLastName() + "  -  ");
                    }
                    System.out.println();
                
                } else {
                    System.out.println("-");
                }
            }
        }
    }


    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }
}