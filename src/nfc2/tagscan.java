/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfc2;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.math.BigInteger;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.smartcardio.*;

public class tagscan {

    static String bin2hex(byte[] data) {
        return String.format("%0" + (data.length * 2) + "X", new BigInteger(1, data));
    }
    
    public static String read() {
        
        String strcode = "";
        
        try {

            // Display the list of terminals
            TerminalFactory factory = TerminalFactory.getDefault();
            List<CardTerminal> terminals = factory.terminals().list();
//                System.out.println("Terminals: " + terminals);

            // Use the first terminal
            CardTerminal terminal = terminals.get(0);

            // Connect wit hthe card
            Card card = terminal.connect("*");
//                System.out.println("Card: " + card);
            CardChannel channel = card.getBasicChannel();

            // Send test command
            ResponseAPDU response = channel.transmit(new CommandAPDU(new byte[]{(byte) 0xFF, (byte) 0xCA, (byte) 0x00, (byte) 0x00, (byte) 0x00}));
//            System.out.println("Response: " + response.toString());

            if (response.getSW1() == 0x63 && response.getSW2() == 0x00) {
//                System.out.println("Failed");
            }

            strcode = bin2hex(response.getData());
            System.out.println("UID: " + strcode);

            card.disconnect(false);

        } catch (Exception e) {
        }
        return strcode;
    }

    public static void main1(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        while (true) {
            
            String a = "-";
//            String a = s.nextLine();
            if (a.equals("end")) {
                break;
            }
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException ex) {
                Logger.getLogger(tagscan.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {

                // Display the list of terminals
                TerminalFactory factory = TerminalFactory.getDefault();
                List<CardTerminal> terminals = factory.terminals().list();
//                System.out.println("Terminals: " + terminals);

                // Use the first terminal
                CardTerminal terminal = terminals.get(0);

                // Connect wit hthe card
                Card card = terminal.connect("*");
//                System.out.println("Card: " + card);
                CardChannel channel = card.getBasicChannel();

                // Send test command
                ResponseAPDU response = channel.transmit(new CommandAPDU(new byte[]{(byte) 0xFF, (byte) 0xCA, (byte) 0x00, (byte) 0x00, (byte) 0x00}));
//                System.out.println("Response: " + response.toString());

                if (response.getSW1() == 0x63 && response.getSW2() == 0x00) {
//                    System.out.println("Failed");
                }

                System.out.println("UID: " + bin2hex(response.getData()));
                
//                try {
//                    // Get UTF-8 byte
//                    byte[] lang = Locale.getDefault().getLanguage().getBytes("UTF-8");
//                    byte[] text = a.getBytes("UTF-8"); // Content in UTF-8
//
//                    int langSize = lang.length;
//                    int textLength = text.length;
//
//                    ByteArrayOutputStream payload = new ByteArrayOutputStream(1 + langSize + textLength);
//                    payload.write((byte) (langSize & 0x1F));
//                    payload.write(lang, 0, langSize);
//                    payload.write(text, 0, textLength);
////                    NdefRecord record = new NdefRecord(NdefRecord.TNF_WELL_KNOWN,
////                            NdefRecord.RTD_TEXT, new byte[0],
////                            payload.toByteArray());
////                    return new NdefMessage(new NdefRecord[]{record});
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }

                // Disconnect the card
                card.disconnect(false);

            } catch (Exception e) {

//                System.out.println("Ouch: " + e.toString());

            }
        }
    }
}
