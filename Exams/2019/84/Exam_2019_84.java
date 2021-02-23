public class Exam_2019_84 {
    public static void main(String[] args) {
        System.out.println(sumPower3(27));
        int[] arr = {5, 7, -2, 10};
        System.out.println(average(arr));
        Node T = new Node(60);

    }

    public static boolean sumPower3(int num) {
        return sumPower3(num, 0);
    }

    private static boolean sumPower3(int num, int pow) {
        int currentValue = (int) Math.pow(3, pow);
        if (num == 0)
            return true;
        if (currentValue > num)
            return false;
        return sumPower3(num - currentValue, pow + 1) || sumPower3(num, pow + 1);
    }

    public static int average(int[] arr) {
        int i = 0;
        int indexToSave = 0;
        int leftSum = arr[i], rightSum = 0;
        for (i = 1; i < arr.length; i++)
            rightSum += arr[i];
        int maxDiff = Math.abs((rightSum / (i - 1)) - leftSum);
        for (int j = 1; j < arr.length - 1; j++) {
            leftSum += arr[j];
            rightSum -= arr[j];
            int rightAvg = (rightSum / (i - j - 1));
            int leftAvg = (leftSum / (j + 1));
            int currentDiff = Math.abs(rightAvg - leftAvg);
            if (currentDiff > maxDiff) {
                indexToSave = j;
                maxDiff = currentDiff;
            }
        }
        return indexToSave;
    }
}

class Node {
    private int _number;
    private Node _leftSon, _rightSon;

    public Node(int number) {
        _number = number;
    }

    public int getNumber() {
        return _number;
    }

    public Node getLeftSon() {
        return _leftSon;
    }

    public Node getRightSon() {
        return _rightSon;
    }
}

