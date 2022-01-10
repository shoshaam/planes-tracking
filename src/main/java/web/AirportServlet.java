package web;

import domain.Airport;
import json.JsonSerializerCreator;
import json.Serializer;
import service.AirportService;
import service.AirportServiceCreator;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

public class AirportServlet extends HttpServlet{

    private Serializer serializer;
    private AirportService service;

    @Override
    public void init(ServletConfig config){
        service = AirportServiceCreator.createService(Mode.NORMAL);
        serializer = JsonSerializerCreator.createSerializer();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        String jsonQueryResult;
        Long queryId = receiveRequestId(request);
        if(queryId == -1){
            List<Airport> airports = service.getAll();
            jsonQueryResult = serializer.serialize(airports);
        }
        else {
            Optional<Airport> airport = service.getById(queryId);
            jsonQueryResult = airport.map(serializer::serialize).orElseGet(() -> {
                try {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return "";
            });
        }

        out.print(jsonQueryResult);
        out.flush();
    }

    /**
     * Метод получает id в эндпоинте
     * @param request - объект запроса
     * @return - Long id значение
     */
    private Long receiveRequestId(HttpServletRequest request) {
        if (request.getPathInfo() == null || request.getPathInfo().equals("/")) {
            return -1L;
        }
        return Long.parseLong(request.getPathInfo().replace("/", ""));
    }

}
