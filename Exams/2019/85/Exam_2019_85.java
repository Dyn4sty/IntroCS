public class Exam_2019_85 {
    public static void main(String[] args) {
//        int[] arr = {1, 3, 2, 3, 10, 10, 3, 2, 4};
//        int[] arr2 = {1, 2, 3, 4};
//        System.out.println(longestPalindrome(arr));
//        System.out.println(longestPalindrome(arr2));
        int[] arr = {7, 10, 13, 19, 22, 25, 28};
        System.out.println(missingValue(arr));
    }

    public static int longestPalindrome(int[] arr) {
        return longestPalindrome(arr, 0, arr.length - 1);
    }

    private static int longestPalindrome(int[] arr, int i, int j) {
        if (i >= j)
            return 0;

        if (arr[i] == arr[j])
            return 2 + longestPalindrome(arr, i + 1, j - 1);
        // checking each side of the palindrome
        return max(longestPalindrome(arr, i, j - 1), longestPalindrome(arr, i + 1, j));

    }

    private static int max(int x, int y) {
        return Math.max(1, Math.max(x, y));
    }

    public static int missingValue(int[] arr) {
        int low = 0, high = arr.length - 1;
        int diff = (arr[high] - arr[low]) / arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            // the missingValue is after the mid item.
            if (arr[mid + 1] - arr[mid] != diff)
                return arr[mid] + diff;
                // the missingValue is before the mid item.
            else if (arr[mid] - arr[mid - 1] != diff)
                return (arr[mid - 1] + diff);
                // the missingValue is in the right side.
            else if (arr[mid] == arr[0] + mid * diff)
                low = mid + 1;
                // the missingValue is in the left side.
            else
                high = mid - 1;
        }
        return -1;
    }

//    public static int missingValue(int[] arr) {
//        int diff = (arr[arr.length - 1] - arr[0]) / arr.length;
//
//        for (int i = 0; i < arr.length - 1; i++) {
//            if (arr[i + 1] - arr[i] != diff)
//                return arr[i] + diff;
//        }
//        return -1;
//    }


}
