/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author Jonas Santos
 */
public class VerificaDecimal {
    public static String validaDecimal(String valor){
        int lenValor;
        String valorPosVirgula []= valor.split(",");
        lenValor=valorPosVirgula[1].length();
        if (lenValor==1){
            valor=valor+"0";
            return valor;
        }
        else{
            return valor;
        }
    }
    
    public static Number nf (String numero) throws ParseException{
        NumberFormat nf = new DecimalFormat("#,###.00");
        return nf.parse(numero);
    }
}
