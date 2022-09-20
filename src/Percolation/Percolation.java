package Percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] open;
    private int sz, opened;
    private WeightedQuickUnionUF dt;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("invalid value of n");
        }
        sz = n;
        opened = 0;
        open = new boolean[sz + 1][sz + 1];
        dt = new WeightedQuickUnionUF(sz * sz + 2);
        for (int i = 1; i <= sz; i++)
            for (int j = 1; j <= sz; j++) {
                open[i][j] = false;
            }
    }

    private int to1D(int row, int col) {
        return (row - 1) * sz + col;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 1 || row > sz || col < 1 || col > sz) {
            throw new IllegalArgumentException("out of bound !");
        }
        if (open[row][col]) return;
        open[row][col] = true;
        opened++;
        if (row - 1 >= 1 && open[row - 1][col]) dt.union(to1D(row - 1, col), to1D(row, col));
        if (col - 1 >= 1 && open[row][col - 1]) dt.union(to1D(row, col - 1), to1D(row, col));
        if (row + 1 <= sz && open[row + 1][col]) dt.union(to1D(row + 1, col), to1D(row, col));
        if (col + 1 <= sz && open[row][col + 1]) dt.union(to1D(row, col + 1), to1D(row, col));
        if (row == 1) dt.union(0, (row - 1) * sz + col);
        if (row == sz) dt.union(sz * sz + 1, (row - 1) * sz + col);
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 1 || row > sz || col < 1 || col > sz) {
            throw new IllegalArgumentException("out of bound !");
        }
//        System.out.println(numberOfOpenSites());
        return open[row][col];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row < 1 || row > sz || col < 1 || col > sz) {
            throw new IllegalArgumentException("out of bound !");
        }
        return dt.find(0) == dt.find((row - 1) * sz + col);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return opened;
    }

    // does the system percolate?
    public boolean percolates() {
//        System.out.println(open[1][1] + " " + open[1][2]);
//        System.out.println(open[2][1] + " " + open[2][2]);
//        System.out.println(dt.find(0) + " " + dt.find(sz * sz + 1) + " check percolation return " + (dt.find(0) == dt.find(sz * sz + 1)));
        return dt.find(0) == dt.find(sz * sz + 1);
    }

    // test client (optional)
}