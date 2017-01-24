package network;

import java.io.*;
import java.net.*;

public class Server{

    public Server() throws IOException {

        try {

            ServerSocket servsock = new ServerSocket(80);
            File myfile = new File("C:/screenshot.jpg");

            while (true) {

                Socket sock = servsock.accept();
                byte[] mybytearray = new byte[(int) myfile.length()];
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myfile));
                bis.read(mybytearray, 0, mybytearray.length);
                OutputStream os = sock.getOutputStream();
                os.write(mybytearray, 0, mybytearray.length);
                os.flush();
                sock.close();
            }
        } catch (Exception e) {
            System.out.print(e);
        }

    }

}
