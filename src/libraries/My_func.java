/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import javax.net.ssl.HttpsURLConnection;
import main.RMIConnector;
import models.DBConn;

/**
 *
 * @author umarmukhtar
 */
public class My_func {
    
    public static final String BASIC_PIN = "123456";
    private static final String USER_AGENT = "Mozilla/5.0";
    public static final String ENC_KEY = "D1n@rPAL_debitgram";
    public static final int STR_LIMIT = 20;
    
    public static String getStrDPGDPSUnit(double amount) {
        DecimalFormat df = new DecimalFormat("#,###.#");
        return df.format(amount);
    } 
    
    public static String getDPGDPSUnit(double amount) {
        DecimalFormat df = new DecimalFormat("####.#");
        return df.format(amount);
    } 
    
    public static void showArray2d(ArrayList<ArrayList<String>> d) {
        if (d.size() > 0) {
            System.out.println("{");
            for (int i = 0; i < d.size(); i++) {
                System.out.println(" ["+i+"]{");
                for (int j = 0; j < d.get(i).size(); j++) {
                    System.out.println("        ["+j+"] : "+d.get(i).get(j));
                }
                System.out.println("   },");
            }
            System.out.println("}");
        } else {
            System.out.println("{}");
        }
    }
    
    public static void showArray1d(ArrayList<String> d) {
        if (d.size() > 0) {
            System.out.println("{");
            try {
                for (int i = 0; ; i++) {
                    System.out.println("   [" + i + "] : " + d.get(i));
                }
            } catch (Exception e) {
            }
            System.out.println("}");
        } else {
            System.out.println("{}");
        }
    }
    
    public static String getCurrentTimestamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.getTime()+"";
    }
    
    public static String getCurrentDatetime_sql() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        return sdf.format(timestamp);
    }
    
    public static String getEncrypt(String input) {
        String output = input;
        
        // encryption process
        try {
            RMIConnector rmic = new RMIConnector(DBConn.getHost(), DBConn.getPort_rmi());
            output = rmic.getNFCEncrypted(input);
        } catch (Exception e) {
        }
        
        return output;
    }
    
    public static String getDecrypt(String input) {
        String output = "";
        
        // encryption process
        try {
            output = input;
        } catch (Exception e) {
        }
        
        return output;
    }
    
    public static String getStringURL(String url) {
        String out = "";
        try {
            URL urlx = new URL(url);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(urlx.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out += inputLine;
            }
            in.close();
        } catch (Exception e) {
            out = "Error: "+e.getMessage();
        }
        return out;
    }
    
    // HTTP POST request
    public static void sendPost(String url, ArrayList<ArrayList<String>> params) throws Exception {
        
//        URL obj = new URL(url);
        URL obj = new URL(null, url, new sun.net.www.protocol.https.Handler());
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        int szParams = params.size();
        String urlParameters = "";
        for (int i = 0; i < szParams-1; i++) {
            urlParameters += params.get(i).get(0) + "=" + params.get(i).get(1) + "&";
        }
        if (szParams > 0) {
            urlParameters += params.get(szParams-1).get(0) + "=" + params.get(szParams-1).get(1);
        }

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        
        System.out.println("|"+urlParameters+"|");
        if (true) {
            return;
        }
        
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }
}
