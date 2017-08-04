/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries;

/**
 *
 * @author umarmukhtar
 */
public class SessionsDP {
    
    private static int me_id;
    private static String me_username;

    public static int getMe_id() {
        return me_id;
    }

    public static void setMe_id(int aMe_id) {
        me_id = aMe_id;
    }

    public static String getMe_username() {
        return me_username;
    }

    public static void setMe_username(String aMe_username) {
        me_username = aMe_username;
    }
}
