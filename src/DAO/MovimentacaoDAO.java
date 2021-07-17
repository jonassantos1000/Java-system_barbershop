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
import model.Cliente;
import model.Funcionario;
import model.Movimentacao;

/**
 *
 * @author Jonas Santos
 */
public class MovimentacaoDAO {
    
    public MovimentacaoDAO(model.Movimentacao movimentacao){
        this.movimentacao=movimentacao;
        this.alteraMovimentacao=movimentacao;
    }
    
    private Movimentacao movimentacao;
    private Movimentacao alteraMovimentacao;
    private Cliente consultaCliente;
    String SQLSELECTALL;

        public List<Movimentacao> selectall(Movimentacao movimentacao, String limite) throws SQLException{
        try{
            SQLSELECTALL="SELECT FIRST "+limite+" * FROM VWMOVIMENTACAO m ";
            int contador=0;
            
            if (limite.equals("0") || limite.isEmpty()){
                limite="99999999"; 
            }

            //Campo codigo
            if (!"0".equals(String.valueOf(movimentacao.getCodigo()))) {
                if (contador==0){ 
                    SQLSELECTALL=SQLSELECTALL+"where m.COD_VENDA LIKE '"+String.valueOf(movimentacao.getCodigo())+"' ";
                    contador++;
                }
            }// fim do campo codigo
            
            if (!"0".equals(String.valueOf(movimentacao.getCliente().getCodigo()))){
                if (contador==0){
                    SQLSELECTALL=SQLSELECTALL+"WHERE m.COD_CLIENTE LIKE '%"+movimentacao.getCliente().getNome()+"%' ";
                    contador++;
                }else{
                    SQLSELECTALL=SQLSELECTALL+"and m.COD_CLIENTE LIKE '%"+movimentacao.getCliente().getNome()+"%' ";  
                }
            }    
            
            if (!"".equals(movimentacao.getCliente().getNome())){
                if (contador==0){
                    SQLSELECTALL=SQLSELECTALL+"WHERE m.NOMECLIENTE LIKE '%"+movimentacao.getCliente().getNome()+"%' ";
                    contador++;
                }else{
                    SQLSELECTALL=SQLSELECTALL+"and m.NOMECLIENTE LIKE '%"+movimentacao.getCliente().getNome()+"%' ";  
                }
            }
            if (!"___.___.___-__".equals(movimentacao.getCliente().getCPF()) && !"".equals(movimentacao.getCliente().getCPF())){
                if (contador==0){
                    SQLSELECTALL=SQLSELECTALL+"WHERE m.CPFCLIENTE LIKE '"+movimentacao.getCliente().getCPF()+"' ";
                    contador++;
                }else{
                    SQLSELECTALL=SQLSELECTALL+"and m.CPFCLIENTE LIKE '"+movimentacao.getCliente().getCPF()+"' ";
                }
            }
            if (!"__.___.___-_".equals(movimentacao.getCliente().getRG()) && !"".equals(movimentacao.getCliente().getRG())) {
                if (contador==0){
                    SQLSELECTALL=SQLSELECTALL+"WHERE m.RGCLIENTE LIKE '"+movimentacao.getCliente().getRG()+"' ";
                    contador++;
                }else{
                SQLSELECTALL=SQLSELECTALL+"and m.RGCLIENTE LIKE '"+movimentacao.getCliente().getRG()+"' ";
                }
            }
            if (!"".equals(movimentacao.getData())) {
                String desmembraData[]=movimentacao.getData().split(";");
                String dataInicial= desmembraData[0];
                
                String dataFinal= desmembraData[1];
                if (contador==0){
                    SQLSELECTALL=SQLSELECTALL+"WHERE CAST(m.DT_VENDA AS date) BETWEEN '"+dataInicial+"' AND '"+dataFinal+"' ";
                    contador++;
                }
            }
            PreparedStatement pst= Connection.connectionFactory.getconnection().prepareStatement(SQLSELECTALL);
            ResultSet rs = pst.executeQuery();
            List<Movimentacao> listMovimentacao = new ArrayList<Movimentacao>();
            
            while (rs.next()){
                String CPFaux="";
                String RGaux="";
                if(rs.getString("CPFCLIENTE")==null){
                    CPFaux="___.___.___-__";
                }else{
                    CPFaux=rs.getString("CPFCLIENTE");
                }
                if(rs.getString("RGCLIENTE")==null){
                    RGaux="__.___.___-_";
                }else{
                    RGaux=rs.getString("RGCLIENTE");
                }
                
                Cliente consultaCliente = new Cliente(rs.getInt("COD_CLIENTE"),rs.getString("NOMECLIENTE"),rs.getString("CPFCLIENTE"),rs.getString("RGCLIENTE"),"");
                Funcionario funcionario = new Funcionario(rs.getInt("COD_FUNCIONARIO"),rs.getString("NOMEFUNCIONARIO"),"","","");
                Movimentacao select = new Movimentacao(rs.getInt("COD_VENDA"),rs.getString("DT_VENDA"),consultaCliente,funcionario);
                listMovimentacao.add(select);
            }
            return listMovimentacao;
            
    }    catch(SQLException ex){
            ex.printStackTrace();
            
        }
        return null;
    } 






}
