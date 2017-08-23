package com.allen.controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * https://www.google.com/settings/security/lesssecureapps
 */


/**
 * https://www.youtube.com/watch?v=UMfjndwGwnM
 * @author Naveen
 * @anthor Allen Qian
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;


public class EmailSend {
    public static List<String> getEmailList() {
        return emailList;
    }

    private static List<String> emailList = new ArrayList<>();

    private static void assignEmailList() {
        File file = new File("email list.txt");
        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                emailList.add(sc.next());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(emailList);
    }

    public static void send(String content){
        assignEmailList();
        try{
            String host ="smtp.gmail.com" ;
            String user = "queuemanager.epm@gmail.com";
            String pass = "vz3AWAvvV";
            String to = "qianyiluntemp@gmail.com";
            String from = "queuemanager.epm@gmail.com";
            String subject = "Queue Manager Automatically Send.";
            String messageText = content;
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Transport transport = null;

            // send multiple emails
            for (String emailAdress : emailList) {

                Message msg = new MimeMessage(mailSession);
                msg.setFrom(new InternetAddress(from));
                InternetAddress[] address = {new InternetAddress(emailAdress)};
                msg.setRecipients(Message.RecipientType.TO, address);
                msg.setSubject(subject);
                msg.setSentDate(new Date());
                msg.setText(messageText);

                transport = mailSession.getTransport("smtp");
                transport.connect(host, user, pass);
                transport.sendMessage(msg, msg.getAllRecipients());

            }

            transport.close();
            System.out.println("message send successfully");
        }catch(Exception ex)
        {
            System.out.println(ex);
        }

    }
}

