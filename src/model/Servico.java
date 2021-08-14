/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.ServicoDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonas Santos
 */
public class Servico {
   
    public Servico(int codigo, String descricao, double preco, String data_cadastro, String data_alteracao, String usuario,String observacao,String inativo){
        setCodigo(codigo);
        setDescricao(descricao);
        setPreco(preco);
        setDataCadastro(data_cadastro);
        setDataAlteracao(data_alteracao);
        setUsuario(usuario);
        setObservacao(observacao);
        setInativo(inativo);
    }
    
    public Servico(int codigo, String descricao, double preco, String data_cadastro, String usuario,String observacao,String inativo){
        //construtor para criar novos servicos(não precisa informar a data de alteracao)
        this(codigo,descricao,preco,data_cadastro,"",usuario,observacao,inativo);
    }
    
    public Servico(int codigo, String descricao, String inativo){
        //utilizado para retornar pesquisa da tela principal de serviços
        this(codigo,descricao,0,"","","",inativo);
    }
    
    public Servico(int codigo, String descricao){
        //construtor utilizado para trazer o resultado inicial da tela de alteração e na tela de incluir e alterar movimentacao
        this(codigo,descricao,0,"","","","");
    }
    
    public Servico(int codigo, String descricao, double preco){
        //construtor utilizado para trazer o resultado da pesquisa na tela ServicoPrincipal
        this(codigo,descricao,preco,"","","","");
    }
    
    private String inativo;    
    private int codigo = 0;
    private String descricao;
    private double preco;
    private String data_cadastro;
    private String data_alteracao;
    private String usuario;// Para gravar o usuario que realizou o cadastro
    private String observacao;
    private List<Servico> result;
    private Servico ResultSelectAltera;
    
    public String getInativo() {
        return inativo;
    }

    public void setInativo(String inativo) {
        this.inativo = inativo;
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
    
    public void setPreco(double preco){
        this.preco=preco;
    }
    
    public double getPreco(){
        return this.preco;
    }
    
    public void setDataCadastro(String data){
        this.data_cadastro=data;
    }
    
    public String getDataCadastro(){
        return this.data_cadastro;
    }
    
    public void setDataAlteracao(String data){
        this.data_alteracao=data;
    }
    
    public String getDataAlteracao(){
        return this.data_alteracao;
    }
    
    public void setUsuario(String usuario){        
        this.usuario=usuario;
    }
    
    public String getUsuario (){
        return this.usuario;
    }
    
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    public void gravar(Servico servico) throws ParseException{
        ServicoDAO daoinsert= new ServicoDAO(this);
        daoinsert.insert(this);
    }
    
    public void alterar(Servico servico){
        ServicoDAO alterarServico= new ServicoDAO(this);
        alterarServico.update();
    }
    
    public void apagar(Servico servico){
        ServicoDAO excluirServico= new ServicoDAO(this);
        excluirServico.delete();
    }    
    
    public void selectAlteraServico(int ID){
        try{
            ServicoDAO alteraServico = new ServicoDAO(this);
            setResultSelectAltera(alteraServico.selectAlteraServico(ID));
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void setResultSelectAltera(Servico servico){
        this.ResultSelectAltera=servico;
    }
    
    public Servico getResultSelectAltera(){
        return ResultSelectAltera;
    }

    public void setSelectFilter(List<Servico> result){
        this.result=result;
    }
    
    public List<Servico> getSelectFilter(){
        return this.result;
    }
    
    
    public void selectFilter(Servico servico,String limite) throws SQLException{
        ServicoDAO dao = new ServicoDAO(this);
        List<Servico> resultselect = new ArrayList();
        resultselect=dao.selectall(servico, limite);
        setSelectFilter(resultselect);        
    }


    
    
}
