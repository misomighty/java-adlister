import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        //The request internally has a hashMap - key: name, value: query
        String name = req.getParameter("name");

        //We need the if statement in case there is no name query passed otherwise name = null
        if(name == null || name.trim().isEmpty()) {
            res.getWriter().print("<h1>Hello world!");
        } else {
            res.getWriter().print("<h1>Hello " + name + "!</h1>");
        }

        //Print is printing to a file, that's why we throw the IO exception
        PrintWriter out = res.getWriter();

        out.println("<h1>Hello World</h1>");



    }
}
