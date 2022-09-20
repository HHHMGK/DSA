package Percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private double[] x;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("no need to run !");
        }
        x = new double[trials];
        for (int i = 0; i < trials; i++) {
            x[i] = 0;
            Percolation sim = new Percolation(n);
            while (!sim.percolates()) {// && sim.numberOfOpenSites() < n * n) {
                int r, c;
                do {
                    r = StdRandom.uniformInt(1, n + 1);
                    c = StdRandom.uniformInt(1, n + 1);
                } while (sim.isOpen(r, c));
                sim.open(r, c);
                x[i]++;
            }
            x[i] /= n * n;
//            System.out.println(i + "//////////////////////////////////////////////////////////////////////");
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(x);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        if (x.length == 1) return Double.NaN;
        return StdStats.stddev(x);

    }

    private final double CONFIDENCE_95 = 1.96;
    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - CONFIDENCE_95 * stddev() / Math.sqrt(x.length);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + CONFIDENCE_95 * stddev() / Math.sqrt(x.length);
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(n, trials);
        System.out.println("mean                    = " + stats.mean());
        System.out.println("stddev                  = " + stats.stddev());
        System.out.println("95% confidence interval = [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
    }

}