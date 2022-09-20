import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Scanner;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class STE {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }
        public FastReader(FileReader fr)
        {
            br = new BufferedReader(fr);
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void add(List<Character> s, String w) {
        for (int i = 0; i < w.length(); i++)
            s.add(w.charAt(i));
    }

    public static String del(List<Character> s, int k) {
        StringBuilder w = new StringBuilder();
        for (int i = s.size() - k; i < s.size(); i++)
            w.append(s.get(i));
        for (int i = 0; i < k; i++)
            s.remove(s.size() - 1);
        return w.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Stopwatch time = new Stopwatch();
        int q, t, k;
        String w;
        List<Character> s = new ArrayList<>();
        Stack<Integer> ops = new Stack<>();
        Stack<Integer> sa = new Stack<>();
        Stack<String> sd = new Stack<>();

        Scanner in = new Scanner(file);
//        FastReader in = null;
//        try {
//            in = new FastReader(new FileReader("test.txt"));
//        }catch (FileNotFoundException e){
//            e.printStackTrace();
//        }

        Out out = new Out("STE.out");
        q = in.nextInt();
        while (q-- > 0) {
            t = in.nextInt();
            if (t == 1) {
                w = in.next();
                add(s, w);
                sa.push(w.length());
                ops.push(t);
            }
            if (t == 2) {
                k = in.nextInt();
                w = del(s,k);
                sd.push(w);
                ops.push(t);
            }
            if (t == 3) {
                k = in.nextInt();
                out.println(s.get(k-1));
            }
            if (t == 4) {
                if (ops.peek() == 1) {
                    del(s,sa.peek());
                    sa.pop();
                } else {
                    add(s,sd.peek());
                    sd.pop();
                }
                ops.pop();
            }
            //cout<<t<<" : ";for(int i=1;i<=n;i++) cout<<s[i];cout<<'\n';
        }
        System.out.println(time.elapsedTime());
    }
}
