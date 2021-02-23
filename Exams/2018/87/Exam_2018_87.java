public class Exam_2018_87 {
    public static void main(String[] args) {
        System.out.println(howManySorted(3, 2));
        System.out.println(howManySorted(2, 3));
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(what2(arr, 6));
    }

    public static int howManySorted(int n, int max) {
        return howManySorted(n, max, 1);
    }

    private static int howManySorted(int n, int max, int min) {
        // not valid.
        if (min > max)
            return 0;
        // we reached the end of the array, and the currentNumber is valid,
        // so its a possibility.
        if (n == 0)
            return 1;
        // adding all the possibilities of the currentNumber
        return howManySorted(n - 1, max, min) +
                // and the possibilities of the next.
                howManySorted(n, max, min + 1);
    }

    // sum from starting index to end index.
    private static int f(int[] a, int low, int high) {
        int res = 0;
        for (int i = low; i <= high; i++)
            res += a[i];
        return res;
    }

    /**
     * checking if value is sum of a subarray.
     * Time Complexity: O(n^3), Space Complexity: O(1)
     *
     * @param a   array of positive integers.
     * @param num value that needs to be found if there is a sub-array whose sum is the same
     * @return true if there is a subset whose sum is equal to num, false otherwise.
     */
    public static boolean what(int[] a, int num) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (f(a, i, j) == num)
                    return true;
            }
        }
        return false;

    }

    // Improved version of the what function.
    // O(n) time complexity.
    public static boolean what2(int[] a, int num) {
        int currentSum = 0;
        for (int i = 0, left = 0; i < a.length; i++) {
            currentSum += a[i];
            while (currentSum >= num) {
                if (currentSum == num)
                    return true;
                currentSum -= a[left++];
            }
        }
        return false;
    }
}
