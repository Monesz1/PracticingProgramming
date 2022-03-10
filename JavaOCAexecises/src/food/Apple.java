/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Attila Molnar
 */
public class Apple extends Fruit {

    @Override
    void grow() {
        Logger log = Logger.getLogger(Apple.class.getName());
        log.log(Level.SEVERE, "I'm growing");
    }

}
