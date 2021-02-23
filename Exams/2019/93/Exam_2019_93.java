public class Exam_2019_93 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 1,3 };
        System.out.println(isSum(arr, 0));
        System.out.println(isSum(arr, 8));
        System.out.println(isSum(arr, 9));
        System.out.println(isSum(arr, 2));
        System.out.println(isSum(arr, 11));
        System.out.println(isSum(arr, 17));
    }

    public static boolean isSum(int[] a, int num) {
        if (num == 0)
            return true;
        return isSum(a, num, 0, 0);
    }

    private static boolean isSum(int[] a, int num, int i, int jumpSize) {
        if (num < 0)
            return false;
        if (i == a.length)
            return num == 0;
        if (jumpSize != 2)
            return isSum(a, num - a[i], i + 1, jumpSize + 1) || isSum(a, num, i + 1, 0);
        return isSum(a, num, i + 1, 0);
    }


}
