/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle.bicycle;

/**
 *
 * @author Attila Molnar
 */
public interface GetBicycleProperties {

    /*It is s a good java programming practice to
    implement get & set methods from an abstract class?*/
    String getFrameType();

    void setFrameType(String frametype);

    String getSeatingType();

    void setSeatingType(String seatingType);

    String getBrakeType();

    void setBrakeType(String breakType);

    String getSuspensionType();

    void setSuspensionType(String suspensionType);

    String getWheelType();

    void setWheelType(String wheelType);

    String getTireType();

    void setTireType(String tireType);

}
