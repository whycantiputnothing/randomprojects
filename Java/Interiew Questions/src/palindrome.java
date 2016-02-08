
public class palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "noob";
		int l = s.length();
		for( int i = 0; i < l; i ++){
			boolean equals = ( s.substring(i, (i+1)).equals(s.substring((l - (i + 1)) , (l-(i)))));
			 if (equals == false){
				 System.out.println(s + " is not a palindrome");
			 System.exit(0);
			 }
		}
		System.out.println(s + " is a palindrome");
		
		
	}

}
