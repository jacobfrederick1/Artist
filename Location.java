import java.util.*;

public class Location {
    private Map<String,String> locations;
    private String section;
    private double priceOfTicket;

    public Location(){
        locations = new HashMap<>();
        locations.put("UnitedStates","1/12/2020");
        section = "Upper Level";
        priceOfTicket = 250;
    }
    public Location(String location,String date,String section,double price){
        locations = new HashMap<>();
        locations.put(location,date);
        this.section = section;
        priceOfTicket = price;
    }
    
    public void setLocation(String location,String date) {
        locations.put(location, date);
    }

    public void setPriceOfTicket(double priceOfTicket) {
        this.priceOfTicket = priceOfTicket;
    }
    
    public void setSection(String section) {
        this.section = section;
    }

    public Map<String, String> getLocations() {
        return locations;
    }
    
    public double getPriceOfTicket() {
        return priceOfTicket;
    }
    
    public String getSection() {
        return section;
    }
    
}
