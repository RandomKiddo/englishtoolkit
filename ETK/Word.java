package ETK;


public class Word{
    protected String word;
    public Word(String word){
        this.word = word;
    }
    @Override
    public String toString(){
        return this.word;
    }
}