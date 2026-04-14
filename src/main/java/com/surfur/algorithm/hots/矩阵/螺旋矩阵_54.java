package com.surfur.algorithm.hots.矩阵;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵_54 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int u = 0, d = m - 1, l = 0, r = n - 1;
        while (true) {
            for (int i = l; i <= r; i++) {
                result.add(matrix[u][i]);
            }
            if (++u > d) {
                break;
            }
            for (int i = u; i <= d; i++) {
                result.add(matrix[i][r]);
            }
            if (--r < l) {
                break;
            }
            for (int i = r; i >= l; i--) {
                result.add(matrix[d][i]);
            }
            if (--d < u) {
                break;
            }
            for (int i = d; i >= u; i--) {
                result.add(matrix[i][l]);
            }
            if (++l > r) {
                break;
            }
        }
        return result;
    }
}
