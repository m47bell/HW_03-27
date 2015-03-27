package nyc.c4q.m47bell;

/**
 * Created by c4q-marbella on 3/25/15.
 * Access Code 2-1
 * Marbella Vidals
 * Write a function called codeBreaker, which accepts two cipher strings
 * and returns a boolean value which tells us whether they are actually
 * the same input message encoded using two different offsets.
 */
import java.util.Scanner;
public class CaesarCipher {

    public static String decode(String enc, int offset) {

        return encode(enc, 26 - offset);
    }

    public static String encode(String enc, int offset) {
        offset = offset % 26 + 26;
        StringBuilder encoded = new StringBuilder();
        for (char i : enc.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    encoded.append((char) ('A' + (i - 'A' + offset) % 26));
                } else {
                    encoded.append((char) ('a' + (i - 'a' + offset) % 26));
                }
            } else {
                encoded.append(i);
            }
        }
        return encoded.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to encode");

        String input = sc.nextLine();
        String encoded = CaesarCipher.encode(input, 25);
        System.out.println("Encoded message: " + encoded);

        String decoded = CaesarCipher.decode(encoded, 25);
        System.out.println("Decoded message: " + decoded + "\n");

        //compare two encoded messages if they are the same input message

        //using the word green(string input), then comparing it to Rot-13- terra
        codeOrigin(encoded, "terra");

    }

    public static void codeOrigin(String code1, String code2) {
        if (codeBreaker(code1, code2)) {
            System.out.println("Same input message");
        } else {
            System.out.println("Not the same input message");
        }
    }

    public static boolean codeBreaker(String code1, String code2) {

        boolean inputMessage = true;

        //check if the two encoded strings are not same length
        if (code1.length() != code2.length()) {

            //Not the same length, can't determine if they are the same, return false;
            return false;

        } else {
            //if same length, then...
            //one string is encoded with cesar cipher, retrieve the decoded string to get offset of second encoded string
            String decoded = CaesarCipher.decode(code1, 25);

            //calculate the offset between the decoded message and code 2 using the ascii

            int asciiCode2 = code2.charAt(0);
            int asciiDecode = decoded.charAt(0);
            int offset = 0;
            int decodeAsciiCode2 = 0;


            for (int i = 1; i < code2.length(); i++) {

                // if asciiCode2 is greater than asciiCode1, subtract offset (code2-decode)
                if (asciiCode2 > asciiDecode) {
                    offset = asciiCode2 - asciiDecode;

                    //decode asciiCode2 with offset and compare with decode
                    decodeAsciiCode2 = asciiCode2 - offset;

                    // convert int to char
                    char code2Char = (char) decodeAsciiCode2;

                    //convert to string
                    String decodeCode2 = Character.toString(code2Char);

                    return inputMessage;

                } else if (asciiCode2 == asciiDecode) {

                    return inputMessage;

                    // if asciiCode2 is less than asciiCode1
                } else
                    offset = Math.abs(asciiCode2 - asciiDecode);

                decodeAsciiCode2 = asciiCode2 + offset;

                // convert int to char
                char code2Char = (char) decodeAsciiCode2;

                //convert to string
                String decodeCode2 = Character.toString(code2Char);

                //compare the two decoded strings to determine if same input message
                if (decodeCode2.equals(decoded)) {
                    return inputMessage;
                }
            }
            return inputMessage;


        }
    }
}