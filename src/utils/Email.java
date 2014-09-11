package utils;

import java.util.Date;
import java.util.ArrayList;
import javax.mail.internet.InternetAddress;


public class Email {

	public static final String KIND = "Email";
	public static final String KINDS = "Emails";
	
	public static final String SENDER = "sender";
	public static final String DATE_SENT = "dateSent";
	public static final String SUBJECT = "subject";
	public static final String BODY = "body";

	
	private InternetAddress _sender;
	private ArrayList<EmailRecipient> _recipients;
	private Date _dateSent;
	private String _subj;
	private String _body;
	

	public Email( InternetAddress sender, String subj, String body ) {
	
		_sender = sender;
		_recipients = new ArrayList();
		_subj = subj;
		_body = body;
		_dateSent = new Date();
	}

	
	public InternetAddress getSender() {
		return _sender;
	}
	
	public void addRecipient( EmailRecipient recipient ) {
		_recipients.add( recipient );
	}
	
	public ArrayList<EmailRecipient> getRecipients() {
		return _recipients;
	}
	
	public String getSubject() {
		return _subj;
	}
	
	
	public String getBody() {
		return _body;
	}
	
	
	public Date getDateSent() {
		return _dateSent;
	}
	
	
}	

