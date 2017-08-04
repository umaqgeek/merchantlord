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
public class B_payment_type {
    
    private String pt_id;
    private String pt_desc;
    
    public B_payment_type(String pt_id, String pt_desc)
    {
        this.pt_id = pt_id;
        this.pt_desc = pt_desc;
    }

    @Override
    public String toString()
    {
        return this.pt_desc;
    }
    
    public String getPt_id()
    {
        return pt_id;
    }

    public String getPt_desc()
    {
        return pt_desc;
    }
}
