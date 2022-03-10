/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motorcycle;

/**
 *
 * @author Attila Molnar
 */
public final class Moped extends vehicle.motor_vehicle.MotorCycle {

    private String pedalType;

    public String getPedalType() {
        return pedalType;
    }

    public void setPedalType(String pedalType) {
        this.pedalType = pedalType;
    }

}
