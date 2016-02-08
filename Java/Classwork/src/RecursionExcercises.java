/**
 * 
 */
/**
 * @author apoloimagod
 *
 */
public class RecursionExcercises {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] bigArray = new int[1000000];
		System.out.println(goodFibonacci(100));
	}
	
	/**
	 * Returns the nth element of the Fibonacci series
	 * @param n
	 * @return
	 */
	public static long fibonacci(long n) {
		if (n == 1 || n == 0)
			return 1;
		return fibonacci(n-2) + fibonacci(n-1);
	}
	
	public static long goodFibonacci(long n) {
		if (n == 0 || n == 1)
			return 1;
		
		long fibPrev = 1;
		long prevFibPrev = 1;
		long result = 0;
		
		while (n > 1) {
			result = fibPrev + prevFibPrev;
			prevFibPrev = fibPrev;
			fibPrev = result;
			--n;
		}
		
		return result;
		
	}
	
	public static int recSum(int[] numbers) {
		return recSumHelper(numbers, 0);
	}

	private static int recSumHelper(int[] numbers, int init) {
		if (init == numbers.length)
			return 0;
		return numbers[init] + recSumHelper(numbers, init + 1);
	}
	
	public static int goodSum(int[] numbers) {
		int sum = 0;
		
		for (int num : numbers)
			sum += num;
		
		return sum;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
