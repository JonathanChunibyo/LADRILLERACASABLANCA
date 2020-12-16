/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Jose
 */
public class correoEnviar {

    public static void enviarEmail(String linea, String dato, String tipo, String tipoDato) {
        final String username = "josepinedaa100@gmail.com";
        final String password = "1Celularnegro";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("josepinedaa100@gmail.com"));
            message.setSubject("Shin Impact");
            message.setText("Alerta en la Sección de " + tipo
                    + "\n\nLinea: " + linea + "\n" + tipoDato + ": " + dato);
            Transport.send(message);
            System.out.println("Correcto!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
