/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaoopractice;

import car.Performance;
import car.SUV;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import manifacturer.BMW;
import vehicle.Engine;
import vehicle.Vehicle;
import vehicle.bicycle.Bicycle;
import vehicle.motor_vehicle.Bus;
import vehicle.motor_vehicle.Car;
import vehicle.motor_vehicle.MotorCycle;
import vehicle.motor_vehicle.Truck;

/**
 *
 * @author Attila Molnar
 */
public class JavaOOPractice {

    /**
     * @param args the command line arguments
     */
    private static boolean heatWave = true;

    public static void main(String[] args) {

        boolean heatWave = false;
        System.out.print(heatWave);

        addCar();
    }

    private static void addCar() {
        List<Car> cars = new ArrayList<>();
        cars.add(buildSportCar());

        Car car = new SUV();
//        Car car2 = new Bus();
//        Bus bus = (Bus) new Car();

    }

    private static Performance buildSportCar() {

        Performance buildSportSedan = new Performance();
        buildSportSedan.setBrakeType("hydraulic dual-circuit brake system with power assistance");
        buildSportSedan.setEngine(new Engine("Internal combustion", "Petrol 1.8L", "M10 I4"));
        buildSportSedan.setPassengerSpace(4);
        buildSportSedan.setSuspensionType("Macpherson struts at the front and a semi-trailing arm design for the rear");
        buildSportSedan.setTireType("175 HR 14 Michelin XAS");
        buildSportSedan.setWeight(1140);
        buildSportSedan.setWheelType("Michelin TRX");
        buildSportSedan.setManifacturer(new BMW("BMW", "Munich, Germany"));

        return buildSportSedan;
    }

}

interface Factory {

    default Vehicle getVehicle(String vehicle) {

        ResourceBundle rb = ResourceBundle.getBundle("vehicle_list");

        if (vehicle.equalsIgnoreCase(rb.getString("car"))) {
            return new Car();
        }
        if (vehicle.equalsIgnoreCase(rb.getString("motorcycle"))) {
            return new MotorCycle();
        }
        if (vehicle.equalsIgnoreCase(rb.getString("bicycle"))) {
            return new Bicycle();
        }
        if (vehicle.equalsIgnoreCase(rb.getString("bus"))) {
            return new Bus();
        }
        if (vehicle.equalsIgnoreCase(rb.getString("truck"))) {
            return new Truck();
        }

        return null;
    }
}
