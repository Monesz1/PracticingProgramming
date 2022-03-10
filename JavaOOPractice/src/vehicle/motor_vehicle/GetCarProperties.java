/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle.motor_vehicle;

/**
 *
 * @author Attila Molnar
 */
public interface GetCarProperties {

    int getWeight();

    void setWeight(int weight);

    int getPassengerSpace();

    void setPassengerSpace(int passengerSpace);

    String getBrakeType();

    void setBrakeType(String breakType);

    String getSuspensionType();

    void setSuspensionType(String suspensionType);

    String getWheelType();

    void setWheelType(String wheelType);

    String getTireType();

    void setTireType(String tireType);
}
