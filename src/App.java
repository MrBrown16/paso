import java.security.Key;

public class App {
    public static void main(String[] args) throws Exception {
        // MainMenu mainMenu = new MainMenu();
        // mainMenu.selectMenu();
        //128 bites kulcs (16 darab kar.)
        String key = "343834839224af82";

        Crypto c = new Crypto();
        String cryptText = c.encrypt("titok", key);
        System.out.println(cryptText);
        String plainText = c.decrypt(cryptText, key);
        System.out.println(plainText);
        
    }
}
