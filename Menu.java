import java.io.*;
import java.util.*;

public class Menu
{
    public static void main(String[] args)
    {
        int cmd; 
        int currentIndex = 0;
        final int SIZE = 20;
        String FileName;
        String DataDirectory = "/home/falkn111/Java/OOAD"; //Place where the files are stored      
        FileReader Files[] = new FileReader[SIZE];         //Array that contains all files
        Scanner sc = new Scanner(System.in);
       
        //Loading Files into Array
        File dir = new File(DataDirectory);
        for (File f : dir.listFiles())
        {
            if(f.getName().contains(".csv"))
            {
                Files[currentIndex] = new CSVReader();
                Files[currentIndex].LoadFile(f.getName());
                currentIndex++;
            }
        }

        //Menu that user views
		System.out.println("Welcome to the Windsor Open Data Source Center\n");
        while(true)
		{		
            System.out.println("Main Menu");
            System.out.println("__________");
            System.out.println("\nHow would you like to search?");
            System.out.println("1. Search Bar");
            System.out.println("2. View All Files");
            System.out.println("0. Exit");
            System.out.print(">> ");
            cmd = sc.nextInt();
        
            switch(cmd)
            {
                //Search Bar Functionality
                case 1: System.out.println("\nWhat would you like to view?");
                        System.out.print(">> ");
                        FileName = sc.next();
                        FileName = FileName.toLowerCase();
                        FileReader Temp[] = new FileReader[SIZE];   //Temporary Array for Search Options
                        int holder = 0;
                        for(int i = 0; i < currentIndex; i++)
                        {
                            if(Files[i].getFileName().toLowerCase().contains(FileName))       //Transfers to temp array if search matches
                            {
                                Temp[holder] = new CSVReader();
                                Temp[holder].Name = Files[i].getFileName();
                                Temp[holder].FileContent = Files[i].getRawFileContent();
                                System.out.println(holder + ": " + Temp[holder].getFileName());
                                holder++;
                            }
                        }
                        if(holder == 0)
                        {
                            System.out.println("No Files Found");
                            break;
                        }
                        else if(holder == 1)
                        {
                            System.out.println(Temp[0].getFileName());
                            System.out.println(Temp[0].getFileContent());
                            break;
                        }

                        System.out.println("\nWhich one would you like to view? (0 - " + (holder-1) + ")");
                        System.out.print(">> ");
                        cmd = sc.nextInt();
                        if((cmd <= holder-1) && (cmd >= 0))
                        {
                            System.out.println(Temp[cmd].getFileContent());
                        }
                        else
                        {
                            System.out.println("Invalid Entry");
                        }
                        break; 
                
                //View All Files Functionality
                case 2: System.out.println("\nList of Files to Choose From:");

                        for(int i = 0; i < currentIndex; i++)
                        {
                            System.out.println(i + ": " + Files[i].getFileName());
                        }

                        System.out.println("\nWhich one would you like to view? (0 - " + (currentIndex-1) + ")");
                        System.out.print(">> ");
                        cmd = sc.nextInt();
                        if((cmd <= currentIndex-1) && (cmd >= 0))
                        {
                            System.out.println(Files[cmd].getFileContent());
                        }
                        else
                        {
                            System.out.println("Invalid Entry\nReturning to Main Menu");
                        }
                        break;
                
                //Exit Program
                case 0: System.out.println("\nThank you for exploring Windsor's Open Data Source Center");
                        System.exit(0);
                        break;

                //Any Other Input Case
                default:System.out.println("\nInvalid Command");
                        break;
            }
        }	
        
        
     
    }
}
