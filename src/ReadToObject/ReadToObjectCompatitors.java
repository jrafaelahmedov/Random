package ReadToObject;


import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadToObjectCompatitors {
    public static Object readToObjectCompatitorsUsingOutputStream(String name) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(name))) {
            Object obj = in.readObject();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
