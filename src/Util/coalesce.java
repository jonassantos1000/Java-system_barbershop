/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author Jonas Santos
 */
public class coalesce {
    public static String coalesce(String campo){
        if (campo.equals("")){
            return campo=null;
        }else{
            return campo;
        }
    }
    
    public static String coalesceMascara(String campo){
        if (campo.equals("___.___.___-__")){
            return campo=null;
        }else if(campo.equals("__.___.___-_")){
            return campo=null;
        }
        else if(campo.equals("_____-___")){
            return campo=null;
        }
        else if(campo.equals("(__) ____-____")){
            return campo=null;
        }
        else if(campo.equals("(__) _____-____")){
            return campo=null;
        } else{
            return campo;
        }
    }
    
    public static String coalesceData(String campo){
        if (campo.equals("null")){
            return campo="";
        }
        else{
            return campo;
        }
    }
    
    
}
    