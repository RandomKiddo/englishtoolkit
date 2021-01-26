package ETK;

import java.util.*;

public class FileContent{
    private ArrayList<Word> words;
    private Separation separation = null;
    public FileContent(){
        this.words = new ArrayList<Word>();
    }
    public void insert(String word){
        this.words.add(
            new Word(word)
        );
    }
    public void insert(Word word){
        this.words.add(word);
    }
    public void saveContent(ArrayList<String> content){
        ArrayList<Word> contentAsWords = convertToWordIfNotSeparation(content);
        this.words = contentAsWords;
    }
    public void useSeparation(Separation separation){
        this.separation = separation;
    }
    private ArrayList<Word> convertToWordIfNotSeparation(ArrayList<String> content){
        ArrayList<Word> words = new ArrayList<Word>();
        for (String candidate : content){
            if (!this.separation.isSeparation(candidate)){
                words.add(
                    new Word(candidate)
                );
            }
        }
        return words;
    }
}