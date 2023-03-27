package com.example.Mail;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
public class EmailController {

//    @Autowired
   private final EmailService emailservice;

    public EmailController(EmailService emailservice) {
        this.emailservice = emailservice;
    }

    @RequestMapping(method = RequestMethod.POST ,value = "/sendemail")
    public ResponseEntity<ResponseWrapper> sendEmail(@RequestBody UserData userData) throws MessagingException, IOException {
        ResponseWrapper response = new ResponseWrapper();
//UserData  userData = new UserData();
        emailservice.sendmail(userData);

        response.setData("Email Sent successfully");
        response.setCode(200);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
}

