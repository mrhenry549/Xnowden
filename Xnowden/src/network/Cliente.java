package network;

import java.io.*;
import java.net.*;

public class Cliente {

    public static void main(String svi[]) throws IOException {

        try {

            Socket sock = new Socket("192.168.250.250", 80);
            byte[] bytearray = new byte[10000000];
            InputStream is = sock.getInputStream();
            FileOutputStream fos = new FileOutputStream("C:/Gatinhos.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            int bytesread = is.read(bytearray, 0, bytearray.length);
            bos.write(bytearray, 0, bytesread);
            bos.close();
            sock.close();

        } catch (Exception e) {
            System.out.print(e);
        }

    }

}
