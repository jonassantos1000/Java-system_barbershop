/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Configuracao;

/**
 *
 * @author faculdade
 */
public class ConfiguracaoDAO {

    public ConfiguracaoDAO(Configuracao configuracao) {
        this.configuracao=configuracao;
    }
   
    private Configuracao configuracao = new Configuracao();
    
    public Configuracao selectConfig (){
        Configuracao config = new Configuracao();
        try{
            String select = "SELECT * FROM CONFIGURACOES WHERE COD_CONFIGURACAO=1";
            PreparedStatement pst= Connection.connectionFactory.getconnection().prepareStatement(select);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Configuracao result = new Configuracao (rs.getString("NM_RAZAOSOCIAL"),rs.getString("NM_RESPONSAVEL"),rs.getString("NU_CNPJ"),
                rs.getString("DS_EMAIL"),rs.getString("DS_SENHA_EMAIL"),rs.getString("DS_SMTP"),rs.getString("DS_PORTA_SMTP"),
                rs.getString("DS_SSL"),rs.getString("DS_TLS"),rs.getString("DS_MENSAGEM_PADRAO"));
                config=result;
            }
            return config;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            return null;   
        }
    }
        
    public void update(){
        try{
            String update="UPDATE CONFIGURACOES SET NM_RAZAOSOCIAL=?,NM_RESPONSAVEL=?,NU_CNPJ=?,DS_EMAIL=?,DS_SENHA_EMAIL=?,DS_SMTP=?,"
                    + "DS_PORTA_SMTP=?,DS_SSL=?,DS_TLS=?,DS_MENSAGEM_PADRAO=?,DT_CONFIGURACAO=?";
            
            PreparedStatement pst= Connection.connectionFactory.getconnection().prepareStatement(update);
            pst.setString(1,configuracao.getRazaoSocial());
            pst.setString(2,configuracao.getResponsavelLegal());
            pst.setString(3, configuracao.getCnpj());
            pst.setString(4, configuracao.getEmail());
            pst.setString(5, configuracao.getSenha());
            pst.setString(6, configuracao.getSmtp());
            pst.setString(7, configuracao.getPortaSMTP());
            pst.setString(8, configuracao.getSSL());
            pst.setString(9, configuracao.getTLS());
            pst.setString(10, configuracao.getMensagemPadrao());
            pst.setDate(11, Util.data.getSqlDate(Util.data.formataData(Util.data.getdata())));
            pst.executeUpdate();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            ex.printStackTrace();
        }    
    }
        
    
    
    
    }
