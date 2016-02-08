
public class HW3 {
	
	public static int D(int n) {
		if (n == 1)
			return 3;
		else if (n == 2)
			return 5;
		else 
			return  (n - 1)*D(n - 1) + (n - 2)*D(n - 2) ;
		
	}
	
	public static int L(int l) {
		if (l == 1)
			return 1;
		if (l == 2)
			return 3;
		else
			return L(l - 1) + L(l - 2);
	}
	
	public static double P(int p) {
		if (p == 0)
			return 500;
		else
			return 1.1*P(p-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		for (int i = 1; i < 8; i++) {
			System.out.println(L(i));
		}
*/
		System.out.println(P(4));
	}

}
