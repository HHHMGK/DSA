public class BinarySearch {
    public static int search(int[] a, int l, int r, int x) {
        int m;
        while (l <= r) {
            m = (l + r) / 2;
            if (a[m] == x) return m;
            else if (a[m] < x) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

    public static int searchR(int[] a,int l,int r,int x) {
        if(l > r) return -1;
        int m = (l+r) /2;
        if(a[m]==x) return m;
        if(a[m] < x) return searchR(a,m+1,r,x);
        return searchR(a,l,m-1,x);
    }
}
