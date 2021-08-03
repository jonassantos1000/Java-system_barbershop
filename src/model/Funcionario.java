/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.FuncionarioDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonas Santos
 */
public class Funcionario extends Pessoa {
    
    public Funcionario(int codigo, String nome, String cpf, String RG, String celular, String email, String data, String endereco, String bairro, String numero, String complemento, String telefone, String observacao, String CEP, String data_alteracao) {
        super(codigo, nome, cpf, RG, celular, email, data, endereco, bairro, numero, complemento, telefone,"", observacao, CEP, data_alteracao);
    }
    
    public Funcionario(int codigo, String nome, String cpf, String RG, String celular, String email, String data_cadastro,String endereco, String bairro, String numero, String complemento, String telefone, String observacao,String cep) {
        //construtor para utilizado para incluir um novo cadastro
        super(codigo,nome,cpf,RG,celular,email,data_cadastro,endereco,bairro,numero,complemento,telefone,"",observacao,cep);
    }
    
    public Funcionario(int codigo, String nome, String cpf, String RG,String email) {
        //construtor utilizado para realizar consultas no Banco de dados 
        this(codigo,nome,cpf,RG,"0",email,"0","0","0","0","0","0","0","0","0");
       
    }
    
    public Funcionario(int codigo, String nome, String cpf, String RG,String email,String endereco,String celular, String data_alteracao, String data_cadastro) {
    //retorno da pesquisa do banco de dados na view principal
        this(codigo,nome,cpf,RG,celular,email,data_cadastro,endereco,"0","0","0","0","0","0",data_alteracao);
       
    }
    
    public Funcionario(int codigo,String nome) {
        this(codigo,nome,"","","0","","0","0","0","0","0","0","0","0","0");
    }
    
    public Funcionario(int codigo) {
        this(codigo,"","","","0","","0","0","0","0","0","0","0","0","0");
    }
    
    private List<Funcionario> result;
    private Funcionario resultalterafuncionario;


  
    public void gravar(Funcionario funcionario) throws ParseException{
        FuncionarioDAO dao = new FuncionarioDAO(this);
        dao.insert();
    }
    
    public void alterar(Funcionario funcionario){
        FuncionarioDAO daoaltera = new FuncionarioDAO(this);
        daoaltera.update();
    }
    
    
    
    public void selectnoFilter(Funcionario funcionario,String limite) throws SQLException{
            FuncionarioDAO dao = new FuncionarioDAO(this);
            List<Funcionario> resultselect = new ArrayList<Funcionario>();
            resultselect=dao.selectall(funcionario,limite);
            setResultselect(resultselect);

    } 
       
    public void setResultselect(List<Funcionario> result){
        this.result=result;
    }
    
    public List<Funcionario> getResultselect(){
       return result; 
    }
    
    public void selectAlteraFuncionario(int codigo){
        try{
            FuncionarioDAO dao = new FuncionarioDAO(this);
            setresultalterafuncionario(dao.selectAlteraFuncionario(codigo));     
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void setresultalterafuncionario(Funcionario result){
        this.resultalterafuncionario=result;
    }    
    
    public Funcionario getresultalterafuncionario(){
        return resultalterafuncionario;
    }

    
      
}
