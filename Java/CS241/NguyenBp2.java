import java.util.Arrays;

public class NguyenBp2 {

	public static void main(String[] args) {
		NguyenBp2 test = new NguyenBp2();
		int swaps = 0;
		int[] rand = new int[100];
		int[] array = { 12, 19, 26, 13, 20, 27, 14, 21, 28, 15, 22, 29, 16, 23, 10, 17, 24, 11, 18, 25 };
		MaxHeap heap = test.new MaxHeap(array, array.length);

		for (int j = 0; j < 20; j++) {
			// fill array with 100 random numbers between 100 and 900
			for (int i = 0; i < rand.length; i++) {
				rand[i] = 100 + (int) (Math.random() * 800);
			}
			heap = test.new MaxHeap(rand, 100, swaps);
			System.out.println("Number of swaps: " + heap.swaps);
			swaps += heap.swaps;
		}
		swaps = (int) (swaps / 20.0 + 0.5);
		System.out.println("The average number of swaps for 20 trials: " + swaps);
		System.exit(0);

	}

	public class MaxHeap {
		int[] heap;
		int[] help = { 0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		int swaps;

		/**
		 * @param entries
		 *            takes an integer array as a parameter, makes array into a
		 *            maxHeap and prints every change to the array
		 */
		public MaxHeap(int[] array, int n) {
			heap = array;

			print();
			System.out.println();
			
			// create first heap
			for (int rootIndex = n / 2 - 1; rootIndex >= 0; rootIndex--) {
				reheap(array, rootIndex, n - 1);
			}
			
			swap(heap, 0, n - 1);
			
			for (int lastIndex = n - 2; lastIndex > 0; lastIndex--) {
				reheap(array, 0, lastIndex);
				swap(array, 0, lastIndex);
			}
			
			
		}

		/**
		 * @param entries
		 *            an integer array to be made into a heap
		 * @param a
		 *            to differentiate between two constructors counts number of
		 *            swaps made
		 */
		public MaxHeap(int[] array, int n, int a) {
			heap = array;
			
			// create first heap
			for (int rootIndex = n / 2 - 1; rootIndex >= 0; rootIndex--) {
				reheap2(array, rootIndex, n - 1);
			}
			
			swap2(heap, 0, n - 1);
			
			for (int lastIndex = n - 2; lastIndex > 0; lastIndex--) {
				reheap2(array, 0, lastIndex);
				swap2(array, 0, lastIndex);
			}
			
			
		}

		public void print() {
			System.out.println(Arrays.toString(heap));
		}

		/**
		 * @param rootIndex
		 *            is the index to begin the reheap implements float down
		 *            only prints if a change to the array is made
		 */
		private void reheap(int[] heap, int rootIndex, int lastIndex) {
			boolean done = false;
			boolean change = false;
			int orphan = heap[rootIndex];
			int leftChildIndex = 2 * rootIndex + 1;
			int largerChildIndex = 0;
			int compare = 0;
			int rightChildIndex = 0;

			// checks if left child exists and is in bounds and stops when the
			// largest child is smaller than the starting node
			while (!done && (leftChildIndex <= lastIndex)) {
				largerChildIndex = leftChildIndex;
				rightChildIndex = leftChildIndex + 1;

				// checks to see if right child is within bounds of the array
				// and then decides which child is larger
				if ((rightChildIndex <= lastIndex) && (heap[rightChildIndex] - heap[largerChildIndex] > 0))
					largerChildIndex = rightChildIndex;

				// if a swap is made change is set to true
				compare = orphan - heap[largerChildIndex];
				if (compare < 0) {
					heap[rootIndex] = heap[largerChildIndex];
					rootIndex = largerChildIndex;
					leftChildIndex = 2 * rootIndex + 1;
					change = true;
				} else
					done = true;
				if (change)
					print();
			}
			heap[rootIndex] = orphan;
			if (change) {
				print();
				System.out.println();
			}
		}

		/**
		 * @param rootIndex
		 *            index of the heap to begin the reheap only changes made to
		 *            original reheap are to not print after swaps and to store
		 *            number of swaps made
		 */
		private void reheap2(int[] heap, int rootIndex, int lastIndex) {
			boolean done = false;
			int orphan = heap[rootIndex];
			int leftChildIndex = 2 * rootIndex + 1;
			int largerChildIndex = 0;
			int compare = 0;
			int rightChildIndex = 0;

			while (!done && (leftChildIndex <= lastIndex)) {
				largerChildIndex = leftChildIndex;
				rightChildIndex = leftChildIndex + 1;
				if ((rightChildIndex <= lastIndex) && (heap[rightChildIndex] - heap[largerChildIndex] > 0))
					largerChildIndex = rightChildIndex;
				compare = orphan - heap[largerChildIndex];
				if (compare < 0) {
					heap[rootIndex] = heap[largerChildIndex];
					rootIndex = largerChildIndex;
					leftChildIndex = 2 * rootIndex + 1;
					swaps++;
				} else
					done = true;
			}
			heap[rootIndex] = orphan;
		}
		
		public final void swap(int[] a, int i, int j) {
			int tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
			print();
			System.out.println();
		}
		
		public final void swap2(int[] a, int i, int j) {
			int tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
			swaps++;
		}
	}

}
