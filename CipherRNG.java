import java.util.Random;


/** Class that performs shifting based on RNG.
 *  @author XiaRui (Charles) Zhang. */
public class CipherRNG {

    private Random gen;
    private String key;

    /** Generates a new CipherRNG objec that uses
     *  PASSWORD as the encryption key. */
    public CipherRNG(String password) {
        gen = new Random(password.hashCode());
        key = password;
    }

    /** Shifts LETTER by OFFSET. Returns the shifted
     *  character. Handles wraparound behavior. */
    public static char shift(char letter, int offset) {
        char result = letter;
        char lower = 'a';
        char upper = 'z';
        int range = 26;

        if (letter >= 'a' && letter <= 'z') {
            lower = 'a';
            upper = 'z';
        } else if (letter >= 'A' && letter <= 'Z') {
            lower = 'A';
            upper = 'Z';
        } else if (letter >= '0' && letter <= '9') {
            lower = '0';
            upper = '9';
            range = 10;
        }  else {
            return (letter);
        }

        offset = offset % range;
        if (offset < 0) {
            offset = (offset % range) + range;
        }
        char temp = (char) (offset);
        result = (char) (letter + temp);

        if (result > upper) {
            result = (char) (((result - upper) % range) + lower - 1);
        }
        return result;
    }

    /** Reverses the effect of shifting LETTER by OFFSET.
     *  Returns the result. */
    public static char unshift(char letter, int offset) {
        return shift(letter, -1 * offset);
    }

    /** Encrypts LETTER with OFFSET. Returns the result (as a String).
     *  */
    private static String encrypt(char letter, int offset) {
        return String.valueOf(shift(letter, offset));
    }

    /** Decrypts LETTER with OFFSET. Returns the result (as a String).
     *  */
    private static String decrypt(char letter, int offset) {
        return String.valueOf(unshift(letter, offset));
    }

    /** Either encrypt MSSG or decrypt it, depending on ENCODE.
     *  Returns the result of encrypting/decrypting mssg. */
    public String crypt(String mssg, boolean encode) {
        String result = "";

        for (int i = 0; i < mssg.length(); i++) {
            int offset = gen.nextInt();
            if (encode) {
                result += encrypt(mssg.charAt(i), offset);
            } else {
                result += decrypt(mssg.charAt(i), offset);
            }
        }
        return result;
    }

    /** Resets the RNG. */
    public void reset() {
        gen = new Random(key.hashCode());
    }

}

