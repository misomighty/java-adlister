import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name = "CounterServlet", urlPatterns = "/counter")
public class Counter extends HttpServlet {
    int counter = 0;
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        counter++;
        HttpSession httpSession = req.getSession();
//        counter = Integer.parseInt(req.getParameter("counter"));
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h3>Page view: " + (counter) + "</h3>");
    }


}
