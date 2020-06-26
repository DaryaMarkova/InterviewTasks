package matrix;

import java.util.Arrays;

public class Main {
    public void rotate(int[][] matrix) {
        // transposing the matrix
        for (int i = 0; i< matrix.length; i++) {
            for(int j = i; j< matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // flip the matrix horizontally
        for (int i = 0 ; i<matrix.length; i++) {
            for (int j = 0; j< matrix.length / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        int dummy = Integer.MIN_VALUE; // replace on max element in array
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < cols; k++) {
                        if (matrix[i][k] != 0) {
                            matrix[i][k] = dummy;
                        }
                    }

                    for (int k = 0; k < rows; k++) {
                        if (matrix[k][j] != 0) {
                            matrix[k][j] = dummy;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == dummy) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
   }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;

        if (rows < 1) {
            return false;
        }

        int searchRow = rows - 1;

        for (int i = 0; i < rows - 1; i++) {
            if (matrix[i][0] <= target && target < matrix[i+1][0]) {
                searchRow = i;
                break;
            }
        }

        if (rows < 3 && target < matrix[searchRow][0]) {
            searchRow = 0;
        }

        // System.out.println("Search row " + searchRow);

        return Arrays.binarySearch(matrix[searchRow], 0, cols, target) >= 0;
    }

    public static void main(String[] args) {
//        int[][] matrix = {
//            {1, 3, 5, 7},
//            {10,11,16,20},
//            {23,30,34,50}
//        };
        int[][] matrix = {
            {1},
            {3}
        };
        System.out.println(new Main().searchMatrix(matrix, 1));
    }
}
