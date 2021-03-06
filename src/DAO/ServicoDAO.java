/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Util.data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Servico;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 *
 * @author Jonas Santos
 */
public class ServicoDAO {

    public ServicoDAO(Servico servico) {
        this.servico = servico;
        this.alteraServico = servico;
    }

    private String SQLINSERT;
    private String SQLSELECTALL;
    private String SQLUPDATE;
    private String SQLSELECTALTERACLIENTE;
    private Servico servico; // recebe objeto para incluir um novo cadastro 
    private Servico alteraServico; //recebe objeto para alterar um cadastro

    public List<Servico> selectall(Servico servico, String limite) throws SQLException {
        try {

            if (servico.getInativo() == "") {
                servico.setInativo("F");
            }

            if (limite.equals("0") || limite.isEmpty()) {
                limite = "9999999";
            }

            SQLSELECTALL = "SELECT FIRST " + limite + " COD_SERVICO,DESCRICAO,PRECO,DATA_CADASTRO,DATA_ALTERACAO,USUARIO,OBSERVACAO,INATIVO FROM SERVICOS as s ";
            int contador = 0;
            //Campo codigo
            if (!"0".equals(String.valueOf(servico.getCodigo()))) {
                if (contador == 0) {
                    SQLSELECTALL = SQLSELECTALL + "where s.COD_SERVICO LIKE '" + String.valueOf(servico.getCodigo()) + "' ";
                    contador++;
                }
            }// fim do campo codigo
            if (!"".equals(servico.getDescricao())) {
                if (contador == 0) {
                    SQLSELECTALL = SQLSELECTALL + "WHERE s.DESCRICAO LIKE '%" + servico.getDescricao() + "%' ";
                    contador++;
                } else {
                    SQLSELECTALL = SQLSELECTALL + "and s.DESCRICAO LIKE '%" + servico.getDescricao() + "%' ";
                }
            }

            if (!"T".equals(servico.getInativo())) {
                if (contador == 0) {
                    SQLSELECTALL = SQLSELECTALL + "WHERE s.INATIVO = '" + servico.getInativo() + "' ";
                    contador++;
                } else {
                    SQLSELECTALL = SQLSELECTALL + "and s.INATIVO = '" + servico.getInativo() + "' ";
                }
            }

            SQLSELECTALL = SQLSELECTALL + "ORDER BY COD_SERVICO";
            PreparedStatement pst = Connection.connectionFactory.getconnection().prepareStatement(SQLSELECTALL);
            ResultSet rs = pst.executeQuery();
            List<Servico> listServico = new ArrayList<Servico>();

            while (rs.next()) {
                Servico select = new Servico(rs.getInt("COD_SERVICO"), rs.getString("DESCRICAO"), rs.getDouble("PRECO"), rs.getString("DATA_CADASTRO"), rs.getString("DATA_ALTERACAO"), rs.getString("USUARIO"), rs.getString("OBSERVACAO"), rs.getString("INATIVO"));
                listServico.add(select);
            }
            return listServico;
        } catch (org.firebirdsql.jdbc.FBSQLException ex) {
            String trace = ExceptionUtils.getStackTrace(ex);
            String metodo = String.valueOf(new Throwable().getStackTrace()[0]);
            Util.Log.setLog(trace, metodo);
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro interno do firebird, reinicie o sistema e tente novamente !");
            System.exit(0);
            return null;
        } catch (SQLException ex) {
            String trace = ExceptionUtils.getStackTrace(ex);
            String metodo = String.valueOf(new Throwable().getStackTrace()[0]);
            Util.Log.setLog(trace, metodo);
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Problemas no sistema, por favor tente mais tarde");
        }
        return null;
    }

    public boolean insert(Servico servico) throws ParseException {
        try {
            SQLINSERT = "INSERT INTO SERVICOS (COD_SERVICO,DESCRICAO,PRECO,DATA_CADASTRO,USUARIO, OBSERVACAO,INATIVO) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pst = Connection.connectionFactory.getconnection().prepareStatement(SQLINSERT);

            pst.setInt(1, servico.getCodigo());
            pst.setString(2, servico.getDescricao());
            pst.setDouble(3, servico.getPreco());
            pst.setDate(4, data.getSqlDate(data.formataData(servico.getDataCadastro())));
            pst.setString(5, servico.getUsuario());
            pst.setString(6, servico.getObservacao());
            pst.setString(7, servico.getInativo());
            pst.executeUpdate();
            return true;
        } catch (org.firebirdsql.jdbc.FBSQLException ex) {
            String trace = ExceptionUtils.getStackTrace(ex);
            String metodo = String.valueOf(new Throwable().getStackTrace()[0]);
            Util.Log.setLog(trace, metodo);
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro interno do firebird, reinicie o sistema e tente novamente !");
            System.exit(0);
            return false;
        } catch (SQLException ex) {
            String trace = ExceptionUtils.getStackTrace(ex);
            String metodo = String.valueOf(new Throwable().getStackTrace()[0]);
            Util.Log.setLog(trace, metodo);
            ex.printStackTrace();
            return false;
        }
    }

