import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.Stopwatch;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
    public static void main(String[] args) {
        Stopwatch time = new Stopwatch();
        In in = new In("D:\\code linh tinh\\Learn Java\\DSA\\algs4-data\\32Kints.txt");
        Out out = new Out("Sum3.out");
        int[] a = in.readAllInts();
        java.util.Arrays.sort(a);
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            int l = i + 1;
            int r = a.length - 1;
            while(l < r)
            {
                if(a[i]+a[l]+a[r]==0){
                    cnt++;
                    //System.out.println(a[i] + " " + a[l] + " " + a[r]);
                    //out.println(a[i] + " " + a[l] + " " + a[r]);
                    while(l < r && a[l]==a[l+1]) l++;
                    while(l < r && a[r-1]==a[r]) r--;
                    l++;
                    r--;
                }
                while(l < r && a[l] + a[r] != -a[i])
                    if(a[l] + a[r] > -a[i]) r--;
                    else l++;
            }
        }
        System.out.println(cnt);
        System.out.println(time.elapsedTime());
    }
}
//Leetcode 3Sum
class Solution {
    public List<List<Integer>> threeSum(int[] a) {
        List<List<Integer>> ans = new ArrayList<>();
        java.util.Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            int l = i + 1;
            int r = a.length - 1;
            while(l < r)
            {
                if(a[i]+a[l]+a[r]==0){
                    Integer[] tmp = {a[i],a[l],a[r]};
                    ans.add(Arrays.asList(tmp));
                    l++;
                    r--;
                }
                while(l < r && a[l] + a[r] != -a[i])
                    if(a[l] + a[r] > -a[i]) r--;
                    else l++;
            }
        }
        return ans;
    }
}
