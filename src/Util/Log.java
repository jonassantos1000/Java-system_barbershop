/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 *
 * @author faculdade
 */
public class Log {

    public static void setLog(String trace, String metodo) {

        try {
            if (Files.isWritable(new File("C:\\Program Files (x86)\\Conatus\\trace\\").toPath())) {
                String horario = data.formataDataLog(data.getdata()).replace("/", "-");
                String horarioCompleto = data.getdata();
                FileWriter log = new FileWriter("C:\\Program Files (x86)\\Conatus\\trace\\ConatusLog " + horario + ".log", true);
                PrintWriter gravaTexto = new PrintWriter(log);

                gravaTexto.printf("\n" + horarioCompleto + " Método: " + metodo + " \n\n");

                gravaTexto.printf(trace);

                gravaTexto.printf("\n Fim_Chamada_" + metodo + ": \n");
                gravaTexto.printf("\n               **************************************************************************\n\n");
                log.close();
            } else {
                JOptionPane.showMessageDialog(null, "Acesso negado ao ler ou gravar log's, para evitar o mau funcionamento do sistema é necessario liberar permissao para o diretorio abaixo:\n  C:\\Program Files (x86)\\Conatus");
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo de Log não encontrado");
            System.exit(0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Acesso negado ao ler ou gravar log's, para evitar o mau funcionamento do sistema é necessario liberar permissao para o diretorio abaixo:\n  C:\\Program Files (x86)\\Conatus");
        }
    }
}
