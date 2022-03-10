/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle.bicycle;

import manifacturer.Manifacturer;
import vehicle.Vehicle;

/**
 *
 * @author Attila Molnar
 */
public class Bicycle implements GetBicycleProperties, Vehicle {

    private String frameType;
    private String seatingType;
    private String breakType;
    private String suspensionType;
    private String wheelType;
    private String tireType;
    private int speed;
    private Manifacturer manifacturer;
    private boolean transportsPeople;

    public void setTransportsPeople(boolean transportsPeople) {
        this.transportsPeople = transportsPeople;
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
    public boolean isTransportsPeople() {
        return transportsPeople;
    }

    @Override
    public String getFrameType() {
        return frameType;
    }

    @Override
    public void setFrameType(String frametype) {
        this.frameType = frameType;
    }

    @Override
    public String getSeatingType() {
        return seatingType;
    }

    @Override
    public void setSeatingType(String seatingType) {
        this.seatingType = seatingType;
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

    @Override
    public Manifacturer getManifacturer() {
        return manifacturer;
    }

    @Override
    public void setManifacturer(Manifacturer manifacturer) {
        this.manifacturer = manifacturer;
    }

}
