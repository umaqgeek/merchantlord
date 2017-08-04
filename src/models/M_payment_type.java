/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author umarmukhtar
 */
public class M_payment_type {
    
    public B_payment_type[] getAll(int limit) {
        B_payment_type bpt[] = new B_payment_type[limit];
        try {
            bpt[0] = new B_payment_type("1", "Goods");
            bpt[1] = new B_payment_type("2", "Services");
            bpt[2] = new B_payment_type("3", "Salary");
        } catch (Exception e) {
        }
        return bpt;
    }
}
