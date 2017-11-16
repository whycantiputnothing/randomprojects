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
        int j = list.size() - 1;
        int i = 0;
        while (i <= j) {
            while (list.get(i) < pivot)
                i++;
            while (list.get(j) > pivot)
                j--;
            if (i <= j)
                swap(list, i++, j--);
        }
            return i;
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
        return superMedian;
    }

    public static void main(String[] args) {
        List<Integer> list = randomList(10, 100);
        System.out.println(list);
        System.out.println(list.get(5));
        int i = list.get(5);
        i = partition(list, i);
        System.out.println(list);
        System.out.println(i);
        System.out.println(getMedian(list, 25 / 2 + 1));
        list.sort(null);
        System.out.println(list);
    }

}
