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
public abstract class Pessoa {
    String nome;
    String cpf;
    String celular;
    String email;
    String data_cadastro;
    String data_alteracao;
    String rg;
    String endereco;
    String bairro;
    String numero;
    String CEP;
    String complemento;
    String telefone;
    String notificawhats;
    String observacao;
    int codigo;
    
    public Pessoa(int codigo, String nome, String cpf, String RG, String celular, String email, String data,
            String endereco, String bairro, String numero, String complemento, String telefone, String notificawhats, String observacao, String CEP, String data_alteracao){
        setCodigo(codigo);
        setNome(nome);
        setCPF(cpf);
        setRG(RG);
        setCelular(celular);
        setEmail(email);
        setData(data);
        setEndereco(endereco);
        setBairro(bairro);
        setNumero(numero);
        setComplemento(complemento);
        setTelefone(telefone);
        setNotificawhats(notificawhats);
        setObservacao(observacao);
        setCEP(CEP);
        setData_alteracao(data_alteracao);
    }
    
    public Pessoa(int codigo, String nome, String cpf, String RG, String celular, String email, String data, String endereco, String bairro, String numero, String complemento, String telefone, String notificawhats, String observacao, String CEP){
        this(codigo,nome,cpf,RG,celular,email,data,endereco,bairro,numero,complemento,telefone,notificawhats,observacao,CEP,"");
    }
      
    public void setRG(String rg){
        this.rg=rg;
    }
    
    public String getRG(){
        return rg;
    }

    public String getData_alteracao() {
        return data_alteracao;
    }

    public void setData_alteracao(String data_alteracao) {
        this.data_alteracao = data_alteracao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNotificawhats() {
        return notificawhats;
    }

    public void setNotificawhats(String notificawhats) {
        this.notificawhats = notificawhats;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    public String getData() {
        return data_cadastro;
    }

    public void setData(String data) {
        this.data_cadastro = data;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
        
    
}

