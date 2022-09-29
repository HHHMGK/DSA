package Week3;

import edu.princeton.cs.algs4.*;

public class testSort {
    public static void main(String[] args) {
        //int[] a = {10, 2, 5, 6, 8, 3, 5, 8, 12, 22};
        In in = new In("algs4-data\\1Mints.txt");
        int[] a = in.readAllInts();
        Stopwatch time = new Stopwatch();
        //Sort.insertionSort(a);
        //Sort.mergeSort(a);
        Sort.quickSort(a);
        System.out.println(time.elapsedTime());
        //for (int x : a) System.out.print(x + " ");
    }
}
