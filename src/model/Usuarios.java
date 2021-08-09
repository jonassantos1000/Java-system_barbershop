/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.UsuarioDAO;

/**
 *
 * @author jonas
 */
public class Usuarios {
    private String usuario;
    private String senha;
    private String gerencia;

    public Usuarios (String usuario, String senha, String gerencia){
        setUsuario(usuario);
        setSenha(senha);
        setGerencia(gerencia);
    }

    public Usuarios(String usuario) {
        this.usuario = usuario;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getGerencia() {
        return gerencia;
    }

    public void setGerencia(String gerencia) {
        this.gerencia = gerencia;
    }
    
    public void inserir(Usuarios usuario){
        UsuarioDAO dao = new UsuarioDAO(this);
        dao.insert();
    }
    
    public Usuarios selectall(Usuarios usuario){
        UsuarioDAO dao = new UsuarioDAO(this);
        return dao.selectUsuario();
    }
    
}
