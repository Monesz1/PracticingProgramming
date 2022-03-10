/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle.motor_vehicle;

import manifacturer.Manifacturer;

/**
 *
 * @author Attila Molnar
 */
public class Truck implements vehicle.Vehicle, vehicle.GetVehicleProperties {

    private String truckType;

    public String getTruckType() {
        return truckType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }

    @Override
    public void accelerate(int speed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void slowDown(int speed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Manifacturer getManifacturer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setManifacturer(Manifacturer manifacturer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isTransportsPeople() {
        return isTransportsPeople(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isTransportsCargo() {
        return isTransportsCargo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String openDoor() {
        return openDoor(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String closeDoor() {
        return closeDoor(); //To change body of generated methods, choose Tools | Templates.
    }

}
