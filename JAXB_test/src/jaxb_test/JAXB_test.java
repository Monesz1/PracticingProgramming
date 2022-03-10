/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb_test;

import java.io.FileOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Attila Molnar
 */
public class JAXB_test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        JAXBContext contextObj = JAXBContext.newInstance(Car.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Car car = new Car(200, "Ford", 1);

        marshallerObj.marshal(car, new FileOutputStream("car.xml"));

    }

}
