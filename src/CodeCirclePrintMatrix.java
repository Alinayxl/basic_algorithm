package src;

/**
 * 例如：
 * 1   2   3   4
 * 5   6   7   8
 * 9   10 11 12
 * 13 14 15 16
 * 打印结果为：1，2，3，4，8，12，16，15，14，13，9，5，6，7，11， 10。
 * 要求额外空间复杂度为O(1)。
 */
public class CodeCirclePrintMatrix {
    public static void CirclePrintMatrix(int[][] matrix){
        int a = 0, b = 0;
        int c = matrix.length - 1;  //行数
        int d = matrix[0].length - 1;  //列数
        while (a <= c && b <= d) {   //顺时针打印矩阵周边的数字
            print(matrix, a++, b++, c--, d--);
        }
    }

    public static void print(int[][] matrix, int a, int b, int c, int d) {
        if (a == c) {
            System.out.print(matrix[a][b++] + " ");
        } else if (b == d) {
            System.out.print(matrix[a++][b] + " ");
        } else {
            int rowIndex = a;
            int columnIndex = b;
            while (columnIndex != d) {
                System.out.print(matrix[rowIndex][columnIndex++] + " ");
            }
            while (rowIndex != c) {
                System.out.print(matrix[rowIndex++][columnIndex] + " ");
            }
            while (columnIndex != b) {
                System.out.print(matrix[rowIndex][columnIndex--] + " ");
            }
            while (rowIndex != a) {
                System.out.print(matrix[rowIndex--][columnIndex] + " ");
            }
        }
    }
    public static void main(String[] arg){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        CirclePrintMatrix(matrix);
    }
}

