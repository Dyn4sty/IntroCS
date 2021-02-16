package com.exams;

/**
 * @author Lior Kashanovsky
 */
public class Exam_2017_86 {
    public static void main(String[] args) {
        /* Question 1 */
        String str3 = "sunday", str4 = "saturday";
        System.out.println(edit(str3, str4));

        /* Question 2 */
        int[] arr = {-2, 0, 1, 3};
        int[] arr2 = {1, 3, 4, 5, 7};
        System.out.println(countTriplets(arr, 2));
        System.out.println(countTriplets(arr2, 12));

        /* Question 3 - [Tree Structure] url(https://prnt.sc/yomt9c) */
        Node root = new Node(30);
        // Left
        root._leftSon = new Node(20);
        root._leftSon._leftSon = new Node(50);
        root._leftSon._leftSon._leftSon = new Node(150);
        // Right
        root._rightSon = new Node(40);
        root._rightSon._rightSon = new Node(50);
        // ----
        System.out.println(what(root));
    }

    public static int edit(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0)
            return Math.max(str1.length(), str2.length());
        // is the current char is the same.
        if (str1.charAt(0) == str2.charAt(0))
            return edit(str1.substring(1), str2.substring(1));
        // check if the letter is needed on str2
        if (isLetterNeeded(str1.charAt(0), str2))
            return 1 + edit(str2.charAt(0) + str1, str2);
        // letter is not needed, remove it.
        return 1 + edit(str1.substring(1), str2);
    }

    private static boolean isLetterNeeded(char c, String str2) {
        if (str2.length() <= 0) {
            return false;
        }
        if (str2.charAt(0) == c)
            return true;
        return isLetterNeeded(c, str2.substring(1));
    }


    public static int countTriplets(int[] arr, int num) {

        int ans = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                if (arr[i] + arr[j] + arr[k] >= num) {
                    k--;
                } else {
                    ans += (k - j);
                    j++;
                }
            }
        }
        return ans;
    }

    public static int what(Node node) {
        int x = 0;
        int y = 0;
        if (node.getLeftSon() != null)
            x = what(node.getLeftSon());
        if (node.getRightSon() != null)
            y = what(node.getRightSon());
        if (x > y)
            return (node.getNumber() + x);
        else
            return (node.getNumber() + y);
    }

    public static class Node {
        private int _number;
        private Node _leftSon, _rightSon;

        public Node(int num) {
            _number = num;
            _leftSon = null;
            _rightSon = null;
        }

        public int getNumber() {
            return _number;
        }

        public void setNumber(int number) {
            _number = number;
        }

        public Node getLeftSon() {
            return _leftSon;
        }

        public void setLeftSon(Node node) {
            _leftSon = node;
        }

        public Node getRightSon() {
            return _rightSon;
        }

        public void setRightSon(Node node) {
            _rightSon = node;
        }
    }
}
