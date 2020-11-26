import java.util.Scanner;
import java.io.File;  
import java.io.FileNotFoundException; 
import java.lang.StringBuilder;

abstract class FileReader 
{
    protected String Name;
    protected StringBuilder FileContent; 
    
    public FileReader()
    {
        Name = "Empty";
        FileContent = new StringBuilder("");
    }
    
    public FileReader(String FileName)
    {
        Name = FileName; 
        FileContent = new StringBuilder("");
    }

    abstract void LoadFile(String FileName);
 
    
    public String getFileName()
    {
        return Name;
    }

    public StringBuilder getRawFileContent()
    {
        return FileContent;
    }

    public String getFileContent()
    {
        String output = FileContent.toString();
        return output; 
    }
}
