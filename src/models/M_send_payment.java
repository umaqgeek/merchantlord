/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import main.RMIConnector;

/**
 *
 * @author umarmukhtar
 */
public class M_send_payment {
    
    public String[] sendPaymentDpgdps(String card_id, String pin_code, int me_id_from, int me_id_to, 
            double tr_amount, int at_id, int pt_id, String tr_notes) {
        boolean status = false;
        String[] str_out = new String[2];
        str_out[0] = "-1";
        str_out[1] = "";
        try {
            RMIConnector rmic = new RMIConnector(DBConn.getHost(), DBConn.getPort_rmi());
            str_out = rmic.tr_isSend_Payment_Dpgdps(card_id, pin_code, me_id_from, me_id_to, 
                    tr_amount, at_id, pt_id, tr_notes);
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            status = false;
            str_out[0] = "1";
            str_out[1] = "Error! "+e.getMessage();
        }
        return str_out;
    }
}
