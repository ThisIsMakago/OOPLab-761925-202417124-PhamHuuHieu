public class AddMatrices {
  
    public static void main(String[] args) {
      
        int[][] matrix1 = { {1, 2, 3}, {2, 4, 3}, {3, 6, 9} };
        int[][] matrix2 = { {2, 3, 4}, {5, 4, 1}, {1, 3, 5} };
        int row = matrix1.length;
        int column = matrix1[0].length;
        int[][] sum = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        System.out.println("Sum of the two matrices:");
        for (int[] i : sum) {
            for (int element : i) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
      
    }
  
}
