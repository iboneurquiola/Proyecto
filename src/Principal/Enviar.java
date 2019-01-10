package Principal;
import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import marvin.image.MarvinImage;

public class Enviar 
{
	static void enviarConGMail(String user, String contraseña, String destinatario, String asunto, String cuerpo, File imageEnviar) {
	   
	    Properties emailProperties = new Properties();
	    emailProperties.put("mail.smtp.host", "smtp.gmail.com");
	    emailProperties.put("mail.smtp.auth", "true");
	    emailProperties.put("mail.smtp.port", "465");
	    emailProperties.put("mail.smtp.socketFactory.port", "465");
	    emailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    emailProperties.put("mail.debug", "true");
	    emailProperties.put("mail.smtp.user", user);
	    emailProperties.put("mail.smtp.clave", contraseña);    
	 
	    Session session = Session.getDefaultInstance(emailProperties);
	    MimeMessage message = new MimeMessage(session);
	    try {

	    BodyPart texto= new MimeBodyPart();
        texto.setText(cuerpo);
        BodyPart adjunto= new MimeBodyPart();
        adjunto.setDataHandler(new DataHandler(new FileDataSource(imageEnviar)));

        MimeMultipart m=new MimeMultipart();
        m.addBodyPart(texto);
        m.addBodyPart(adjunto);

        message.setFrom(new InternetAddress(user));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   //Se podrían añadir varios de la misma manera
        message.setSubject(asunto);
        message.setContent(m);

        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.gmail.com", user, contraseña);
        transport.sendMessage(message, message.getAllRecipients());

        transport.close();
    }
    catch (MessagingException me) {
        me.printStackTrace();   //Si se produce un error
    }
	}




}
