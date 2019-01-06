package com.hzj.bookshop.utlis;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class EmailUtils {
    /**
     * 发送邮件的工具类
     * @param sendEmail  接收人邮件地址
     * @param subject  邮件标题
     * @param body  邮件主体
     */
    public static void sendAccountActivateEmail(String sendEmail, String subject, String body) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.qq.com");
        //发送的邮箱
        props.put("mail.user", "1305696249@qq.com");
        //你开启pop3/smtp时的验证码
        props.put("mail.password", "bbfsoeibkkxabade");
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.starttls.enable", "true");
        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        String username = props.getProperty("mail.user");
        try {
            InternetAddress form = new InternetAddress(username);
            message.setFrom(form);
            InternetAddress to = new InternetAddress(sendEmail);
            message.setRecipient(Message.RecipientType.TO, to);
            // 设置邮件标题
            message.setSubject(subject);
            message.setSentDate(new Date());
            // 设置邮件的内容体
            message.setContent(body,"text/html;charset=utf-8");
            // 发送邮件
            Transport.send(message);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
