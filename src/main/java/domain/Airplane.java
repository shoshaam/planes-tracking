package domain;

/**
 * Домэйн класс самолёта
 */
public class Airplane {
    Long id;
    String productionLine;
    String registrationNumber;
    // текущее местонахождение, null по дефолту
    String place = null;
    // текущий статус (прибывает/отбывает) null по дефолту
    Status status = null;

    public Airplane(Long id, String productionLine, String registrationNumber) {
        this.id = id;
        this.productionLine = productionLine;
        this.registrationNumber = registrationNumber;
    }

    public Airplane(Long id, String productionLine, String registrationNumber, String place) {
        this.id = id;
        this.productionLine = productionLine;
        this.registrationNumber = registrationNumber;
        this.place = place;
    }

    public Airplane(Long id, String productionLine, String registrationNumber, Status status) {
        this.id = id;
        this.productionLine = productionLine;
        this.registrationNumber = registrationNumber;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getProductionLine() {
        return productionLine;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getPlace() {
        return place;
    }

    public Status getStatus() {
        return status;
    }
}
