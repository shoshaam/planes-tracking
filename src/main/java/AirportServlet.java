import com.google.gson.JsonObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AirportServlet extends HttpServlet {
    private final AirportService service = new AirportService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        Airport airport = service.getAllInformationById(getAirportId(request));

        JsonObject json = new JsonObject();
        json.addProperty("AirportId", airport.getId());
        json.addProperty("IataCode", airport.getIataCode());
        json.addProperty("AirportName", airport.getAirportName());
        out.print(json);
        out.flush();

    }

    private int getAirportId(HttpServletRequest request){
        if(request.getPathInfo() != null){
            return Integer.parseInt(request.getPathInfo().replace("/", ""));
        }
        return -1;
    }
}
