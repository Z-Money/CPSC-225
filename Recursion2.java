public class Recursion2 {
    public static void main(String args[]) {
        int[] numbers = { -25, -6, 0, 23, 37, 50 };
        int total = recSum(numbers, numbers.length);
        System.out.printf("Total in array: %d%n", total);
        int n = 7;
        System.out.printf("Fib(%d) = %d%n", n, fib(n));
        System.out.printf("Index of %d: %d", 23, recBinarySearch(numbers, 99));
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
}
