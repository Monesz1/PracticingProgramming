/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle;

import manifacturer.Manifacturer;

/**
 *
 * @author Attila Molnar
 */
public interface Vehicle extends GetVehicleProperties {

    void accelerate(int speed);

    void slowDown(int speed);

    Manifacturer getManifacturer();

    void setManifacturer(Manifacturer manifacturer);

}
