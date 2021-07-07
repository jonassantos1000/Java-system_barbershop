/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Connection.connectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Cliente;

/**
 *
 * @author Jonas Santos
 */
public class counters {
    
    
    private final String SQLSELECTCODIGO = "SELECT VALOR FROM COUNTERS WHERE NOME= ?";
    private final String SQLALTERARCOUNTERS = "UPDATE COUNTERS SET VALOR= ? WHERE NOME= ?";
    private Cliente cliente;
    
    private String campo;
    int valor;
       
    public void setCampo(String campo){
        this.campo=campo;
    }
    
    public void setValor(int valor){
        this.valor=valor;
    }
    
    public String getCampo(){
        return this.campo;
    }
    
    public int getValor(){
        return this.valor;
    }
    
    
    public void alteracodigo(int valor){
        try{
            PreparedStatement pst= Connection.connectionFactory.getconnection().prepareStatement(SQLALTERARCOUNTERS);
            int countersnovo;
            countersnovo=getValor()+1;
            pst.setInt(1, countersnovo);
            pst.setString(2, getCampo());
            pst.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel fazer o incremento do codigo");
        }
    }
    
    public int consultacodigo(){
        try{
            PreparedStatement pst= Connection.connectionFactory.getconnection().prepareStatement(SQLSELECTCODIGO);
            
            pst.setString(1, getCampo());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
               setValor(rs.getInt(1));
            alteracodigo(getValor());   
            }
            
            return getValor();
            
        }
        catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel encontrar um codigo valido para o cadastro de cliente");
        return 0;
        }
        
       
    }
}
