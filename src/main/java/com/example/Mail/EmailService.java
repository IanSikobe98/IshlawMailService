package com.example.Mail;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;

public interface EmailService {

    void sendmail(UserData userData) throws  MessagingException, IOException;
}
