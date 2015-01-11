import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/** The class that handles User interaction, and then uses
 *  CipherRNG to encrypt/decrypt files.
 *  @author XiaRui (Charles) Zhang */
public class Encrypt {

    /** The main method. Handles UI, ARGS contains necessary info.
     *  */
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        String input;
        String output;
        boolean encode;

        if (args.length < 2) {
            System.out.println("Please enter the file name to read from");
            input = keyboard.next();
            System.out.println("Please enter the file name to write to");
            output = keyboard.next();
            System.out.println("Encrypting or decrypting? e for encrypting"
                               + " d for decrypting.");
            encode = (keyboard.next().equals("e"));
        } else {
            input = args[0];
            output = args[1];
            encode = (args.length > 2) && (args[2].equals("e"));
        }

        System.out.println("Please enter the encryption key.");
        String key = keyboard.next();

        CipherRNG cipher = new CipherRNG(key);

        try {
            BufferedReader br = new BufferedReader(new FileReader(input));
            PrintWriter writer = new PrintWriter(output);

            String line = br.readLine();
            while (line != null) {
                writer.println(cipher.crypt(line, encode));
                line = br.readLine();
            }
            br.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("Error with reading/writing file.");
            System.out.println(e);
        }

    }



}
