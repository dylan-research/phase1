package utils;

import static org.junit.Assert.*;
import org.junit.Test;


public class PwdUtilTest {

	@Test
	public void testStrongInvalid1() {
		boolean rCode = PwdUtil.isStrong( null );
		assertEquals( rCode, false );
	}

	
	@Test
	public void testStrongInvalid2() {
		boolean rCode = PwdUtil.isStrong( "" );
		assertEquals( rCode, false );
	}

	
	@Test
	public void testStrongInvalid3() {
		boolean rCode = PwdUtil.isStrong( "goodPw1" );
		assertEquals( rCode, false );
	}

	
	@Test
	public void testStrongInvalid4() {
		boolean rCode = PwdUtil.isStrong( "goodPassword2" );
		assertEquals( rCode, false );
	}

	@Test
	public void testStrongInvalid5() {
		boolean rCode = PwdUtil.isStrong( "goodpwd2" );
		assertEquals( rCode, false );
	}

	@Test
	public void testStrongInvalid6() {
		boolean rCode = PwdUtil.isStrong( "goodPass" );
		assertEquals( rCode, false );
	}

	@Test
	public void testStrongValid() {
		boolean rCode = PwdUtil.isStrong( "good Pass2" );
		assertEquals( rCode, true );
	}

	@Test
	public void testGenerateInvalid1() {
		String pwd = PwdUtil.generatePwd( 7 );
		assertEquals( pwd, null );
	}

	@Test
	public void testGenerateInvalid2() {
		String pwd = PwdUtil.generatePwd( 13 );
		assertEquals( pwd, null );
	}

	@Test
	public void testGenerateValid() {
		int len = 8;
		
		String pwd = PwdUtil.generatePwd( len );
		assertEquals( pwd.length(), len );
		
		boolean rCode = PwdUtil.isStrong( pwd );
		assertEquals( rCode, true );
		
	}

}
