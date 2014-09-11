package utils;

import javax.mail.internet.InternetAddress;


public class EmailRecipient {

	public static final int TO = 10;
	public static final int CC = 20;
	public static final int BCC = 30;
	
	
	private int _type;
	private InternetAddress _emailAddr;
	

	public EmailRecipient( int type, InternetAddress emailAddr ) {
	
		_type = type;
		_emailAddr = emailAddr;
	}

	
	public int getType() {
		return _type;
	}
	
	
	public InternetAddress getEmailAddr() {
		return _emailAddr;
	}
	
	
}	

