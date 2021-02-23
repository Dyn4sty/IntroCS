public class Exam_2020_81 {
    public static void main(String[] args) {
        int[] lengths = {2, 5, 10, 20, 50};
        System.out.println(makeSum(lengths, 40, 4));
        int[] arr = {10, 4, 2, 5, 6, 3, 8, 1, 5, 9};
        minimumSubK(arr, 20); // Minimum sum sub-array is (1,3) || Minimum sum sub-array is (7,8)
        minimumSubK(arr, 2); // Minimum sum sub-array is (1,2)
    }

    /**
     * find how many ways we able to sum n (may be different or not)
     * length Section to k length.
     *
     * @param lengths arr of different lengths Section
     * @param k       the length to sum to.
     * @param num     maximum number of Sectios to use.
     * @return how many ways.
     */
    public static int makeSum(int[] lengths, int k, int num) {
        return makeSum(lengths, k, num, 0);
    }

    private static int makeSum(int[] lengths, int k, int num, int i) {
        if (i == lengths.length || k < 0 || num == 0) {
            if (k == 0)
                return 1;
            return 0;
        }
        return makeSum(lengths, k - lengths[i], num - 1, i) +
                makeSum(lengths, k, num, i + 1);
    }

    /**
     * finds the k-size sub-array whose sum is minimal
     *
     * @param arr The array where the minimum sub-array should be found.
     * @param k   the sub-array size (smaller than arr.length)
     */
    public static void minimumSubK(int[] arr, int k) {
        int minSum = 0;
        // last known idx of the smallest sub.
        int lastEndingIdx = 0;
        // Initializing the `Window`
        for (int i = 0; i < k; i++)
            minSum += arr[i];

        // Compute sums of remaining windows by
        // removing first element of previous
        // window and adding last element of
        // current window.
        int windowSum = minSum;
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i];
            windowSum -= arr[i - k];
            if (windowSum < minSum) {
                minSum = windowSum;
                lastEndingIdx = i;
            }
        }
        System.out.printf("Minimum sum sub-array is (%d,%d) \n", lastEndingIdx - k + 1, lastEndingIdx);
    }
}
