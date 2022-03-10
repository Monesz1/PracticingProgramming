/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle;

/**
 *
 * @author Attila Molnar
 */
public interface GetVehicleProperties {

    public static final String od = "The door is open";
    public static final String cd = "The door is closed";
    public static final boolean transportPeople = true;
    public static final boolean transportCargo = true;

    default boolean isTransportsPeople() {
        return transportPeople;
    }

    default boolean isTransportsCargo() {
        return transportCargo;
    }

    default String openDoor() {

        return od;
    }

    default String closeDoor() {

        return cd;
    }

}
