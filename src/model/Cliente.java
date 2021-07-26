/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import DAO.ClientesDAO;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Jonas Santos
 */
public class Cliente extends Pessoa {
    public Cliente(int codigo, String nome, String cpf, String RG, String celular, String email, String data_cadastro,
        String endereco, String bairro, String numero, String complemento, String telefone, String notificawhats, String observacao,String cep,String data_alteracao) {
        super(codigo,nome,cpf,RG,celular,email,data_cadastro,endereco,bairro,numero,complemento,telefone,notificawhats,observacao,cep,data_alteracao);
    }  
    public Cliente(int codigo, String nome, String cpf, String RG, String celular, String email, String data_cadastro,
        String endereco, String bairro, String numero, String complemento, String telefone, String notificawhats, String observacao,String cep) {
        super(codigo,nome,cpf,RG,celular,email,data_cadastro,endereco,bairro,numero,complemento,telefone,notificawhats,observacao,cep);
    }
    
    
    public Cliente(int codigo, String nome, String cpf, String RG,String email) {
        //construtor utilizado para realizar consultas no Banco de dados 
        this(codigo,nome,cpf,RG,"0",email,"0","0","0","0","0","0","0","0","0");
       
    }
    
    public Cliente(int codigo, String nome, String cpf, String RG,String email,String endereco,String celular, String data_alteracao, String data_cadastro) {//construtor da view principal
        this(codigo,nome,cpf,RG,celular,email,data_cadastro,endereco,"0","0","0","0","0","0","0",data_alteracao);
       
    }
    
    public Cliente(int codigo) {
        //Construtor utilizado para incluir movimentacao
        this(codigo,"","","","0","","0","0","0","0","0","0","0","0","0");
     
    }
    
    private List<Cliente> result;
    private Cliente resultalteracliente;




    
    public void gravar(Cliente cliente) throws ParseException{
        ClientesDAO dao = new ClientesDAO(this);
        dao.insert();
    }
    
    public void alterar(Cliente cliente){
        ClientesDAO daoaltera = new ClientesDAO(this);
        daoaltera.update();
    }
    
    
    
    public void selectnoFilter(Cliente cliente,String limite) throws SQLException{
            ClientesDAO dao = new ClientesDAO(this);
            List<Cliente> resultselect = new ArrayList<Cliente>();
            resultselect=dao.selectall(cliente,limite);
            setResultselect(resultselect);

    } 
       
    public void setResultselect(List<Cliente> result){
        this.result=result;
    }
    
    public List<Cliente> getResultselect(){
       return result; 
    }
    
    public void selectAlteraCliente(int codigo){
        try{
            ClientesDAO dao = new ClientesDAO(this);
            setresultalteracliente(dao.selectAlteraCliente(codigo));     
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void setresultalteracliente(Cliente result){
        this.resultalteracliente=result;
    }    
    
    public Cliente getresultalteracliente(){
        return resultalteracliente;
    }
    
    
    
    
    public static void gravacliente(int codigo, String nome, String CPF, String RG, String endereco, String CEP) throws IOException{
        try{
            FileWriter client = new FileWriter("C:\\mtx\\client"+codigo+".txt");
            PrintWriter gravaTexto = new PrintWriter(client);
            gravaTexto.printf("Codigo="+codigo+"\n");
            gravaTexto.printf("Nome="+nome+"\n");
            gravaTexto.printf("CPF="+CPF+"\n");
            gravaTexto.printf("RG="+RG+"\n");
            gravaTexto.printf("Endereco="+endereco+"\n");
            gravaTexto.printf("CEP="+CEP+"\n");
            client.close();
        }
        catch (IOException ex){
        //;
        JOptionPane.showMessageDialog(null,"erro ao escrever arquivo");
        }
        
        
    }
    


}
