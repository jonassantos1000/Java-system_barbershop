/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonas Santos
 */
public class ProdutosMovimento {
    private Servico servico;
    private int venda;
    private int qtde;
    private double preco;
    private double precoTotal;

    private List<ProdutosMovimento> listaProdutos;
    
    public ProdutosMovimento(Servico servico, int qtde, double preco,double total){
        setServico(servico);
        setQtde(qtde);
        setPreco(preco);
        setPrecoTotal(total);

    }
    
    public ProdutosMovimento(){
        
    }
        
    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public List<ProdutosMovimento> getListaProdutos() {
        return listaProdutos;
    }
    
    public void setListaProduto(List<ProdutosMovimento> produto){
        listaProdutos=produto;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
    
    public void adicionar(){
        
    }
            
    
}
