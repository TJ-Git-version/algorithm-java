package com.surfur.algorithm.hots.矩阵;

import java.util.*;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * <p>
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 */
public class 矩阵置零_73 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] matrix2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix2);
        System.out.println();
    }

    public static void setZeroes(int[][] matrix) {
        Map<Integer, List<Integer>> matrixMap = new HashMap<>();
        for (int row = 0; row < matrix.length; row++) {
            // row 行
            boolean flag = false;
            for (int cell = 0; cell < matrix[row].length; cell++) {
                // cell 列
                if (matrix[row][cell] == 0) {
                    flag = true;
                    matrixMap.putIfAbsent(row, new ArrayList<>());
                    matrixMap.get(row).add(cell);
                }
                if (flag && cell == matrix[row].length - 1) {
                    Arrays.fill(matrix[row], 0);
                }
            }
        }
        if (matrixMap.isEmpty()) {
            return;
        }
        List<Integer> cells = new ArrayList<>();
        matrixMap.forEach((k, v) -> {
            cells.addAll(v);
        });
        if (cells.isEmpty()) {
            return;
        }
        for (int row = 0; row < matrix.length; row++) {
            if (matrixMap.containsKey(row)) {
                continue;
            }
            // row 行
            for (int cell = 0; cell < matrix[row].length; cell++) {
                // cell 列
                if (cells.contains(cell)) {
                    matrix[row][cell] = 0;
                }
            }
        }
    }
}
