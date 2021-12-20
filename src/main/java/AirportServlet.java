import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

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

        String jsonQueryResult = receiveInformation(request);
        if (jsonQueryResult == null){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }

        out.print(jsonQueryResult);
        out.flush();
    }

    /**
     * Метод определяет вид запроса (получение всех данных или объекта по id) и возвращает json объект
     * @param request - запрос
     * @return - json объект с полученной информацией
     */
    private String receiveInformation(HttpServletRequest request){
        if(request.getPathInfo() == null || request.getPathInfo().equals("/")){
            return getAllAirports();
        }
        Long id = Long.parseLong(request.getPathInfo().replace("/", ""));
        return getAirportById(id);
    }

    /**
     * Метод выполянет запрос получения данных о всех аэропортах и сериализаует Map, возвращая json
     * @return - json данные всех аэропортов
     */
    private String getAllAirports(){
        Map<Long, Airport> airports = service.getAll();
        return serializer.serialize(airports);
    }

    /**
     * Метод выполянет запрос получения данных об аэропорте с заданным id и сериализаует объект, возвращая json
     * @param id - id аэропорта
     * @return - json данные аэропорта с заданным id
     */
    private String getAirportById(Long id){
        Airport airport = service.getById(id);
        if (airport != null){
            return serializer.serialize(airport);
        }
        return  null;
    }


}
