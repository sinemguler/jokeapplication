package com.joke.webservices.email;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.joke.webservices.configuration.JokeProperties;

import jakarta.annotation.PostConstruct;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    JavaMailSenderImpl mailSender;

   @Autowired
   JokeProperties jokeProperties;

   @Autowired
   MessageSource messageSource;

    @PostConstruct
    public void initialize() {
        this.mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.ethereal.email");
        mailSender.setPort(587);
        mailSender.setUsername("@ethereal.email");
        mailSender.setPassword("");

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.smtp.starttls.enable", "true");
    }

    String activationEmail = """
            <html>
                <body>
                    <h1>${title}</h1>
                    <a href="${url}">${clickHere}</a>
                </body>    
            </html>        
            """;

    public void sendActivationEmail(String email, String activationToken) {
        var activationUrl = jokeProperties.getClient().host() + "/activation/" + activationToken;
        var title = messageSource.getMessage("joke.mail.user.created.title", null, LocaleContextHolder.getLocale());
        var clickHere = messageSource.getMessage("joke.mail.click.here", null,LocaleContextHolder.getLocale());
        var mailBody = activationEmail.replace("${url}", activationUrl)
        .replace("${title}", title)
        .replace("${clickHere}", clickHere);
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
        try{
            message.setFrom(jokeProperties.getEmail().from());
            message.setTo(email);
            message.setSubject(title);
            message.setText(mailBody,true);
        }catch(MessagingException e){
            e.printStackTrace();
        }
       
        this.mailSender.send(mimeMessage);
    }
}
