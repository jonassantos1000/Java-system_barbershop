/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Funcionario;

/**
 *
 * @author Jonas Santos
 */
public class FuncionarioDAO {
    private final String SQLINCLUIR = "INSERT INTO FUNCIONARIO (COD_FUNCIONARIO,NOME,CPF,DATA_CADASTRO,RG,ENDERECO,NUMERO,CEP,BAIRRO,COMPLEMENTO,EMAIL,TELEFONE,"
            + "CELULAR,OBSERVACAO) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
    
    
    String SQLUPDATE="UPDATE FUNCIONARIO SET NOME=?,CPF=?,RG=?,ENDERECO=?,NUMERO=?,CEP=?,BAIRRO=?,COMPLEMENTO=?,EMAIL=?"
            +",TELEFONE=?,CELULAR=?,OBSERVACAO=?,DATA_ALTERACAO=? WHERE COD_FUNCIONARIO=?";
    


    public FuncionarioDAO(Funcionario funcionario){
        this.funcionario=funcionario;
        this.alterafuncionario=funcionario;

    }
    
    private String SQLSELECTALL;
    private Funcionario funcionario;
    private Funcionario alterafuncionario;
    
    public boolean insert() throws ParseException{
        try{
            PreparedStatement pst= Connection.connectionFactory.getconnection().prepareStatement(SQLINCLUIR);
            int codigo;
            pst.setInt(1, funcionario.getCodigo());
            pst.setString(2,funcionario.getNome());
            pst.setString(3,funcionario.getCPF());
            pst.setDate(4, Util.data.getSqlDate(Util.data.formataData(funcionario.getData())));
            pst.setString(5, funcionario.getRG());
            pst.setString(6,funcionario.getEndereco());
            pst.setString(7,funcionario.getNumero());
            pst.setString(8, funcionario.getCEP());
            pst.setString(9, funcionario.getBairro());
            pst.setString(10, funcionario.getComplemento());
            pst.setString(11, funcionario.getEmail());
            pst.setString(12, funcionario.getTelefone());
            pst.setString(13, funcionario.getCelular());
            pst.setString(14, funcionario.getObservacao());
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
            pst.setString(1,funcionario.getNome());
            pst.setString(2,funcionario.getCPF());
            pst.setString(3, funcionario.getRG());
            pst.setString(4,funcionario.getEndereco());
            pst.setString(5,funcionario.getNumero());
            pst.setString(6, funcionario.getCEP());
            pst.setString(7, funcionario.getBairro());
            pst.setString(8, funcionario.getComplemento());
            pst.setString(9, funcionario.getEmail());
            pst.setString(10, funcionario.getTelefone());
            pst.setString(11, funcionario.getCelular());
            pst.setString(12, funcionario.getObservacao());
            pst.setDate(13, Util.data.getSqlDate(Util.data.formataData(Util.data.getdata())));
            pst.setInt(14, funcionario.getCodigo());
            pst.executeUpdate();
            return true;

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    public Funcionario selectAlteraFuncionario(int ID){
        try{
            String CONSULTACADASTRO;
            CONSULTACADASTRO="SELECT * FROM FUNCIONARIO WHERE COD_FUNCIONARIO='"+ID+"'";
            PreparedStatement pst= Connection.connectionFactory.getconnection().prepareStatement(CONSULTACADASTRO);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
            Funcionario selectAltera = new Funcionario(ID,rs.getString("NOME"),rs.getString("CPF"),rs.getString("RG"),rs.getString("CELULAR"),rs.getString("EMAIL"),String.valueOf(rs.getTimestamp("DATA_CADASTRO")).replace(".0", ""),
                rs.getString("ENDERECO"),rs.getString("BAIRRO"),rs.getString("NUMERO"),rs.getString("COMPLEMENTO"),rs.getString("TELEFONE"),rs.getString("OBSERVACAO"),rs.getString("CEP"),String.valueOf(rs.getTimestamp("DATA_ALTERACAO")).replace(".0",""));
            
            alterafuncionario=selectAltera;
            }
            
            return alterafuncionario;
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            return null;
        }
    }
       
    public List<Funcionario> selectall(Funcionario funcionario, String limite) throws SQLException{
        try{
            if (limite=="0" || limite==""){
                limite="9999999"; 
            }
            
            SQLSELECTALL="SELECT FIRST "+limite+" COD_FUNCIONARIO,NOME,CPF,RG,EMAIL,ENDERECO,CELULAR,DATA_ALTERACAO,DATA_CADASTRO FROM FUNCIONARIO as f ";
            int contador=0;
            //Campo codigo
            if (!"0".equals(String.valueOf(funcionario.getCodigo()))) {
                if (contador==0){ 
                    SQLSELECTALL=SQLSELECTALL+"where f.COD_FUNCIONARIO LIKE '"+String.valueOf(funcionario.getCodigo())+"' ";
                    contador++;
                }
            }// fim do campo codigo
            if (!"".equals(funcionario.getNome())){
                if (contador==0){
                    SQLSELECTALL=SQLSELECTALL+"WHERE f.NOME LIKE '%"+funcionario.getNome()+"%' ";
                    contador++;
                }else{
                SQLSELECTALL=SQLSELECTALL+"and f.NOME LIKE '%"+funcionario.getNome()+"%' ";  
                }
            }
            if (!"___.___.___-__".equals(funcionario.getCPF()) && !"".equals(funcionario.getCPF())){
                if (contador==0){
                    SQLSELECTALL=SQLSELECTALL+"WHERE f.CPF LIKE '"+funcionario.getCPF()+"' ";
                    contador++;
                }else{
                    SQLSELECTALL=SQLSELECTALL+"and f.CPF LIKE '"+funcionario.getCPF()+"' ";
                }
            }
            if (!"__.___.___-_".equals(funcionario.getRG()) && !"".equals(funcionario.getRG())) {
                if (contador==0){
                    SQLSELECTALL=SQLSELECTALL+"WHERE f.RG LIKE '"+funcionario.getRG()+"' ";
                    contador++;
                }else{
                SQLSELECTALL=SQLSELECTALL+"and f.RG LIKE '"+funcionario.getRG()+"' ";
                }
            }
            if (!"".equals(funcionario.getEmail())) {
                if (contador==0){
                    SQLSELECTALL=SQLSELECTALL+"WHERE f.EMAIL LIKE '"+funcionario.getEmail()+"' ";
                    contador++;
                }else{
                SQLSELECTALL=SQLSELECTALL+"and f.EMAIL LIKE '"+funcionario.getEmail()+"' ";
                }
            }
            PreparedStatement pst= Connection.connectionFactory.getconnection().prepareStatement(SQLSELECTALL);
            ResultSet rs = pst.executeQuery();
            List<Funcionario> listFuncionario = new ArrayList<Funcionario>();
            
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
                
                Funcionario select = new Funcionario(rs.getInt("COD_FUNCIONARIO"),rs.getString("NOME"),rs.getString("CPF"),rs.getString("RG"),rs.getString("EMAIL"),rs.getString("ENDERECO"),rs.getString("CELULAR"),rs.getString("DATA_ALTERACAO"),rs.getString("DATA_CADASTRO"));
                listFuncionario.add(select);
            }
            return listFuncionario;
            
    }    catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Problemas no sistema, por favor tente mais tarde");
        }
        return null;
    }
}