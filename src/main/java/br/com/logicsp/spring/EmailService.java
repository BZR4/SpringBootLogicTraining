package br.com.logicsp.spring;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public void enviar(String nome, String emailDestinatario){
        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("esdrasilva@gmail.com", "Locusamenus01"));
            email.setSSLOnConnect(true);

            email.setFrom("esdrasilva@gmail.com");
            email.setSubject("Você foi convidado pelo ListaVIP!");
            email.setMsg("Olá "+nome+"! Você acaba de ser convidado pela ListaVIP!");
            email.addTo(emailDestinatario);
            email.send();

        }catch (EmailException e){
            e.printStackTrace();
        }
    }
}
