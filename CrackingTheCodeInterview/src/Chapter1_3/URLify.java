package Chapter1_3;

public class URLify {

	public static void main(String[] args) {
		String s = "My lover is A   ";
		int n = 13;
		String s2 = "Mr John Smith        ";
		
		char[] arr = s2.toCharArray();
		// Use self algo
		System.out.println("\"" + String.valueOf(URLify(arr, n)) + "\"");
		
		// Use library
		String s2new = s2.substring(0, n);
		System.out.println("\"" + s2new.replace(" ", "%20") + "\"");

	}
	
	public static char[] URLify(char[] arr, int n) {
		int count = 0;
		int spaceIndex = n;
		int indexOri = n - 1;
		
		// count space
		for (int i = 0; i < arr.length; i++) {
			if (i < n && arr[i] == ' ')
				count += 2;
			if (i >= n)
				arr[i] = '\0';
		}	
		
		
		// replace " " to "20%"
		for (int i = n + count - 1; i >= 0; i--) {
			if (arr[indexOri] == ' ') {
				arr[i] = '0';
				arr[i - 1] = '2';
				arr[i - 2] = '%';
				i -= 2;
			} else 
				arr[i] = arr[indexOri];
			indexOri--;
		}
		
		
		return arr;		
	}

}
