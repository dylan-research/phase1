package items;

import utils.IDGenerator;

public class Item {

	private String _id;
	private String _acctID;
	private String _name;
	private float _price;
	
	
	public Item( String acctID, String name ) {
		_id = IDGenerator.generate();
		_acctID = acctID;
		_name = name;
		_price = 0;
	}
	
	
	public String getID() {
		return _id;
	}
		
	public void setID( String id ) {
		_id = id;
	}
	
	
	public String getAcctID() {
		return _acctID;
	}
		
	public void setAcctID( String id ) {
		_acctID = id;
	}
	
	
	public String getName() {
		return _name;
	}
	
	public void setName( String name ) {
		_name = name;
	}
	
	
	public float getPrice() {
		return _price;
	}
	
	public void setPrice( float price ) {
		_price = price;
	}
}
