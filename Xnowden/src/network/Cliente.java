package network;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Cliente {

    public final static int SOCKET_PORT = 80;
    public final static String SERVER = "192.168.250.250";
    public final static String FILE_TO_RECEIVED = "C:/Screenshot.jpg";

    public final static int FILE_SIZE = 6022386;

    public Cliente() throws IOException {
        int bytesRead;
        int current = 0;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        Socket sock = null;
        try {
            sock = new Socket(SERVER, SOCKET_PORT);
            System.out.println("Conectando...");

            // receive file
            byte[] mybytearray = new byte[FILE_SIZE];
            InputStream is = sock.getInputStream();
            fos = new FileOutputStream(FILE_TO_RECEIVED);
            bos = new BufferedOutputStream(fos);
            bytesRead = is.read(mybytearray, 0, mybytearray.length);
            current = bytesRead;

            do {
                bytesRead = is.read(mybytearray, current, (mybytearray.length - current));
                if (bytesRead >= 0) {
                    current += bytesRead;
                }
            } while (bytesRead > -1);

            bos.write(mybytearray, 0, current);
            bos.flush();
            System.out.println("Ficheiro " + FILE_TO_RECEIVED + " recebido (" + current + " bytes lidos)");
        } finally {
            if (fos != null) {
                fos.close();
            }
            if (bos != null) {
                bos.close();
            }
            if (sock != null) {
                sock.close();
            }
        }
    }

}
