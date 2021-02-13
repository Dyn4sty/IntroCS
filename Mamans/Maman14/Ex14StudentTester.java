public class Ex14StudentTester {

    public static void main(String[] args) {
        System.out.println("********** Question 1 **********\n");

        int[] array1 = { 6, 6, 18, 18, -4, -4, 12, 9, 9 };
        System.out.println("Checking method findSingle on array [6,6,18,18,-4,-4,12,9,9]\n");
        int studentResult;

        studentResult = Ex14.findSingle(array1);
        System.out.println("Result is: " + studentResult);
        System.out.println();

        System.out.println("********** Question 2 **********\n");
        int[] array2 = { 1, 4, 45, 6, 0, 19 };
        int x = 5;
        System.out.println("Checking method smallestSubSum on array [1,4,45,6,0,19]\n");
        studentResult = Ex14.smallestSubSum(array2, x);
        System.out.println("Result is: " + studentResult);
        System.out.println();
        System.out.println("********** Question 3 **********\n");

        System.out.println("Checking method solutions with number 4\n");

        studentResult = Ex14.solutions(4);
        System.out.println();
        System.out.println("Result is: " + studentResult);
        System.out.println();

        System.out.println("********** Question 4**********\n");

        boolean[][] mat = { { false, false, false, false, true }, { false, true, true, true, false },
                { false, false, true, true, false }, { true, false, false, false, false },
                { true, true, false, false, false }, };

        System.out.println("Checking method cntTrueReg with the matrix:\n");
        printMat(mat);

        int studentCntRegResult = Ex14.cntTrueReg(mat);
        System.out.println();
        System.out.println("Result is: " + studentCntRegResult);

    }

    public static void printMat(boolean[][] mat) {
        for (boolean[] booleans : mat) {
            for (int j = 0; j < mat[0].length; j++)
                if (booleans[j])
                    System.out.print("1\t");
                else
                    System.out.print("0\t");
            System.out.println();
        }
    }
}
