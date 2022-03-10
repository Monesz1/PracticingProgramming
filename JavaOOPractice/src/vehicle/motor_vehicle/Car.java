/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle.motor_vehicle;

import manifacturer.Manifacturer;
import vehicle.Engine;

/**
 *
 * @author Attila Molnar
 */
public class Car implements GetCarProperties, vehicle.Vehicle {

    private int passengerSpace;
    private int weight;
    private String breakType;
    private String suspensionType;
    private String wheelType;
    private String tireType;
    private int speed;
    private Engine engine;
    private Manifacturer manifacturer;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void accelerate(int speed) {
        this.speed += speed;
    }

    @Override
    public void slowDown(int speed) {
        this.speed -= speed;
    }

    @Override
    public Manifacturer getManifacturer() {
        return manifacturer;
    }

    @Override
    public void setManifacturer(Manifacturer manifacturer) {
        this.manifacturer = manifacturer;
    }

    @Override
    public boolean isTransportsPeople() {
        return isTransportsPeople();
    }

    @Override
    public boolean isTransportsCargo() {
        return isTransportsCargo();
    }

    @Override
    public String openDoor() {
        return openDoor();
    }

    @Override
    public String closeDoor() {
        return closeDoor();
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int getPassengerSpace() {
        return passengerSpace;
    }

    @Override
    public void setPassengerSpace(int passengerSpace) {
        this.passengerSpace = passengerSpace;
    }

    @Override
    public String getBrakeType() {
        return breakType;
    }

    @Override
    public void setBrakeType(String breakType) {
        this.breakType = breakType;
    }

    @Override
    public String getSuspensionType() {
        return suspensionType;
    }

    @Override
    public void setSuspensionType(String suspensionType) {
        this.suspensionType = suspensionType;
    }

    @Override
    public String getWheelType() {
        return wheelType;
    }

    @Override
    public void setWheelType(String wheelType) {
        this.wheelType = wheelType;
    }

    @Override
    public String getTireType() {
        return tireType;
    }

    @Override
    public void setTireType(String tireType) {
        this.tireType = tireType;
    }

}
