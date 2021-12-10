/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author Jonas Santos
 */
public class data {
    public static String getdata(){
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        
        return timeStamp;
    }
    
    public static Date formataData(String data) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        sdf.setLenient(false);
        
        return sdf.parse(data);
    }
    
    public static java.sql.Date getSqlDate(Date data) {
        return new java.sql.Date(data.getTime());
    }
    
    public static String formataDate(Date data){
        Date dataAtual = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = dateFormat.format(dataAtual);
        return dataFormatada;
    }    

   public static String formataDataBD(String data){
       try{
        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String result = out.format(in.parse(data.toString()));
        
        return result;
        
       }catch(Exception ex){
           return "";    
        }
   }
   
    public static String formataDataRelatorio(String data){
       try{
        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        String result = out.format(in.parse(data.toString()));
        
        return result;
        
       }catch(Exception ex){
           return "";    
        }
   }
   
    public static String formataDataFiltro(String data){
        try{
            SimpleDateFormat in = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
            String result = out.format(in.parse(data.toString()));

            return result;

       }catch(Exception ex){
           return "";    
        }
    
    }  
    
    public static String formataDataLog(String data){
        try{
            SimpleDateFormat in = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy HH");
            String result = out.format(in.parse(data.toString()));

            return result;

       }catch(Exception ex){
           return "";    
        }
    
    }  
    
    public static String getMesExtenso(int mes){
        switch (mes){
            case 1:
                return "JANEIRO";
            case 2:
                return "FEVEREIRO";
            case 3:
                return "MARÇO";
            case 4:
                return "ABRIL";
            case 5:
                return "MAIO";
            case 6:
                return "JUNHO";
            case 7:
                return "JULHO";
            case 8:
                return "AGOSTO";
            case 9:
                return "SETEMBRO";
            case 10:
                return "OUTUBRO";
            case 11: 
                return "NOVEMBRO";
            case 12: 
                return "DEZEMBRO";
        }
        return null;
                   
    }
    
}