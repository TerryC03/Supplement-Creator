

import java.util.Properties;
 





import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class SendEmail {
 
	public static double sendEmail(double cost) {
 
		final String username = "willynilly272@gmail.com";
		final String password = "122134tc";
 
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
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("willynilly271@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("willynilly271@gmail.com"));
			message.setSubject("Order Confirmation: 00000001");
			message.setText("Hello Terry Carney,\n\n "
					+ "This is your recommended Amino Acid Profile: \n"
					+ " We have calculated your total production cost of your"
					+ " desired supplement. The total cost is: " + "$" + Math.round(cost * 100.0)/100.0 + "."
					+ " Consultation is free. Consultation with a spokesperson via phone, skype or in-person is acceptable"
					+ " at your convenience two (2) weeks of receiving your quote. Bulk items (over 100) will receive a 40-percent"
					+ " discount! As always, we will ensure the quality of your desired product will meet your standards and"
					+ " future customers (which is of highest grade!)\n\n"
					
					+ "I look forward to our business relationship,\n"
					+ "Terry L Carney\n"
					+ "Terry's Labs, LLC");
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return cost;
	}
}
