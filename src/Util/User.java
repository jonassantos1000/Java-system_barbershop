/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonas
 */
public class User {
    public static void setPermissao(String login){
        try{
            FileWriter user = new FileWriter("C:\\conatus\\parameters\\user.txt");
            PrintWriter gravaTexto = new PrintWriter(user);
            gravaTexto.printf(login);
            user.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static String getPermissao(){
        String path = "C:\\conatus\\parameters\\user.txt";
        String teste=null;
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line=null;
            line = br.readLine();
            return line;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
