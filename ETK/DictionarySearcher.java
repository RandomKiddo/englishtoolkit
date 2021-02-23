package ETK;

import java.io.*;
import java.util.*;

public class DictionarySearcher{
    public static long FORCE_INTERRUPT_TIME = 60_000;
    public static String customDirectory = "/Users/firsttry/Desktop/english3.txt"; //update this with personal file directory
    private boolean interrupted;
    public DictionarySearcher(){
        this.interrupted = false;
    }
    public WordCertification search(Word word){
        ArrayList<String> certifiedWords = readDictionary();
        return certifyWord(certifiedWords, word);
    }
    private ArrayList<String> readDictionary(){
        DictionaryReader reader = new DictionaryReader(
            DictionarySearcher.customDirectory
        );
        Thread dictionaryMonitor = new Thread(reader);
        dictionaryMonitor.run();
        monitorThread(dictionaryMonitor);
        return reader.getCertifiedWords();
    }
    private void monitorThread(Thread thread){
        long start = System.currentTimeMillis();
        long stop = start;
        while (thread.isAlive()){
            stop = System.currentTimeMillis();
            if (stop > start + FORCE_INTERRUPT_TIME){
                thread.interrupt();
                this.interrupted = true;
            }
        }
    }
    private WordCertification certifyWord(ArrayList<String> certifiedWords, Word word){
        int left = 0, right = certifiedWords.size();
        while (left <= right){
            int split = (left + right) / 2;
            String currentWord = certifiedWords.get(split);
            int comparison = word.toString().toLowerCase().compareTo(currentWord.toLowerCase());
            if (comparison == 0 && !this.interrupted){
                return WordCertification.ENGLISH_CERTIFIED;
            } else if (comparison == 0 && this.interrupted){
                return WordCertification.CERTIFIED_THROUGH_INTERRUPT;
            } else if (comparison > 0){
                left = split;
            } else {
                right = split;
            }
        }
        if (this.interrupted){
            return WordCertification.INCONCLUSIVE;
        }
        return WordCertification.NOT_FOUND;
    }
}