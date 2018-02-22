package MedianOfMedians;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MediansOfMedians {

    public static List<Integer> randomList(int size) {
        List<Integer> lst = new ArrayList<Integer>();
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            lst.add(rand.nextInt(Integer.MAX_VALUE));
        }
        return lst;
    }

    public static List<Integer> randomList(int size, int max) {
        List<Integer> lst = new ArrayList<Integer>();
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            lst.add(rand.nextInt(max));
        }
        return lst;
    }

    public static void swap(List<Integer> list, int i, int j) {
        int val = list.get(i);
        list.set(i, list.get(j));
        list.set(j, val);
    }

    public static int partition(List<Integer> list, int pivot) {
        int low = 0;
        int low2 = 0;
        int high = list.size() - 1;
        while (low <= high) {
            if(list.get(low) == pivot) {
                low++;
            }
            else if(list.get(low) > pivot){
                swap(list, low, high--);
            }
            else {
                swap(list, low++, low2++);
            }
        }
//        System.out.println("low: " + low + " high: " + high + " low2: " + low2 );
        return low2;
    }

    public static int getMedian(List<Integer> list, int k) {
        if (list.size() <= 5) {
            list.sort(null);
            return list.get(k - 1);
        }

        List<Integer> superMedianList = new ArrayList<Integer>();

        for (int i = 0; i < list.size() / 5; i++) {
            if (i * 5 > list.size()) {
                superMedianList.add(getMedian(list.subList(i * 5, i * 5 + 5), list.size() % 5));
            } else {
                superMedianList.add(getMedian(list.subList(i * 5, i * 5 + 5), 3));
            }
        }
        int superMedian = getMedian(superMedianList, superMedianList.size() / 2);
        int position = partition(list, superMedian);
        if(position == k -1) {
            return list.get(position);
        }
        return list.get(position);
        
    }

    public static void main(String[] args) {
        List<Integer> list = randomList(11, 100);
        System.out.println(list);
        System.out.println(getMedian(list, 6));
        list.sort(null);
        System.out.println(list);
        System.exit(0);
    }

}
