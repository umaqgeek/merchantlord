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
public class M_account_type {
    
    public B_account_type[] getAll(int limit) {
        B_account_type bat[] = new B_account_type[limit];
        try {
            bat[0] = new B_account_type("17", "DPG");
            bat[1] = new B_account_type("18", "DPS");
        } catch (Exception e) {
        }
        return bat;
    }
}
