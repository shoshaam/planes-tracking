/**
 * Домэйн класс аэропорта
 */
public class Airport {
    int id;
    String iataCode;
    String airportName;

    Airport(int id, String airportName, String iataCode){
        this.id = id;
        this.iataCode = iataCode;
        this.airportName = airportName;
    }

    public int getId(){
        return this.id;
    }

    public String getIataCode(){
        return this.iataCode;
    }

    public String getAirportName(){
        return this.airportName;
    }

}
