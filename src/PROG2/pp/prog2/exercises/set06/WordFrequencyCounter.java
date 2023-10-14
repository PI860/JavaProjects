package pp.prog2.exercises.set06;

import java.io.*;
import java.util.*;

/**
 * @author Paulina Pyczot
 * @date 24.04.2023
 **/


public class WordFrequencyCounter implements Comparator<Map.Entry<String, Integer>> {
    private HashMap<String,Integer> words = new HashMap<>();// Key-Value Paar aus Wort und Häufigkeit
    private int lineCounter = 0;

    public static void main(String[] args) {
        WordFrequencyCounter counter = new WordFrequencyCounter();
        counter.analyzeText(new File("src/pp/prog2/exercises/set06/Song.txt"));
        counter.printResults();
    }

    public void analyzeText(File textFile) {
        try {
            BufferedReader in =
                    new BufferedReader(new FileReader(textFile));
// Iterate through each line of the file
            while (true) {
                String currLine = in.readLine();
                if (currLine == null)
                    break;
                analyzeLine(currLine);
            }
        } catch (IOException ex) {
            System.out.println(
                    "Error occurred while reading from "
                            + textFile.getAbsolutePath() + ":");
            System.out.println(ex);
        }
    }

    private void analyzeLine(String line) {
        lineCounter++;
        line = line.toLowerCase(Locale.ROOT);
        StringTokenizer tokenizer = new StringTokenizer(line, " -,()'"); //teilt String "line" nach Leerzeichen auf
        while (tokenizer.hasMoreElements()) { //solange Zeile weitere Elemente hat, mach:
            String word = tokenizer.nextToken();
            if (words.containsKey(word)) {

                Integer count = words.get(word);
                words.put(word,count+1);
            }else{
                words.put(word,1);
            }
        }
    }

    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return -Double.compare(o1.getValue(), o2.getValue());
    }

    public void printResults() {
        Set<Map.Entry<String, Integer>> entries = words.entrySet();
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(entries);
        Collections.sort(entryList, new WordFrequencyCounter());
        StringBuilder result = new StringBuilder();
        System.out.println("Line Count: " + lineCounter);
        System.out.println("Word Count: " + entryList.size());
        System.out.println("Frequency of occurrence of each word:");
        int count = 0;
        for(Map.Entry<String, Integer> entry : entryList) {
            System.out.printf("%16s : %3d",entry.getKey(),entry.getValue());
            count++;
            count = count % 5;
            if (count == 0){
                System.out.println();
            }
        }
    }
}
