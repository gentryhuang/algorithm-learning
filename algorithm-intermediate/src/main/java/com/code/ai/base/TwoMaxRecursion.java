package com.code.ai.base;

/**
 * TwoMaxRecursion
 * <p>
 * desc: 递归求左边部分最值、右边部分最值，最后求两部分的最值
 * 递归思想：
 * 递归函数是由系统栈处理的，一个函数调子过程之前会把自己相关现场信息压到栈中保存起来，子过程返回后取出栈中保存的父过程信息还原现场接着执行。
 */
public class TwoMaxRecursion {

    /**
     * 递归求一个数组中最大值
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int getMax(int[] arr, int left, int right) {

        // 终止条件，极限到二分后只有一个元素的时候不需要划分了，终止即可。
        if (left == right) {
            // 或 return arr[right];
            return arr[left];
        }

        // 二分中间位置
        int mid = (left + right) / 2;

        // 左边最大值
        // 极限只有一个元素
        int maxLeft = getMax(arr, left, mid);

        // 右边最大值
        // 极限只有一个元素
        int maxRight = getMax(arr, mid + 1, right);

        // 左右两边最大值
        // 极限情况：左边只有一个元素，右边只有一个元素
        return Math.max(maxLeft, maxRight);
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 10, 6, 9};
        System.out.println(getMax(arr, 0, arr.length - 1));
    }
}
