package aviationstackapi.dto.flight;

import com.google.gson.annotations.SerializedName;

public class FlightDTO {
    public Departure departure;
    public Arrival arrival;
    public Live live;
    public Aircraft aircraft;

    public class Departure{
        public String iata;
        public String scheduled;
    }

    public class Arrival{
        public String iata;
        public String scheduled;
    }

    public class Live{
        @SerializedName(value = "is_ground")
        public boolean isGround;
    }

    public class Aircraft{
        public String registration;
    }
}
