package ETK;

import java.util.*;

public class LineBreaker{
    private ArrayList<Word> wordsFound;
    private String line;
    private Separation separation = null;
    public LineBreaker(String line){
        this.line = line;
    }
    public void useSeparation(Separation separation){
        this.separation = separation;
    }
    public ArrayList<String> breakLine(){
        if (separation == null){
            return null;
        }
        return findWords();
    }
    private ArrayList<String> findWords(){
        StringBuffer currentBuilding = new StringBuffer();
        ArrayList<String> contentsIncludingSeparations = new ArrayList<String>();
        String currentWord = "";
        for (int i = 0; i < this.line.length(); i++){
            char currentChar = this.line.charAt(i);
            if (this.separation.isSeparation(currentChar)){
                contentsIncludingSeparations.add(currentWord);
                contentsIncludingSeparations.add("" + currentChar);
            } else {
                currentWord += currentChar;
            }
        }
        contentsIncludingSeparations.add(currentWord);
        return contentsIncludingSeparations;
    }
}