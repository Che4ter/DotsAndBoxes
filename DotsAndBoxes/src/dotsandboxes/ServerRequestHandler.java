package dotsandboxes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by philipp on 5/21/15.
 */
public class ServerRequestHandler extends Thread
{
    private Socket mSocket;
    private BufferedReader mInputStream;
    private PrintWriter mOutputStream;

    ServerRequestHandler(Socket socket)
    {
        this.mSocket = socket;
    }

    @Override
    public void run()
    {
        try
        {
            System.out.println("Received a connection");

            // Get input and output streams
            mInputStream = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
            mOutputStream = new PrintWriter(mSocket.getOutputStream());

            SendToClient("Welcome to DotsAndBoxes :)");

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void SendToClient(String pMessage)
    {
        mOutputStream.println(pMessage);
        mOutputStream.flush();
    }

    public String ReadFromClient()
    {
        String message = "";

        try
        {
            String line = mInputStream.readLine();
            while (line != null && line.length() > 0)
            {
                message += line;
                line = mInputStream.readLine();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return message;

    }

    public void CloseConnection()
    {
        try
        {
            mInputStream.close();
            mOutputStream.close();
            mSocket.close();
            System.out.println("Connection closed");
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
