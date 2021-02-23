package ETK;

public class WordCertifier extends Word{
    private WordCertification certification;
    public WordCertifier(String word){
        super(word);
    }
    public String inDictionary(){
        DictionarySearcher searcher = new DictionarySearcher();
        WordCertification certification = searcher.search(this);
        this.certification = certification;
        String message = null;
        switch (certification){
            case ENGLISH_CERTIFIED:
                message = "Word Is Part Of The English Language";
            case CERTIFIED_THROUGH_INTERRUPT:
                message = "Word Is Part Of The English Language; Thread Was Interrupted During Reading";
            case NOT_FOUND:
                message = "Word Was Not Found In The English Dictionary";
            case INCONCLUSIVE:
                message = "Word Cannot Be Concluded With Its Presence In English; Thread Was Likely Interrupted";
        }
        return message;
    }
}