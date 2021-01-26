package ETK;

public class TDS{
    public static void main(String [] args){
        DictionarySearcher searcher = new DictionarySearcher();
        WordCertification isIn = searcher.search(
            new Word("hello")
        );
        WordCertification isNotIn = searcher.search(
            new Word("heklof")
        );
        System.out.println(isIn);
        System.out.println(isNotIn);
    }
}