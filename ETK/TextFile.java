package ETK;

import java.io.*;

public class TextFile{
    private File file;
    private String fullFilePath;
    public TextFile(String filePath){
        this.fullFilePath = filePath;
        this.file = new File(filePath);
    }
    public File retrieveFileData(){
        return this.file;
    }
    public String filePath(){
        return this.fullFilePath;
    }
}