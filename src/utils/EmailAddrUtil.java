 package utils;
 import java.util.regex.Matcher;
 import java.util.regex.Pattern;

public class EmailAddrUtil {

	/**
	 * emailAddr: email address
	 */
	public static boolean isValidEmailAddr( String emailAddr ) {
		/**
		 * return true: if email address is valid
		 * return false: if email address is not valid
		 */
		
		if(emailAddr==""||emailAddr==null)
			return false;
		else{
			
			/*
			starts with a letter, the name consists of letters or . or _ or numbers, 
			followed by a @, then letters and . and com
	 	    */
	 	    Pattern pattern = Pattern.compile("[a-zA-Z]+[a-zA-Z0-9_.]*@{1}[a-z0-9]+.com");
	 	    Matcher matcher = pattern.matcher(emailAddr);
	 	    return matcher.matches();
	 	}
	}
}

