package ETK;

import java.util.*;

/**
 * @author Neil G
 * @version SentenceTokenizer-1.0
 * <pre>
 * 
 * SentenceTokenizer instances are used to tokenize a String sentence into its pieces. 
 * 
 * For example:
 * "Hello world! I love you!"
 * 
 * would result in...
 * 
 * ["Hello", " ", "world", "!", " ", "I", " ", "love", " ", "you", "!"]
 * 
 * Dependencies:
 * java.util.*
 * </pre>
 */
public class SentenceTokenizer{
    /**
     * Tokenizes the String sentence parameter into it's pieces separated by Token values
     * @param sentence The String sentence to tokenize
     * @return An ArrayList<String> instance of the String pieces
     */
    public static ArrayList<String> tokenize(String sentence){
        ArrayList<String> tokens = new ArrayList<String>();
        String piece = "";
        for (int i = 0; i < sentence.length(); i++){
            String currentChar = sentence.substring(i, i+1);
            if (isToken(currentChar)){
                tokens.add(piece);
                tokens.add(currentChar);
                piece = "";
            } else {
                piece += currentChar;
            }
        }
        return tokens;
    }
    private static boolean isToken(String piece){
        return Token.isToken(piece);
    }
}