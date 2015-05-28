package dotsandboxes;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by philipp on 5/21/15.
 */
public class Server extends Thread
{

    private final String SERVER_IP = "127.0.0.1";
    public ServerRequestHandler mClient;
    private int mServerPort = 1337;
    private ServerSocket mServerSocket;
    private boolean mRunning = false;

    public Server(int pPort)
    {
        mServerPort = pPort;
    }

    public void startServer()
    {
        try
        {
            mServerSocket = new ServerSocket(mServerPort);
            this.start();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void stopServer()
    {
        mRunning = false;
        this.interrupt();
    }

    @Override
    public void run()
    {
        mRunning = true;
        while (mRunning)
        {
            try
            {
                System.out.println("Listening for a connection");

                // Call accept() to receive the next connection
                Socket socket = mServerSocket.accept();

                // Pass the socket to the RequestHandler thread for processing
                mClient = new ServerRequestHandler(socket);
                mClient.start();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

}
