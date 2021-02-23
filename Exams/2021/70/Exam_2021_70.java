public class Exam_2021_70 {
    public static void main(String[] args) {
        int[] prices = { 0, 1, 3, 10, 9, 10, 17, 17, 20 };
        System.out.println(findMaxPrice(prices, 8)); // 23
        int[] a1 = { 1, 12, 15, 26, 38 };
        int[] a2 = { 12, 13, 18, 30, 45 };
        System.out.println(getMedian(a1, a2)); // 16
    }

    public static int findMaxPrice(int[] prices, int n) {
        return findMaxPrice(prices, n, 1);
    }

    private static int findMaxPrice(int[] prices, int n, int i) {
        if (i > n || n == 0)
            return 0;
        return Math.max(findMaxPrice(prices, n - i, i) + prices[i], findMaxPrice(prices, n, i + 1));
    }

    /**
     * find median of two sorted arrays (both have n elements Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param a first array
     * @param b second array
     * @return median of both arrays.
     */
    public static int getMedian(int[] a, int[] b) {
        final int N = a.length;
        int[] medianArray = new int[N + N];
        for (int i = 0, medianIdx = 0; i < N; i++, medianIdx += 2) {
            int firstItem = a[i], secondItem = b[i];
            if (firstItem < secondItem) {
                medianArray[medianIdx] = firstItem;
                medianArray[medianIdx + 1] = secondItem;
            } else {
                medianArray[medianIdx] = secondItem;
                medianArray[medianIdx + 1] = firstItem;
            }
        }
        return (medianArray[N] + medianArray[N - 1]) / 2;
    }
}
