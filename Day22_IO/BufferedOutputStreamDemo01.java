package Day22_IO;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamDemo01 {

    public static void main(String[] args) {
        try {
            FileOutputStream fis = new FileOutputStream("b.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fis,1024);
            bos.write(97);
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
