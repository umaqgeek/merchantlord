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
public class B_account_type {
    
    private String at_id;
    private String at_desc;
    
    public B_account_type(String at_id, String at_desc)
    {
        this.at_id = at_id;
        this.at_desc = at_desc;
    }

    @Override
    public String toString()
    {
        return this.at_desc;
    }
    
    public String getAt_id()
    {
        return at_id;
    }

    public String getAt_desc()
    {
        return at_desc;
    }
}
