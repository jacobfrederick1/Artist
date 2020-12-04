import java.util.Scanner;

public class MusicEvents {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Artists person = new Artists();
        String decision = "";
        person.process("artists30.txt");

        System.out.print(
            "\nWelcome to the Artist register! Here we store information about artist such as the ones listed below:\n"
            + person.getArtistKeysSet() + "\n"
        );

        while(true){
            System.out.print("Would you like to add any artist to the list(Yes/No)? ");
            decision = input.next();
            if(decision.equals("Yes")){
                while(true){

                    System.out.print("Do you know all of their information or just their name(All/Some? ");
                    decision = input.next();
                    if(decision.equals("All")){
                        System.out.print("You have selected All! Please enter thier name, genre, label, a touring location and a date for the event: ");
                        System.out.println(person.addArtist(input.next(), new Artist(input.next(),input.next(),input.next(),input.next())));
                        break;
                    }

                    else if(decision.equals("Some")){
                        System.out.print("You have selected Some! Please enter thier name: ");
                        System.out.println(person.addArtist(input.next()));
                        break;
                    }

                    else{
                        System.out.println("Please enter All/Some!");
                    }
                }
            }
            else if(decision.equals("No")){
                break;
            }
            else{
                System.out.print("Error: Please Select Yes/No!");
            }
        }

        while (true){
            System.out.print("\n" + person.getArtistKeysSet() + "\nWould you like to see any of the artist named above(Yes/No)? ");
            decision = input.next();
            if (decision.equals("Yes")) {
                System.out.print("Who would you like to see? ");
                decision = input.next();
                System.out.print(person.getArtist(decision)+ "\n");
            } 
            else if (decision.equals("No")) {
                break;
            } 
            else {
                System.out.print("Error: Please type Yes/No!\n");
            }

        }
        input.close();
    }
}
