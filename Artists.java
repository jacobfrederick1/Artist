//Needed imports
import java.util.*;
import java .io.*;

/**
 * public class Artists extends the Artist class- Reads artist from a file and stores them in a list of Artist objects
 */
public class Artists{
    
    Map<String,Artist> performers;

    public Artists(){
        performers = new HashMap<>();
    }

    public void process(String file){
        
        try {
            File infile = new File(file);
            Scanner input = new Scanner(infile);

            // Test if file has text
            while (input.hasNext()) {
                String key = input.next();
                if(performers.containsKey(key)){
                    performers.put(input.next(), new Artist(input.next(),input.next()));
                }
            }
            input.close();
        }
        // catches exception and prints error statement
        catch (Exception e) {
            System.out.print("The file was not found!");
        }
    }
    
}