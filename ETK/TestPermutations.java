package ETK;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPermutations{
    private Permutations permutations;
    private static final String TEST_STRING = "ABC";
    public TestPermutations(){
        //Declaration Necessary For Compilation
    }
    @Before
    public void setUp(){
        this.permutations = new Permutations(TEST_STRING);
    }
    @Test
    public void testPermutationGeneration(){
        String[] result = this.permutations.getPermutations();
        String[] expected = {
            "ABC", "ACB",
            "BAC", "BCA",
            "CAB", "CBA"
        };
        assertEquals(result, expected);
    }
}
