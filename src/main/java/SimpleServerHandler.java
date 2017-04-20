import org.webbitserver.HttpControl;
import org.webbitserver.HttpHandler;
import org.webbitserver.HttpRequest;
import org.webbitserver.HttpResponse;

import java.text.NumberFormat;

class SimpleServerHandler implements HttpHandler {
    public void handleHttpRequest(HttpRequest httpRequest, HttpResponse httpResponse, HttpControl httpControl) throws Exception
    {
        httpResponse.header("Content-type", "text/html")
                .content("<html>" +
                        "   <body>" +
                            memoryUsage() +
                        "   </body>" +
                        "</html>")
                .end();
    }

    private String memoryUsage()
    {
        Runtime runtime = Runtime.getRuntime();

        NumberFormat format = NumberFormat.getInstance();

        StringBuilder sb = new StringBuilder();
        long maxMemory = runtime.maxMemory();
        long allocatedMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();

        sb.append("free memory: ").append(format.format(freeMemory / 1024)).append("<br/>");
        sb.append("allocated memory: ").append(format.format(allocatedMemory / 1024)).append("<br/>");
        sb.append("max memory: ").append(format.format(maxMemory / 1024)).append("<br/>");
        sb.append("total free memory: ").append(format.format((freeMemory + (maxMemory - allocatedMemory)) / 1024)).append("<br/>");
        return sb.toString();
    }
}
