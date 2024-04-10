import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {
    private static int[] arr = {0, 5, 4, 11, 2, 0, 0, 5, 4};
    private static int target = 11;

    public static void main(String[] args) {
        testCase();
    }

    private static boolean binarySearch(int[] array, int target) {
        Arrays.sort(array);
        if (array.length <= 1) {
            return target == array[0];
        }
        if (target == array[array.length / 2]) {
            return true;
        } else if (target < array[array.length / 2]) {
            return binarySearch(Arrays.copyOfRange(array, 0, array.length / 2), target);
        } else if (target > array[array.length / 2]) {
            return binarySearch(Arrays.copyOfRange(array, array.length / 2 + 1, array.length), target);
        }
        return false;
    }

    private static void testCase() {
        for (int i = 0; i < 50; i++) {
            target = new Random().nextInt(11) + 1;
            if (binarySearch(arr, target)) {
                System.out.println(binarySearch(arr, target)
                        ? "Array [" + Arrays.toString(arr) + "] contain [" + target + "]"
                        : "Array [" + Arrays.toString(arr) + "] not contain [" + target + "]");
            }
        }
    }
}