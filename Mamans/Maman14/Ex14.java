/**
 * four methods that work with strings and array.
 *
 * @author Lior Kashanovsky
 * @version Maman 14
 */

public class Ex14 {

    /**
     * Getting the distinct value in the array.
     * <p>
     * Complexity analysis: <br>
     * O(log(n)) Time, O(1) Place.
     *
     * @param a array of integers
     * @return the distinct value
     */
    public static int findSingle(int[] a) {
        // Initialize left & right indices
        int left = 0, right = a.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            // if current mid is even and & current item equals to the right.
            if (mid % 2 == 0)
                if (a[mid + 1] == a[mid])
                    // the value is in the right.
                    left = mid + 1;
                else
                    // the value is in the left.
                    right = mid;
            else {
                // if current mid is odd & the current item equals to the left.
                if (a[mid - 1] == a[mid])
                    // the value is in the right.
                    left = mid + 1;
                else
                    // the value is in the left.
                    right = mid - 1;
            }
        }
        return a[left];

    }
    // -----------------------------------------------------------------------

    /**
     * finding the smallest sub array with sum greater than x.
     * <p>
     * Complexity analysis: <br>
     * O(n) Time, O(1) Place.
     *
     * @param arr array of integers.
     * @param x   value
     * @return the minimum sub-array length
     */
    public static int smallestSubSum(int[] arr, int x) {
        int minSub = Integer.MAX_VALUE;
        int left = 0, currentSum = 0;

        for (int right = 0; right < arr.length && minSub > 1; right++) {
            // Keep adding while the sum is less than x.
            currentSum += arr[right];

            while (currentSum > x && left <= arr.length) {
                minSub = Math.min(minSub, (right - left) + 1);
                // remove all the items from the left.
                currentSum -= arr[left++];
            }
        }
        // if the minSub equals the default value
        if (minSub == Integer.MAX_VALUE)
            return -1;
        return minSub;
    }
    // -----------------------------------------------------------------------

    /**
     * Prints all the possibilities for solving the equation `x1 + x2 + x3 = num` <br>
     * where x1, x2 and x3 are greater than 0 and less than 11, <br>
     * and returning the number of solutions
     *
     * @param num the number which we need to get the solutions to
     * @return The number we need to find solutions to.
     */
    public static int solutions(int num) {
        /* Base cases */
        if (num < 3 || num > 30)
            return 0;

        return solutions(num, 1, 1, 0);
    }

    private static int solutions(int num, int x1, int x2, int res) {
        int x3 = num - (x1 + x2);
        if (1 <= x3 && x3 <= 10) {
            System.out.printf("%d + %d + %d = %d \n", x1, x2, x3, num);
            res++;
        }
        // Checking if x1 is in range, and avoiding recursive calls
        // when x3 is negative.
        if (x1 < 10 && x3 > 0)
            return solutions(num, x1 + 1, x2, res);
        /*
         * each recursive call is incrementing x2, while resetting x1 back to 1.
         * (Similar to a nested loop)
         *  when x2 == 10, We're done.
         */
        if (x2 != 10 && x3 >= 0) {
            return solutions(num, 1, x2 + 1, res);
        }
        // Everything is done.
        return res;

    }
    // -----------------------------------------------------------------------

    /**
     * Counts how many different true regions exist in the matrix
     *
     * @param mat Boolean matrix.
     * @return return the number of true regions  in the matrix. If no true regions exist 0 will be returned.
     */
    public static int cntTrueReg(boolean[][] mat) {
        return cntTrueReg(mat, 0, 0, 0);
    }

    private static int cntTrueReg(boolean[][] m, int i, int j, int regions) {
        final int N = m.length;

        // End of the current row,
        if (j == N) {
            // resetting j and searching the next row.
            j = 0;
            i++;
        }
        // End of the matrix, We're done.
        if (i == N)
            return regions;

        // We came to a cell with a True value,
        // need to find the whole region of adjacent cells, and mark them.
        if (m[i][j]) {
            regions++;
            markAdjacent(m, i, j);
        }

        return cntTrueReg(m, i, j + 1, regions);

    }

    /* Helper function */
    private static void markAdjacent(boolean[][] m, int i, int j) {
        final boolean VISITED = false;
        final int N = m.length;
        // Boundary Checks
        if ((i >= 0) && (j >= 0) && (i < N) && (j < N) && m[i][j]) {
            // Mark cell.
            m[i][j] = VISITED;

            /* Traversing */
            markAdjacent(m, i - 1, j); // Up
            markAdjacent(m, i + 1, j); // Down
            markAdjacent(m, i, j - 1); // Left
            markAdjacent(m, i, j + 1); // Right
        }

    }
}