    public Servico selectAlteraServico(int ID) throws SQLException {
        try {
            SQLSELECTALTERACLIENTE = "SELECT * FROM SERVICOS WHERE COD_SERVICO=" + ID;
            PreparedStatement pst = Connection.connectionFactory.getconnection().prepareStatement(SQLSELECTALTERACLIENTE);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Servico resultAlteraServico = new Servico(ID, rs.getString("DESCRICAO"), rs.getDouble("PRECO"), String.valueOf(rs.getTimestamp("DATA_CADASTRO")).replace(".0", ""), String.valueOf(rs.getTimestamp("DATA_ALTERACAO")).replace(".0", ""), rs.getString("USUARIO"), rs.getString("OBSERVACAO"), rs.getString("INATIVO"));
                alteraServico = resultAlteraServico;
            }
            return alteraServico;
        } catch (org.firebirdsql.jdbc.FBSQLException ex) {
            String trace = ExceptionUtils.getStackTrace(ex);
            String metodo = String.valueOf(new Throwable().getStackTrace()[0]);
            Util.Log.setLog(trace, metodo);
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro interno do firebird, reinicie o sistema e tente novamente !");
            System.exit(0);
            return null;
        } catch (SQLException ex) {
            String trace = ExceptionUtils.getStackTrace(ex);
            String metodo = String.valueOf(new Throwable().getStackTrace()[0]);
            Util.Log.setLog(trace, metodo);
            JOptionPane.showMessageDialog(null, ex);
            ex.printStackTrace();
            return null;
        }
    }

    public boolean update() {
        try {
            SQLUPDATE = "UPDATE SERVICOS SET DESCRICAO=?,PRECO=?,DATA_ALTERACAO=?,USUARIO=?,OBSERVACAO=?,INATIVO=? WHERE COD_SERVICO=?";
            PreparedStatement pst = Connection.connectionFactory.getconnection().prepareStatement(SQLUPDATE);
            pst.setString(1, servico.getDescricao());
            pst.setDouble(2, servico.getPreco());
            pst.setDate(3, data.getSqlDate(data.formataData(data.getdata())));
            pst.setString(4, servico.getUsuario());
            pst.setString(5, servico.getObservacao());
            pst.setString(6, servico.getInativo());
            pst.setInt(7, servico.getCodigo());
            pst.executeUpdate();
            return true;
        } catch (org.firebirdsql.jdbc.FBSQLException ex) {
            String trace = ExceptionUtils.getStackTrace(ex);
            String metodo = String.valueOf(new Throwable().getStackTrace()[0]);
            Util.Log.setLog(trace, metodo);
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro interno do firebird, reinicie o sistema e tente novamente !");
            System.exit(0);
            return false;
        } catch (SQLException ex) {
            String trace = ExceptionUtils.getStackTrace(ex);
            String metodo = String.valueOf(new Throwable().getStackTrace()[0]);
            Util.Log.setLog(trace, metodo);
            ex.printStackTrace();
            return false;
        } catch (ParseException PE) {
            String trace = ExceptionUtils.getStackTrace(PE);
            String metodo = String.valueOf(new Throwable().getStackTrace()[0]);
            Util.Log.setLog(trace, metodo);
            PE.printStackTrace();
            return false;
        }

    }

    public boolean delete() {
        try {
            String SQLDELETE = "DELETE FROM SERVICOS WHERE COD_SERVICO=?";
            PreparedStatement pst = Connection.connectionFactory.getconnection().prepareStatement(SQLDELETE);
            pst.setInt(1, servico.getCodigo());
            pst.executeUpdate();
            return true;
        } catch (org.firebirdsql.jdbc.FBSQLException ex) {
            String trace = ExceptionUtils.getStackTrace(ex);
            String metodo = String.valueOf(new Throwable().getStackTrace()[0]);
            Util.Log.setLog(trace, metodo);
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro interno do firebird, reinicie o sistema e tente novamente !");
            System.exit(0);
            return false;
        } catch (SQLException ex) {
            String trace = ExceptionUtils.getStackTrace(ex);
            String metodo = String.valueOf(new Throwable().getStackTrace()[0]);
            Util.Log.setLog(trace, metodo);
            JOptionPane.showMessageDialog(null, "N??o foi possivel excluir este servi??o, pois ele foi utilizado numa movimenta????o !");
            ex.printStackTrace();
            return false;
        }

    }

}
