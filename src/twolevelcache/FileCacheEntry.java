
package twolevelcache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pavel
 */
public class FileCacheEntry extends BaseCacheEntry {
    File file;
    public FileCacheEntry(Object o){
        super();
        try {
            file = File.createTempFile("cache", "");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(o);
        } catch (IOException ex) {
            Logger.getLogger(FileCacheEntry.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override 
    public Object get(){
        ObjectInputStream ois = null;
        try {
            super.get(); //todo: later fix bad design
            FileInputStream fin = new FileInputStream(file);
            ois = new ObjectInputStream(fin);
            return ois.readObject();
        }
        catch (IOException|ClassNotFoundException ex) {
            Logger.getLogger(FileCacheEntry.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(ois != null){
                    ois.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(FileCacheEntry.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    @Override
    public void dispose() {
        file.delete();
    }
    
}
