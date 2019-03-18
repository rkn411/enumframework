package com.vsoft.automation.utilities;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

import com.vsoft.automation.config.ConfigProperties;

public class MailUtil

{
	public static Logger logger = Logger.getLogger(MailUtil.class);
	
	/**
	 * use this method to send mail using gmail settings
	 *
	 * @param mailSubject
	 * @param mailBody
	 * @param reportFilePath
	 */
	public static void confiureAndSendMail(String mailSubject, String mailBody, String reportFilePath)

	{
		String fromMail = ConfigProperties.REPORT_FROM_MAIL;
		String fromMailPassword = ConfigProperties.REPORT_FROM_MAIL_PASSWORD;

		String[] to = ConfigProperties.REPORT_TO_MAIL;
		String[] cc = ConfigProperties.REPORT_TO_CC_MAIL;
		String[] bcc = ConfigProperties.REPORT_TO_BCC_MAIL;

		MailUtil.sendMail(fromMail, fromMailPassword, "smtp.gmail.com", "465", "true", "true", true,
				"javax.net.ssl.SSLSocketFactory", "false", to, cc, bcc, mailSubject, mailBody, reportFilePath,
				new File(reportFilePath).getName());
	}

	/**
	 * use this method to send mail using necessary list of parameters like
	 * username,password,port,subject,body..etc
	 *
	 */
	public static boolean sendMail(String userName, String passWord, String host, String port, String starttls,
			String auth, boolean debug, String socketFactoryClass, String fallback, String[] to, String[] cc,
			String[] bcc, String subject, String text, String attachmentPath, String attachmentName) {

		// Object Instantiation of a properties file.
		Properties props = new Properties();

		props.put("mail.smtp.user", userName);

		props.put("mail.smtp.host", host);

		if (!"".equals(port)) {
			props.put("mail.smtp.port", port);
		}

		if (!"".equals(starttls)) {
			props.put("mail.smtp.starttls.enable", starttls);
			props.put("mail.smtp.auth", auth);
		}

		if (debug) {

			props.put("mail.smtp.debug", "true");

		} else {

			props.put("mail.smtp.debug", "false");

		}

		if (!"".equals(port)) {
			props.put("mail.smtp.socketFactory.port", port);
		}
		if (!"".equals(socketFactoryClass)) {
			props.put("mail.smtp.socketFactory.class", socketFactoryClass);
		}
		if (!"".equals(fallback)) {
			props.put("mail.smtp.socketFactory.fallback", fallback);
		}

		try {

			Session session = Session.getDefaultInstance(props, null);

			session.setDebug(debug);

			MimeMessage msg = new MimeMessage(session);

			msg.setText(text);

			msg.setSubject(subject);

			Multipart multipart = new MimeMultipart();
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(attachmentPath);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(attachmentName);
			multipart.addBodyPart(messageBodyPart);

			msg.setContent(multipart);
			msg.setFrom(new InternetAddress(userName));

			for (int i = 0; i < to.length; i++) {
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to[i]));
			}

			for (int i = 0; i < cc.length; i++) {
				msg.addRecipient(Message.RecipientType.CC, new InternetAddress(cc[i]));
			}

			for (int i = 0; i < bcc.length; i++) {
				msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc[i]));
			}

			msg.saveChanges();

			Transport transport = session.getTransport("smtp");

			transport.connect(host, userName, passWord);

			transport.sendMessage(msg, msg.getAllRecipients());

			transport.close();

			return true;

		} catch (Exception mex) {
			logger.info("Exception Details: " + ExceptionUtil.getExceptionStackTrace(mex));
			return false;
		}
	}
}