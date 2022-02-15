package domain;

/**
 * Статус самолёта: прибывает/убывает
 */
public enum Status {
    DEPARTS("departs"),
    ARRIVES("arrives");

    private final String status;

    Status(String status){
        this.status = status;
    }
    public String getStatus(){ return status;}
}
