/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;
import DAO.MovimentacaoDAO;
import DAO.ServicoDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonas Santos
 */

public class Movimentacao {
    
    public Movimentacao(int codigo,double valor, String data, Cliente cliente, List<ProdutosMovimento> listProduto, Funcionario funcionario,String dataAlteracao){
        setCodigo(codigo);
        setValor(valor);
        setData(data);
        setCliente(cliente);
        setListProduto(listProduto);
        setFuncionario(funcionario);
        setDataAlteracao(dataAlteracao);
    }
    
    public Movimentacao(int codigo,double valor, String data, Cliente cliente, List<ProdutosMovimento> listProduto, Funcionario funcionario){
        this(codigo,valor,data,cliente,listProduto,funcionario,"");
    }
    
    public Movimentacao(int codigo, String data, Cliente cliente){
        this(codigo,0.0,data,cliente,null,null,"");
    }
    
    public Movimentacao(int codigo,double valor, String data, Cliente cliente, Funcionario funcionario){
        //UTILIZADO PARA CONSULTA NA VIEW
        this(codigo,valor,data,cliente,null,funcionario,"");
    }
 
    Movimentacao consultaMovimentacao;
    private int codigo = 0;
    private double valor;
    private String data;
    private int quantidade;
    private Cliente cliente;
    private String dataAlteracao;

    public String getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(String dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
    List<ProdutosMovimento> listProduto;
    private Movimentacao ResultSelectAltera;

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
 
    public void selectAlteraMovimentacao(int ID){
        try{
            MovimentacaoDAO alteraMovimentacao = new MovimentacaoDAO(this);
            setResultSelectAltera(alteraMovimentacao.selectAlteraMovimentacao(ID));
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public Movimentacao getResultSelectAltera() {
        return ResultSelectAltera;
    }

    public void setResultSelectAltera(Movimentacao ResultSelectAltera) {
        this.ResultSelectAltera = ResultSelectAltera;
    }
         
    public void gravar (Movimentacao mov) throws ParseException{
        MovimentacaoDAO dao = new MovimentacaoDAO(this);
        dao.insert();
    }
    
    public void alterar(Movimentacao mov){
        MovimentacaoDAO dao = new MovimentacaoDAO(this);
        dao.update();
    }
    
    public void apagar(Movimentacao Movimentacao){
        MovimentacaoDAO excluirMovimentacao= new MovimentacaoDAO(this);
        excluirMovimentacao.delete();
    }   
}
