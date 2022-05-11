import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Filehandler implements Runnable {

    private static Set<String> words;
    private static int longestLength;
    private static String longestWord = "";
    private static int shortestLength = 100;
    private static String shortestWord = "";
    private static int lengthSum;
    private static int wordCount;
    private String filePath;
    private static final Object countLock = new Object();

    public Filehandler(int number) {
        words = Collections.synchronizedSet(new HashSet<>());
        filePath = "D:\\AP_Lab\\lesson9\\files\\" + "file_" + number + ".txt";
    }

    @Override
    public void run() {
        try (FileInputStream fStream = new FileInputStream(filePath)) {
            BufferedReader bReader = new BufferedReader(new InputStreamReader(fStream));
            synchronized (countLock) {
                while (bReader.ready()) {
                    String word = bReader.readLine();
                    wordCount++;
                    lengthSum += word.length();
                    words.add(word);
                    if (word.length() > longestLength) {
                        longestLength = word.length();
                        longestWord = word;
                    }
                    if (word.length() < shortestLength) {
                        shortestLength = word.length();
                        shortestWord = word;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file is not found!");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void printResult() {
        System.out.println("The longest word is '" + longestWord + "' with length " + longestLength);
        System.out.println("The shortest word is '" + shortestWord + "' with length " + shortestLength);
        System.out.println("Average : " + lengthSum / wordCount);
        System.out.println("The number of counted words: " + wordCount + " and the sum of their length is: " + lengthSum);
    }
}
