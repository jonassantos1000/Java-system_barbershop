/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jonas Santos
 */
public class Servico {
    private int codigo = 0;
    private String descricao;

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
    
    public int incluir(){
        int id = 123; /*instrução de teste*/
     
        return id;
    }
    
    public void alterar(){
        
    }
    
    public void excluir(){
        
    }
    
}
