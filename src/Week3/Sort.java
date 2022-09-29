package Week3;

import edu.princeton.cs.algs4.StdRandom;

public class Sort {

    public static final int SORT_CUTOFF = 8;

    public static void insertionSort(int[] a) {
        insertionSort(a, 0, a.length - 1);
    }

    public static void insertionSort(int[] a, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            int j = i;
            while (j > l && a[j - 1] > a[j]) {
                swap(a, j - 1, j);
                j--;
            }
        }
    }


    public static void mergeSort(int[] a) {
        int[] aux = new int[a.length];
//        for (int i = 0;i<a.length;i++)
//            aux[i] = a[i];
        mergeSort(a, aux, 0, a.length - 1);
    }

    public static void merge(int[] a, int[] aux, int l, int m, int r) {
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i > m) aux[k] = a[j++];
            else if (j > r) aux[k] = a[i++];
            else if (a[i] < a[j]) aux[k] = a[i++];
            else aux[k] = a[j++];
        }
        for (int k = l; k <= r; k++)
            a[k] = aux[k];
    }


    public static void mergeSort(int[] a, int[] aux, int l, int r) {
        if (r - l + 1 <= SORT_CUTOFF) {
            insertionSort(a, l, r);
            return;
        }
        int m = l + (r - l) / 2;
        mergeSort(a, aux, l, m);
        mergeSort(a, aux, m + 1, r);
        if (a[m] <= a[m + 1]) return;
        merge(a, aux, l, m, r);
    }


    public static void quickSort(int[] a) {
        StdRandom.shuffle(a);
        quickSort3way(a,0,a.length-1);
    }

    public static void quickSort(int[] a, int l, int r) {
        if (r - l + 1 <= SORT_CUTOFF) {
            insertionSort(a, l, r);
            return ;
        }
        int median = medianOf3(a,l,l+(r-l)/2,r);
        swap(a,l,median);
        int m = partition(a,l,r);
        quickSort(a,l,m);
        quickSort(a,m+1,r);
    }
    public static void quickSort3way(int[] a, int l, int r) {
        if (r - l + 1 <= SORT_CUTOFF) {
            insertionSort(a, l, r);
            return ;
        }
        int lt = l, gt = r;
        int i = l;
        int v = a[l];
        while(i <= gt) {
            if(a[i] < v) swap(a,lt++,i++);
            else if(a[i] > v) swap(a,gt--,i);
            else i++;
        }
        quickSort3way(a,l,lt-1);
        quickSort3way(a,gt+1,r);
    }

    public static int partition(int[] a, int l, int r) {
        int i = l + 1, j = r;
        while (true) {
            while (i < r && a[i] < a[l]) i++;
            while (j > l && a[j] > a[l]) j--;
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }

    private static int medianOf3(int[] a,int x,int y,int z) {
        if(a[x] > a[y]) {
            if(a[y] > a[z]) return y;
            if(a[x] > a[z]) return z;
            return x;
        }
        else {
            if(a[x] > a[z]) return x;
            if(a[y] > a[z]) return z;
            return y;
        }
    }
    private static void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }
}
