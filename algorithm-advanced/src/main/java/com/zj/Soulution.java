package com.zj;

/**
 * Soulution
 *
 * @author hlb
 */
public class Soulution {

    public boolean Find(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int low = 0;
            int high = array[i].length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (target > array[i][mid]) {
                    low = mid + 1;
                } else if (target < array[i][mid]) {
                    high = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}

class SolutionT {
    public boolean Find(int target, int[][] array) {
        int row = array.length - 1;
        int col = 0;
        while (row >= 0 && col < array[row].length) {
            if (target < array[row][col]) {
                row--;
            } else if (target > array[row][col]) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }
}

