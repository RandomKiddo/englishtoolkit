package ETK;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDictionarySearcher{
    protected DictionarySearcher searcher;
    public TestDictionarySearcher(){
        //Declaration needed for compilation
    }
    @Before
    public void setUp(){
        this.searcher = new DictionarySearcher();
    }
    @Test
    public void testSearch(){
        WordCertification isIn = searcher.search(
            new Word("hello")
        );
        WordCertification isNotIn = searcher.search(
            new Word("heklof")
        );
        assertEquals(isIn, WordCertification.ENGLISH_CERTIFIED);
        assertEquals(isNotIn, WordCertification.NOT_FOUND);
        if (isIn == WordCertification.INCONCLUSIVE || isNotIn == WordCertification.INCONCLUSIVE){
            assertTrue(false); //notifies JUnit that a Thread interrupt occurred, tilt: supposed to fail
        } else {
            assertTrue(true);
        }
    }
}