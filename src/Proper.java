import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class Proper {
    final String PROP_FILE = "config.properties";
    Properties pro = new Properties();
    public String readProper(String key) {
        try {
            return tryReadProper(key);
        } catch (IOException e) {
            String msg = "HIBA! A beállítás beolvasása sikertelen";
            System.err.println(msg);
            return msg;
        }
    }
    public String tryReadProper(String key) 
        throws FileNotFoundException, UnsupportedEncodingException, IOException{
            
        FileInputStream fis = new FileInputStream(PROP_FILE);
        InputStreamReader isr = new InputStreamReader(fis,"utf-8");
        Reader reader = new BufferedReader(isr);
        pro.load(reader);
        String result = pro.getProperty(key);
        return result;
    }
}
