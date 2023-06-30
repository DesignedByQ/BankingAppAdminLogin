package com.techprj.registration.admin.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	//Send from account details
	private static final String username="henryopara@gmail.com";
	private static final String password="gqas vncg rquo hvwh";
	
	public boolean sendEmail(String emailid, String twoFaCode) throws AddressException, MessagingException {
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() { 
						return new PasswordAuthentication(username, password);
					}
				});
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(username));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailid));
				
		message.setSubject("Two Factor Authenication code from our Service");
		message.setText("Your Two Factor Authenication code is: " + twoFaCode);
		
		Transport.send(message);
		
		return true;
		
	}

}
