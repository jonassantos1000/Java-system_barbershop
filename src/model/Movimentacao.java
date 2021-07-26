/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;
import DAO.MovimentacaoDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Jonas Santos
 */



public class Movimentacao {
   
    
    public Movimentacao(int codigo,double valor, String data, Cliente cliente, List<ProdutosMovimento> listProduto, Funcionario funcionario){
        setCodigo(codigo);
        setValor(valor);
        setData(data);
        setCliente(cliente);
        setListProduto(listProduto);
        setFuncionario(funcionario);
    }
    
    public Movimentacao(int codigo, String data, Cliente cliente){
        this(codigo,0.0,data,cliente,null,null);
    }
    
    public Movimentacao(int codigo,double valor, String data, Cliente cliente, Funcionario funcionario){
        //UTILIZADO PARA CONSULTA NA VIEW
        this(codigo,valor,data,cliente,null,funcionario);
    }
    
    
    
    Movimentacao consultaMovimentacao;
    private int codigo = 0;
    private double valor;
    private String data;
    private int quantidade;
    private Cliente cliente;
    List<ProdutosMovimento> listProduto;

    public List<ProdutosMovimento> getListProduto() {
        return listProduto;
    }

    public void setListProduto(List<ProdutosMovimento> listProduto) {
        this.listProduto = listProduto;
    }
    private Funcionario funcionario;

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
  
        public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public List<Movimentacao> consultarMovimentacao(Movimentacao movimentacao, String limite) throws SQLException{
        MovimentacaoDAO dao = new MovimentacaoDAO(this);
        List<Movimentacao> resultSelect= new ArrayList<Movimentacao>();
        resultSelect=dao.selectall(movimentacao, limite);
        return resultSelect;
    }
     
    public void gravar (Movimentacao mov) throws ParseException{
        MovimentacaoDAO dao = new MovimentacaoDAO(this);
        dao.insert();
    }
    
    public void alterar(){
        
    }
    
    public void cancelar (){
        
    }
    
    public void estornar (){
        
    }

}
