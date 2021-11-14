/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.mail;

import java.util.logging.Level;
import java.util.logging.Logger;
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
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setStartTLSRequired(true);
        email.setStartTLSEnabled(true);
        email.setSSLOnConnect(true);
            
        email.setAuthenticator(new DefaultAuthenticator("suporteconatus@gmail.com", "Jonas@1000"));
        
        try{
            //Email que vai realiza o envio
            email.setFrom("suporteconatus@gmail.com");
            
            email.setSubject(assunto); //assunto do e-mail
            email.setMsg("Teste realizado para envio de relatorio pós venda");
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
}
