package weichhart.georg.array;

import java.util.HashSet;
import java.util.Set;

public class StringProperties {

	public static void main(String[] args) {
		// last y is not unique
		String test = "qwertzuiopüasdfghjklöäyxcvbnm,.-1234567890ß´!§$%&/()=?`²QWERTZUIOPÜÄÖLKJHGFDSAYXCVBNM;:_";
		long start = System.nanoTime();
		boolean result = charsUniqueInString1(test);
		System.out.println("duration u1 " + (System.nanoTime()-start) + " r:" + result);
		
		start = System.nanoTime();
		result = charsUniqueInString2(test);
		System.out.println("duration u2 " + (System.nanoTime()-start) + " r:" + result);
		
		start = System.nanoTime();
		result = charsUniqueInString3(test);
		System.out.println("duration u3 " + (System.nanoTime()-start) + " r:" + result);

		String test2 = ",.-1234567890ß´!§$%&/()=?`²QWERTZUIOPÜÄÖLKJHGFDSAYXCVBNM;:_qwertzuiopüasdfghjklöäyxcvbnm";//m 
		start = System.nanoTime();
		result = isPermutation1(test,test2);
		System.out.println("duration p1 " + (System.nanoTime()-start) + " r:" + result);

		start = System.nanoTime();
		result = isPermutation2(test,test2);
		System.out.println("duration p2 " + (System.nanoTime()-start) + " r:" + result);

		start = System.nanoTime();
		result = isPermutation3(test,test2);
		System.out.println("duration p3 " + (System.nanoTime()-start) + " r:" + result);
	}
	
	/**
	 * brute force search is chars are in string more than once
	 * @param s
	 * @return
	 */
	public static boolean charsUniqueInString1(final String s) {
		for(int i = 0; i < s.length(); ++i) {
			for(int ii = i+1; ii < s.length(); ++ii) {
				if(s.charAt(i) == s.charAt(ii))
					return false;
			}
		}
		return true;
	}
	
	/**
	 * depends on the Set implementation, which allows only unique elements .add returns false if a char is already in there
	 * @param s
	 * @return
	 */
	public static boolean charsUniqueInString2(final String s) {
		Set<Character> v = new HashSet<Character>();
		for(int i = 0; i < s.length(); ++i) {
			if(!v.add(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	

	/**
	 * boolarray for every possible char 
	 * @param s
	 * @return
	 */
	public static boolean charsUniqueInString3(final String s) {
		// max length is the alphabet's nr of chars 65535 (FFFF) 
		boolean[] chars = new boolean[65535];
		
		for(int i = 0; i < s.length(); ++i) {
			int c = s.charAt(i);
			if(chars[c]) {
				return false;
			} else {
				chars[c] = true;
			}
		}
		return true;
	}
	
	
	/**
	 * create a stringbuilder of s1 & remove s2 chars one by one
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isPermutation1(String s1, String s2) {
		if(s1.length()!=s2.length())
			return false;
		
		StringBuilder strg1 = new StringBuilder(s1);
		for(int i = 0; i < s2.length(); ++i) {
			int pos = strg1.indexOf(String.valueOf(s2.charAt(i)));
			if(pos>=0)
				strg1 = strg1.deleteCharAt(pos);
			else
				return false;
		}
		if(strg1.length() == 0)
			return true;
		return false;
	}

	/**
	 * a boolean array is used to check the 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isPermutation2(String s1, String s2) {
		if(s1.length()!=s2.length())
			return false;
		
		boolean[] checkS2 = new boolean[s2.length()];
		
		for(int i=0;i<s1.length();++i) {
			char c = s1.charAt(i);
			boolean found = false;
			for(int ii = s2.indexOf(c); ii >= 0; ii = s2.indexOf(c,ii)) {
				if(!checkS2[ii]) {
					checkS2[ii] = true;
					found=true;
					break;
				}
			}
			if(!found)
				return false;
		}
		//checkS2 length == s1.length all in CheckS2 should be true
		//System.out.println(Arrays.toString(checkS2));
		return true;
	}
	
	/**
	 * use a int array to count all chars of s1 and then subtract 1 for every char in 2 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isPermutation3(String s1, String s2) {
		if(s1.length()!=s2.length())
			return false;
		// max length is the alphabet's nr of chars 65535 (FFFF) 
		int[] check = new int[65535];
		
		for(int i=0;i<s1.length();++i) {
			check[s1.charAt(i)]++;
		}
		
		for(int i=0;i<s2.length();++i) {
			int c = s2.charAt(i);
			check[c]--;
			if(check[c]<0)
				return false;
		}
		
		return true;
	}
}
