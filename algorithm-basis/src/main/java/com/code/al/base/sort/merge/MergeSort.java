package com.code.al.base.sort.merge;

/**
 * MergeSort
 * <p>
 * desc：归并排序
 * 1 时间复杂度 O(NlogN)，额外空间复杂度 O(N)
 * 2 稳定性：稳定
 * 3 思想：先左侧部分排好序，再右侧部分排好序，然后整体利用外排整理好。采用分治法的一个典型的应用。
 * 4 步骤：
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    public static void sortProcess(int[] arr, int l, int r) {
        // 终止条件，只有一个元素不需排序
        if (l == r) {
            return;
        }

        // l 和 r 中间位置
        int mid = l + ((r - l) >> 1);

        // 左边排好序
        // 极限左边只有一个元素
        sortProcess(arr, l, mid);

        // 右边排好序
        // 极限右边只有一个元素
        sortProcess(arr, mid + 1, r);

        // 将两边排好序的序列整合到一起
        merge(arr, l, mid, r);
    }

    /**
     * 将 [l ~ mid]  和 [mid+1 ~ r] 两个有序序列合并为一个有序序列
     * 过程：
     * 1 准备一个临时数组，用来存放合并后的序列
     * 2 比较两个指针对应的元素大小，小的放到临时数组中，并向后移动指针
     * 3 重复 2 步骤，直到其中一个指针走到末尾，然后将另一个序列剩余部分拷贝到临时数组即可（指针没有走完的前提下）
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    public static void merge(int[] arr, int l, int mid, int r) {
        // 辅助数组，用来存放合并后的序列（l~r 有多少个元素，就申请多大空间）
        int[] help = new int[r - l + 1];

        // 标记辅助数组已经填充元素的位置
        int i = 0;

        // 左侧有序序列指针，指向左侧有序序列最小值
        int p1 = l;

        //右侧有序序列指针，指向右侧有序序列最小值
        int p2 = mid + 1;

        // 谁小将谁填到辅助数组中，并移动指针
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        // 两个指针必有且只有一个越界
        // p1 没有越界，p2 越界了，那么只需把p1对应序列剩余的元素拷贝到辅助数组即可
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        // p2 没有越界，p1 越界了，那么只需把p2对应序列剩余的元素拷贝到辅助数组即可
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        // 把辅助数组中元素拷贝回原数组
        for (i = 0; i < help.length; i++) {
            // 这个 l 很关键，l 是两个有序序列的最小的下标。用于指定开始拷贝的位置
            arr[l + i] = help[i];
        }
    }

}
