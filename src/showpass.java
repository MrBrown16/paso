import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class showpass {
    
    public void getPasses() throws FileNotFoundException{
        File file = new File("data.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] lineSP = line.split(":");
            String using = lineSP[0];
            String pwCrypted = lineSP[2];
            String key = getAppKey();
            String plaintext = getPlainText(pwCrypted, key);
            String username = lineSP[1];
            System.out.println(using + " : " + username + " : " + plaintext);
        }
    }
    private String getAppKey(){
        Proper proper = new Proper();
        String appKey = proper.readProper("AppKey");
        return appKey;
    }
    private String getPlainText(String cryptText, String key){
        Crypto crypto = new Crypto();
        String plainText = crypto.decrypt(cryptText, key);
        
        return plainText;
    }

}
