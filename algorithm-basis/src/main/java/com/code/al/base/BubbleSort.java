package com.code.al.base;

import static com.code.al.base.common.SortTool.swap;

/**
 * BubbleSort
 * <p>
 * desc：冒泡排序
 * 1 时间复杂度 O(N^2)，额外空间复杂度 O(1)
 * 2 稳定性：稳定
 * 3 思想：
 * 3.1 确定比较的回合数，也就是 N-1 趟比较。
 * 3.2 确定每一回合比较的次数，也就是 N -1 次。
 * 3.3 注意，每一轮回合下来都会排好一个数。由于排好的数无需参与比较，因此随着回合数增加，对应的比较次数也在降低，直到最后一回合比较一次。
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

        // 比较多少趟 end
        for (int end = arr.length - 1; end >= 1; end--) {
            // 每趟比较的次数: end
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    /**
     * 冒泡排序优化
     *
     * @param arr
     */
    public static void bubbleSortOptimization(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 比较多少趟 end
        for (int end = arr.length - 1; end >= 1; end--) {

            // 有序标记，如果存在一回合没有进行元素交换，那么说明已经是有顺的了
            boolean isSorted = true;

            // 每趟比较的次数: end
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    // 还是非有序序列
                    isSorted = false;
                }
            }

            // 已经是有序的了，直接结束
            if (isSorted) {
                break;
            }
        }
    }


}
