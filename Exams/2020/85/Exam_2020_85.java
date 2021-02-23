package com.exams;

public class Exam_2020_85 {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, -1, -1, -1},  /* 0 - even */
                {1, 1, 1, -1, -1},  /* 1 - odd */
                {1, 1, 1, 1, 1},  /* 2 - even */
                {-1, -1, -1, -1, 1},  /* 3 - odd */
                {1, 1, -1, -1, 1},  /* 4 - even */
        };
        int[] a1 = {1, 2, 4, 4, 5};
        int[] a2 = {1, 3, 2};
        int[] a3 = {5, 4, 3, 2, 1};
        System.out.println(findMaximum(mat));
        System.out.println(strictlyIncreasing(a1));
        System.out.println(strictlyIncreasing(a2));
        System.out.println(strictlyIncreasing(a3));
    }

    public static int findMaximum(int[][] mat) {
        if (mat[0][0] == -1)
            return -1;
        return findMaximum(mat, 0, 0);
    }

    private static int findMaximum(int[][] mat, int i, int j) {
        if (i < 0 || i == mat.length || j < 0 || j == mat[i].length || mat[i][j] == -1)
            return -1;
        return Math.max(findMaximum(mat, i, i % 2 == 0 ? j + 1 : j - 1), findMaximum(mat, i + 1, j)) + 1;

    }

    public static int strictlyIncreasing(int[] a) {
    int total = 0;
    int increase = 1;
        for (int i = 0; i < a.length-1; i++) {
            if (a[i] < a[i+1])
                total += increase++;
            else
                increase = 1;
        }
        return total;
    }


}
