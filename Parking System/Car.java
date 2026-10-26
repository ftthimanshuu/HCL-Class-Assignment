public class Car {
    private String carNumber;
    private int lotNumber;

    public Car(String carNumber, int lotNumber) {
        this.carNumber = carNumber;
        this.lotNumber = lotNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public int getLotNumber() {
        return lotNumber;
    }
}
