/*
 * Council Numbers
 *
 * A school council has N people and K of them are parents.
 * What is the minimum number of K parents
 * to add to make them 1\3 of the total number of parents?
 *
 * */
public class CouncilNumbers {
    public static void main(String[] args) {
        int N = 28;
        int K = 5;
        long start = System.currentTimeMillis();
        System.out.print("Parents += " + binarySearch(N, K) + " - ");
        System.out.println(System.currentTimeMillis() - start + " ms");
    }

    private static int binarySearch(int allNumbers, int parents) {
        int target = allNumbers / 3 + 1;
        if (parents < target) {
            return binarySearch(allNumbers + 1, parents + 1);
        }
        return parents;
    }
}
