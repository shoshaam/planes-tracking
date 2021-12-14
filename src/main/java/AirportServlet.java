import com.google.gson.JsonElement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AirportServlet extends HttpServlet implements ServiceCreator {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        AirportService service = createService();
        Object queryResult = receiveInformation(request, service);
        JsonSerializer js = new JsonSerializer();
        JsonElement json = js.serialize(queryResult);

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

    @Override
    public AirportService createService() {
        return new AirportInformationService();
    }
}
