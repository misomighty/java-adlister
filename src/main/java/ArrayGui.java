import javax.jws.WebService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;

@WebServlet(name = "ArrayGuiServlet", urlPatterns = "/array")
public class ArrayGui extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
//        int size = Integer.parseInt(req.getParameter("size"));
//        String fill = req.getParameter("fill");
//
//        Array
//        for(int i = 0; i < size; i++) {
//
//            res.setContentType("text/html");
//            PrintWriter out = res.getWriter();
//            out.println("<div>" +item+ "</div>");
//        }

    }
}
