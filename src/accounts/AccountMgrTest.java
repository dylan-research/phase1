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
		
		int rCode = AccountMgr.addAcct( newAcct );
		assertEquals( rCode, 0 );
		
		rCode = AccountMgr.addAcct( newAcct );
		assertEquals( rCode, 1 );
		
		Account retrievedAcct = AccountMgr.getAcct( newAcct.getID() );
		assertEquals( newAcct.getID(), retrievedAcct.getID() );
		
		rCode = AccountMgr.removeAcct( newAcct.getID() );
		assertEquals( rCode, 0 );
		
		rCode = AccountMgr.removeAcct( newAcct.getID() );
		assertEquals( rCode, 1 );
	}

	
}
