import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SpellChecker {
    public static void main(String[] args) throws FileNotFoundException {
        SpellChecker spellCheck = new SpellChecker();

        spellCheck.spellCheckerTest();
    }

    public Set<String> readHashWords(String filename) throws FileNotFoundException {
        Set<String> words = new HashSet<>();
        Scanner in = new Scanner(new File(filename));

        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext()) {
            words.add(in.next().toLowerCase());
        }
        return words;
    }

    public ArrayList<String> readArrayWords(String filename) throws FileNotFoundException {
        ArrayList<String> words = new ArrayList<>();
        Scanner in = new Scanner(new File(filename));

        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext()) {
            words.add(in.next().toLowerCase());
        }
        return words;
    }

    public TreeSet<String> readTreeWords(String filename) throws FileNotFoundException {
        TreeSet<String> words = new TreeSet<>();

        Scanner in = new Scanner(new File(filename));

        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext()) {
            words.add(in.next().toLowerCase());
        }
        return words;
    }

    public void spellCheckerTest() throws FileNotFoundException {
        StopWatch stopwatch = new StopWatch();

        Set<String> dictionaryHash = readHashWords("./ch07/Lab9/resources/words");
        Set<String> dictionaryTree = readTreeWords("./ch07/Lab9/resources/words");
        ArrayList<String> dictionaryArray = readArrayWords("./ch07/Lab9/resources/words");

        Set<String> documentHash = readHashWords("./ch07/Lab9/resources/war-and-peace.txt");
        Set<String> documentTree = readTreeWords("./ch07/Lab9/resources/war-and-peace.txt");
        ArrayList<String> documentArray = readArrayWords("./ch07/Lab9/resources/war-and-peace.txt");

        // HashSet test
        int wordCount = 0;

        stopwatch.start();

        for (String word : documentHash) {
            if (!dictionaryHash.contains(word)) {
                wordCount++;
            }
        }

        System.out.println("Words not found: " +
                wordCount +
                "\nWords in dictionary: " +
                dictionaryHash.size());

        stopwatch.stop();

        System.out.println("Elapsed HashSet time: " + stopwatch.getElapsedTime() + " ms\n\n");
        stopwatch.reset();

        // TreeSet Test
        wordCount = 0;

        stopwatch.start();

        for (String word : documentTree) {
            if (!dictionaryTree.contains(word)) {
                wordCount++;
            }
        }

        System.out.println("Words not found: " +
                wordCount +
                "\nWords in dictionary: " +
                dictionaryTree.size());

        stopwatch.stop();

        System.out.println("Elapsed TreeSet time: " + stopwatch.getElapsedTime() + " ms\n\n");
        stopwatch.reset();

        // ArrayList Test
        wordCount = 0;

        stopwatch.start();

        for (String word : documentArray) {
            if (!dictionaryArray.contains(word)) {
                wordCount++;
            }
        }
        
        System.out.println("Words not found: " +
        wordCount +
        "\nWords in dictionary: " +
        dictionaryArray.size());
        
        stopwatch.stop();

        System.out.println("Elapsed TreeSet time: " + stopwatch.getElapsedTime() + " ms\n\n");
        stopwatch.reset();
    }
}