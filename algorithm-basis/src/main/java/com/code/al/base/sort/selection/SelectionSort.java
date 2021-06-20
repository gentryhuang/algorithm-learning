package com.code.al.base.sort.selection;

import static com.code.al.base.common.SortTool.swap;

/**
 * SelectionSort
 *
 * desc：选择排序
 * 1 时间复杂度 O(N^2)，额外空间复杂度 O(1)
 * 2 稳定性：稳定
 * 3 步骤：
 * 3.1 从 0 ~ N-1 范围，找一个最小的放到 0 位置
 * 3.2 从 1 ~ N-1 范围，找一个最小的放到 1 位置
 * ...
 * 从 N-2 ~ N-1 范围，找一个最小的放到 N-2 位置
 * 4 步骤说明：
 * - 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 * - 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * - 重复第二步，直到所有元素均排序完毕
 */
public class SelectionSort {

    /**
     * 选择排序
     *
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 外层循环 i 作为已排序序列的末尾，初始该序列为空
        for (int i = 0; i < arr.length - 1; i++) {
            // 寻找 [i,N) 区间里的最小值
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 记录小值的下标（也可以大值，这样就倒序排序）
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

}
