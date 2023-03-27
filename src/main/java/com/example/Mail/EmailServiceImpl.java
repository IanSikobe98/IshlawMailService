package com.example.Mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@Slf4j
@Service
public class EmailServiceImpl implements EmailService{

    @Override
    public void sendmail(UserData userData) throws AddressException, MessagingException, IOException {
        log.info("Data is:{}",userData);
        String UsernameMsg = "Hello "+ userData.getUsername() + " your account was successfully created.";
        String PasswordMsg = "Your password is:" +userData.getPassword();
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ApwokaIan@gmail.com", "Sikobe+faith");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("ApwokaIan@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userData.getEmailAddress()));
        msg.setSubject("Ishlaw Account Creation");
        msg.setContent("<h1>Ishlaw Account Creation</h1>"+
                "<p>"+UsernameMsg + "</p>" +
                "<p>"+PasswordMsg + "</p>"
                , "text/html");

        msg.setSentDate(new Date());

//        MimeBodyPart messageBodyPart = new MimeBodyPart();
//        messageBodyPart.setContent("Tutorials point email", "text/html");
//
//        Multipart multipart = new MimeMultipart();
//        multipart.addBodyPart(messageBodyPart);
//        MimeBodyPart attachPart = new MimeBodyPart();

//        attachPart.attachFile("C:/Users/Ianwa/Documents/ALCATEL STUFF ALL OF IT/WhatsApp Images/IMG-20161128-WA0001.jpg");
//        multipart.addBodyPart(attachPart);
//        msg.setContent(multipart);
        Transport.send(msg);
    }
}
