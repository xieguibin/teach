package com.tt.teach.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.security.PrivateKey;

public class EmailUtil {
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String form;
    public void sendEmailPlus(String email, String title, String context, MultipartFile file) throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper= new MimeMessageHelper(mimeMessage,true);
        helper.setFrom(form);
        helper.setTo(email);
        helper.setText(context);
        helper.setSubject(title);
        String filename=file.getOriginalFilename();
        helper.addAttachment(filename,file);
        javaMailSender.send(mimeMessage);

    }
}
