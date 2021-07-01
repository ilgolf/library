import java.util.*;

class Solution {

    private static int[][] matrix;

    static int rotate(int[] query) {
        int r1 = query[0] - 1;
        int c1 = query[1] - 1;
        int r2 = query[2] - 1;
        int c2 = query[3] - 1;

        int temp = matrix[r1][c1];
        int min = temp;
        for(int i=r1; i<r2; i++) {
            matrix[i][c1] = matrix[i + 1][c1];
            if(min > matrix[i][c1]) min = matrix[i][c1];
        }

        for(int i=c1; i<c2; i++) {
            matrix[r2][i] = matrix[r2][i + 1];
            if(min > matrix[r2][i]) min = matrix[r2][i];
        }

        for(int i=r2; i>r1; i--) {
            matrix[i][c2] = matrix[i - 1][c2];
            if(min > matrix[i][c2]) min = matrix[i][c2];
        }

        for(int i=c2; i>c1; i--) {
            matrix[r1][i] = matrix[r1][i - 1];
            if(min > matrix[r1][i]) min = matrix[r1][i];
        }

        matrix[r1][c1 + 1] = temp;

        return min;
    }

    public static int[] solution(int rows, int cols, int[][] queries) {
        int[] answer = new int[queries.length];
        matrix = new int[rows][cols];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                matrix[i][j] = i * cols + j + 1;
            }
        }

        for(int i=0; i<queries.length; i++) {
            answer[i] = rotate(queries[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        int rows = 6;
        int cols = 6;

        int[][] queries = { {2,2,5,4}, {3,3,6,6}, {5,1,6,3} };

        System.out.println(Arrays.toString(solution(rows, cols, queries)));

    }
}