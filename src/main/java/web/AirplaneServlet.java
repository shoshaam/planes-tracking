package web;

import domain.Airplane;
import json.JsonSerializerCreator;
import json.Serializer;
import service.airplane.AirplaneService;
import service.airplane.AirplaneServiceCreator;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

public class AirplaneServlet extends HttpServlet {
    private Serializer serializer;
    private AirplaneService service;

    @Override
    public void init(ServletConfig config){
        service = AirplaneServiceCreator.createService(Mode.NORMAL);
        serializer = JsonSerializerCreator.createSerializer();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        String jsonQueryResult;
        Long queryId = receiveRequestId(request);
        if(queryId == -1){
            List<Airplane> airplanesWithPlace = service.getAllWithPlace();
            jsonQueryResult = serializer.serialize(airplanesWithPlace);
        }
        else {
            Optional<Airplane> airplaneWithPlace = service.getByIdWithPlace(queryId);
            jsonQueryResult = airplaneWithPlace.map(serializer::serialize).orElseGet(() -> {
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
    private Long receiveRequestId(HttpServletRequest request){
        if (request.getPathInfo() == null || request.getPathInfo().equals("/")){
            return -1L;
        }
        return Long.parseLong(request.getPathInfo().replace("/",""));
    }
}
