/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Usuarios;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 *
 * @author jonas
 */
public class UsuarioDAO {

    Usuarios usuario;

    public UsuarioDAO(Usuarios usuario) {
        this.usuario = usuario;
    }

    public boolean insert() {
        try {
            String SQLINCLUIR = "INSERT INTO USUARIOS (USUARIO,SENHA,GERENCIA) VALUES (?,?,?)";
            PreparedStatement pst = Connection.connectionFactory.getconnection().prepareStatement(SQLINCLUIR);
            pst.setString(1, usuario.getUsuario());
            pst.setString(2, usuario.getSenha());
            pst.setString(3, usuario.getGerencia());
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
        } catch (Exception e) {
            String trace = ExceptionUtils.getStackTrace(e);
            String metodo = String.valueOf(new Throwable().getStackTrace()[0]);
            Util.Log.setLog(trace, metodo);
            e.printStackTrace();
            return false;
        }
    }

    public Usuarios selectUsuario() {
        try {
            String CONSULTACADASTRO;
            CONSULTACADASTRO = "SELECT * FROM USUARIOS WHERE USUARIO='" + usuario.getUsuario() + "'";
            PreparedStatement pst = Connection.connectionFactory.getconnection().prepareStatement(CONSULTACADASTRO);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Usuarios selectUsuario = new Usuarios(rs.getString("USUARIO"), rs.getString("SENHA"), rs.getString("GERENCIA"));
                return selectUsuario;
            }
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
            JOptionPane.showMessageDialog(null, ex);
            return null;
        }
        return null;
    }
}
