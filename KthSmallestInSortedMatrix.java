import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {
    // Helper class to store cell position and value
    static class Cell implements Comparable<Cell> {
        int val, row, col;
        public Cell(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
        public int compareTo(Cell other) {
            return Integer.compare(this.val, other.val);
        }
    }

    /**
     * Finds the kth smallest element in a sorted N x N matrix.
     * @param mat The N x N matrix, each row and column sorted in non-decreasing order.
     * @param N Size of the matrix.
     * @param K Position to find (1-based).
     * @return The Kth smallest element.
     */
    public static int kthSmallest(int[][] mat, int N, int K) {
        // Min heap
        PriorityQueue<Cell> minHeap = new PriorityQueue<>();

        // Insert the first element of each row into heap
        for (int i = 0; i < N; i++) {
            minHeap.offer(new Cell(mat[i][0], i, 0));
        }

        // Remove smallest from min heap K-1 times
        Cell curr = null;
        for (int i = 0; i < K; i++) {
            curr = minHeap.poll();
            // Insert next element from the same row
            if (curr.col + 1 < N) {
                minHeap.offer(new Cell(mat[curr.row][curr.col + 1], curr.row, curr.col + 1));
            }
        }
        // Kth extraction
        return curr.val;
    }

    // You can test the function below
    public static void main(String[] args) {
        int[][] mat1 = {
            {16, 28, 60, 64},
            {22, 41, 63, 91},
            {27, 50, 87, 93},
            {36, 78, 87, 94}
        };
        System.out.println(kthSmallest(mat1, 4, 3)); // Output: 27

        int[][] mat2 = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {24, 29, 37, 48},
            {32, 33, 39, 50}
        };
        System.out.println(kthSmallest(mat2, 4, 7)); // Output: 30
    }
}