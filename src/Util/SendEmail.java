/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;


import javax.swing.JOptionPane;
import model.Configuracao;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

/**
 *
 * @author faculdade
 */
public class SendEmail {
    public static void send (String caminho, String  descArquivo, String nomeArquivo, String emailDestinatario,String assunto){
        //Configurações do e-mail
        Configuracao config = new Configuracao();
        config=config.pesquisar();
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName(config.getSmtp());
        email.setSmtpPort(Integer.parseInt(config.getPortaSMTP()));
        if (config.getTLS().equals("T")){
            email.setStartTLSRequired(true);
            email.setStartTLSEnabled(true);
        }else{
            email.setStartTLSRequired(false);
            email.setStartTLSEnabled(false);
        }
        
        if(config.getSSL().equals("T")){
            email.setSSLOnConnect(true);
        }else{
            email.setSSLOnConnect(false);
        }
          
        email.setAuthenticator(new DefaultAuthenticator(config.getEmail(), config.getSenha()));
        
        try{
            //Email que vai realiza o envio
            email.setFrom(config.getEmail());
            
            email.setSubject(assunto); //assunto do e-mail
            String msg;
            if (config.getMensagemPadrao()==null){
                msg = " ";
            }
            else{
                msg=config.getMensagemPadrao();
            }
            email.setMsg(msg);
            email.addTo(emailDestinatario); // e-mail do destinatario
            
            //anexar arquivo ao e-mail
            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath(caminho);
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setName(nomeArquivo);
            attachment.setDescription(descArquivo);
            
            email.attach(attachment);
            
            //enviar e-mail
            email.send();
        } catch (EmailException ex) {
            ex.printStackTrace();
        }
    }
    
        public static void testaEnvio (){
            //Configurações do e-mail
            Configuracao config = new Configuracao();
            config=config.pesquisar();
            MultiPartEmail email = new MultiPartEmail();
            email.setHostName(config.getSmtp());
            email.setSmtpPort(Integer.parseInt(config.getPortaSMTP()));
            if (config.getTLS().equals("T")){
                email.setStartTLSRequired(true);
                email.setStartTLSEnabled(true);
            }else{
                email.setStartTLSRequired(false);
                email.setStartTLSEnabled(false);
            }

            if(config.getSSL().equals("T")){
                email.setSSLOnConnect(true);
            }else{
                email.setSSLOnConnect(false);
            }

            email.setAuthenticator(new DefaultAuthenticator(config.getEmail(), config.getSenha()));

            try{
                //Email que vai realiza o envio
                email.setFrom(config.getEmail());
                email.setSubject("Teste de envio de e-mail"); //assunto do e-mail
                email.setMsg("Mensagem padrão: \n"+config.getMensagemPadrao());
                email.addTo(config.getEmail()); // e-mail do destinatario

                //enviar e-mail
                email.send();
                
                JOptionPane.showMessageDialog(null, "E-mail esta comunicando normalmente !");
            } catch (EmailException ex) {
                JOptionPane.showMessageDialog(null, "Verifique as configurações, o e-mail não esta comunicando com as configurações informadas");
                ex.printStackTrace();
            }
    }
    
}
