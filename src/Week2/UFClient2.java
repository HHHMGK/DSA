import edu.princeton.cs.algs4.*;

public class UFClient2 {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        UF dt = new UF(n);
        int cnt = 0;
        while (!StdIn.isEmpty()) {
            int u, v;
            u = StdIn.readInt();
            v = StdIn.readInt();
            dt.union(u, v);
            cnt++;
            if (dt.count() == 1) {
                System.out.println(cnt);
                return ;
            }
        }
        System.out.println("FAILED");
    }
}