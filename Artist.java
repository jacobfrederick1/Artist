public class Artist{

    private String genre;
    private String label;
    private Location location;

    public Artist(){
        location = new Location();
        genre = "Metal";
        label = "Death Metal Records";
    }

    public Artist(String genre, String label){
        location = new Location();
        this.genre = genre;
        this.label = label;
    }

    public Artist(String genre,String label,String destination,String date,String section,Double price){
        location = new Location(destination,date,section,price);
        this.genre = genre;
        this.label = label;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setLocation(String destination, String date) {
        getLocation().setLocation(destination, date);
    }

    public String getGenre() {
        return genre;
    }

    public String getLabel() {
        return label;
    }

    public Location getLocation() {
        return location;
    }

}