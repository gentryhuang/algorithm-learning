package com.code.al.base.sort.quick;

import static com.code.al.base.common.SortTool.swap;

/**
 * QuickSort
 * <p>
 * desc：快速排序优化
 * 经典排序问题缺陷：
 * 每一轮都只能确定好一个位置，也就是基准元素，即使出现和基准元素相等元素，在下一轮仍然需要参与 partition 。
 * 快速排序优化，是在经典排序的基础上将区间分为三个部分：小于基准元素、等于基准元素、大于基准元素。这样对于相等的基准元素就不需要再参与 partition 。
 * 说明：
 * 1 事实上快速排序一般明显比其他 O(NlogN)算法更快，因为它的内部循环可以在大部分的架构上很有效率地被实现出来。
 * 2 快速排序使用分治法
 * 时间复杂度：
 *  - 时间复杂度 O(NlogN)
 * 额外空间复杂度
 * - 最低为 O(logN)，高一点为 O(N)
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
        // 终止条件，必须满足 l < r
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

    /**
     *
     * @param arr
     * @param l
     * @param r
     * @return 和基准元素相等元素区域的左边界下标和右边界下标。注意，当没有相等的基准元素时，返回的两个值是一样的，这样就回到了经典排序。
     */
    public static int[] partition(int[] arr, int l, int r) {

        // 基于元素
        int pivot = arr[r];

        // 代表小于基准元素的区域边界，初始值为 l-1
        int less = l - 1;

        // 代表大于基准元素的区域边界，初始值为 r （正常情况应该是 r + 1，但是这里选择了最后一个元素作为划分标准，因此要特殊处理）
        // 注意，由于选择了 r 对应的元素作为基准元素，因此不能让他参与划分，这里巧妙的直接将它划分到 more 区域，最后再通过交换让 r 对应的元素归位，
        // 也就划分成了 小于基准元素、等于基准元素、大于基准元素
        int more = r;

        // 从序列左边 l 开始向右遍历元素，直到和 more 重合
        while (l < more) {

            // 小于的时候交换完毕 l 需要 ++ ，因为交换后的值是小于或等于基准元素，因此不需要考虑大于的情况
            if (arr[l] < pivot) {
                swap(arr, ++less, l++);

                // 大于的时候交换完毕 l 不能 ++，因为从 --more 位置交换过来的元素大小未知，因为需要再次处理小于或等于的情况
            } else if (arr[l] > pivot) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }

        // 将基准元素归位
        swap(arr, more, r);

        // 基准元素区域的左右小标，当没有相同的基准元素时，两者相同。
        return new int[]{less + 1, more};
    }

}
