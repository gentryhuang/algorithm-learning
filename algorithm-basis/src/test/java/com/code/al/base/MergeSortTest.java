package com.code.al.base;

import com.code.al.base.common.SortTool;
import com.code.al.base.sort.merge.MergeSort;

/**
 * MergeSortTest
 */
public class MergeSortTest {
    public static void main(String[] args) {
        int testCount = 5000;
        int maxSize = 100;
        int maxValue = 10;
        boolean succeed = true;
        for (int i = 0; i < testCount; i++) {
            int[] arr1 = SortTool.generateRandomArray(maxSize, maxValue);
            int[] arr2 = SortTool.copyArray(arr1);
            MergeSort.mergeSort(arr1);
            SortTool.comparator(arr2);
            if (!SortTool.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = SortTool.generateRandomArray(maxSize, maxValue);
        SortTool.printArray(arr);
        MergeSort.mergeSort(arr);
        SortTool.printArray(arr);
    }
}
