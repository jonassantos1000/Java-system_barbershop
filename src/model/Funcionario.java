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
public class Funcionario extends Pessoa {
    
    public Funcionario(int codigo, String nome, String cpf, String RG, String celular, String email, String data, String endereco, String bairro, String numero, String complemento, String telefone, String observacao, String CEP, String data_alteracao) {
        super(codigo, nome, cpf, RG, celular, email, data, endereco, bairro, numero, complemento, telefone, observacao, CEP, data_alteracao);
    }
      
}
