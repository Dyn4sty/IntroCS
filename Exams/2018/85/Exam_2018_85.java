public class Exam_2018_85 {

    /* ***********************************************************************************
     *                              Recursion
     ***********************************************************************************/


    // Simple Overloading function,
    public static int longestSlope(int[][] mat, int num) {
        return longestSlope(mat, num, 0, 0);
    }
    // iterating through each cell in the matrix
    private static int longestSlope(int[][] mat, int num, int i, int j) {
        if (j == mat[i].length) {
            j = 0;
            i++;
        }
        if (i == mat.length)
            return 0;

        int currentCellSlope = getSlopeLength(mat, num, i, j);
        int nextCellSlope = longestSlope(mat, num, i, j + 1);

        return Math.max(currentCellSlope, nextCellSlope);
    }

    private static int getSlopeLength(int[][] mat, int num, int i, int j) {
        int up = 1, down = 1, left = 1, right = 1;
        // Getting each direction slope.
        if (i - 1 >= 0 && mat[i][j] - mat[i - 1][j] == num)
            up += getSlopeLength(mat, num, i - 1, j);

        if (i + 1 < mat.length && mat[i][j] - mat[i + 1][j] == num)
            down += getSlopeLength(mat, num, i + 1, j);

        if (j - 1 >= 0 && mat[i][j] - mat[i][j - 1] == num)
            left += getSlopeLength(mat, num, i, j - 1);

        if (j + 1 < mat[i].length && mat[i][j] - mat[i][j + 1] == num)
            right += getSlopeLength(mat, num, i, j + 1);

        // return the max slope
        return Math.max(Math.max(up, down), Math.max(left, right));
    }
    // ----------------------------Another Example---------------------------------------

    public static int longestSlope2(int[][] mat, int num) {
        return longestSlope2(mat, num, 0, 0);
    }

    private static int longestSlope2(int[][] mat, int num, int i, int j) {
        if (i == mat.length) {
            return 0;
        }
        if (j == mat[i].length) {
            return longestSlope2(mat, num, i + 1, 0);
        }

        int currentCellSlope = getSlopeLength2(mat, num, i, j);

        int nextCellSlope = longestSlope2(mat, num, i, j + 1);

        return Math.max(currentCellSlope, nextCellSlope);

    }

    private static int getSlopeLength2(int[][] mat, int num, int i, int j) {
        int up = getSlopeLength2(mat, num, i - 1, j, mat[i][j]);
        int down = getSlopeLength2(mat, num, i + 1, j, mat[i][j]);
        int right = getSlopeLength2(mat, num, i, j + 1, mat[i][j]);
        int left = getSlopeLength2(mat, num, i, j - 1, mat[i][j]);
        return Math.max(Math.max(up, down), Math.max(left, right)) + 1;
    }

    private static int getSlopeLength2(int[][] mat, int num, int i, int j, int prevCell) {
        final int n = mat.length;
        if (i < 0 || i >= n || j < 0 || j >= n)
            return 0;
        if (mat[i][j] - prevCell != num)
            return 0;
        return getSlopeLength2(mat, num, i, j);
    }

    // ------------------------------------------------------------------------------
}
