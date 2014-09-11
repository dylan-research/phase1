package locations;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;


public class LocationTest {

	private static Location _loc1;
	
	@BeforeClass
	public static void oneTimeSetUp() {
		_loc1 = new Location( "CN", "China" );
    }
	
	
	@Test
	public void testAddInvalid1() {
		int rCode = _loc1.addSubLocation( null );
		assertEquals( rCode, -1 );
	}

	
	@Test
	public void testAddInvalid2() {
		Location loc2 = new Location( null, "Beijing" );
		int rCode = _loc1.addSubLocation( loc2 );
		assertEquals( rCode, -1 );
	}

	
	@Test
	public void testAddInvalid3() {
		Location loc2 = new Location( "", "Beijing" );
		int rCode = _loc1.addSubLocation( loc2 );
		assertEquals( rCode, -1 );
	}

	
	@Test
	public void testRemoveInvalid1() {
		int rCode = _loc1.removeSubLocation( null );
		assertEquals( rCode, -1 );
	}
	
	@Test
	public void testRemoveInvalid2() {
		int rCode = _loc1.removeSubLocation( "" );
		assertEquals( rCode, -1 );
	}
	

	@Test
	public void testAll() {
		Location loc2 = new Location( "CN-ZJ", "Zheijiang" );
		Location loc3 = new Location( "CN-AH", "Anhui" );
		Location loc4 = new Location( "CN-JS", "Jiangsu" );
		Location loc5 = new Location( "CN-GD", "Guangdong" );
		
		// valid addition
		int rCode = _loc1.addSubLocation( loc2 );
		assertEquals( rCode, 0 );
		
		// duplicate addition
		rCode = _loc1.addSubLocation( loc2 );
		assertEquals( rCode, 1 );
		
		// 2nd valid addition
		rCode = _loc1.addSubLocation( loc3 );
		assertEquals( rCode, 0 );
		
		// check number of sublocations
		Location[] subLocs = _loc1.getSubLocations();
		assertEquals( subLocs.length, 2 );
		
		// remove non-existant
		rCode = _loc1.removeSubLocation( loc4.getCode() );
		assertEquals( rCode, 1 );
		
		// valid removal
		rCode = _loc1.removeSubLocation( loc2.getCode() );
		assertEquals( rCode, 0 );
		
		// 2nd valid removal
		rCode = _loc1.removeSubLocation( loc3.getCode() );
		assertEquals( rCode, 0 );
		
		// number of sublocations should be zero
		subLocs = _loc1.getSubLocations();
		assertNull( subLocs );
		
		// add 4 sublocations
		rCode = _loc1.addSubLocation( loc2 );
		assertEquals( rCode, 0 );
		
		rCode = _loc1.addSubLocation( loc3 );
		assertEquals( rCode, 0 );
		
		rCode = _loc1.addSubLocation( loc4 );
		assertEquals( rCode, 0 );
		
		rCode = _loc1.addSubLocation( loc5 );
		assertEquals( rCode, 0 );
		
		// check number of sublocations
		subLocs = _loc1.getSubLocations();
		assertEquals( subLocs.length, 2 );
		
		// check order of sublocations
		assertEquals( subLocs[0].getCode(), "CN-AH" );
		assertEquals( subLocs[1].getCode(), "CN-GD" );
		assertEquals( subLocs[2].getCode(), "CN-JS" );
		assertEquals( subLocs[3].getCode(), "CN-ZJ" );
		
	}

	
}
