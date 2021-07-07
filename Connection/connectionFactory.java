/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Jonas Santos
 */
public class connectionFactory {
    private static Connection conexao;
    
    public static Connection getconnection(){
        try{
            if(conexao==null){
                Class.forName("org.firebirdsql.jdbc.FBDriver"); 
                conexao= DriverManager.getConnection(
                    "jdbc:firebirdsql:127.0.0.1/3050:C:\\sys\\base\\MTX.FDB?encoding=ISO8859_1",
                    "SYSDBA", "masterkey");
            }
            
            return conexao;
        }
        catch (ClassNotFoundException cnfe) {
                JOptionPane.showMessageDialog(null, "Erro no driver JBDC");
                return null;
            }
        catch(SQLException SQLex){
            SQLex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao se conectar ao banco de dados");
                return null;
        }
    } 
}
