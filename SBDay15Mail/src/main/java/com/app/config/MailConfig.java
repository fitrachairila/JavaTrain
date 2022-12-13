package com.app.config;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.search.FlagTerm;
import javax.sound.midi.MidiMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.app.model.DTOMail;

@Component
public class MailConfig {

	@Autowired
	JavaMailSender javaMailSender;

	public void send(String to, String subject, String body) {

		// Dengan membuat Model
		SimpleMailMessage isipesan = new SimpleMailMessage();
		isipesan.setTo(to);
		isipesan.setSubject(subject);
		isipesan.setText(body);

		// kirim email by javamailsender
		javaMailSender.send(isipesan);
	}

	// Tanpa Harus Buat Model
	public void send2(DTOMail dm) {
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(dm.getTo());
			helper.setSubject(dm.getSubject());
			helper.setText(dm.getBody());
			
			FileSystemResource file = new FileSystemResource(dm.getAtch());
			helper.addAttachment(file.getFilename(), file);
			javaMailSender.send(message);
		}catch (MessagingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		}
		
	public void send3Multipart(String to, String subject, String ps,  MultipartFile[] attachment) {
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(ps);
			
			//FileSystemResource file = new FileSystemResource(dm.getAttachment());
			//Insert 1 File
			//helper.addAttachment(attach.getOriginalFilename(), attach);
			
			//Insert lebih dari 1 file
			for (int i = 0; i < attachment.length; i++) {
			helper.addAttachment(attachment[i].getOriginalFilename(), attachment[i]);
			}
			javaMailSender.send(message);
		}catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	public void readmail() {
		//Set Property
		Properties pr = new Properties();
		pr.put("mail.imap.host", "imap.gmail.com");
		pr.put("mail.imap.port", "993");
		pr.put("mail.imap.starttls.enable", "true");
		pr.put("mail.imap.ssl.trust", "imap.gmail.com");
		Session emailsession = Session.getDefaultInstance(pr);
		try {
		//konek imap server
		Store store = emailsession.getStore("imaps");
		store.connect("imap.gmail.com", "fitrachairila@gmail.com","nwxykanjhblorpgw");
		
		//Buat Object inbox
		Folder inbox = store.getFolder("inbox");
		inbox.open(Folder.READ_WRITE);
		
		//tarik pesan unread
		Message[]msg = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
		System.out.println("Jumlah Email Unread : " +msg.length);
		
		//Menambahkan informasi pengirim dan subject pengirim email
		for (int i=0; i < msg.length; i++) {
			System.out.println("Mail ke : " + (i+1));
			System.out.println("Dari : " + msg[i].getFrom()[0]);
			System.out.println("Dari : " + msg[i].getSubject());
			
			//Ambil konten isi email 
			//Untuk Konten bertipe multipart
			System.out.println("Tipe Konten : " + msg[i].getContentType());
			String msgContent="";
			String ctype = msg[i].getContentType();
			if(ctype.contains("multipart")) {
				System.out.println(1);
			}else if(ctype.contains("text/plain"))
			
			Multipart mtp = (Multipart) msg[i].getContent();
			int numMtp = mtp.getCount();
			for (int j=0; j < numMtp; j++) {
				MimeBodyPart part = (MimeBodyPart) mtp.getBodyPart(j);
				msgContent = part.getContentID().toString();
			}
			
			System.out.println("Isi Email : " + msgContent);
		}
		
		inbox.close();
		store.close();
		
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}