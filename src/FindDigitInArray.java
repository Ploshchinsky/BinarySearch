import java.util.Arrays;

/*
 * Find Digit in Array
 *
 * A classic task for practicing binary search.
 * An array of numbers N is given. Need to check number K inside the array?
 *
 * */
public class FindDigitInArray {
    public static void main(String[] args) {
        int[] n = {0, 0, 2, 4, 5, 8, 8, 9, 11, 15, 17, 22};
        int[] k = {8, 7, 22, 0, 23, -1};
        int[] empty = {};

        System.out.println("Array - " + Arrays.toString(n));
        for (int i = 0; i < k.length; i++) {
            System.out.println("\tDigit [" + k[i] + "] in array? - "
                    + binarySearch(n, k[i]));
        }
    }

    private static boolean binarySearch(int[] array, int target) {
        if (array == null || array.length < 1) {
            return false;
        }

        int min = 0;
        int max = array.length - 1;

        do {
            int cursor = (min + max + 1) / 2;
            if (array[cursor] == target) {
                return true;
            } else if (array[cursor] > target) {
                max = cursor - 1;
            } else {
                min = cursor;
            }
        } while (min < max);
        return array[min] == target;
    }
}
