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
    
    public Relatorio(String mes,int ano, int atendimentos, double total) {
        this.ano = ano;
        this.mes = mes;
        this.atendimentos = atendimentos;
        this.total = total;
    }
    
    public Relatorio(){
        
    }
        
    
    public Relatorio(int codigo, int qtde, double preco, String descricao, double subTotal){
        this.descricao=descricao;
        this.preco =preco;
        this.qtde=qtde;
        this.codigo=codigo;
        this.subTotal=subTotal;
    }
    
    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(int atendimentos) {
        this.atendimentos = atendimentos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    private int codigo;
    private int qtde;
    private double preco;
    private String descricao;
    private double subTotal;
    private String diretorio;
    private String categoria;
    private int ano;
    private String mes;
    private int atendimentos;   
    private double total;
                
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
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
    
    public List<Relatorio> selectComprovante(Relatorio relatorio){
        RelatorioDAO dao = new RelatorioDAO(this);
        return dao.SelectComprovante(relatorio.getCodigo());
    }
    
    public List<Relatorio> pesquisarTotalizadorMes(Relatorio relatorio) {
        RelatorioDAO dao = new RelatorioDAO(this);
        return dao.SelectTotalizadorMes();
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

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
