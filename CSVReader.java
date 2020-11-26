import java.util.Scanner;
import java.io.File;  
import java.io.FileNotFoundException;     

class CSVReader extends FileReader
{
    //Calls FileReaders Constructor
    public CSVReader()
    {
        super();
    }

    //Calls FileReaders Overloaded Constructor
    public CSVReader(String FileName)
    {
        super(FileName);
    }

    //Displays contents of a given file
    public void LoadFile(String FileName) 
    {
        Name = FileName; 
        StringBuilder str = new StringBuilder();        
        try
        {
            File FileType = new File(FileName);     //Creates file attribute
            Scanner Reader = new Scanner(FileType); //Creates Scanner to read file

            while (Reader.hasNextLine()) 
            {
                String line = Reader.nextLine();    //Reads line in file
                line = line.replace(","," | ");
                line = line.replace("\"","");
                FileContent.append(line + "\n");    //Stores multiple lines
            }
            Reader.close();
        }

        //If file cannot be found, display error message
        catch (FileNotFoundException e) 
        {
            System.out.println("\nFile Not Found");
        }
    }     
}
