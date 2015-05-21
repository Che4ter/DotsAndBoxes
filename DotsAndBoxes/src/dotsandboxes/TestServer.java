package dotsandboxes;

/**
 * Created by philipp on 5/21/15.
 */
public class TestServer
{
    public static void main(String[] args)
    {
        System.out.println("Start server on port 42");

        try
        {
            Server server = new Server(12345);
        server.startServer();
            while (server.mClient == null)
            {
                Thread.sleep(1000);
            }
        System.out.println(server.mClient.ReadFromClient());
        Thread.sleep(1000);
        server.mClient.SendToClient("Hello Client");

            Thread.sleep(60000);
            server.stopServer();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }



    }
}
