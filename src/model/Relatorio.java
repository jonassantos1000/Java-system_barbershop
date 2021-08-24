/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.RelatorioDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author faculdade
 */
public class Relatorio {
    public Relatorio(int codigo, String descricao, String diretorio,String categoria){
        setCodigo(codigo);
        setDescricao(descricao);
        setDiretorio(diretorio);
        setCategoria(categoria);
    }
    
    public Relatorio(String categoria){
        this(0,"","",categoria);
    }
    
    private int codigo;
    private String descricao;
    private String diretorio;
    private String categoria;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
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

    public String getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }
    
    public List<Relatorio> select(Relatorio relatorio) throws SQLException{
        RelatorioDAO dao = new RelatorioDAO(this);
        return dao.selectRelatorios();
    }
    
}
