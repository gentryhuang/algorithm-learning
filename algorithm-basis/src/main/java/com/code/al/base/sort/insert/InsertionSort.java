package com.code.al.base.sort.insert;

import static com.code.al.base.common.SortTool.swap;

/**
 * InsertionSort
 * <p>
 * desc：插入排序
 * 1 时间复杂度 O(N^2)，最优的复杂度O(N)(有序)，额外空间复杂度 O(1)
 * 2 稳定性：稳定
 * 3 思想：类似打扑克牌，通过构建有序序列。对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 * 4 步骤：
 * 1）将待排序数组的第一个元素看做有序序列第一个元素，将第二个元素到最后一个元素当成未排序序列
 * 2）从头到尾依次扫描未排序序列，为扫描到的每个元素寻找合适的插入位置
 */
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 未排序的序列（0 位置认为已排序）
        for (int i = 1; i < arr.length; i++) {
            // 依次和已排序的比较，这里的 j 就是已经排序序列的某个位置，初始位置是有序序列末尾
            // 寻找待排序元素 arr[i] 合适的插入位置，大于已排序末尾元素 或 到达有序序列头则停止
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }


        /*
        // 未排序的序列（0 位置认为已排序）
        for (int i = 1; i < arr.length; i++) {

            // 寻找待排序元素 arr[i] 合适的插入位置
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
         */
    }
}
