//Needed imports
import java.util.*;
import java .io.*;

/**
 * public class Artists extends the Artist class- Reads artist from a file and stores them in a list of Artist objects
 */
public class Artists{
    
    private Map<String,Artist> artists;
    String result = "";

    public Artists(){
        artists = new HashMap<>();
    }

    //reads in artist from a file and creates an Artist object for each non duplicate
    public String process(String dataFile){
        String statements = "";
        try{
            File infile = new File(dataFile);
            Scanner input = new Scanner(infile);
            while(input.hasNext()){
                String artist = input.next().toLowerCase();
                if(!exist(artist)){
                    artists.put(artist,new Artist(input.next(),input.next(),input.next(),input.next()));
                    statements += artist + " was successfully added\n";
                }
                else{
                    statements += artist + " was already added\n";
                }
            }
            input.close();
        }
        catch(FileNotFoundException exception){
            return "Error file not found";
        }
        return statements + " " + artists  ;
    }

    //adds an artist to artists with a default Artist constructor.
    public String addArtist(String name){
        if(!exist(name)){
            artists.put(name,new Artist());
            result = name + " was successfully added";
        }
        else{
            result = name + " was already added";
        }
        return result;
    }

    public String addArtist(String name, Artist information){
        if(!exist(name)){
            artists.put(name,information);
            result = name + " was successfully added";
        }
        else{
            result = name + " was already added";
        }
        return result;
    }
    
    //updates all values for an artist
    public String changeValue(String name,String genre,String label,String location,String date){
        if(exist(name)){
            artists.replace(name, artists.get(name), new Artist(genre,label,location,date));
            result = name + "'s values have been updates";
        }
        else{
            result = name + "'s values could not be changed because it does not exist";
        }
        return result;
    }

    //retuns the artist object
    public String getArtist(String name){
        if(exist(name)){
            return name + artists.get(name).toString();
        }
        else{
            result = name + " is not accessable";
        }
        return result;
    }

    //returns a map of the artist
    public Map<String, Artist> getArtists() {
        return artists;
    }

    //returns a set of all the artist
    public Set<String> getArtistKeysSet(){
        return  artists.keySet();
    }

    //returns all of the values in artists
    public Collection getArtistValues(){
        return artists.values();
    }

    //removes an artist and their values
    public String removeArtist(String name){
        if(exist(name)){
            artists.remove(name);
            result = name + "was successfully removed";
        }
        else{
            result = name + "could not be removed because it does not exist";
        }
        return result;
    }

    //test if an artist exist
    public boolean exist(String name){
        if(artists.containsKey(name))
            return true;
        else
            return false;
    }

    public String toString() {
        return "" + artists;
    }

}