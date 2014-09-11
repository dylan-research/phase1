package signin;

import static org.junit.Assert.*;
import org.junit.Test;


public class LoginMgrTest {

	
	@Test
	public void testAddInvalid1() {
		int rCode = LoginMgr.addLogin( new Login( "", "pwd1" ) );
		assertEquals( rCode, -1 );
	}

	
	@Test
	public void testAddInvalid2() {
		int rCode = LoginMgr.addLogin( new Login( "id1", "" ) );
		assertEquals( rCode, -1 );
	}

	
	@Test
	public void testAddInvalid3() {
		int rCode = LoginMgr.addLogin( new Login( null, "pwd1" ) );
		assertEquals( rCode, -1 );
	}

	
	@Test
	public void testAddInvalid4() {
		int rCode = LoginMgr.addLogin( new Login( "id1", null ) );
		assertEquals( rCode, -1 );
	}

	
	@Test
	public void testRemoveInvalid1() {
		int rCode = LoginMgr.removeLogin( "" );
		assertEquals( rCode, -1 );
	}

	
	@Test
	public void testRemoveInvalid2() {
		int rCode = LoginMgr.removeLogin( null );
		assertEquals( rCode, -1 );
	}

	
	@Test
	public void testCheckInvalid1() {
		boolean rCode = LoginMgr.checkLogin( new Login( "", "pwd1" ) );
		assertEquals( rCode, false );
	}

	
	@Test
	public void testCheckInvalid2() {
		boolean rCode = LoginMgr.checkLogin( new Login( "id1", "" ) );
		assertEquals( rCode, false );
	}

	
	@Test
	public void testCheckInvalid3() {
		boolean rCode = LoginMgr.checkLogin( new Login( null, "pwd1" ) );
		assertEquals( rCode, false );
	}

	
	@Test
	public void testCheckInvalid4() {
		boolean rCode = LoginMgr.checkLogin( new Login( "id1", null ) );
		assertEquals( rCode, false );
	}

	
	@Test
	public void testAll() {
		Login login1 = new Login( "id1", "pwd1" );
		Login login2 = new Login( "id2", "pwd2" );
		
		int rCode = LoginMgr.addLogin( login1 );
		assertEquals( rCode, 0 );
		
		rCode = LoginMgr.addLogin( login1 );
		assertEquals( rCode, 1 );
		
		boolean rCode2 = LoginMgr.checkLogin( login1 );
		assertEquals( rCode2, true );
		
		rCode2 = LoginMgr.checkLogin( login2 );
		assertEquals( rCode2, false );
		
		rCode = LoginMgr.removeLogin( login1.getID() );
		assertEquals( rCode, 0 );
		
		rCode = LoginMgr.removeLogin( login1.getID() );
		assertEquals( rCode, 1 );
	}
	
}
