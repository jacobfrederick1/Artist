import java.util.*;
public class Artist{

    private String genre;
    private String label;
    private Map<String,String> locations;


    /**
     * default constructor Artist initialized a map of locations for events and dates
     * sets the genre of a band and their label
     */
    public Artist(){
        locations = new HashMap<>();
        locations.put("United States","1/12/2020");
        genre = "Metal";
        label = "Death Metal Records";
    }

    /**
     * argument constructor that initializes a map of locations for events and dates
     * sets the genre, band's label
     * @param genre the genre of the band
     * @param label the label that the band is signed to
     * @param location the location of their performance
     * @param date the day they will be performing
     */
    public Artist(String genre,String label, String location,String date){
        locations = new HashMap<>();
        locations.put(location,date);
        this.genre = genre;
        this.label = label;
    }

    /**
     * setter method to manipulate the genre of the artist
     * @param genre the genre of the band
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * setter method to manipulate the band's label
     * @param label the band's label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * addlocation method to add a new location and date to the hashmap of locations
     * @param destination the location the band is performing
     * @param date the day the artist is having the performance
     */
    public void addLocation(String destination, String date) {
        locations.put(destination,date);
    }

    /**
     * setdate method to change the date of a performance
     * @param area the location the band is performing
     * @param date the new date the artist is having the performance
     */
    public void setDate(String area, String date){
        locations.replace(area, date);
    }

    /**
     * getGenre returns the genre of the artist
     * @return the artist's genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * returns the artist label
     * @return the label of the artist
     */
    public String getLabel() {
        return label;
    }

    /**
     * getLocation returns all of the artist performance locations
     * @return the locations the artist are performing
     */
    public Set<String> getLocations() {
        return locations.keySet();
    }

    /**
     * getLocation returns the place they are performing on a certain date
     * @return
     */
    public Map<String,String> getLocation(String date){
        return locations;
    }

    /**
     * getDate returns the day they are performing at a certain location
     * @param area the place the artist are performing
     * @return the day the artist are performing at desired location
     */
    public String getDate(String area){
        return locations.get(area);
    }

    /**
     * returns all of the dates that the artist are performing
     * @return the days the artist are performing
     */
    public Collection<String> getDates(){
        return locations.values();
    }

    /**
     * displays all of the artist touring dates
     * @return a string displaying the artist tour dates and locations
     */
    public String toString(){
        String output = String.format("'s genre is %1s and are signed with %1s. Their tour locations and dates are as follows: %1s",genre,label,locations );
        output = output.replace("=", " on ").replace("_", " ");
        return output;
    }  
}