import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.Stopwatch;

public class Sum2 {
    public static void main(String[] args) {
        Stopwatch time = new Stopwatch();
        In in = new In("D:\\code linh tinh\\Learn Java\\DSA\\algs4-data\\32Kints.txt");
        Out out = new Out("Sum2.out");
        int[] a = in.readAllInts();
        java.util.Arrays.sort(a);
        for(int i = 0;i<a.length;i++){
            int rs = BinarySearch.search(a,i+1,a.length-1,-a[i]);
            if(rs!=-1){
                out.println(a[i] + " " + a[rs]);
            }
        }
        System.out.println(time.elapsedTime());
    }
}
