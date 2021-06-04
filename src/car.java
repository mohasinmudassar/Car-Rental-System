
public class car {
    double carRate;
    String carName;
    car(double carRate, String carName){
        this.carRate = carRate;
        this.carName = carName;
    }

    double getCarRate() {
        return carRate;
    }

    public String getCarName() {
        return carName;
    }
    
}

class PremiumCar extends car{
    double INSURANCE_RATE = 0.05;
    public PremiumCar(double carRate, String carName) {
        super(carRate, carName);
    }
    @Override
    double getCarRate(){
        double insurance = carRate * 0.05;
        insurance /= 100;
        carRate += insurance;
        return carRate;
    }
    
    
}
