 /**
 * COPYRIGHT: smanna@cpp.edu
 * CS 240 Spring 2016
 * Programming Assignment 4
 *
 * !!WARNING!! Do not edit this code!!
 * Changes to this code will not be accepted!
 *
 **/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

public class GenerateScore {

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static void main(String[] args) throws IOException {
        HashTable ht = new HashTable(50);
        int expectedScore = 0;
        int score = 0;

        // get path according to argument
        String path;
        String pathResult;
        if (args.length > 0 && args[0].equals("eval")) {
            path = "data/eval/";
            pathResult = "data/eval.txt";
        } else {
            path = "data/test/";
            pathResult = "data/test.txt";
        }

        // read all the files and hash all the contents
        try {
            ht.hashing(path);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Encountered exception. Can't finish hashing!");
            System.out.println("Final score: " + score + " out of " + expectedScore);
            return;
        }

        // read test.txt/eval.txt file to construct expected results
        HashMap<String, Double> testSet = new HashMap<>();
        FileReader fr = new FileReader(pathResult);
        try (BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                ++expectedScore;
                String[] items = line.split("=");

                testSet.put(items[0].trim(), Double.valueOf(items[1].trim()));
            }
        }

        // compare between obtained results and expected results
        for (String name : testSet.keySet()) {
            Double expectedResult = testSet.get(name);
            Double result = 0.0;

            try {
                result = round(ht.getAverage(name), 2);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Encountered exception. No score for this case.");
                System.out.println("\"" + name + "\", expected=" + expectedResult.toString());
                continue;
            }

            System.out.print("\"" + name + "\", expected=" + expectedResult.toString()
                    + ", received=" + result.toString());
            if (expectedResult.compareTo(result) == 0) {
                System.out.println(" [PASS]");
                ++score;
            } else {
                System.out.println(" [MISMATCHED]");
            }
        }

        System.out.println("Final score: " + score + " out of " + expectedScore);
    }
}
