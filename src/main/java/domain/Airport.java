package domain;

/**
 * Домэйн класс аэропорта
 */
public class Airport {
    Long id;
    String iataCode;
    String airportName;

    public Airport(Long id, String iataCode, String airportName) {
        this.id = id;
        this.iataCode = iataCode;
        this.airportName = airportName;
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

}
