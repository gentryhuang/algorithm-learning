package com.code.al.base;

import static com.code.al.base.common.SortTool.swap;

/**
 * QuickSort
 * <p>
 * desc：快速排序
 * 说明：
 * 1 事实上快速排序一般明显比其他 O(NlogN)算法更快，因为它的内部循环可以在大部分的架构上很有效率地被实现出来。
 * 2 快速排序使用分治法
 * 时间复杂度：
 * 时间复杂度 O(NlogN)，额外空间复杂度最低为 O(logN)，高一点为 O(N)[用来记录左右断点位置]
 * 稳定性：
 * 常规实现做不到稳定性，论文级别可以
 * 3 步骤：
 */
public class QuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        // 终止条件
        if (l < r) {
            /*
             * 随机选择一个数和最后一个数进行交换，再按照最后一个数作为划分值。
             * 这样的话可以使排序的最差和最好是个随机事件，即事件复杂度 O(NlogN)。
             */
            int targetIndex = l + (int) (Math.random() * (r - l + 1));
            swap(arr, targetIndex, r);

            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }

        swap(arr, more, r);

        return new int[]{less + 1, more};
    }

}
