/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import libraries.My_func;
import main.RMIConnector;
import models.DBConn;
import nfc2.tagscan;
import views.PaparanTerminal;

/**
 *
 * @author umarmukhtar
 */
public class ReadCard implements Runnable {
    
    private static long timer = 100; // 1.0 seconds
    private static boolean isRun = true;
    private static String currentCardID = "";
    public static String me_username_from = "";

    @Override
    public void run() {
        
        while (isRun) {
            try {
                Thread.sleep(timer);
                
                String nfccode = tagscan.read();
                if (nfccode.length() > 0) {
                    if (!nfccode.equals(currentCardID)) {
                        currentCardID = nfccode;
                        PaparanTerminal.currentCardID = currentCardID;
                        RMIConnector rmic = new RMIConnector(DBConn.getHost(), DBConn.getPort_rmi());
                        ArrayList<String> dn = rmic.dn_getData_basedNfcCode(nfccode);
                        My_func.showArray1d(dn);
                        if (dn.size() > 0) {
                            me_username_from = dn.get(1);
                            PaparanTerminal.txt_cardid.setText(me_username_from);
                            String activationID = dn.get(7);
                            String activationStatus = "n/a";
                            if (activationID.equals("1")) {
                                activationStatus = "Email Not Verified!!";
                            } else if (activationID.equals("2")) {
                                activationStatus = "Account Not Full Verified!";
                            } else if (activationID.equals("3")) {
                                activationStatus = "Full Verified";
                            }
                            String papar = "Username: " + me_username_from;
                            papar += "\nFull Name: " + dn.get(2) + " " + dn.get(3);
                            papar += "\nPhone No.: " + dn.get(4);
                            papar += "\nE-mail Address: " + dn.get(5);
                            papar += "\nActivation Status: " + activationStatus;
                            PaparanTerminal.txt_papar.setText(papar);
                        } else {
                            me_username_from = "";
                            PaparanTerminal.txt_cardid.setText("No User");
                            PaparanTerminal.txt_papar.setText("");
                        }
                    }
                } else {
                    currentCardID = "";
                    me_username_from = "";
                    PaparanTerminal.txt_cardid.setText("");
                    PaparanTerminal.txt_papar.setText("");
                    PaparanTerminal.currentCardID = "";
                }
                
            } catch (Exception e) {
                String err = e.getMessage();
                System.out.println("Error: "+err);
                if (err.equals("sleep interrupted")) {
                    isRun = false;
                    System.exit(1);
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "System Crashed! Please restart the application.", "System Crashed", JOptionPane.ERROR_MESSAGE);
                    System.exit(1);
                    break;
                }
            }
        }
    }
}
