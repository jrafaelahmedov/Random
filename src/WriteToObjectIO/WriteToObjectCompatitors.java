package WriteToObjectIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteToObjectCompatitors {
    public static void writeToObjectCompatitorsUsingFileWriter(Object object, String name) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream ;
        try {
            fileOutputStream = new FileOutputStream(name);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
