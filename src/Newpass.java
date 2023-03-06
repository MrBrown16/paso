import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Newpass {
    Scanner scanner;
    public Newpass() {
        this.scanner = new Scanner(System.in);
    }
    
    public void addNewpass() {
        System.out.println("\n-----Új jelszó-----");
        System.out.print("Használat: ");
        String using = this.scanner.nextLine();
        System.out.print("Felhasználónév: ");
        String username = this.scanner.nextLine();
        System.out.print("Jelszó: ");
        String pass = this.scanner.nextLine();
        System.out.println("Folytatáshoz nyomjon egy Entert...");
        appendToFile(using, username, pass);
    }
    private void appendToFile(String using,String username, String pass)  {
        try {
            tryAppendToFile(using, username, pass);
        } catch (IOException e) {
            System.err.println("Hiba! A fájlba írás sikertelen!");
        }
    }
    private void tryAppendToFile(String using,String username, String pass) throws IOException {
        String key = this.getAppKey();
        String cryptText = getCryptedText(pass, key);
        FileWriter fileWriter = new FileWriter(
            "data.txt", 
            Charset.forName("utf-8"),
            true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        String line = using + ":" + username + ":" + cryptText;
        printWriter.println(line);
        printWriter.close();
    }
    private String getAppKey(){
        Proper proper = new Proper();
        String appKey = proper.readProper("AppKey");
        return appKey;
    }
    private String getCryptedText(String plainText, String key){
        Crypto crypto = new Crypto();
        String cryptText = crypto.encrypt(plainText, key);
        return cryptText;
    }
}
