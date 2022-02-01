package web;

import aviationstackapi.service.ApiService;
import aviationstackapi.service.AviationstackServiceCreator;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Класс, отвечающий за выполнение действий до и после выгрузки сервлетов
 */
public class ApiListener implements ServletContextListener {

    private ApiService service = AviationstackServiceCreator.createService(Mode.NORMAL);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        service.startUpdating();
    }
}
