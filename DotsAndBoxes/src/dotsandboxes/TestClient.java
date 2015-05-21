package dotsandboxes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by philipp on 5/21/15.
 */
public class TestClient
{
    public static void main(String[] args)
    {


        System.out.println("Connecting to Server");

        try
        {
            Socket socket = new Socket("127.0.0.1", 12345);

            PrintStream out = new PrintStream(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("Connected");
            out.println("I'm a new client ");

            String line = in.readLine();
            while (line != null)
            {
                System.out.println(line);
                line = in.readLine();
            }

            in.close();
            out.close();
            socket.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
