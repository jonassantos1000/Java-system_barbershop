/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.ServicoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonas Santos
 */
public class Servico {
   
    public Servico(int codigo, String descricao, double preco, String data_cadastro, String data_alteracao, String usuario){
        setCodigo(codigo);
        setDescricao(descricao);
        setPreco(preco);
        setDataCadastro(data_cadastro);
        setDataAlteracao(data_alteracao);
        setUsuario(usuario);
        
    }
    
    public Servico(int codigo, String descricao, double preco, String data_cadastro, String usuario){
        //construtor para criar novos servicos(não precisa informar a data de alteracao)
        this(codigo,descricao,preco,data_cadastro,"",usuario);
    }
    
    public Servico(int codigo, String descricao){
        //construtor utilizado para trazer o resultado da pesquisa na tela ServicoPrincipal
        this(codigo,descricao,0,"","","");
    }
    
    private int codigo = 0;
    private String descricao;
    private double preco;
    private String data_cadastro;
    private String data_alteracao;
    private String usuario;// Para gravar o usuario que realizou o cadastro
    private List<Servico> result;
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void setPreco(double preco){
        this.preco=preco;
    }
    
    public double getPreco(){
        return this.preco;
    }
    
    public void setDataCadastro(String data){
        this.data_cadastro=data;
    }
    
    public String getDataCadastro(){
        return this.data_cadastro;
    }
    
    public void setDataAlteracao(String data){
        this.data_alteracao=data;
    }
    
    public String getDataAlteracao(){
        return this.data_alteracao;
    }
    
    public void setUsuario(String usuario){        
        this.usuario=usuario;
    }
    
    public String getUsuario (){
        return this.usuario;
    }
    
    public void gravar(){
        
    }
    
    public void alterar(){
        
    }
    
    public void setSelectFilter(List<Servico> result){
        this.result=result;
    }
    
    public List<Servico> getSelectFilter(){
        return this.result;
    }
    
    
    public void selectFilter(Servico servico,String limite) throws SQLException{
        ServicoDAO dao = new ServicoDAO(this);
        List<Servico> resultselect = new ArrayList();
        resultselect=dao.selectall(servico, limite);
        setSelectFilter(resultselect);        
    }
    
    
    
    
    
}
