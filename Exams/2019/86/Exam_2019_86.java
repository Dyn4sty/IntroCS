public class Exam_2019_86 {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 3, 1, 6},
                {2, 8, 1, 2},
                {6, 2, 7, 5},
                {2, 84, 1, 3},
        };
        System.out.println(howManyPaths(mat));
        int[] a = {0, 19, 16, 15, 15, 15, 15, 13, 5};
        int[] b = {0, 12, 13, 14, 14, 15, 15, 13, 25, 30, 5};
        System.out.println(meetingPoint(a, b));
    }

    public static int howManyPaths(int[][] mat) {
        return howManyPaths(mat, 0, 0);
    }

    private static int howManyPaths(int[][] mat, int i, int j) {
        final int VISITED = -1;
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[i].length || mat[i][j] == VISITED)
            return 0;
        if (i == mat.length - 1 && j == mat[i].length - 1)
            return 1;
        int k = mat[i][j];
        mat[i][j] = VISITED;
        int up = howManyPaths(mat, i + k, j);
        int down = howManyPaths(mat, i - k, j);
        int right = howManyPaths(mat, i, j + k);
        int left = howManyPaths(mat, i, j - k);
        mat[i][j] = k;
        return up + down + right + left;
    }
    public static int meetingPoint(int[] a, int[] b) {
        for (int i = 0; i < a.length && i < b.length; i++) {
            if (a[i] == b[i])
                return i;
        }
        return -1;
    }
//    public static int meetingPoint(int[] a, int[] b) {
//        int left = 0, right = Math.min(a.length, b.length) - 1;
//        int minIdx = Integer.MAX_VALUE;
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            // we found a match.
//            if (a[mid] == b[mid]) {
//                // saving the index if  it's smaller.
//                minIdx = Math.min(minIdx, mid);
//                // searching only the left side.
//                right = mid - 1;
//            } else if (a[mid] > b[mid])
//                left = mid + 1;
//            else if (a[mid] < b[mid])
//                right = mid - 1;
//        }
//        return minIdx == Integer.MAX_VALUE ? -1 : minIdx;
//    }

}
