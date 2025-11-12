import java.util.*;  // optional — useful if you later use Arrays.sort or PriorityQueue

class Solution {

    public static int kthSmallest(int[][] mat, int n, int k) {
        // Step 1: Create a 1D array to store all elements of the matrix
        int arr[] = new int[n * n];
        int index = 0;

        // Step 2: Copy all elements from the 2D matrix into 1D array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[index++] = mat[i][j];
            }
        }

        // Step 3: Selection Sort the array
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {  
                    min = j;
                }
            }

            // Swap arr[i] and arr[min]
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        // Step 4: Return the k-th smallest element
        return arr[k - 1];
    }

    // Optional main method to test your code
    public static void main(String[] args) {
        int[][] mat = {
            {16, 28, 60, 64},
            {22, 41, 63, 91},
            {27, 50, 87, 93},
            {36, 78, 87, 94}
        };
        int n = 4, k = 3;

        System.out.println("Kth smallest element is: " + kthSmallest(mat, n, k));
    }
}
