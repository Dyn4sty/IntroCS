import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Ex14Test {
    public static String fixString(String str) {
        String newString = "";

        for (char ch : str.toCharArray()) {
            if ((ch >= '0' && ch <= '9') || ch == '+' || ch == '\n')
                newString += ch;
        }
        String newnewString = "";
        for (String equation : newString.split("\n"))
            newnewString += equation.substring(0, Math.max(equation.length() - 1, 0)) + '\n';
        return newnewString;
    }

    // -----------------------------------------------------------------------

    public static void DO_TEST(String statement, Object expected, Object actual) {
        System.out.print("TESTING: (" + statement + ") - ");

        if (expected == actual)
            System.out.println("Correct!");
        else
            System.out.println("Wrong! - Expected Value = " + expected + " , Actual = " + actual);
    }

    // -----------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println("=====================================================================================");

        System.out.println("First Exercise - findSingle");
        {
            {
                int[] arr = new int[] { 6, 6, 18, 18, -4, -4, 12, 9, 9 };
                int val = Ex14.findSingle(arr);
                int res = 12;
                DO_TEST("findSingle({ 6, 6, 18, 18, -4, -4, 12, 9, 9 })", res, val);
            }
            {
                int arr[] = new int[] { -4, -4, 9 };
                int val = Ex14.findSingle(arr);
                int res = 9;
                DO_TEST("findSingle({ -4, -4, 9 })", res, val);
            }
            {
                int arr[] = new int[] { 6, 6, 12, 18, 18, 9, 9 };
                int val = Ex14.findSingle(arr);
                int res = 12;
                DO_TEST("findSingle({ 6, 6, 12, 18, 18, 9, 9})", res, val);
            }
            {
                int arr[] = new int[] { 6, 6, 12, 18, 18, -4, -4, 9, 9 };
                int val = Ex14.findSingle(arr);
                int res = 12;
                DO_TEST("findSingle({ 6, 6, 12, 18, 18, -4, -4, 9, 9 })", res, val);
            }
            {
                int arr[] = new int[] { 8, 8, -7, -7, 3, 3, 0, 0, 10, 10, 5, 5, 4 };
                int val = Ex14.findSingle(arr);
                int res = 4;
                DO_TEST("findSingle({ 8, 8, -7, -7, 3, 3, 0, 0, 10, 10, 5, 5, 4 })", res, val);
            }
            {
                int arr[] = new int[] { 4, 8, 8, -7, -7, 3, 3, 0, 0, 10, 10, 5, 5 };
                int val = Ex14.findSingle(arr);
                int res = 4;
                DO_TEST("findSingle({ 4, 8, 8, -7, -7, 3, 3, 0, 0, 10, 10, 5, 5 })", res, val);
            }
            {
                int arr[] = new int[] { 5 };
                int val = Ex14.findSingle(arr);
                int res = 5;
                DO_TEST("findSingle({ 5 })", res, val);
            }
        }

        System.out.println("=====================================================================================");
        System.out.println("Second Exercise - smallestSubSum");

        // Second Exercise
        {
            {
                int arr[] = new int[] { 1, 4, 45, 6, 0, 19 };
                int val = Ex14.smallestSubSum(arr, 51);
                int res = 3;
                DO_TEST("smallestSubSum({ 1, 4, 45, 6, 0, 19 }, 51)", res, val);
            }
            {
                int arr[] = new int[] { 1, 10, 5, 2, 7 };
                int val = Ex14.smallestSubSum(arr, 9);
                int res = 1;
                DO_TEST("smallestSubSum({ 1, 10, 5, 2, 7 }, 9)", res, val);
            }
            {
                int arr[] = new int[] { 1, 11, 100, 1, 0, 200, 3, 2, 1, 250 };
                int val = Ex14.smallestSubSum(arr, 280);
                int res = 4;
                DO_TEST("smallestSubSum({ 1, 11, 100, 1, 0, 200, 3, 2, 1, 250 }, 280)", res, val);
            }
            {
                int arr[] = new int[] { 8, 4, 5, 2, 1, 1, 1, 1, 1, 1, 10, 5 };
                int val = Ex14.smallestSubSum(arr, 17);
                int res = 4;
                DO_TEST("smallestSubSum({ 8, 4, 5, 2, 1, 1, 1, 1, 1, 1, 10, 5 }, 17)", res, val);
            }
            {
                int arr[] = new int[] { 45, 6, 0 };
                int val = Ex14.smallestSubSum(arr, 51);
                int res = -1;
                DO_TEST("smallestSubSum({ 45, 6, 0 }, 51)", res, val);
            }
            {
                int arr[] = new int[] { 45 };
                int val = Ex14.smallestSubSum(arr, 100);
                int res = -1;
                DO_TEST("smallestSubSum({ 45 }, 100)", res, val);
            }
            {
                int arr[] = new int[] {};
                int val = Ex14.smallestSubSum(arr, 100);
                int res = -1;
                DO_TEST("smallestSubSum({ }, 100)", res, val);
            }

        }

        System.out.println("=====================================================================================");
        System.out.println("Third Exercise - solutions");

        {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            PrintStream old = System.out;

            {
                System.setOut(ps);
                int val = Ex14.solutions(0);
                System.out.flush();
                System.setOut(old);

                int res = 0;
                DO_TEST("solutions(0)", res, val);
                DO_TEST("solutions(0) -  Output", true, fixString(baos.toString()).isEmpty());
                ps.flush();
                baos.reset();
            }

            {
                System.setOut(ps);
                int val = Ex14.solutions(2);
                System.out.flush();
                System.setOut(old);

                int res = 0;
                DO_TEST("solutions(2)", res, val);
                DO_TEST("solutions(2) - Output", true, fixString(baos.toString()).isEmpty());
                ps.flush();
                baos.reset();
            }

            {
                System.setOut(ps);
                int val = Ex14.solutions(3);
                System.out.flush();
                System.setOut(old);

                int res = 1;
                String buffer = fixString(baos.toString());
                DO_TEST("solutions(3)", res, val);
                DO_TEST("solutions(3) -  Output", true, buffer.equals("1+1+1\n"));
                ps.flush();
                baos.reset();
            }

            {
                System.setOut(ps);
                int val = Ex14.solutions(5);
                System.out.flush();
                System.setOut(old);

                int res = 6;
                String buffer = fixString(baos.toString());
                String compare = "";
                compare += "1+1+3\n";
                compare += "1+2+2\n";
                compare += "1+3+1\n";
                compare += "2+1+2\n";
                compare += "2+2+1\n";
                compare += "3+1+1\n";

                DO_TEST("solutions(5)", res, val);
                DO_TEST("solutions(5) -  Output", true, buffer.equals(compare));
                ps.flush();
                baos.reset();
            }

            {
                System.setOut(ps);
                int val = Ex14.solutions(7);
                System.out.flush();
                System.setOut(old);

                int res = 15;
                String buffer = fixString(baos.toString());
                String compare = "";
                compare += "1+1+5\n";
                compare += "1+2+4\n";
                compare += "1+3+3\n";
                compare += "1+4+2\n";
                compare += "1+5+1\n";
                compare += "2+1+4\n";
                compare += "2+2+3\n";
                compare += "2+3+2\n";
                compare += "2+4+1\n";
                compare += "3+1+3\n";
                compare += "3+2+2\n";
                compare += "3+3+1\n";
                compare += "4+1+2\n";
                compare += "4+2+1\n";
                compare += "5+1+1\n";

                DO_TEST("solutions(7)", res, val);
                DO_TEST("solutions(7) -  Output", true, buffer.equals(compare));
                ps.flush();
                baos.reset();
            }

            {
                System.setOut(ps);
                int val = Ex14.solutions(31);
                System.out.flush();
                System.setOut(old);

                int res = 0;
                String buffer = fixString(baos.toString());
                DO_TEST("solutions(31)", res, val);
                DO_TEST("solutions(31) -  Output", true, fixString(baos.toString()).isEmpty());
                ps.flush();
                baos.reset();
            }
        }

        System.out.println("=====================================================================================");
        System.out.println("Fourth Exercise - cntTrueReg");

        {
            boolean[][] mat1 = new boolean[][] { { false, false, false, false, true },
                    { false, true, true, true, false }, { false, false, true, true, false },
                    { true, false, false, false, false }, { true, true, false, false, false } };

            DO_TEST("cntTrueReg(mat1)", 3, Ex14.cntTrueReg(mat1));
        }

        {
            boolean[][] mat2 = new boolean[][] { { false, true, false, true, false },
                    { false, true, true, true, false }, { false, false, false, false, false },
                    { true, false, true, false, true }, { true, false, false, true, true } };

            DO_TEST("cntTrueReg(mat2)", 4, Ex14.cntTrueReg(mat2));
        }

        {
            boolean[][] mat3 = new boolean[][] { { false, true, false, true, false },
                    { false, true, true, true, false }, { false, false, false, false, false },
                    { false, true, true, true, false }, { false, true, false, true, false } };

            DO_TEST("cntTrueReg(mat3)", 2, Ex14.cntTrueReg(mat3));
        }

        {
            boolean[][] mat4 = new boolean[][] { { true, true, false, true, true }, { false, true, false, true, false },
                    { false, true, false, true, false }, { false, true, false, true, false },
                    { true, true, false, true, true } };

            DO_TEST("cntTrueReg(mat4)", 2, Ex14.cntTrueReg(mat4));
        }

        System.out.println("=====================================================================================");
    }
}
