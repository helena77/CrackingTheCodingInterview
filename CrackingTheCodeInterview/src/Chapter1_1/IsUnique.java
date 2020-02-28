package Chapter1_1;

import java.util.Arrays;
import java.util.HashSet;

/* The points of this questions；
 * 1. should ask the interviewer if the string is an ASCII or a Unicode string
 * 2. make an assumption, if it is an ASCII, check if it exceeds 128 characters
 *   or if the case in extended ASCII(256 characters)
 */
public class IsUnique {

	public static void main(String[] args) {
		String s1 = "Apple";
		String s2 = "peach";
		
		System.out.println(checkUniqueBF(s1));
		System.out.println(checkUniqueBF(s2));
		System.out.println(checkUniqueHS(s1));
		System.out.println(checkUniqueHS(s2));
		System.out.println(checkUniqueSort(s1));
		System.out.println(checkUniqueSort(s2));
	}
	
	/* Brute Force 
	* Time efficiency: O(n^2)
	* Space complexity: O(1)
	*/
	public static boolean checkUniqueBF(String s) {
		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j))
					return false;
			}
		}
		return true;
	}
	
	/* Hashset 
	* Time complexity: O(n)
	* Space complexity: O(1)
	*/
	public static boolean checkUniqueHS(String s) {
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			set.add(s.charAt(i));
		}
		if (set.size() != s.length())
			return false;
		return true;
	}
	
	/* implement the algo 
	* time efficiency: O(nlogn)
	* Space complexity: extra space (depend on the sort algo)
	*/
	public static boolean checkUniqueSort(String s) {
		// convert input string to char array
		char tempArr[] = s.toCharArray();
		//sort tempArr
		Arrays.sort(tempArr);
		//check duplicates
		for (int i = 0; i < s.length() - 1; i++) {
			if (tempArr[i] == tempArr[i + 1])
				return false;
		}
		return true;
	}
}

