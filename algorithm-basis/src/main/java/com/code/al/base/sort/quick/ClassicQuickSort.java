package com.code.al.base.sort.quick;

import static com.code.al.base.common.SortTool.swap;

/**
 * ClassicQuickSort
 * <p>
 * desc：经典快速排序
 * 说明：
 * 1 快速排序是从冒泡排序演变而来的，快速排序也属于交换排序，通过元素之间的比较和交换位置来达到排序的目的。
 * 2 冒泡排序在每一轮中只把 1 个元素冒泡到数列的一端，而快速排序则在每一轮挑选一个基准元素，并让 <= 它的元素移动到列表的一边，让 > 它的元素移动到另一端，从而把列表拆解成两个部分。
 * 3 在分治法的思想下，原列表在每一轮都被拆成两部分，每一部分又分别被拆成两部分，直到不可再分为止。
 * 时间复杂度：
 * - 平均时间复杂度：每一轮的比较和交换，需要把对应序列全部元素都遍历一遍，事件复杂度为 O(N)。假如有 M 个元素，那么平均需要 logM 轮。因此对应的平均时间复杂度为 O(NlogN)。
 * - 极端时间复杂度：如果基准元素的选择和序列数据状态关联，比如基准元素选择序列第1个元素，此时序列在有序或逆序的情况下，就需要 M 轮。因此对应的时间复杂度为 O(N^2)
 * - 基准元素 partition 过程在序列越中间越好
 * 额外空间复杂度
 * - 最低为 O(logN)：
 * - 高一点为 O(N)：如果选择的基准元素是最大或最小，就会出现 O(N)
 * 稳定性：
 * - 常规实现做不到稳定性，论文级别可以
 */
public class ClassicQuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        // 终止条件
        if (startIndex >= endIndex) {
            return;
        }

        /*
         * 1 随机选择一个数和第一个数进行交换，再按照最后一个数作为划分值。这样的话可以使排序的最差和最好是个随机事件，即事件复杂度 O(NlogN)
         * 2 即使是随机选择基准元素，也会有极小的几率选到序列的最大值或最小值，同样会影响分治的效果
         */
        int targetIndex = startIndex + (int) (Math.random() * (endIndex - startIndex + 1));
        swap(arr, targetIndex, startIndex);

        // 得到基准元素的位置(基准元素的左边 <= 基准元素，右边 > 基准元素)，注意等于的情况在哪边理论可以的
        int pivotIndex = partitionSingle(arr, startIndex, endIndex);

        // 根据基准元素，分成左右两部分进行递归排序
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    /**
     * 双边循环法
     * <p>
     * partition 方法实现了元素的交换，让序列中的元素依据自身大小，分别交换到基准元素的左右两边。注意，还需要最后一步交换基准元素。
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {

        // 基准元素
        int pivot = arr[startIndex];

        // 左指针
        int left = startIndex;

        // 右指针
        int right = endIndex;

        // 左右指针没有重合，就可以继续执行本轮逻辑
        while (left != right) {

            // 控制 right 指针比较并左移动(注意，需要先移动右指针，因为我们选择的基准元素在左边第一个)
            // 指针不重合 && 元素 > 基准元素
            while (left < right && arr[right] > pivot) {
                right--;
            }

            // 控制 left 指针比较并左移动
            // 指针不重合 && 元素 <= 基准元素
            while (left < right && arr[left] <= pivot) {
                left++;
            }

            // 两个指针都暂停，交换 left 和 right 指针所指向的元素
            if (left < right) {
                swap(arr, left, right);
            }
        }

        // 走到这里说明两个指针重合，元素遍历完毕。注意：是 right 指针去重合 left 指针
        // 此时就可以将 基准元素 pivot 和指针重合点元素交换，完成分割
        swap(arr, startIndex, left);

        // 返回基准位置
        return left;
    }

    /**
     * 单边循环法
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partitionSingle(int[] arr, int startIndex, int endIndex) {
        // 基准元素
        int pivot = arr[startIndex];

        // mark 指针，代表小于基准元素的区域边界 [startIndex,x]
        int mark = startIndex;

        // 从基准元素的下一个位置开始遍历序列
        // 1 如果遍历到元素 > 基准元素，不做任何操作，继续遍历
        // 2 如果遍历到元素 <= 基准元素，向右推进 mark ，因为小于等于基准元素的区域边界增大了 1 , 且 marK 指针对应元素 和 当前遍历到的元素交换，进而完成 mark 的推进进度
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                mark++;
                swap(arr, mark, i);
            }
        }

        // 走到这里说明元素遍历完毕，此时 mark 指向就是遍历过程的最后一个 <= 基准元素的下标。
        // 此时就可以将基准元素 pivot 和 mark 指针元素交换，完成分割
        swap(arr, startIndex, mark);

        // 返回基准位置
        return mark;
    }

}
