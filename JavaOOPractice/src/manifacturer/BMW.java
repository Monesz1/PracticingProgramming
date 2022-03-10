/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manifacturer;

/**
 *
 * @author Attila Molnar
 */
public class BMW extends Manifacturer {

    private String companyName;
    private String address;

    public BMW(String companyName, String address) {
        this.companyName = companyName;
        this.address = address;
    }

}
