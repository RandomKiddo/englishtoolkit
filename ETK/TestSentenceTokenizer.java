package ETK;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSentenceTokenizer{
    private final String TEST_SENTENCE = 
    "John Doe\'s food! Is it good? Yes, it is. (Now 50% off) - Limited time only: new food in stock; only at select locations [LA, SF {Cali}]. <_Nick>: \"Isn\'t it so good?\"";
    public TestSentenceTokenizer(){
        //Declaration Necessary For Compilation
    }
    @Test
    public void testTokenizer(){
        Object[] shallowTokens = SentenceTokenizer.tokenize(TEST_SENTENCE).toArray();
        Object[] correctTokens = {
            "John", " ", "Doe", "\'s", " ", "food", "!", " ", "Is", " ", "it", " ", "good", "?", " ", "Yes", ",", " ",
            "it", " ", "is", ".", " ", "(", "Now", " ", "50%", " ", "off", ")", " ", "-", " ", "Limited", " ", "time",
            " ", "only", ":", " ", "new", " ", "food", " ", "in", " ", "stock", ";", " ", "only", " ", "at", " ", "select",
            " ", "locations", " ", "[", "LA", "," ," ", "SF", " ", "{", "Cali", "}", "]", ".", " ", "<", "_", "Nick", ">", ":",
            " ", "\"", "Isn", "\'t", " ", "it", " ", "so", " ", "good", "?", "\""
        };
        assertEquals(compileTokens(shallowTokens), (compileTokens(correctTokens)));
    }
    private String compileTokens(Object[] shallowCopy){
        String compiled = "";
        for (Object obj : shallowCopy){
            compiled += obj.toString();
        }
        return compiled;
    }
}