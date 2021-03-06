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
import model.Relatorio;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 *
 * @author faculdade
 */
public class RelatorioDAO {

    public RelatorioDAO(Relatorio relatorio) {
        relatorios = relatorio;
    }

    Relatorio relatorios;

    public List<Relatorio> selectRelatorios() throws SQLException {
        try {
            String SQLSELECT = "SELECT * FROM RELATORIOS r ORDER BY r.COD_RELATORIO,r.CATEGORIA";
            PreparedStatement pst = Connection.connectionFactory.getconnection().prepareStatement(SQLSELECT);
            ResultSet rs = pst.executeQuery();
            List<Relatorio> listRelatorios = new ArrayList<Relatorio>();
            while (rs.next()) {
                Relatorio relatorio = new Relatorio(rs.getInt("COD_RELATORIO"), rs.getString("DESCRICAO"), rs.getString("DIRETORIO"), rs.getString("CATEGORIA"));
                listRelatorios.add(relatorio);
            }
            return listRelatorios;
        } catch (org.firebirdsql.jdbc.FBSQLException ex) {
            String trace = ExceptionUtils.getStackTrace(ex);
            String metodo = String.valueOf(new Throwable().getStackTrace()[0]);
            Util.Log.setLog(trace, metodo);
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro interno do firebird, reinicie o sistema e tente novamente !");
            System.exit(0);
            return null;
        } catch (Exception ex) {
            String trace = ExceptionUtils.getStackTrace(ex);
            String metodo = String.valueOf(new Throwable().getStackTrace()[0]);
            Util.Log.setLog(trace, metodo);
            ex.printStackTrace();
            return null;
        }

    }

    public List<Relatorio> SelectTotalizadorMes() {
        try {
            String SQLSELECT = "SELECT  \n"
                    + "EXTRACT (MONTH FROM v.DT_VENDA) AS MES,\n"
                    + "EXTRACT (YEAR FROM v.DT_VENDA) AS ANO,\n"
                    + "count(CAST (v.DT_VENDA AS date )) AS ATENDIMENTOS,\n"
                    + "sum(v.vl_total_venda) AS TOTAL\n"
                    + "FROM \n"
                    + "vendas v";
            if (relatorios.getAno() != 0) {
                SQLSELECT = SQLSELECT + " WHERE EXTRACT (YEAR FROM v.DT_VENDA) BETWEEN '" + relatorios.getAno() + "' AND '" + relatorios.getAno() + "'";
            }
            SQLSELECT = SQLSELECT + " GROUP BY 1,2\n"
                    + "ORDER BY 2,1";

            PreparedStatement pst = Connection.connectionFactory.getconnection().prepareStatement(SQLSELECT);
            ResultSet rs = pst.executeQuery();
            List<Relatorio> listRelatorios = new ArrayList<Relatorio>();
            while (rs.next()) {
                String mes = Util.data.getMesExtenso(rs.getInt("MES"));
                Relatorio relatorio = new Relatorio(mes, rs.getInt("ANO"), rs.getInt("ATENDIMENTOS"), rs.getDouble("TOTAL"));
                listRelatorios.add(relatorio);
            }
            return listRelatorios;
        } catch (org.firebirdsql.jdbc.FBSQLException ex) {
            String trace = ExceptionUtils.getStackTrace(ex);
            String metodo = String.valueOf(new Throwable().getStackTrace()[0]);
            Util.Log.setLog(trace, metodo);
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro interno do firebird, reinicie o sistema e tente novamente !");
            System.exit(0);
            return null;
        } catch (Exception e) {
            String trace = ExceptionUtils.getStackTrace(e);
            String metodo = String.valueOf(new Throwable().getStackTrace()[0]);
            Util.Log.setLog(trace, metodo);
            e.printStackTrace();
            return null;
        }
    }

    public List<Relatorio> SelectComprovante(int ID) {
        try {
            String SQLSELECT = "SELECT iv.COD_SERVICO AS COD_SERVICO,s.DESCRICAO ,iv.QT_SERVICO_VENDIDO,"
                    + "iv.VL_UNITARIO_PRODUTO_VENDIDO FROM vendas v JOIN ITENS_VENDAS iv "
                    + "ON (v.COD_VENDA=iv.COD_VENDA) JOIN SERVICOS s ON (s.COD_SERVICO=iv.COD_SERVICO)"
                    + " WHERE v.COD_VENDA ='" + ID + "'";

            PreparedStatement pst = Connection.connectionFactory.getconnection().prepareStatement(SQLSELECT);
            ResultSet rs = pst.executeQuery();
            List<Relatorio> listRelatorios = new ArrayList<Relatorio>();
            while (rs.next()) {
                int qtde = rs.getInt("QT_SERVICO_VENDIDO");
                double valorUni = rs.getDouble("VL_UNITARIO_PRODUTO_VENDIDO");
                double subTotal = valorUni * qtde;
                Relatorio relatorio = new Relatorio(rs.getInt("COD_SERVICO"), qtde, valorUni, rs.getString("DESCRICAO"), subTotal);
                listRelatorios.add(relatorio);
            }
            return listRelatorios;
        } catch (org.firebirdsql.jdbc.FBSQLException ex) {
            String trace = ExceptionUtils.getStackTrace(ex);
            String metodo = String.valueOf(new Throwable().getStackTrace()[0]);
            Util.Log.setLog(trace, metodo);
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro interno do firebird, reinicie o sistema e tente novamente !");
            System.exit(0);
            return null;
        } catch (Exception e) {
            String trace = ExceptionUtils.getStackTrace(e);
            String metodo = String.valueOf(new Throwable().getStackTrace()[0]);
            Util.Log.setLog(trace, metodo);
            e.printStackTrace();
            return null;
        }
    }
}
