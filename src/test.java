import classes.User;

import java.io.*;

public class test {
    public static void main(String[] args) throws Exception {
        String path = "E:\\Server\\Users\\usama78941\\usama78941.dat";
        File file = new File(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Object object = objectInputStream.readObject();
        if (object instanceof User) {
            User user = (User)(object);
            System.out.println(user.toString());
        }

    }
}
