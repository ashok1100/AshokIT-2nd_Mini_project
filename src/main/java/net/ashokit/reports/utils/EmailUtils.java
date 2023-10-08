package net.ashokit.reports.utils;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender mailSender;

	public boolean sendEmail(File file) {

		boolean status = false;

		try {
			MimeMessage msg = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg, true);
			helper.setTo("munagantiashokkumar@gmail.com");
			helper.setSubject("User record reports");
			helper.setText("<h3>Please download the User data</h3>", true);
			helper.addAttachment(file.getName(), file);
			mailSender.send(msg);
			status = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
