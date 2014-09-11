package utils;

import static org.junit.Assert.*;
import org.junit.Test;


public class EmailAddrUtilTest {

	@Test
	public void testInvalid1() {
		boolean rCode = EmailAddrUtil.isValidEmailAddr( "" );
		assertEquals( rCode, false );
	}

	
	@Test
	public void testInvalid2() {
		boolean rCode = EmailAddrUtil.isValidEmailAddr( null );
		assertEquals( rCode, false );
	}

	
	@Test
	public void testInvalid3() {
		boolean rCode = EmailAddrUtil.isValidEmailAddr( "test.com" );
		assertEquals( rCode, false );
	}

	
	@Test
	public void testInvalid4() {
		boolean rCode = EmailAddrUtil.isValidEmailAddr( "@test.com" );
		assertEquals( rCode, false );
	}

	@Test
	public void testInvalid5() {
		boolean rCode = EmailAddrUtil.isValidEmailAddr( "test@" );
		assertEquals( rCode, false );
	}

	@Test
	public void testInvalid6() {
		boolean rCode = EmailAddrUtil.isValidEmailAddr( ".test@test.com" );
		assertEquals( rCode, false );
	}

	@Test
	public void testInvalid7() {
		boolean rCode = EmailAddrUtil.isValidEmailAddr( "test@test." );
		assertEquals( rCode, false );
	}

	@Test
	public void testInvalid8() {
		boolean rCode = EmailAddrUtil.isValidEmailAddr( "test @test.com" );
		assertEquals( rCode, false );
	}

	@Test
	public void testInvalid9() {
		boolean rCode = EmailAddrUtil.isValidEmailAddr( "test@@test.com" );
		assertEquals( rCode, false );
	}

	@Test
	public void testInvalid10() {
		boolean rCode = EmailAddrUtil.isValidEmailAddr( "test@test..com" );
		assertEquals( rCode, false );
	}

	@Test
	public void testValid1() {
		boolean rCode = EmailAddrUtil.isValidEmailAddr( "test@test.com" );
		assertEquals( rCode, true );
	}

	@Test
	public void testValid2() {
		boolean rCode = EmailAddrUtil.isValidEmailAddr( "test123.user@test.com" );
		assertEquals( rCode, true );
	}

	@Test
	public void testValid3() {
		boolean rCode = EmailAddrUtil.isValidEmailAddr( "test_user123@qq456.com" );
		assertEquals( rCode, true );
	}

	@Test
	public void testValid4() {
		boolean rCode = EmailAddrUtil.isValidEmailAddr( "microsoft@google.org" );
		assertEquals( rCode, true );
	}

	@Test
	public void testValid5() {
		boolean rCode = EmailAddrUtil.isValidEmailAddr( "someone@cau.edu.cn" );
		assertEquals( rCode, true );
	}

	@Test
	public void testValid6() {
		boolean rCode = EmailAddrUtil.isValidEmailAddr( "1234567890@biz.info" );
		assertEquals( rCode, true );
	}

}
