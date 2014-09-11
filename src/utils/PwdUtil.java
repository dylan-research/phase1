package utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Random;

public class PwdUtil {

	public static int MIN_LENGTH = 8;
	public static int MAX_LENGTH = 12;
	
	public static char getRandomChar(){
		Random random=new Random();
		int r=random.nextInt(25)+65;
		return (char)r;
		  } 
		
	
	public static String genRandomNum(int len){
		int i;
		int count=0;
		char[] str={'0','1','2','3','4','5','6','7','8','9'};
		StringBuffer pwd=new StringBuffer("");
		Random r=new Random();
		while(count<len-1){
			i=Math.abs(r.nextInt(10));
			pwd.append(str[i]);
			count ++;
		}
		return pwd.toString();
	}
		
	
	/**
	 * pwd: password
	 */
	public static boolean isStrong( String pwd ) {
		/**
		 * return false: if pwd = null
		 * return false: if the length of pwd is not at least MIN_LENGTH
		 * return false: if the length of pwd is over MAX_LENGTH
		 * return true: if pwd has at least one uppercase case letter AND one number
		 */
		if(pwd==null)
			return false;
		else if(pwd.length()<MIN_LENGTH||pwd.length()>MAX_LENGTH)
			return false;
		//else if()
			//return false;
		else{
			
			//pwd has at least one uppercase case letter and one number, then it can contain letter from space to ~
			Pattern pattern = Pattern.compile("([ -~]*[A-Z]+[ -~]*[0-9]+[ -~]*)|([ -~]*[0-9]+[ -~]*[A-Z]+[ -~]*)");
	 	    Matcher matcher = pattern.matcher(pwd);
	 	    return matcher.matches();
		}
			
	}
	
	/**
	 * pwdLen: length of password to be generated (must be from MIN_LENGTH to MAX_LENGTH) 
	 */
	public static String generatePwd( int pwdLen ) {
		/**
		 * return null: if pwdLen < MIN_LENGTH
		 * return null: if pwdLen > MAX_LENGTH
		 * return a password with at least one uppercase letter and one number
		 */
		if(pwdLen<MIN_LENGTH||pwdLen>MAX_LENGTH)
			return null;
		else
			return getRandomChar()+genRandomNum(pwdLen);
	}
}
