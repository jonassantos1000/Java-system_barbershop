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
import javax.swing.JOptionPane;

/**
 *
 * @author jonas
 */
public class User {
    public static void setPermissao(String gerencia, String login){
        try{
            FileWriter permission = new FileWriter("C:\\conatus\\parameters\\permission.txt");
            PrintWriter gravaTexto = new PrintWriter(permission);
            gravaTexto.printf(gerencia);
            permission.close();
            
            FileWriter user = new FileWriter("C:\\conatus\\parameters\\user.txt");
            PrintWriter gravaUsuario = new PrintWriter(user);
            gravaUsuario.printf(login);
            user.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"A instalação do sistema esta com problemas, contate o suporte técnico !");
            System.exit(0);
            ex.printStackTrace();
        }
    }
    
    public static String getPermissao(){
        String path = "C:\\conatus\\parameters\\permission.txt";
        String teste=null;
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line=null;
            line = br.readLine();
            return line;
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"A instalação do sistema esta com problemas, contate o suporte técnico !");
            System.exit(0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"A instalação do sistema esta com problemas, contate o suporte técnico !");
            System.exit(0);
        }
        return null;
    }
}
