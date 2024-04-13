/*
 * Stickers On The Deck
 *
 * Given: A board with dimensions W x H centimeters.
 * There are N square stickers (with equal sides) on the board.
 *
 * Goal: Determine the minimum size of the post-its to fit on the board
 * */
public class StickersOnDeck {
    public static void main(String[] args) {
        int w = 4096;
        int h = 2048;
        int n = 8921;
        long start = System.currentTimeMillis();
        System.out.print("Size of stickers [binary] -  " + binarySearch(w, h, n) + " - ");
        System.out.println(System.currentTimeMillis() - start + " ms");
        start = System.currentTimeMillis();
        System.out.print("Size of stickers [cycle] -  " + cycleSearch(w, h, n) + " - ");
        System.out.println(System.currentTimeMillis() - start + " ms");
    }

    private static int binarySearch(int width, int height, int stickersAmount) {
        int min = 0;
        int max = Math.max(width, height);

        while (min != max) {
            int cursor = (min + max + 1) / 2;
            if (stickersCount(width, height, cursor) >= stickersAmount) {
                min = cursor;
            } else {
                max = cursor - 1;
            }
        }
        return max;
    }


    private static int stickersCount(int width, int height, int stickersSize) {
        int horizontalCount = height / stickersSize;
        int verticalCount = width / stickersSize;
        return horizontalCount * verticalCount;
    }

    private static int cycleSearch(int width, int height, int stickersAmount) {
        int size = 0;
        int stickersCount = 0;
        do {
            size++;
            stickersCount = (width / size) * (height / size);
        } while (stickersCount >= stickersAmount);

        return size;
    }

}
