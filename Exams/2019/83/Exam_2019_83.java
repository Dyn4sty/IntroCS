public class Exam_2019_83 {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 0, 0, 1},
                {1, 1, 1, 1, 0, 1, 1},
        };
        System.out.println(longestPath(mat, 2, 5)); // 16
        int[][] arr = {
                {-99, -72, -64, -55, -28, -10, -5},
                {-72, -53, -46, -38, 11, 13, 22},
                {-63, -48, -27, -12, 14, 16, 23},
                {-44, -29, -10, 0, 18, 20, 28},
                {0, 12, 14, 20, 28, 30, 35}
        };
        System.out.println(howManyNegativeNumbers(arr)); // 18
    }

    public static int longestPath(int[][] mat, int x, int y) {
        return longestPath(mat, x, y, 0, 0);
    }

    private static int longestPath(int[][] mat, int x, int y, int i, int j) {
        final int VISITED = 0;
        if (i < 0 || i == mat.length || j < 0 || j == mat[0].length || mat[i][j] == VISITED)
            return 0;
        if (i == y && j == x)
            return 1;

        int temp = mat[i][j];
        mat[i][j] = VISITED;
        int up = 1 + longestPath(mat, x, y, i - 1, j);
        int down = 1 + longestPath(mat, x, y, i + 1, j);
        int right = 1 + longestPath(mat, x, y, i, j + 1);
        int left = 1 + longestPath(mat, x, y, i, j - 1);
        mat[i][j] = temp;
        return Math.max(Math.max(up, down), Math.max(right, left));
    }

    public static int howManyNegativeNumbers(int[][] arr) {
        int count = 0;
        int row = arr.length - 1, col = 0;

        while ((row >= 0) && (col < arr[row].length)) {
            while (arr[row][col] >= 0)
                row--;
            count += row + 1;
            col++;
        }
        return count;
    }
}
