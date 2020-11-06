//Needed imports
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * public class Artists extends the Artist class- Reads artist from a file and stores them in a list of Artist objects
 */
public class Artists extends Artist{

    
    List <Artists> artists;
    
    
    /**
     * No Argument Constructor Artist - initializes the list and overrides Artist no argument constructor
     */
    public Artists(){
        super("Motionless In White", "Metal");
        artists = new ArrayList<>();
    }

    /**
    * Argument constructor- Artist takes two string arguments sends them to the constructor in the super class
    * @param name The argument will be assigned to the variable name
    * @param genre The string will be assigned to the variable genre
    */
    public Artists(String name,String genre){
        super(name,genre);
    }
    
    /**
     * readArtist method takes a file in string format and uses try-catch blocks to read in all the values from the file.
     * In addition, the names and genres are read in line at a time and placed in the argument constructor to be added to the list of artists until.
     * there are no more lines on the file. Throws error if the file is unable to be opened
     * @param fileName The name of the file that is trying to be read
     * @return Boolean value dependent on if the file was able to be opened and the data extracted.
     */
    public boolean readArtists(String fileName){

        /*try block to test if the file can be open
         *uses File and Scanner objects to open and read file
        */
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            while(reader.hasNext()){
                artists.add(new Artists(reader.next().replace("_", " "),reader.next()));
            }
            reader.close();
        //catches error if the file trying to be opened is not found or readable.
        } catch (FileNotFoundException F) {
            System.out.print("It appears the file name you entered does not match a file or directory!");

        }
        //returns boolean of true if file is found
        return true;
    }

    /**
     * count method takes no arguments and returns the number of indexes in the list
     * @return The number of indexes in the list
     */
	public int count(){
        return artists.size();
    }
    
    /**
     * count method takes a string argument and test it against the genres in the list 
     * to return the number of artist in that genre
     * @param genre The genre that the user is looking for in the list
     * @return The number of artist that are classified as that genre
     */
    public int count(String genre) {
        int count = 0;
        for (Artists each : artists) {
            if(each.getGenre().equals(genre)){
                count++;
            }
        }
        return count;
    }

    /**
     * addArtist takes two string arguments to compare to the artist in the list. If the artist is not found in the list
     * then the artist along with there genre will be added to the list. if the name is found then it test to see if the genre
     * is different and if it is then the genre for that artist will be updated to the new genre
     * @param artist The artist the user is looking for
     * @param genre  The genre that the user is looking for in association to the artist
     */
    public void addArtist(String artist, String genre){
        boolean flag = false;

       for (Artists artists2 : artists) {
           if(artists2.getName().toLowerCase().equals(artist.toLowerCase())){
               flag = false;
               if(!artists2.getGenre().equals(genre)){
                    artists2.setGenre(genre);
               }
               break;
           }
           else if(artists.get(artists.size()-1).equals(artists2)){
               flag = true;
           }  
       }
       if(flag == true){
          artists.add(new Artists(artist, genre));
       }
    }

    /**
     * display takes two arguments one of type string and the other of type int. The method will display n
     * number of artist whose genre matches the argument genre.
     * @param genre The genre that the user is searching for
     * @param n The max number of artist in that genre that will be displayed
     * @return The number of artist found in that genre
     */
    public int display(String genre, int n){
        String artistByGenre = "";
        int type = 0;
        for (Artists artist : artists) {
            if(artist.getGenre().equals(genre) && type < n){
                artistByGenre += artist.getName() + ", ";
                type+=1;
            }
        }
        System.out.print(artistByGenre);
        return type;
    }

    /**
     * getArtist method takes a String and an int and test to see if the genre matches any genres in the list
     * if it does it adds the artist name to a string variable to be displayed later. It will repeat the process
     * until it reaches the end of the list of it has the int number of artist.
     * @param genre The genre that the user is searching for
     * @param i The max number of artist matching the genre to be displayed
     * @return A string of the artist that match the genre the user was looking for
     */
    public String getArtists(String genre, int i){
        String artistByGenre = "";
        int count = 0;
        for (Artists artist : artists) {
            if(artist.getGenre().equals(genre) && count <=i){
                artistByGenre += artist.getName() + " ";
                count++;
            }
        }
       return artistByGenre;
    }

    /**
     * genre method takes a string argument which is the name of an artist and test it against other
     * artist's names within the list. if it comes back with a match the method will return the artist genre.
     * if it fails to find a match it returns unknown
     * @param name The name of the artist the user is looking for
     * @return The genre of the artist the user was looking for
     */
    public String genre(String name){
        String genre = "";
        Boolean flag = false;
        for (Artists artists2 : artists) {
            if(artists2.getName().toLowerCase().equals(name.toLowerCase())){
                genre = artists2.getGenre();
                flag = true;
            }
        }
        if(flag == false){
            addArtist(name,"unknown");
            genre = "unknown";
        }
        return genre;
    }
}
