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
import model.Usuarios;

/**
 *
 * @author jonas
 */
public class User {
  
    public static String getPermissao(String usuario){
        try{
            Usuarios user = new Usuarios(usuario);            
            String permissao=user.selectall(user).getGerencia();
            return permissao;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
