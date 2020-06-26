package dynamic;

public class Main {
    public int uniquePaths(int[][] obstacles) {
        int n = obstacles.length;
        int m = obstacles[0].length;

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacles[i][j] == 1) {
                    matrix[i][j] = 0;
                    continue;
                }

                if (i == 0) {
                    matrix[i][j] = j > 0 ? matrix[i][j - 1] : 1;
                } else if (j == 0) {
                    matrix[i][j] = i > 0 ? matrix[i - 1][j] : 1;
                } else {
                    matrix[i][j] = matrix[i][j - 1] + matrix[i - 1][j];
                }
            }
        }

        return matrix[n - 1][m - 1];
    }
    // модифицировать прямо текущую матрицу с весами (не заводить новую)
    public int minPathSum(int[][] weights) {
        int n = weights.length;
        int m = weights[0].length;

        for (int j = 1; j < m; j++) {
            weights[0][j] = weights[0][j - 1] + weights[0][j];
        }

        for (int i = 1; i < n; i++) {
            weights[i][0] = weights[i - 1][0] + weights[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                weights[i][j] = Math.min(weights[i - 1][j], weights[i][j - 1]) + weights[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(weights[i][j] + " ");
            }

            System.out.println();
        }

        return weights[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] weights = {{1, 3, 1}, { 1,5,1 }, {4, 2, 1} };
        System.out.println(new Main().minPathSum(weights));
    }
}
