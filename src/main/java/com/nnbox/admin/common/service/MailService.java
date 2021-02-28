package com.nnbox.admin.common.service;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nnbox.admin.common.utils.Messages;

@Service
public class MailService {
	@Autowired
	Messages messages;
//	@Value("${mail.signUpPath}")
	private String signUpPath;
//	@Value("${mail.findPasswordPath}")
	private String findPasswordPath;
	
	@Value("${mail.host}")
	private String host;
	@Value("${mail.senderemail}")
	private String senderEmail;
	@Value("${mail.auth.user}")
	private String authUser;
	@Value("${mail.auth.password}")
	private String authPassword;

	private boolean send(String receiver, String subject, String contents) throws Exception {
		try {

			String senderName = messages.get("application.name");
			
			Properties props = new Properties();

			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.ssl.trust", host);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.connectiontimeout", 10 * 1000);

			Session session = Session.getInstance(props, new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(authUser, authPassword);
				}
			});
			
			Multipart mp = new MimeMultipart();
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(senderEmail, senderName, "UTF-8"));
			InternetAddress[] toAddress = InternetAddress.parse(receiver);
			msg.setRecipients(Message.RecipientType.TO, toAddress);
			msg.setSubject(subject, "UTF-8");
			msg.setText(senderName, "UTF-8");
			msg.setContent(contents, "text/html; charset=UTF-8");
			msg.setSentDate(new Date());
			Transport.send(msg);
			
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean sendSignUpEmail(String email, String token) throws Exception {
		String url = signUpPath + token;
		
		String subject = messages.get("application.name") + "회원가입 메일 인증";
		
		String contentHead = "안녕하세요 <br/>" + messages.get("application.name") + "에 오신 것을 환영합니다. ";
		String contentNote = "아래 본인 확인하기 버튼을 클릭하시면 회원가입 인증이 완료됩니다. <br/>버튼 클릭 후 " + messages.get("application.name")
				+ "에 로그인을 해 주세요.";
		String contentButton = "본인 확인하기";
		String contentBottom = "본 메일은 발신전용 입니다. <br/>궁금하신 점은 고객센터로 문의해 주세요.<br/><br/>Copyrightⓒ2020 "
				+ messages.get("application.name") + " All rights reserved.";

		String contents = "<meta charset=\"utf-8\">\r\n" + "<div style=\"width: 685px\">\r\n"
				+ "	<div style=\"padding: 30px\">\r\n"
				+ "		<div style=\"font-size: 28px;letter-spacing: -1px;color: rgb(10,20,29);font-family: Nanum Gothic, Dotum;font-weight: bold;text-align: center;padding: 20px;\">\r\n"
				+ "			" + subject + "\r\n" + "		</div>\r\n"
				+ "		<div style=\"height: 1px; background-color: #e0e0e0;\"></div>\r\n"
				+ "		<div style=\"font-size: 16px;letter-spacing: -1px;color: rgb(87,87,87);line-height: 24px;font-family: Nanum Gothic, Dotum;font-weight: bold; padding-top: 20px;\">\r\n"
				+ contentHead + "		</div>\r\n"
				+ "		<div style=\"font-size: 13px;letter-spacing: -1px;line-height: 18px;color: #4990e2;font-family: Nanum Gothic, Dotum;padding-top: 30px;padding-bottom: 15px\">\r\n"
				+ contentNote + "		</div>\r\n"
				+ "		<div style=\"height: 1px; background-color: #e0e0e0;\"></div>\r\n"
				+ "		<div style=\"padding: 25px; text-align: center;\">\r\n" + "			<a href='" + url
				+ "' style='border-radius: 3px;display: inline-block;font-size: 18px;letter-spacing: -1px; font-weight: bold;line-: 24px;padding: 15px 70px;text-align: center;text-decoration: none !important;transition: opacity 0.1s ease-in;color:#fff; !important;background-color: #4990e2;font-family: sans-serif;' target='_blank' rel='noreferrer noopener'>\r\n"
				+ contentButton + "			</a>\r\n" + "		</div>\r\n" + "		\r\n"
				+ "		<div style=\"height: 1px; background-color: #e0e0e0;\"></div>\r\n" + "		\r\n"
				+ "	</div>\r\n"
				+ "	<div style=\"padding:30px; background-color: #e7e9ea;font-size: 13px;letter-spacing: -1px;color: rgb(87,87,87);font-family: Nanum Gothic, Dotum;\">\r\n"
				+ contentBottom + "	</div>\r\n" + "</div>\r\n";

		
		return send(email, subject, contents);
	}

	public boolean sendPasswordModify(String email, String token) throws Exception {
		String url = findPasswordPath + token;
		
		String subject = messages.get("application.name") + " 비밀번호 변경";
		
		String contentHead = "안녕하세요 <br/>" + messages.get("application.name") + "에 오신 것을 환영합니다. ";
		String contentNote = "아래 링크를 클릭하여 비밀번호를 변경하실 수 있습니다.";
		String contentButton = "비밀번호 변경하기";
		String contentBottom = "본 메일은 발신전용 입니다. <br/>궁금하신 점은 고객센터로 문의해 주세요.<br/><br/>Copyrightⓒ2020 "
				+ messages.get("application.name") + " All rights reserved.";

		String contents = "<meta charset=\"utf-8\">\r\n" + "<div style=\"width: 685px\">\r\n"
				+ "	<div style=\"padding: 30px\">\r\n"
				+ "		<div style=\"font-size: 28px;letter-spacing: -1px;color: rgb(10,20,29);font-family: Nanum Gothic, Dotum;font-weight: bold;text-align: center;padding: 20px;\">\r\n"
				+ "			" + subject + "\r\n" + "		</div>\r\n"
				+ "		<div style=\"height: 1px; background-color: #e0e0e0;\"></div>\r\n"
				+ "		<div style=\"font-size: 16px;letter-spacing: -1px;color: rgb(87,87,87);line-height: 24px;font-family: Nanum Gothic, Dotum;font-weight: bold; padding-top: 20px;\">\r\n"
				+ contentHead + "		</div>\r\n"
				+ "		<div style=\"font-size: 13px;letter-spacing: -1px;line-height: 18px;color: #4990e2;font-family: Nanum Gothic, Dotum;padding-top: 30px;padding-bottom: 15px\">\r\n"
				+ contentNote + "		</div>\r\n"
				+ "		<div style=\"height: 1px; background-color: #e0e0e0;\"></div>\r\n"
				+ "		<div style=\"padding: 25px; text-align: center;\">\r\n" + "			<a href='" + url
				+ "' style='border-radius: 3px;display: inline-block;font-size: 18px;letter-spacing: -1px; font-weight: bold;line-: 24px;padding: 15px 70px;text-align: center;text-decoration: none !important;transition: opacity 0.1s ease-in;color:#fff; !important;background-color: #4990e2;font-family: sans-serif;' target='_blank' rel='noreferrer noopener'>\r\n"
				+ contentButton + "			</a>\r\n" + "		</div>\r\n" + "		\r\n"
				+ "		<div style=\"height: 1px; background-color: #e0e0e0;\"></div>\r\n" + "		\r\n"
				+ "	</div>\r\n"
				+ "	<div style=\"padding:30px; background-color: #e7e9ea;font-size: 13px;letter-spacing: -1px;color: rgb(87,87,87);font-family: Nanum Gothic, Dotum;\">\r\n"
				+ contentBottom + "	</div>\r\n" + "</div>\r\n";

		
		return send(email, subject, contents);
	}
}
