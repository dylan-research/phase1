package accounts;

import static org.junit.Assert.*;
import org.junit.Test;


public class AccountMgrTest {

	@Test
	public void testAddInvalid1() {
		int rCode = AccountMgr.addAcct( new Account( "" ) );
		assertEquals( rCode, -1 );
	}

	
	@Test
	public void testAddInvalid2() {
		int rCode = AccountMgr.addAcct( new Account( null ) );
		assertEquals( rCode, -1 );
	}

	
	@Test
	public void testAddInvalid3() {
		Account newAcct1 = new Account( "new1" );
		newAcct1.setName( "somebody" );
		newAcct1.setEmailAddr( "somebody@somewhere.com" );
		
		int rCode = AccountMgr.addAcct( newAcct1 );
		assertEquals( rCode, 0 );
		
		Account newAcct2 = new Account( "new2" );
		newAcct2.setName( newAcct1.getName() );
		newAcct2.setEmailAddr( newAcct1.getEmailAddr() );
		
		rCode = AccountMgr.addAcct( newAcct2 );
		assertEquals( rCode, 2 );
		
	}

	
	@Test
	public void testRemoveInvalid1() {
		int rCode = AccountMgr.removeAcct( "" );
		assertEquals( rCode, -1 );
	}
	
	@Test
	public void testRemoveInvalid2() {
		int rCode = AccountMgr.removeAcct( null );
		assertEquals( rCode, -1 );
	}
	

	@Test
	public void testAll() {
		Account newAcct = new Account( "id1" );
		newAcct.setName( "random" );
		newAcct.setEmailAddr( "someone@someplace.org" );
		
		int rCode = AccountMgr.addAcct( newAcct );
		assertEquals( rCode, 0 );
		
		rCode = AccountMgr.addAcct( newAcct );
		assertEquals( rCode, 1 );
		
		Account retrievedAcct = AccountMgr.getAcct( newAcct.getID() );
		assertSame( newAcct.getName(), retrievedAcct.getName() );
		
		rCode = AccountMgr.removeAcct( newAcct.getID() );
		assertEquals( rCode, 0 );
		
		rCode = AccountMgr.removeAcct( newAcct.getID() );
		assertEquals( rCode, 1 );
	}

	
}
