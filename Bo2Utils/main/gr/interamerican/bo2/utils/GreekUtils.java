package gr.interamerican.bo2.utils;

/**
 * Utilities for the Greek Language.
 */
public class GreekUtils {

	/**
	 * Converts an english uppercase character to its corresponding greek
	 * that looks exactly the same. <br/>
	 * 
	 * The method is used for the translation of all latin characters
	 * to their corresponding greek character in plate numbers.
	 * 
	 * Examples:  
	 * <li> input: A (english) return � (greek) </li>
	 * <li> input: S (english) return S (there is no corresponding greek letter) </li>
	 * 
	 * @param c english character
	 * 
	 * @return greek character
	 */
	private static char greek(char c) {
	  switch (c) {
	  	case 'A':return '�';
		case 'B':return '�';
	  	case 'E':return '�';
	  	case 'H':return '�';
	  	case 'I':return '�';
	  	case 'K':return '�';
	  	case 'M':return '�';
	  	case 'N':return '�';
	  	case 'O':return '�';
	  	case 'P':return '�';
	  	case 'T':return '�';
	  	case 'X':return '�';  		
	  	case 'Y':return '�';  		
	  	case 'Z':return '�';  			
	  	default: return c;
	  } 
	
	}

	/**
	 * Removes all characters that are not letters or digits, converts to 
	 * upper case and then replaces any latin character that has a similar 
	 * greek character with its greek similar (visually equal) character. <br/>
	 * 
	 * @param str
	 *        String to process.
	 * 
	 * @return Returns the result of the process.
	 */
	public static String removeSymbolsAndReplaceLatinWithSimilarGreekChars (String str) {
	   String result=StringUtils.removeAllButLettersAndDigits(str);
	   result = result.toUpperCase();
	   int l=result.length();
	   StringBuilder strb=new StringBuilder();
	   for (int i = 0; i < l; i++) {
		   char c=result.charAt(i);
		   if (c=='-'||c=='_'||c==' ' ) {
			   continue;    		   
		   } else if (!Character.isDigit(c)) {
			   strb.append(greek(c));
		   } else {
			   strb.append(result.charAt(i));
		   }
	   }
	   return strb.toString();
	}

}
