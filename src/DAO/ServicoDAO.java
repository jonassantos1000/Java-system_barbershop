/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Servico;

/**
 *
 * @author Jonas Santos
 */
public class ServicoDAO {
    
    public ServicoDAO(Servico servico){
        this.servico=servico;
    }
    
    private String SQLSELECTALL;
    
    private Servico servico;
    
    
        public List<Servico> selectall(Servico servico, String limite) throws SQLException{
        try{
            if (limite=="0" || limite==""){
                limite="9999999"; 
            }
            
            SQLSELECTALL="SELECT FIRST "+limite+" COD_SERVICO,DESCRICAO,PRECO,DATA_CADASTRO,DATA_ALTERACAO,USUARIO FROM SERVICOS as s ";
            int contador=0;
            //Campo codigo
            if (!"0".equals(String.valueOf(servico.getCodigo()))) {
                if (contador==0){ 
                    SQLSELECTALL=SQLSELECTALL+"where s.COD_SERVICO LIKE '"+String.valueOf(servico.getCodigo())+"' ";
                    contador++;
                }
            }// fim do campo codigo
            if (!"".equals(servico.getDescricao())){
                if (contador==0){
                    SQLSELECTALL=SQLSELECTALL+"WHERE s.DESCRICAO LIKE '%"+servico.getDescricao()+"%' ";
                    contador++;
                }else{
                SQLSELECTALL=SQLSELECTALL+"and s.DESCRICAO LIKE '%"+servico.getDescricao()+"%' ";  
                }
            }
            
            PreparedStatement pst= Connection.connectionFactory.getconnection().prepareStatement(SQLSELECTALL);
            ResultSet rs = pst.executeQuery();
            List<Servico> listServico = new ArrayList<Servico>();
            
            while (rs.next()){
                Servico select = new Servico(rs.getInt("COD_SERVICO"),rs.getString("DESCRICAO"),rs.getDouble("PRECO"),rs.getString("DATA_CADASTRO"),rs.getString("DATA_ALTERACAO"),rs.getString("USUARIO"));
                listServico.add(select);
            }
            return listServico;
            
    }    catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Problemas no sistema, por favor tente mais tarde");
        }
        return null;
    }   
    
    
    
    
}
