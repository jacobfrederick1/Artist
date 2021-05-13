//Needed imports
import java.util.*;
import java .io.*;

/**
 * public class Artists extends the Artist class- Reads artist from a file and stores them in a list of Artist objects
 */
public class Artists{
    
    private Map<String,Artist> artists;
    String result = "";

    /**
     * initializes artists map
     */
    public Artists(){
        artists = new HashMap<>();
    }

    /**
     * process method reads in a file and adds the information to a hashmap
     * the hashmap uses an artist name as a key and the following information is sent to Artist
     * @param dataFile the name of the file being read in
     * @return a string stating wether or not the file was sucsessfully read.
     */
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

    /**
     * addArtist method adds a new artist to the hashMap if they do not exist
     * @param name the name of the artist wanting to be added
     * @return a string stating wether or not the artist is already in the hashmap
     */
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

    /**
     * 
     * @param name the name of the artist wanting to be added
     * @param information uses default constructor from Artist class to give the new artist default information
     * @return a string stating wether or not the artist was already in the hashmap
     */
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
    
    /**
     * updates all of the values for an artist
     * @param name the name of the artist
     * @param genre the genre of the artist
     * @param label what label the artist is signed with
     * @param location the location the artist is playing
     * @param date the day the artist is performing
     * @return a string stating wether or not the artist information was successfully updates
     */
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

    /**
     * getArtist returns the the information for a particular artist
     * @param name the name of the artist whose information is to be displayed
     * @return the information about the artist such as genre, label and day and locations of upcoming performances.
     */
    public String getArtist(String name){
        if(exist(name)){
            return name + artists.get(name).toString();
        }
        else{
            result = name + " is not accessable";
        }
        return result;
    }


    /**
     * getArtists returns a specified artist
     * @return the information about the artist
     */
    public Map<String, Artist> getArtists() {
        return artists;
    }

    /**
     * returns all of the artist in the hashmap
     * @return a set containing all of the artist names
     */
    public Set<String> getArtistKeysSet(){
        return  artists.keySet();
    }

    /**
     * getArtistValues returns the information about an artist.
     * @return
     */
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

    /**
     * exist test a name against the hashmap to see if they exist
     * @param name the name of the artist
     * @return boolean value stating wether or not the name was in the hashmap
     */
    public boolean exist(String name){
        if(artists.containsKey(name))
            return true;
        else
            return false;
    }

    /**
     * @return returns a string of the artists hashmap
     */
    public String toString() {
        return "" + artists;
    }

}