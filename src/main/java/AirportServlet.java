import javax.servlet.ServletConfig;
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
        service = AirportServiceCreator.createService();
        serializer = JsonSerializerCreator.createSerializer();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        try {
            Object queryResult = receiveInformation(request, service);
            String json = serializer.serialize(queryResult);
            out.print(json);
            out.flush();
        } catch (ElementNotFoundException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private Object receiveInformation(HttpServletRequest request, AirportService service) throws ElementNotFoundException {
        if(request.getPathInfo() == null || request.getPathInfo().equals("/")){
            return service.getAll();
        }
        Long id = Long.parseLong(request.getPathInfo().replace("/", ""));
        try {
            return service.getById(id);
        } catch (ElementNotFoundException e) {
            //тут ещё должен быть логер, но его нет
            throw e;
        }
    }
}
