
public class StringReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abuttuba";
		String temp2 = "";
		int a = s.length();
		for (int i = 1; i <= a; i++){
			temp2 = temp2 + s.substring((a-i), (a-i+1));
		}
		System.out.println(temp2);
		}
		
		
	}
