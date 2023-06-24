package com.example.Mail;



import java.io.UnsupportedEncodingException;

public interface MailService {

    EmailAlert constructEmailObj(UserData userData);
    void sendMail(String to, String subject, String text) throws Exception;
    void sendEmail(EmailAlert order) throws UnsupportedEncodingException;
}
