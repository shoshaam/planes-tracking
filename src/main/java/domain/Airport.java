package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Домэйн класс аэропорта
 */
public class Airport {
    Long id;
    String iataCode;
    String airportName;
    //самолёты в аэропорте, по дефолту null
    List<Airplane> airplanes = null;

    public Airport(Long id, String iataCode, String airportName) {
        this.id = id;
        this.iataCode = iataCode;
        this.airportName = airportName;
    }

    public Airport(Long id, String iataCode, String airportName, List<Airplane> airplanes) {
        this.id = id;
        this.iataCode = iataCode;
        this.airportName = airportName;
        this.airplanes = airplanes;
    }

    public Long getId() {
        return id;
    }

    public String getIataCode(){
        return this.iataCode;
    }

    public String getAirportName(){
        return this.airportName;
    }

    public List<Airplane> getAirplanes() {
        return airplanes;
    }

    public void setAirplanes(List<Airplane> airplanes) {
        this.airplanes = airplanes;
    }
}
