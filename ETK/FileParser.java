package ETK;

import java.util.*;

public class FileParser{
    private TextFile textFile;
    private FileContent fileContent;
    public FileParser(TextFile textFile){
        this.textFile = textFile;
        this.fileContent = new FileContent();
        scanFile();
    }
    private void scanFile(){
        Scanner reader = getFileScanner();
        int lineNumber = 0;
        while (reader.hasNextLine()){
            lineNumber++;
            breakLine(reader.nextLine());
        }
    }
    private Scanner getFileScanner(){
        return new Scanner(this.textFile.filePath());
    }
    private void breakLine(String line){
        LineBreaker breaker = generateBreaker(line);
        ArrayList<String> broken = breaker.breakLine();
        saveToContent(broken);
    }
    private LineBreaker generateBreaker(String line){
        LineBreaker breaker = new LineBreaker(line);
        Separation separation = Separation.Default();
        breaker.useSeparation(separation);
        this.fileContent.useSeparation(separation);
        return breaker;
    }
    private void saveToContent(ArrayList<String> broken){
        this.fileContent.saveContent(broken);
    }
}