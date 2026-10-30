public class Recursion2 {
    public static void main(String args[]) {
        int[] numbers = { -25, -6, 0, 23, 37, 50 };
        int total = recSum(numbers, numbers.length);
        System.out.printf("Total in array: %d%n", total);
        int n = 7;
        System.out.printf("Fib(%d) = %d%n", n, fib(n));
        System.out.printf("Index of %d: %d%n", 23, recBinarySearch(numbers, 99));

        int[] numbers2 = { 2, 7, 10, 17 };
        int target = 17;
        int pos = countNumbers(numbers2, target, 0, numbers2.length - 1);
        System.out.printf("%d was found %d time(s)%n", target, pos);
    }

    public static int recSum(int[] listOfNums, int listLen) {
        if (listLen <= 0) {
            return 0;
        }
        return listOfNums[listLen - 1] + recSum(listOfNums, listLen - 1);
    }

    public static int fib(int n) {
        if (n <= 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int recBinarySearch(int[] nums, int target) {
        return binSearchHelper(nums, target, 0, nums.length - 1);
    }

    public static int binSearchHelper(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2; // Int division
        if (nums[mid] == target) {
            return mid;
        }
        if (target < nums[mid]) {
            return binSearchHelper(nums, target, left, mid - 1);
        }
        return binSearchHelper(nums, target, mid + 1, right);
    }

    public static int countNumbers(int[] nums, int targetNum, int left, int right) {
        if (left > right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int count = 0;
        if (nums[mid] == targetNum) {
            count = 1;
        }
        return count + countNumbers(nums, targetNum, left, mid - 1) + countNumbers(nums, targetNum, mid + 1, right);
    }
}
