package patterns.builderPattern.example2.builders;

import patterns.builderPattern.example2.cars.CarType;
import patterns.builderPattern.example2.components.Engine;
import patterns.builderPattern.example2.components.GPSNavigator;
import patterns.builderPattern.example2.components.Transmission;
import patterns.builderPattern.example2.components.TripComputer;

/**
 * Builder interface defines all possible ways to configure a product.
 */
public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}