

public class ArtistTester {
    public static void main(String[] args){

        //Testing for Artist Class

        Artist person = new Artist();

        System.out.print(String.format("\n\nTesting the default constructor in the Artist class\nExpected Genre: Metal\nGenre Result: %1s\nExpected Label: Death Metal Records\nLabel Results: %1s\nExpected Location(s): United States\nLocation Results: %1s\nExpected Date(s): 1/12/2020\nDate(s) Results: %1s. \n"
        ,person.getGenre(),person.getLabel(),person.getLocation(),person.getDate("United States")));

        person.setGenre("Satanic Metal");
        person.setLabel("Kidz-Bop");
        person.addLocation("Europe", "1/09/2020");
        person.setDate("United States", "01/13/1906");

        System.out.print(String.format("\n\nTesting the default constructor in the Artist class after changing values\nExpected Genre: Satanic Metal\nGenre Result: %1s\nExpected Label: Kidz-Bop\nLabel Results: %1s\nExpected Location(s): [United States,Europe]\nLocation Results: %1s\nExpected Date: 01/13/1906\nDate Results: %1s. \n"+
        "Expected Date(s): [01/13/1906, 1/09/2020]\nDate(s) Result: %1s\n"
        ,person.getGenre(),person.getLabel(),person.getLocation(),person.getDate("United States"),person.getDates()));

        

        Artist another = new Artist("Classic Rock", "Old School Rock","Egypt", "05/10/1010");

        System.out.print(String.format("\n\nTesting the Argument constructor in the Artist class\nExpected Genre: Classic Rock\nGenre Result: %1s\nExpected Label: Old School Rock\nLabel Results: %1s\nExpected Location(s): [Egypt\nLocation Results: %1s\nExpected Date(s): 5/10/1010\nDate Results: %1s\nExpected Dates: 5/10/1010\n"+
        "Dates Result: %1s",another.getGenre(),another.getLabel(),another.getLocation(),another.getDate("Egypt"),another.getDates()));

        another.setGenre("Pop");
        another.setLabel("WayneWorld");
        another.addLocation("Columbia", "06/06/1979");
        another.setDate("Egypt", "03/04/1567");

        System.out.print(String.format("\n\nTesting the Argument constructor in the Artist class\nExpected Genre: Pop\nGenre Result: %1s \nExpected Label: WayneWorld\nLabel Result: %1s\nExpected Location(s): [Egypt,Columbia]\nLocation(s) Result: %1s\nExpected Date(s): 03/04/1567\nDate Results: %1s\nExpected Dates: 03/04/1567, 06/06/1979\n"+
        "Date Results: %1s", another.getGenre(),another.getLabel(),another.getLocation(),another.getDate("Egypt"),another.getDates()));
        
        System.out.print(person.toString() + "\n" + another.toString());
    }
}
