package utils;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import javax.mail.internet.*;


public class TextFileLoaderTest {

	
	@Test
	public void testLoadInvalid1() {
		try {
			String[] rCode = TextFileLoader.load( "" );
			assertNull( rCode );
		} catch ( Exception e ) {
			fail();
		}
	}

	
	@Test
	public void testLoadInvalid2() {
		try {
			String[] rCode = TextFileLoader.load( null );
			assertNull( rCode );
		} catch ( Exception e ) {
			fail();
		}
	}

	
	@Test
	public void testLoadInvalid3() {
		try {
			String[] rCode = TextFileLoader.load( "fakefile.txt" );
			fail();
		} catch ( IOException e ) {
			// expected: the file should not exist
		}
	}

	
	@Test
	public void testLoadValid() {
		// make sure that there is a file called "test-data.txt"
		try {
			String[] lines = TextFileLoader.load( "test-data.txt" );
			assertEquals( lines.length, 8 );
			
			assertSame( lines[7], "no more lines" );
		} catch ( Exception e ) {
			fail();
		}
	}

	
}
