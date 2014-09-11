package utils;

import static org.junit.Assert.*;
import org.junit.Test;
import javax.mail.internet.*;

public class EmailSvcTest {

	
	@Test
	public void testSendInvalidEmail() {
		int rCode = EmailSvc.send( null );
		assertEquals( rCode, -1 );
	}

	
	@Test
	public void testSendInvalidEmail2() {
		// invalid because there is not a recipient
		try {
			Email email = new Email( new InternetAddress( "from@somewhere.org"), "test Subject", "message" );
			
			int rCode = EmailSvc.send( email );
			assertEquals( rCode, -1 );
		} catch ( Exception e ) {
		}
	}

	
	@Test
	public void testSendSuccessfully() {
		// need to check that an email was sent to the recipient's email address
		try {
			InternetAddress fromAddr = new InternetAddress( "from@somewhere.org" );
			InternetAddress toAddr = new InternetAddress( "to@somewhere.org" );
			
			Email email = new Email( fromAddr, "test Subject", "message" );
			EmailRecipient recip = new EmailRecipient( EmailRecipient.TO, toAddr );
			email.addRecipient( recip );
			
			int rCode = EmailSvc.send( email );
			assertEquals( rCode, 0 );
			
		} catch ( Exception e ) {			
		}
	}

	
}
