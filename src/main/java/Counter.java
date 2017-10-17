import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name = "CounterServlet", urlPatterns = "/counter")
public class Counter extends HttpServlet {
    // No need to make this var package level so label it private
    private int counter = 0;
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // Counter increments on page load as each page load instantiates a new class
        counter++;

        // To reset the counter we need to set a query string
        if(req.getParameter("reset") != null) {
            // We set the query string to != null that way we can just use /counter?reset
            counter = 0;
        }

        // Without setting the content type the HTML string is not rendered as HTML
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h3>Page view: " + (counter) + "</h3>");
    }


}
