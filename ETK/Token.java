package ETK;

import java.lang.reflect.*;

/**
 * @author Neil G
 * @version Token-1.0
 * <pre>
 * 
 * Token enum used to separate a sentence using SentenceTokenizer
 * In SentenceTokenizer, the found Token will then be split into its own place in the ArrayList
 * 
 * Token.APOSTROPHE is a special case, due to it sometimes being grouped with its meaning. For example,
 * the word "Jack's" would be split into ["Jack", "'s"], not ["Jack", "'", "s"]
 * 
 * Dependencies:
 * java.lang.reflect.*
 * </pre>
 */
public enum Token{
    PERIOD("."),
    EXCLAMATION("!"), 
    QUESTION("?"),
    HYPHEN("-"),
    UNDERLINE("_"),
    OPEN_PARENTHESIS("("),
    CLOSE_PARENTHISES(")"),
    OPEN_BRACES("{"),
    CLOSE_BRACES("}"),
    OPEN_BRACKETS("["),
    CLOSE_BRACKETS("]"),
    SPACE(" "),
    COLON(":"),
    COMMA(","),
    SEMICOLON(";"),
    OPEN_ARROW("<"),
    CLOSE_ARROW(">"),
    QUOTATION("\""),
    APOSTROPHE("\'");
    /**
     * The value represented by the token
     */
    public String value;
    private Token(String value){
        this.value = value;
    }
    /**
     * Checks if the String input is a Token value
     * @param piece The String value to check
     * @return true if it is a token value, false otherwise
     */
    public static boolean isToken(String piece){
        for (Token token : Token.values()){
            if (piece.equals(token.toString())){
                return true;
            }
        }
        return false;
    }
    @Override
    /**
     * Returns the value of this token
     * @return This Token instance's value
     */
    public String toString(){
        return this.value;
    }
}