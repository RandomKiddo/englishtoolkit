package ETK;

import java.io.*;
import java.util.*;

public class DictionaryReader implements Runnable{
    private File dictionary;
    public static final String dictionaryFileDownloadURL = "http://www.gwicks.net/dictionaries.html";
    private ArrayList<String> certifiedWords;
    public DictionaryReader(String directory){
        this.dictionary = new File(directory);
        this.certifiedWords = new ArrayList(200_000);
    }
    public void read(){
        run();
    }
    @Override
    public void run(){
        Scanner reader = getReadingMechanism();
        if (reader == null){
            throw new RuntimeException("Scanner could not find file through filepath for dictionary");
        }
        while (reader.hasNextLine()){
            this.certifiedWords.add(
                reader.nextLine().trim()
            );
        }
    }
    private Scanner getReadingMechanism(){
        Scanner reader = null;
        try{
            reader = new Scanner(this.dictionary);
        } catch (FileNotFoundException fnferr){
            reader = null;
        } finally {
            return reader;
        }
    }
    public ArrayList<String> getCertifiedWords(){
        return this.certifiedWords;
    }
}