/**
 SuperClass Artist, Stores data on artist.
 */
public abstract class Artist {

    //private variables for artist
    private String name;
    private String genre;

    /**
     * Argument constructor- Artist takes two string arguments and sets name to the first string and genre to the second
     * @param name The argument will be assigned to the variable name
     * @param genre The string will be assigned to the variable genre
     */
    public Artist(String name,String genre){
        this.name = name;
        this.genre = genre;

    }

    /**
     * No-Argument constructor - Artist assigns default vaules to name and genre
     */
    public Artist(){
        name = "Motionless In White";
        genre = "Metal";
    }

    /**
     * SetName method takes a string argument and assigns the value to the variable name
     * @param name The String that will be assigned to the private variable name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * SetGenre method takes a string argument and assigns the value to the variable genre
     * @param genre The string that will be assigned to the private variable genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * getName method returns the data stored in the private variable name
     * @return The name of the artist
     */
    public String getName() {
        return name;
    }

    /**
     * getGenre method returns the data stored in the private variable genre
     * @return The genre of the artist
     */
    public String getGenre(){
        return genre;
    }

}
