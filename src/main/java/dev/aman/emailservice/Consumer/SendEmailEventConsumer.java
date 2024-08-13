package dev.aman.emailservice.Consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.aman.emailservice.DTOs.SendEmailEventDTO;
import dev.aman.emailservice.Utils.EmailUtil;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

@Service
public class SendEmailEventConsumer {

    private ObjectMapper objectMapper;

    public SendEmailEventConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    // Email will be sent only be one server.
    // This method will only be executed by one server not multiple servers.
    @KafkaListener(topics = "sendEmail", groupId = "emailService")
    public void handleSendEmailEvent(String message) throws JsonProcessingException {
        SendEmailEventDTO emailEventDTO = objectMapper.readValue(
                message, SendEmailEventDTO.class
        );

        String to = emailEventDTO.getTo();
        String from = emailEventDTO.getFrom();
        String subject = emailEventDTO.getSubject();
        String body = emailEventDTO.getBody();

        // Send an email.
        // Send Email in Java SMTP with TLS Authentication
        /*
        https://www.digitalocean.com/community/tutorials/javamail-example-send-mail-in-java-smtp
         */

        System.out.println("Email Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "eoggdbuxkztasmal"); // search gmail app password to create a temporary password from where you want to send the email
            }
        };
        Session session = Session.getInstance(props, auth);

        EmailUtil.sendEmail(session, to, subject, body);
    }
}
