package Chapter1_2;

/* The points of this questions；
 * 1. should ask the interviewer about case sensitive such as is God a permutation of dog, furthermore, is whitespace significant?
 * 2. make an assumption, it is case sensitive and white space is significant, so "god      " is different from "dog"
 */
public class Permutation {
	final static int NUM = 256;
	public static void main(String[] args) {
		String s1 = "abcdefgh";
		String s2 = "acdeghfb";
		String s3 = "abcde";
		
		System.out.println(checkPermutation(s1, s2));
		System.out.println(checkPermutation(s1, s3));
		System.out.println(checkPermutation(s2, s3));
	}
	
	public static boolean checkPermutation(String s1, String s2) {
		int[] arr1 = new int[NUM];
		int[] arr2 = new int[NUM];
		computeLetters(s1, arr1);
		computeLetters(s2, arr2);
		
		for (int i = 0; i < NUM; i++) {
			if (arr1[i] != arr2[i])
				return false;
		}
		return true;
	}
	
	private static void computeLetters(String s, int[] a) {
		for (int i = 0; i < s.length(); i++) {
			int index = (int)s.charAt(i);
			a[index]++;
		}
	}

}