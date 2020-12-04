import java.util.*;
public class Artist{

    private String genre;
    private String label;
    private Map<String,String> locations;



    public Artist(){
        locations = new HashMap<>();
        locations.put("United States","1/12/2020");
        genre = "Metal";
        label = "Death Metal Records";
    }

    public Artist(String genre,String label, String location,String date){
        locations = new HashMap<>();
        locations.put(location,date);
        this.genre = genre;
        this.label = label;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void addLocation(String destination, String date) {
        locations.put(destination,date);
    }
    public void setDate(String area, String date){
        locations.replace(area, date);
    }

    public String getGenre() {
        return genre;
    }

    public String getLabel() {
        return label;
    }

    public Set<String> getLocation() {
        return locations.keySet();
    }

    public Map<String,String> getLocations(){
        return locations;
    }

    public String getDate(String area){
        return locations.get(area);
    }

    public Collection<String> getDates(){
        return locations.values();
    }

    public String toString(){
        String output = String.format("'s genre is %1s and are signed with %1s. Their tour locations and dates are as follows: %1s",genre,label,locations );
        output = output.replace("=", " on ").replace("_", " ");
        return output;
    }

    public boolean international(String currentLocation, String eventLocation){
        if(currentLocation.equals(eventLocation))
            return false;
        return true;
    }   
}