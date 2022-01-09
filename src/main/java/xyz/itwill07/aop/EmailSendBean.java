package xyz.itwill07.aop;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;

// ���� ���� ����� �����ϴ� Ŭ����
public class EmailSendBean {
	// ���� �����ϴ� JavaMailSender	��ü�� �����ϴ� �ʵ�
	private JavaMailSender mailSender;

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	// ������ �����ϴ� �޼ҵ� >> �ٽɰ��ɸ��
	//  => �޴� ��� �̸��� �ּ�, ����, ������ �Ű������� ���޹޾� ����
	//  => �޴� ��� �̸����� �ּҷ� ��ȯ >> �޼��� ���
	public String sendEmail(String email, String subject, String content) {
		// JavaMailSender.createMimeMessage() : MimeMessage ��ü�� ��ȯ�ϴ� �޼ҵ�
		// MimeMessage : ���� ���� ���� ������ �����ϱ� ���� ��ü
		MimeMessage message= mailSender.createMimeMessage();
		
		try {
			// MimeMessage.setSubject(String subject) : MimeMessage ��ü���� ���� ������ �����ϴ� �޼ҵ�
			message.setSubject(subject);
			
			// MimeMessage.setContent(String content) : MimeMessage ��ü���� ���� ����(�ؽ�Ʈ)�� �����ϴ� �޼ҵ�
			message.setText(content);
			
			// MimeMessage.setRecipients(RecipientType type, InternetAddress email)
			//  => MimeMessage ��ü�� ������ �޴� ����ڿ� ���� ������ �����ϴ� �޼ҵ�
			//  => �޴� ����� �̸��� �ּҴ� InternetAddress ��ü ��� ���ڿ�(String) ����
			// InternetAddress.parse(String email) : ���ڿ��� ���޹޾� InternetAddress ��ü��
			message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(email));
			
			// JavaMailSender.send(MimeMessage message) : JavaMailSender ��ü�� ������ �����ϴ� �޼ҵ�
			mailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return email;
	}
}
