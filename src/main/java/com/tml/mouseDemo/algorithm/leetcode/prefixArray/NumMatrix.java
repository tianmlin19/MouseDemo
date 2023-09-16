package com.tml.mouseDemo.algorithm.leetcode.prefixArray;

public class NumMatrix {

    /**
     * 记录当前点到原点的总和
     */
    private int[][] prefixNum = null;

    public NumMatrix(int[][] matrix) {
        prefixNum = new int[matrix.length][matrix[0].length];
        for (int i = 1; i < matrix.length; i++) {
            int[] cols = matrix[i];
            for (int j = 1; j < cols.length; j++) {
                prefixNum[i][j] = prefixNum[i - 1][j] + prefixNum[i][j - 1] + matrix[i - 1][j - 1] - prefixNum[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixNum[row2+1 ][col2 +1] - prefixNum[row2 + 1][col1 + 1] - prefixNum[row1 + 1][col2 + 1] + prefixNum[row1 + 1][col1 + 1];

    }
}
