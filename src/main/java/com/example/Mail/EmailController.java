package com.example.Mail;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
public class EmailController {

   private final MailService mailService;

    public EmailController( MailService mailService) {
        this.mailService = mailService;
    }


    @RequestMapping(method = RequestMethod.POST ,value = "/sendemail")
    public ResponseEntity<ResponseWrapper> sendEmail(@RequestBody UserData userData) throws MessagingException, IOException {
        ResponseWrapper response = new ResponseWrapper();
        EmailAlert emailAlert = new EmailAlert();
        emailAlert =mailService.constructEmailObj(userData);
        mailService.sendEmail(emailAlert);


        response.setData("Email Sent successfully");
        response.setCode(200);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
}

