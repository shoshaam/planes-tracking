import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AirportServlet extends HttpServlet{

    private Serializer serializer;
    private AirportService service;

    @Override
    public void init(ServletConfig config){
        service = AirportInfoCreator.createService();
        serializer = JsonSerializerCreator.createSerializer();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        Object queryResult = receiveInformation(request, service);
        String json = serializer.serialize(queryResult);

        out.print(json);
        out.flush();

    }

    private Object receiveInformation(HttpServletRequest request, AirportService service){
        if(request.getPathInfo() == null || request.getPathInfo().equals("/")){
            return service.getAll();
        }
        int id = Integer.parseInt(request.getPathInfo().replace("/", ""));
        return service.getById(id);
    }
}
