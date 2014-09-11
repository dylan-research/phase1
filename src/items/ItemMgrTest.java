package items;

import static org.junit.Assert.*;
import org.junit.Test;


public class ItemMgrTest {

	@Test
	public void testAddInvalid1() {
		int rCode = ItemMgr.addItem( null );
		assertEquals( rCode, -1 );
	}

	
	@Test
	public void testAddInvalid2() {
		int rCode = ItemMgr.addItem( new Item( "", "item1" ) );
		assertEquals( rCode, -1 );
	}

	
	@Test
	public void testAddInvalid3() {
		int rCode = ItemMgr.addItem( new Item( null, "item1" ) );
		assertEquals( rCode, -1 );
	}

	
	@Test
	public void testRemoveInvalid1() {
		int rCode = ItemMgr.removeItem( "" );
		assertEquals( rCode, -1 );
	}
	
	@Test
	public void testRemoveInvalid2() {
		int rCode = ItemMgr.removeItem( null );
		assertEquals( rCode, -1 );
	}
	

	@Test
	public void testAll() {
		Item newItem = new Item( "acct1", "bicyle" );
		
		int rCode = ItemMgr.addItem( newItem );
		assertEquals( rCode, 0 );
		
		rCode = ItemMgr.addItem( newItem );
		assertEquals( rCode, 1 );
		
		Item retrievedItem = ItemMgr.getItem( newItem.getID() );
		assertEquals( newItem.getName(), retrievedItem.getName() );
		
		rCode = ItemMgr.removeItem( newItem.getID() );
		assertEquals( rCode, 0 );
		
		rCode = ItemMgr.removeItem( newItem.getID() );
		assertEquals( rCode, 1 );
	}

	
}
