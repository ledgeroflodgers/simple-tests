
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class SendEmailTLS {

    public static void main(String[] args) {

        final String username = "username@gmail.com";
        final String password = "password";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            String FROM_ADDRESS ="<no-reply@onland.ca>";
            //String cleanedFrom = new String(FROM_ADDRESS.getBytes("UTF-8"), "UTF-8");
            message.setFrom(new InternetAddress(FROM_ADDRESS,"OnLand\u00AE", "UTF-8"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("someemail@teranet.ca, someemail@yahoo.com")
            );
            message.setSubject("Testing Gmail TLS");
            message.setText("Dear Mail Crawler,"
                    + "\n\n Please do not spam my email!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}