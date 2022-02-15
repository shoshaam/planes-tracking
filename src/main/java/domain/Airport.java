package domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Домэйн класс аэропорта
 */
public class Airport {
    private Long id;
    @SerializedName(value = "iata_code")
    private String iataCode;
    @SerializedName(value = "airport_name")
    private String airportName;
    //самолёты в аэропорте, по дефолту null
    private List<Airplane> airplanes = null;

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
