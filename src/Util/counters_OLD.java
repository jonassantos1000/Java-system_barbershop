/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.PrintWriter;
import java.io.FileWriter;
/**
 *
 * @author Jonas Santos
 */
public class counters_OLD {   
        public static String valorcounters(String campo){
            String path = "C:\\mtx\\Resources\\counters.dll";
            ArrayList lista = new ArrayList();
            String teste=null;
            try(BufferedReader br = new BufferedReader(new FileReader(path))){
                String line=null;
                
                while(line!=campo){
                    //System.out.println("line= "+line+" campo= "+campo);
                        line = br.readLine();
                        String[] vet = line.split("=");
                        line= vet[0];
                        String valor = vet[1];
                        if(line.equals(campo)){
                            teste=valor;
                            br.close();
                            break;
                        }
                        else{
                            line = br.readLine();
                            vet = line.split("=");
                            line= vet[0];
                            valor = vet[1];
                        
                    }
                                        
                }
                br.close();
                
                if(teste==null){
                    JOptionPane.showMessageDialog(null, "Codigo invalido, contate o suporte técnico");
                }

            }
            catch(IOException e){
               JOptionPane.showMessageDialog(null, "Codigo invalido aqui, contate o suporte técnico"); 
            
            }
        return teste;
        }
    
}
