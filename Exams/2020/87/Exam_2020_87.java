public class Exam_2020_87 {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
        };
        System.out.println(totalWays(mat, 1)); // 2
        System.out.println(totalWays(mat, 2)); // 2
        System.out.println(totalWays(mat, 3)); // 2
        System.out.println(totalWays(mat, 4)); // 0
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9}; /*
                                                1   5   8
                                                2   4   5
                                                        */
        printTriplets(a, 40);
    }

    public static int totalWays(int[][] mat, int k) {
        return totalWays(mat, k, 0, 1, false) + totalWays(mat, k, 1, 0, true);
    }

    private static int totalWays(int[][] mat, int k, int i, int j, boolean isDown) {
        if (i < 0 || i == mat.length || j < 0 || j == mat[i].length)
            return 0;
        if (i == mat.length - 1 && j == mat.length - 1) {
            if (k == 0)
                return 1;
            return 0;
        }
        return totalWays(mat, isDown ? k : k - 1, i + 1, j, true)
                + totalWays(mat, isDown ? k - 1 : k, i, j + 1, false);
    }

    public static void printTriplets(int[] a, int num) {
        for (int left = 0; left < a.length; left++) {
            int mid = left + 1;
            int right = a.length - 1;
            while (mid < right) {
                int currentValue = a[left] * a[mid] * a[right];
                if (currentValue == num) {
                    System.out.printf("%d \t %d \t %d \n", a[left], a[mid], a[right]);
                    right--;
                    mid++;
                } else if (currentValue > num)
                    right--;
                else
                    mid++;
            }
        }
    }
}
