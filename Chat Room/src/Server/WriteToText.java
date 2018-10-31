package Server;

import java.util.*;   //includes Scanner
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

//TODO: will need to update build path on final filelocation

public class WriteToText
{
    static Scanner inputStream = null;
    PrintWriter outputStream = null;
    String filePath = "/Users/rjesposito86/IdeaProjects/CS113_Final/login.txt"; //NEEDS TO BE CHANGED ON DIFFERENT COMPUTERS
    ArrayList<String> logins= new ArrayList<>();

    public WriteToText() {

    }
    public void  readLoginInfo() {

        // Check file exist
        try {
            inputStream = new Scanner(new FileInputStream(filePath));
        } catch (FileNotFoundException e) {
            System.out.println("File login.dat was not found");
            System.out.println("or could not be opened");
            System.exit(0);
        }

        while ( inputStream.hasNext() )
        {
            String temp = inputStream.nextLine();
            if(!temp.equals(""))
            {
                logins.add(temp);
            }
        }
    }

    public void writeToFile(String name, String pass){
        try
        {
            outputStream = new PrintWriter(new FileOutputStream
                    (filePath, true));
        }

        //Check to see if file can be created or exists. If not, end program
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening the file output.txt.");
            System.exit(0);
        }

        //Tell user you are writing out to file
        // System.out.println("Writing to file.");

        //Write out to file
        String login = name + "*" + pass;
        outputStream.println(login);

        //Close output file
        outputStream.close();

        //System.out.println("End of program.");
    }

}