/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.ConfiguracaoDAO;
import static Util.coalesce.coalesce;

/**
 *
 * @author faculdade
 */
public class Configuracao {
    
    public Configuracao(){
        
    }

    public Configuracao(String razaoSocial, String responsavelLegal, String cnpj, String email, String senha, String smtp, String portaSMTP, String SSL, String TLS, String mensagemPadrao) {
        this.razaoSocial = razaoSocial;
        this.responsavelLegal = responsavelLegal;
        this.cnpj = cnpj;
        this.email = email;
        this.senha = senha;
        this.smtp = smtp;
        this.portaSMTP = portaSMTP;
        this.SSL = SSL;
        this.TLS = TLS;
        this.mensagemPadrao = mensagemPadrao;
    }
    
    private String razaoSocial;
    private String responsavelLegal;
    private String cnpj;
    private String email;
    private String senha;
    private String smtp;
    private String portaSMTP;
    private String SSL;
    private String TLS;
    private String mensagemPadrao;

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getResponsavelLegal() {
        return responsavelLegal;
    }

    public void setResponsavelLegal(String responsavelLegal) {
        this.responsavelLegal = responsavelLegal;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSmtp() {
        return smtp;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }

    public String getPortaSMTP() {
        return portaSMTP;
    }

    public void setPortaSMTP(String portaSMTP) {
        this.portaSMTP = portaSMTP;
    }

    public String getSSL() {
        return SSL;
    }

    public void setSSL(String SSL) {
        this.SSL = SSL;
    }

    public String getTLS() {
        return TLS;
    }

    public void setTLS(String TLS) {
        this.TLS = TLS;
    }

    public String getMensagemPadrao() {
        return mensagemPadrao;
    }

    public void setMensagemPadrao(String mensagemPadrao) {
        this.mensagemPadrao = mensagemPadrao;
    }
    
    public Configuracao pesquisar () {
        ConfiguracaoDAO dao = new ConfiguracaoDAO (this);
        return dao.selectConfig();
    }
        
    public void salvar(){
        ConfiguracaoDAO dao = new ConfiguracaoDAO (this);
        dao.update();
    }
}
