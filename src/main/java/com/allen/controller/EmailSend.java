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
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;


public class EmailSend {
    public static List<String> getEmailList() {
        return emailList;
    }

    private static List<String> emailList = new ArrayList<>();

    private static void loadEmailList() {
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

    // https://stackoverflow.com/questions/326390/how-do-i-create-a-java-string-from-the-contents-of-a-file
    private static String loadEmailContent(String path)
            throws IOException  {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, Charset.defaultCharset());
    }

    public static void send(String content){
        loadEmailList();
        try{
            String emailContentFilePath = "email content.txt";
            String host ="mail.sap.corp" ;
//            String user = "queuemanager.epm@gmail.com";
//            String pass = "vz3AWAvvV";
            String from = "allen.qian@sap.com";
            String subject = "Queue Manager Automatically Send.";
            String messageText = loadEmailContent(emailContentFilePath) + "\n\n" + content;
            boolean sessionDebug = false;

            Properties props = System.getProperties();

//            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "25");
//            props.put("mail.smtp.auth", "true");
//            props.put("mail.smtp.starttls.required", "true");

            //            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);

            // send multiple emails
            for (String emailAdress : emailList) {

                Message msg = new MimeMessage(mailSession);
                msg.setFrom(new InternetAddress(from));
                InternetAddress[] address = {new InternetAddress(emailAdress)};
                msg.setRecipients(Message.RecipientType.TO, address);
                msg.setSubject(subject);
                msg.setSentDate(new Date());
                msg.setText(messageText);

                //                transport = mailSession.getTransport("smtp");
//                transport.connect(host, user, pass);

//                transport.connect(host, user, pass);
                Transport.send(msg);


            }

            System.out.println("message send successfully");
        }catch(Exception ex)  {
            System.out.println(ex);
        }

    }
}

