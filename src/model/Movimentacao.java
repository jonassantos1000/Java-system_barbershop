/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Jonas Santos
 */
public class Movimentacao {
    private int codigo = 0;
    private double valor;
    private Date data;
    private int quantidade;

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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
