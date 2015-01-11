import ucb.junit.textui;
import org.junit.Test;
import static org.junit.Assert.*;

public class CipherTest {

    @Test
    public void dummy() { }

    @Test
    public void testShiftLowerCase() {
        char result = CipherRNG.shift('a', 0);
        char expect = 'a';
        assertEquals(expect, result);

        result = CipherRNG.shift('a', 1);
        expect = 'b';
        assertEquals(expect, result);

        result = CipherRNG.shift('a', 10);
        expect = 'k';
        assertEquals(expect, result);

        result = CipherRNG.shift('a', 25);
        expect = 'z';
        assertEquals(expect, result);

        result = CipherRNG.shift('a', 26);
        expect = 'a';
        assertEquals(expect, result);

        result = CipherRNG.shift('x', 26);
        expect = 'x';
        assertEquals(expect, result);

        result = CipherRNG.shift('x', 2);
        expect = 'z';
        assertEquals(expect, result);

        result = CipherRNG.shift('x', 28);
        expect = 'z';
        assertEquals(expect, result);

        result = CipherRNG.shift('x', 3);
        expect = 'a';
        assertEquals(expect, result);

        result = CipherRNG.shift('x', 30);
        expect = 'b';
        assertEquals(expect, result);

        result = CipherRNG.shift('x', 4);
        expect = 'b';
        assertEquals(expect, result);

    }

    @Test
    public void testShiftUpperCase() {
        char result = CipherRNG.shift('A', 0);
        char expect = 'A';
        assertEquals(expect, result);

        result = CipherRNG.shift('A', 1);
        expect = 'B';
        assertEquals(expect, result);

        result = CipherRNG.shift('A', 10);
        expect = 'K';
        assertEquals(expect, result);

        result = CipherRNG.shift('A', 25);
        expect = 'Z';
        assertEquals(expect, result);

        result = CipherRNG.shift('A', 26);
        expect = 'A';
        assertEquals(expect, result);

        result = CipherRNG.shift('X', 26);
        expect = 'X';
        assertEquals(expect, result);

        result = CipherRNG.shift('X', 2);
        expect = 'Z';
        assertEquals(expect, result);

        result = CipherRNG.shift('X', 28);
        expect = 'Z';
        assertEquals(expect, result);

        result = CipherRNG.shift('X', 3);
        expect = 'A';
        assertEquals(expect, result);

        result = CipherRNG.shift('X', 30);
        expect = 'B';
        assertEquals(expect, result);

        result = CipherRNG.shift('X', 4);
        expect = 'B';
        assertEquals(expect, result);
    }

    @Test
    public void testShiftPunctuals() {
        char result = CipherRNG.shift('a', 0);
        char expect = 'a';

        result = CipherRNG.shift(';', 5);
        expect = ';';
        assertEquals(expect, result);

        result = CipherRNG.shift(';', 8);
        expect = ';';
        assertEquals(expect, result);
    }

    @Test
    public void testUnshift() {
        char original = 'k';
        char[] tests = {'a', 'b', 'd', 'e', 'x', 'z', 'A', 'C', 'K', 'Q', 'X',
                        'Z', '.', ',', ';', '3', '6', 'k'};
        for (int i = 0; i < tests.length; i++) {
            original = tests[i];
            assertEquals(original,
                CipherRNG.unshift(CipherRNG.shift(original, 1), 1));
            assertEquals(original,
                CipherRNG.unshift(CipherRNG.shift(original, 5), 5));
            assertEquals(original,
                CipherRNG.unshift(CipherRNG.shift(original, 8), 8));
            assertEquals(original,
                CipherRNG.unshift(CipherRNG.shift(original, 12), 12));
            assertEquals(original,
                CipherRNG.unshift(CipherRNG.shift(original, 18), 18));
            assertEquals(original,
                CipherRNG.unshift(CipherRNG.shift(original, 25), 25));
            assertEquals(original,
                CipherRNG.unshift(CipherRNG.shift(original, 26), 26));
            assertEquals(original,
                CipherRNG.unshift(CipherRNG.shift(original, 54), 54));
        }
    }

    @Test
    public void testEncryptDecrypt() {
        CipherRNG cipher = new CipherRNG("sentinel");
        String plaintext = "Hello World!";
        String ciphertext = cipher.crypt(plaintext, true);
        cipher.reset();
        String decoded = cipher.crypt(ciphertext, false);
        cipher.reset();
        System.out.println("The plaintext is: " + plaintext);
        System.out.println("The ciphertext is: " + ciphertext);
        System.out.println("The decoded text is: " + decoded);

        assertTrue(plaintext.equals(decoded));

        plaintext = "AAAAAAAAAAAAAAAAAAAaa!";
        ciphertext = cipher.crypt(plaintext, true);
        cipher.reset();
        decoded = cipher.crypt(ciphertext, false);
        System.out.println("The plaintext is: " + plaintext);
        System.out.println("The ciphertext is: " + ciphertext);
        System.out.println("The decoded text is: " + decoded);
        assertTrue(plaintext.equals(decoded));
    }





    public static void main(String[] ignored) {
        textui.runClasses(CipherTest.class);
    }



}








