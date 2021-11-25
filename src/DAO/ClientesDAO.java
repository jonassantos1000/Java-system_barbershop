/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Connection.connectionFactory;
import Util.data;
import java.sql.Date;
import java.sql.PreparedStatement;
import model.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonas Santos
 */
public class ClientesDAO {
    private final String SQLINCLUIR = "INSERT INTO CLIENTES (CODIGO,NOME,CPF,DATA_CADASTRO,RG,ENDERECO,NUMERO,CEP,BAIRRO,COMPLEMENTO,EMAIL,TELEFONE,"
            + "CELULAR,OBSERVACAO,NOTIFICA_WHATS) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    String SQLUPDATE="UPDATE CLIENTES SET NOME=?,CPF=?,RG=?,ENDERECO=?,NUMERO=?,CEP=?,BAIRRO=?,COMPLEMENTO=?,EMAIL=?"
            +",TELEFONE=?,CELULAR=?,OBSERVACAO=?,NOTIFICA_WHATS=?,DATA_ALTERACAO=? WHERE CODIGO=?";

    public ClientesDAO(Cliente cliente){
        this.cliente=cliente;
        this.alteracliente=cliente;

    }
    private String SQLSELECTALL;
    private Cliente cliente;
    private Cliente alteracliente;
    
    public boolean insert() throws ParseException{
        try{
            PreparedStatement pst= Connection.connectionFactory.getconnection().prepareStatement(SQLINCLUIR);
            int codigo;
            pst.setInt(1, cliente.getCodigo());
            pst.setString(2,cliente.getNome());
            pst.setString(3,cliente.getCPF());
            pst.setDate(4, Util.data.getSqlDate(Util.data.formataData(cliente.getData())));
            pst.setString(5, cliente.getRG());
            pst.setString(6,cliente.getEndereco());
            pst.setString(7,cliente.getNumero());
            pst.setString(8, cliente.getCEP());
            pst.setString(9, cliente.getBairro());
            pst.setString(10, cliente.getComplemento());
            pst.setString(11, cliente.getEmail());
            pst.setString(12, cliente.getTelefone());
            pst.setString(13, cliente.getCelular());
            pst.setString(14, cliente.getObservacao());
            pst.setString(15,cliente.getNotificaEmail());
            pst.executeUpdate();
            return true;
        }
        catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel incluir o cadastro !!!");
            return false;
        }
    }
    
    public boolean update(){
        try{
            
            PreparedStatement pst= Connection.connectionFactory.getconnection().prepareStatement(SQLUPDATE);
            pst.setString(1,cliente.getNome());
            pst.setString(2,cliente.getCPF());
            pst.setString(3, cliente.getRG());
            pst.setString(4,cliente.getEndereco());
            pst.setString(5,cliente.getNumero());
            pst.setString(6, cliente.getCEP());
            pst.setString(7, cliente.getBairro());
            pst.setString(8, cliente.getComplemento());
            pst.setString(9, cliente.getEmail());
            pst.setString(10, cliente.getTelefone());
            pst.setString(11, cliente.getCelular());
            pst.setString(12, cliente.getObservacao());
            pst.setString(13,cliente.getNotificaEmail());
            pst.setDate(14, Util.data.getSqlDate(Util.data.formataData(Util.data.getdata())));
            pst.setInt(15, cliente.getCodigo());
            pst.executeUpdate();
            return true;

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
            return false;
        }
    }
    
    public Cliente selectAlteraCliente(int ID){
        try{
            String CONSULTACADASTRO;
            CONSULTACADASTRO="SELECT * FROM CLIENTES WHERE CODIGO='"+ID+"'";
            PreparedStatement pst= Connection.connectionFactory.getconnection().prepareStatement(CONSULTACADASTRO);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
            Cliente selectAltera = new Cliente(ID,rs.getString("NOME"),rs.getString("CPF"),rs.getString("RG"),rs.getString("CELULAR"),rs.getString("EMAIL"),String.valueOf(rs.getTimestamp("DATA_CADASTRO")).replace(".0", ""),
                rs.getString("ENDERECO"),rs.getString("BAIRRO"),rs.getString("NUMERO"),rs.getString("COMPLEMENTO"),rs.getString("TELEFONE"),rs.getString("NOTIFICA_WHATS"),rs.getString("OBSERVACAO"),rs.getString("CEP"),String.valueOf(rs.getTimestamp("DATA_ALTERACAO")).replace(".0",""));
            alteracliente=selectAltera;
            
            }
            
            return alteracliente;
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            ex.printStackTrace();
            return null;
        }
    }
    
       
    public List<Cliente> selectall(Cliente cliente, String limite) throws SQLException{
        try{
            SQLSELECTALL="SELECT FIRST "+limite+" CODIGO,NOME,CPF,RG,EMAIL,ENDERECO,CELULAR,DATA_ALTERACAO,DATA_CADASTRO FROM CLIENTES as c ";
            int contador=0;
            //Campo codigo
            if (!"0".equals(String.valueOf(cliente.getCodigo()))) {
                if (contador==0){ 
                    SQLSELECTALL=SQLSELECTALL+"where c.CODIGO LIKE '"+String.valueOf(cliente.getCodigo())+"' ";
                    contador++;
                }
            }// fim do campo codigo
            if (!"".equals(cliente.getNome())){
                if (contador==0){
                    SQLSELECTALL=SQLSELECTALL+"WHERE c.NOME LIKE '%"+cliente.getNome()+"%' ";
                    contador++;
                }else{
                SQLSELECTALL=SQLSELECTALL+"and c.NOME LIKE '%"+cliente.getNome()+"%' ";  
                }
            }
            if (!"___.___.___-__".equals(cliente.getCPF()) && !"".equals(cliente.getCPF())){
                if (contador==0){
                    SQLSELECTALL=SQLSELECTALL+"WHERE c.CPF LIKE '"+cliente.getCPF()+"' ";
                    contador++;
                }else{
                    SQLSELECTALL=SQLSELECTALL+"and c.CPF LIKE '"+cliente.getCPF()+"' ";
                }
            }
            if (!"__.___.___-_".equals(cliente.getRG()) && !"".equals(cliente.getRG())) {
                if (contador==0){
                    SQLSELECTALL=SQLSELECTALL+"WHERE c.RG LIKE '"+cliente.getRG()+"' ";
                    contador++;
                }else{
                SQLSELECTALL=SQLSELECTALL+"and c.RG LIKE '"+cliente.getRG()+"' ";
                }
            }
            if (!"".equals(cliente.getEmail())) {
                if (contador==0){
                    SQLSELECTALL=SQLSELECTALL+"WHERE c.EMAIL LIKE '"+cliente.getEmail()+"' ";
                    contador++;
                }else{
                SQLSELECTALL=SQLSELECTALL+"and c.EMAIL LIKE '"+cliente.getEmail()+"' ";
                }
            }
            PreparedStatement pst= Connection.connectionFactory.getconnection().prepareStatement(SQLSELECTALL);
            ResultSet rs = pst.executeQuery();
            List<Cliente> listCliente = new ArrayList<Cliente>();
            
            while (rs.next()){
                String CPFaux="";
                String RGaux="";
                if(rs.getString("CPF")==null){
                    CPFaux="___.___.___-__";
                }else{
                    CPFaux=rs.getString("CPF");
                }
                if(rs.getString("RG")==null){
                    RGaux="__.___.___-_";
                }else{
                    RGaux=rs.getString("RG");
                }
                
                Cliente select = new Cliente(rs.getInt("CODIGO"),rs.getString("NOME"),rs.getString("CPF"),rs.getString("RG"),rs.getString("EMAIL"),rs.getString("ENDERECO"),rs.getString("CELULAR"),rs.getString("DATA_ALTERACAO"),rs.getString("DATA_CADASTRO"));
                listCliente.add(select);
            }
            return listCliente;
            
    }    catch(SQLException ex){
            ex.printStackTrace();
            
        }
        return null;
    }
    
    public boolean delete(){
            try{
                String SQLDELETE="DELETE FROM CLIENTES WHERE CODIGO=?";
                PreparedStatement pst= Connection.connectionFactory.getconnection().prepareStatement(SQLDELETE);
                pst.setInt(1, cliente.getCodigo());
                pst.executeUpdate();
                return true;
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Não foi possivel excluir este cliente, pois ele foi utilizado numa movimentação !");
                ex.printStackTrace();
                return false;
            }
           
        }
}