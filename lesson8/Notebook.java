import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.io.*;

public class Notebook {

    Scanner scanner = new Scanner(System.in);
    private ArrayList<Note> notes;
    
    
    // constructor
    public Notebook() {
        notes = new ArrayList<>();
        readNotes(); 
    }

    
    public void manage() {  
        do {
            showMenu();
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        addNote();
                        break;
                    case 2:
                        removeNote();
                        break;
                    case 3:
                        showNote();
                        break;
                    case 4:
                        export();
                        break;
                    case 5:
                        saveNotes();
                        return;
                    default:
                        System.out.println("Your input is out of range, Try again!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Your input is not valid. Try again!");
                scanner.nextLine();
            } 
        } while (true);
    }


    private void addNote() {
        scanner.nextLine();
        System.out.println("Type the title of your note. If you want to back to menu, enter -1: ");
        String title = scanner.nextLine();
        if (title.equals("-1")) {
            return;
        }
        while (containsNoteName(title)) { 
            System.out.println("A note with this title is already in your notebook. Enter new title: ");
            title = scanner.nextLine();
        }
        System.out.println("Write your note. When you finished, enter '#' in a seperate line: ");
        StringBuilder text = new StringBuilder();
        String line = scanner.nextLine();
        while (!line.equals("#")) {
            text.append("\n" + line);
            line = scanner.nextLine();
        }
        Note note = new Note(title, text.toString(), LocalDate.now());
        notes.add(note);
    }


    private void removeNote() {
        listNotes();
        System.out.println("Choose one of the notes to remove or enter 0 to back to menu: ");
        try {
            int choice = scanner.nextInt();
            if (choice == 0) {
                return;
            }
            if (choice < 0 || choice > notes.size()) {
                System.out.println("You have to enter a number between 1 to " + notes.size());
                return;
            }
            notes.remove(choice - 1);
        } catch (InputMismatchException e) {
            System.out.println("You have to enter an integer number");
            scanner.nextLine();
        }
    }


    private void listNotes() {
        int index = 1;
        for (Note note : notes) {
            System.out.println(index + "- " + note.getName() + "\t" + note.getDate());
            index++;
        }
    }


    private void showNote() {
        if (notes.isEmpty()) {
            System.out.println("There is no note in your notebook!");
            return;
        }
        listNotes();
        System.out.println("Choose one of the notes to show or enter 0 to back to menu: ");
        try {
            int choice = scanner.nextInt();
            if (choice == 0) {
                return;
            }
            if (choice < 0 || choice > notes.size()) {
                System.out.println("You have to enter a number between 1 to " + notes.size());
                return;
            }
            System.out.println(notes.get(choice - 1));
        } catch (InputMismatchException e) {
            System.out.println("You have to enter an integer number");
            scanner.nextLine();
        }
    }


    private void export() {
        listNotes();
        System.out.println("Choose one of the notes to export or enter 0 to back to menu: ");
        try {
            int choice = scanner.nextInt();
            if (choice == 0) {
                return;
            }
            if (choice < 0 || choice > notes.size()) {
                System.out.println("You have to enter a number between 1 to " + notes.size());
                return;
            }
            Note note = notes.get(choice - 1);
            String filename = note.getName() + ".txt";
            try (FileWriter fileWriter = new FileWriter(filename);) {
                fileWriter.write("<<" + note.getName() + ">>");
                fileWriter.append("\n" + note.getText());
                System.out.printf("The note is exported now in %s\n", filename);
            } catch (IOException e) {
                System.out.println("There is a problem for exporting this note!");
            }
        } catch (InputMismatchException e) {
            System.out.println("You have to enter an integer number");
            scanner.nextLine();
        }
    }


    private void readNotes() {
        try (FileInputStream fi = new FileInputStream("notes.bin"); ObjectInputStream Ofin = new ObjectInputStream(fi)) {
            while (true) {
                Note note = (Note) Ofin.readObject();
                if (note == null) {
                    break;
                }
                notes.add(note);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file 'notes.bin' is not found");
        } catch (EOFException e) {   
    
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println("The class 'note' is not found!");
        }
    }


    private void saveNotes() {
        try (FileOutputStream fout = new FileOutputStream("notes.bin"); ObjectOutputStream ofout = new ObjectOutputStream(fout)) {
            for (Note note : notes) {
                ofout.writeObject(note);
            }
        } catch (IOException e) {
            System.out.println("There is a problem for saving your notes!");
        }
    }


    public boolean containsNoteName(String name) {
        for (Note note : notes) {
            if (note.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }


    private void showMenu() {
        System.out.println("1- Add");
        System.out.println("2- Remove");
        System.out.println("3- Notes");
        System.out.println("4- Export");
        System.out.println("5- Exit");
    }


    private static void clear() {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }
}