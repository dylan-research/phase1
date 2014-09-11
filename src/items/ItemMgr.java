package items;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class ItemMgr {

	// contains a map of all the items: String = id of item, Item = item
	private static Map< String, Item > _items;
	
	// contains a map of all the items for an account: String = id of account, Map = _items 
	private static Map< String, Map > _itemsByAcct;

	
	static {
		_items = new HashMap< String, Item >();
		_itemsByAcct = new HashMap< String, Map >();
	}
	
	
	// acctID: id of account
	// item: item
	public static int addItem( Item item ) {
		// add the item to _items
		// add the item for the correct account to _itemsByAcct
		
		// return -1: if item is null
		// return -1: if acctID of item is invalid ("" or null)
		// return 1: if the item has already been added
		
		if ( item == null )
			return -1;
		if ( item.getAcctID() == null )
			return -1;
		if ( item.getAcctID().equals("") )
			return -1;
		if( _items.containsKey( item.getID() ) )
			return 1;
		
		_items.put( item.getID(), item );
		_itemsByAcct.put( item.getAcctID(), _items );
		return 0;
		
		
	}
	
	
	// itemID: id of item
	public static int removeItem( String itemID ) {
		// return -1: if itemID is invalid ("" or null)
		// return 1: if the item cannot be found
		
		if ( itemID == null )
			return -1;
		if ( itemID.equals("") )
			return -1;
		if( !_items.containsKey(itemID) )
			return 1;
		
		_items.remove(itemID);
		return 0; // if the item was removed successfully
	}
	
	
	// itemID: id of item
	public static Item getItem( String itemID ) {
		if(! _items.containsKey(itemID) )
			return null;
		if ( itemID == null )
			return null;
		if ( itemID.equals("") )
			return null;
		
		return _items.get(itemID);
		
		
	}
	
	
}
