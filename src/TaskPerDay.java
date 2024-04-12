import java.util.Arrays;
/*
* Task Per Day
*
* Objective: to solve N tasks. On the first day we solve K tasks.
* Each new day is one task more (K+1).
*
* Find: Minimum number of days required to solve N tasks
*
* */
public class TaskPerDay {
    public static void main(String[] args) {
        int n = 21;
        int k = 2;
        long start = System.currentTimeMillis();
        System.out.print("Recursive method : " + recursive(n, k, 0) + " - ");
        System.out.print(System.currentTimeMillis() - start + " ms\n");

        start = System.currentTimeMillis();
        System.out.print("Cycle method : " + cycle(n, k) + " - ");
        System.out.print(System.currentTimeMillis() - start + " ms\n");

        start = System.currentTimeMillis();
        System.out.print("Binary method : " + binarySearch(n, k) + " - ");
        System.out.print(System.currentTimeMillis() - start + " ms\n");
    }

    private static int recursive(int targetTasks, int currentTasks, int acc) {
        int days = -1;
        if (currentTasks == targetTasks) {
            return 1;
        } else if (acc < targetTasks) {
            acc += currentTasks;
            days = recursive(targetTasks, currentTasks + 1, acc);
        }
        return ++days;
    }

    private static int cycle(int targetTasks, int currentTasks) {
        int solvedTasks = 0;
        int days = 0;
        while (solvedTasks < targetTasks) {
            days++;
            solvedTasks += currentTasks;
            currentTasks++;
        }
        return days;
    }

    private static int binarySearch(int targetTasks, int currentTasks) {
        int min = 0, max = targetTasks;
        int cursor, solvedTasks;

        while (min < max) {
            cursor = min + (max - min) / 2;
            solvedTasks = checkTaskAmount(cursor, currentTasks);
            if (solvedTasks > targetTasks) {
                max = cursor;
            } else if (solvedTasks < targetTasks) {
                min = cursor + 1;
            }
        }

        return min;
    }

    private static int checkTaskAmount(int days, int param) {
        return (param + (param + days - 1) * days) / 2;
    }
}
