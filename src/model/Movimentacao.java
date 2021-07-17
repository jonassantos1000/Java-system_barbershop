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
import java.util.ArrayList;

/**
 *
 * @author Jonas Santos
 */



public class Movimentacao {
   
    
    public Movimentacao(int codigo, int quantidade, double valor, String data, Cliente cliente, Servico servico, Funcionario funcionario){
        setCodigo(codigo);
        setQuantidade(quantidade);
        setValor(valor);
        setData(data);
        setCliente(cliente);
        setServico(servico);
        setFuncionario(funcionario);
    }
    
    public Movimentacao(int codigo, String data, Cliente cliente){
        this(codigo,0,0.0,data,cliente,null,null);
    }
    
    public Movimentacao(int codigo, String data, Cliente cliente, Funcionario funcionario){
        this(codigo,0,0.0,data,cliente,null,funcionario);
    }
    
    
    
    Movimentacao consultaMovimentacao;
    private int codigo = 0;
    private double valor;
    private String data;
    private int quantidade;
    private Cliente cliente;
    private Servico servico;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
        public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
    
    public List<Movimentacao> consultarMovimentacao(Movimentacao movimentacao, String limite) throws SQLException{
        MovimentacaoDAO dao = new MovimentacaoDAO(this);
        List<Movimentacao> resultSelect= new ArrayList<Movimentacao>();
        resultSelect=dao.selectall(movimentacao, limite);
        return resultSelect;
    }
     
    public int incluir (){
        int id = 123; /*instrução de teste*/
     
        return id;
    }
    
    public void alterar(){
        
    }
    
    public void cancelar (){
        
    }
    
    public void estornar (){
        
    }

}
