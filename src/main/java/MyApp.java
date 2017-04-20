import org.webbitserver.WebServer;
import org.webbitserver.netty.NettyWebServer;

public class MyApp
{
    private static final int PORT = 2017;
    private static final int MILLIS = 1000;

    public static void main(String[] args) throws Exception
    {
        WebServer webServer = new NettyWebServer(PORT)
                .add(new SimpleServerHandler())
                .staleConnectionTimeout(MILLIS);
        webServer.start().get();
        System.out.println("Listening on " + webServer.getUri());
    }
}
