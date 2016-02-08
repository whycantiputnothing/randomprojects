
public class Shit {
	public static int mystery(int n)
	{
	 int x = 1;
	 int y = 1;
	 // Point A
	 while (n > 2)
	 {
	 x = x + y;
	 // Point B
	 y = x - y;
	 n--;
	 }
	 // Point C
	 return x;
	}
	public static void main (String args[]) {
		// TODO Auto-generated method stub
		
		System.out.println(mystery(5));
		System.out.println(mystery(6));
		} 
	}

