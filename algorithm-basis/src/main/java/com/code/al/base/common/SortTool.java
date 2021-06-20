package com.code.al.base.common;

import java.util.Arrays;

/**
 * SortTool
 *
 * desc：对数器
 * 1 存在一个要测试的方法
 * 2 实现一个和要测试的方法功能一致的绝对正确的方法
 * 3 实现一个随机样本产生器，用来生成测试数据
 * 4 实现一个比对方法，用来比对测试方法和绝对正确方法的执行结果
 * 5 多次测试、比对，判断测试的方法正确性
 * 6 当样本数量很多时，比对测试依然正确，那么可以确定要测试的方法已经正确
 */
public class SortTool {
    /**
     * 绝对正确的方法
     * <p>
     * System 排序
     *
     * @param arr
     */
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 随机样本产生器
     *
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // Math.random(): [0,1)
        // (int) ((maxSize + 1) * Math.random()) : [0,maxSize]
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    /**
     * 比对方法
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) ||
                (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }


    /* -------------------------------------------------------------------------------------- */

    /**
     * 交换位置
     *
     * @param arr 数组
     * @param i   下标
     * @param j   下标
     */
    public static void swap(int[] arr, int i, int j) {
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 拷贝数组
     *
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }

        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }

        return res;
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // random() -> [0,1)
        System.out.println((int) Math.random());
    }

}
