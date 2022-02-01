package domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Домэйн класс перелётов
 */
public class Flight {
    private Long id;
    private String depIata;
    private LocalDateTime depSheduled;
    private String arrIata;
    private LocalDateTime arrSheduled;
    private String planeRegistrationNumber;
    private boolean isGround;

    public Flight(Long id, String depIata, LocalDateTime depSheduled, String arrIata, LocalDateTime arrSheduled, String planeRegistrationNumber, boolean isGround) {
        this.id = id;
        this.depIata = depIata;
        this.depSheduled = depSheduled;
        this.arrIata = arrIata;
        this.arrSheduled = arrSheduled;
        this.planeRegistrationNumber = planeRegistrationNumber;
        this.isGround = isGround;
    }

    public Flight(Long id, String depIata, String depSheduled, String arrIata, String arrSheduled, String planeRegistrationNumber, boolean isGround) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

        this.id = id;
        this.depIata = depIata;
        this.depSheduled = LocalDateTime.parse(depSheduled, formatter);
        this.arrIata = arrIata;
        this.arrSheduled = LocalDateTime.parse(arrSheduled, formatter);
        this.planeRegistrationNumber = planeRegistrationNumber;
        this.isGround = isGround;
    }

    public Long getId() {
        return id;
    }

    public String getDepIata() {
        return depIata;
    }

    public LocalDateTime getDepSheduled() {
        return depSheduled;
    }

    public String getArrIata() {
        return arrIata;
    }

    public LocalDateTime getArrSheduled() {
        return arrSheduled;
    }

    public String getPlaneRegistrationNumber() {
        return planeRegistrationNumber;
    }

    public boolean isGround() {
        return isGround;
    }
}
