import java.io.IOException;
import java.util.Scanner;

public class MainMenu {
    Scanner scanner; //Adattag
    public MainMenu() {
        scanner = new Scanner(System.in);
    }
    //TODO: itt lesz egy változtatni való
    
    public void showMenu() {
        System.out.println();
        System.out.println("----------------------");
        System.out.println("   1.) Megtekintés");
        System.out.println("   2.) Új jelszó");
        System.out.println("   3.) Kilépés");
        System.out.println("----------------------");
        System.out.println();
    }
    public void selectMenu() throws IOException {        
        String selected = "";
        while(!selected.equals("3")) {
            showMenu();
            System.out.print("Választás: ");
            selected = scanner.nextLine();
            if (selected.equals("1")) {
                System.out.println("Megetekintés árnyékeljárás");
                scanner.nextLine();
            }else if (selected.equals("2")) {
                Newpass newpass = new Newpass();
                newpass.addNewpass();
                scanner.nextLine();
            }
        }
        
    }
}
