import java.util.ArrayList;

public class VotingSystem {

    private ArrayList<Voting> votingList;

    // constructor
    public VotingSystem() {
        this.votingList = new ArrayList<>();
    }


    public void createVoting(String question, boolean isAnonymous, int type, ArrayList<String> choices) {
        Voting voting = new Voting(type, question, isAnonymous);
        for (String choice : choices) {
            voting.createChoice(choice);
        }
        votingList.add(voting);
    }


    public Voting getVoting(int index) {
        return this.votingList.get(index - 1);
    }


    public ArrayList<Voting> getVotingList() {
        return votingList;
    }


    public void printResults(int index) {
        votingList.get(index).printResults();
    }


    public void printVoters(int index) {
        votingList.get(index).printVoters();
    }


    public void printVoting(int index) {
        ArrayList<String> choices= votingList.get(index).getChoices();
        System.out.printf("Question: ");
        System.out.println(votingList.get(index).getQuestion());
        for (int i = 0; i < choices.size(); i++) {
            System.out.println(i + 1 + "- " + choices.get(i));
        }
    }


    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }
}
