import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/** Counts how many A's, B's, C's and etc are in a given file.
 *  @author XiaRui (Charles) Zhang */
public class FreqAnalysis {

    /** Calculates and returns the standard deviations from the data
     *  in COUNTS and stores how much each count deviates from the
     *  average in DEVIATIONS. */
    public static double stanDev(int[] counts, double[] deviations) {
        int total = 0;

        if (counts.length != deviations.length) {
            System.out.println("Unequal sizes of matrices.");
            return 0.0;
        }

        for (int i = 0; i < counts.length; i++) {
            total += counts[i];
        }

        double average = total / counts.length;
        double variance = 0.0;

        for (int i = 0; i < deviations.length; i++) {
            deviations[i] = counts[i] - average;
            variance += (deviations[i] * deviations[i]);
        }
        variance = variance / deviations.length;
        return Math.sqrt(variance);
    }

    /** The Main method of this file. Does analysis. ARGS contains
     *  the filename of the file we are interested in. */
    public static void main(String[] args) {

        String title;
        boolean deviate;
        if (args.length < 1) {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Please enter a filename.");
            title = keyboard.next();
            System.out.println("Would you like to see the deviations"
                               + " or counts and percentages?");
            System.out.println("Enter d for deviations and c for counts");
            String temp = keyboard.next();
            deviate = temp.equals("d");
        } else {
            title = args[0];
            deviate = (args.length > 1) && (args[1].equals("d"));
        }

        int[] charCount = new int[(int) 'z' + 1];
        for (int i = 0; i < charCount.length; i++) {
            charCount[i] = 0;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(title));
            String input = br.readLine();
            while (input != null) {

                for (int i = 0; i < input.length(); i++) {
                    int value = (int) input.charAt(i);
                    if (value < charCount.length) {
                        charCount[value] = charCount[value] + 1;
                    }
                }
                input = br.readLine();
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }

        int total = 0;
        int[] letterCount = new int[26];
        double[] deviations = new double[26];
        for (int i = 0; i < 26; i++) {
            int lower = ((int) ('a' + i));
            int upper = ((int) ('A' + i));
            total += charCount[lower];
            total += charCount[upper];

            letterCount[i] = charCount[lower] + charCount[upper];
        }

        if (!deviate)  {
            for (int i = 0; i < 26; i++) {
                int upper = ((int) ('A' + i));
                int sum = letterCount[i];
                System.out.printf("The number of " + (char) upper + " is: " + sum
                                  + ". Its percentage of the total is: %.2f%s",
                                  (100.0 * sum / total), "%");
                System.out.println();
            }
        } else {
            double standardDeviation = stanDev(letterCount, deviations);
            double average = total / letterCount.length;
            System.out.println("The standard deviation is: "
                               + standardDeviation);
            System.out.println("The average is: " + average);
            for (int i = 0; i < 26; i++) {
                int upper = ((int) ('A' + i));
                System.out.printf("The deviation of " + (char) upper + " is: "
                                  + deviations[i] + ". Its z-score is %.2f",
                                  deviations[i] / standardDeviation);
                System.out.println();
            }
        }
    }


}



