package com.getterz.mail;

import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

@Service
public class GetterzMailService {

    static final String FROM = "kigael16@naver.com";
    static final String FROMNAME = "Getterz Verification";
    static final String SMTP_USERNAME = "kigael16@naver.com";
    static final String SMTP_PASSWORD = "kenem-1257-";
    static final String HOST = "smtp.naver.com";
    static final int PORT = 465;

    public void sendBuyerEmailVerification(String emailAddress, String verification) throws UnsupportedEncodingException, MessagingException {
        Properties props = System.getProperties();
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.trust", HOST);
        Session session = Session.getDefaultInstance(props);
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(FROM, FROMNAME));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(emailAddress));
        msg.setSubject("Getterz Buyer Email Verification");
        msg.setContent(String.join(
                System.getProperty("line.separator"),
                "<h1>Buyer Email Verification Link</h1>",
                "<a href=\"http://localhost/#/buyer/verify_email?token="+URLEncoder.encode(verification,StandardCharsets.UTF_8)+"\">Verification Link</a>."),
                "text/html;"
        );
        Transport transport = session.getTransport();
        try {
            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
            transport.sendMessage(msg, msg.getAllRecipients());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            transport.close();
        }
    }

    public void sendBuyerAdminMessage(String emailAddress, String message) throws UnsupportedEncodingException, MessagingException {
        Properties props = System.getProperties();
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.trust", HOST);
        Session session = Session.getDefaultInstance(props);
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(FROM, FROMNAME));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(emailAddress));
        msg.setSubject("Getterz Buyer Admin Message");
        msg.setContent(String.join(
                System.getProperty("line.separator"),
                "<h1>Buyer Admin Message</h1>",
                "<p>"+message+"</p>"),
                "text/html;"
        );
        Transport transport = session.getTransport();
        try {
            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
            transport.sendMessage(msg, msg.getAllRecipients());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            transport.close();
        }
    }

}