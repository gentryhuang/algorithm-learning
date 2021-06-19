package com.code.al.base;

import static com.code.al.base.common.SortTool.swap;

/**
 * BubbleSort
 *
 * desc：冒泡排序
 * 1 时间复杂度 O(N^2)，额外空间复杂度 O(1)
 * 2 稳定性：稳定
 * 3 步骤：
 * 3.1 从 0 位置开始两两比较，如果第一个比第二个大，就交换它们两个，否则不交换。
 * 3.2 直到每一对相邻元素比较完成，最后的元素就是最大值即当前趟的最大值。
 * 3.3 除了最后一个元素外，针对所有的元素重复以上步骤；
 * 3.4 随着比较趟数的增加，每趟需要两两比较的次数就越少，直到没有任何一对元素需要比较；
 * 4 举例：
 * 1) 0 ～ end（ 放好 end 位置）
 * 2) 0 ～ end -1 （放好 end-1 位置）
 * 3) 0 ～ end -2 （放好 end-2 位置）
 * ...
 * 0 ～ 1 （放好 1 位置结束）
 */
public class BubbleSort {

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 比较多少趟（比较多少对）
        for (int end = arr.length - 1; end >= 1; end--) {
            // 每趟比较的次数: 0 ~ end
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }


}
