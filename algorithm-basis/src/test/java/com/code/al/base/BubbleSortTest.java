package com.code.al.base;

import com.code.al.base.common.SortTool;
import com.code.al.base.sort.bubble.BubbleSort;

/**
 * BubbleSortTest
 */
public class BubbleSortTest {
    public static void main(String[] args) {
        int testCount = 5000;
        int maxSize = 10;
        int maxValue = 10;
        boolean succeed = true;
        for (int i = 0; i < testCount; i++) {
            int[] arr1 = SortTool.generateRandomArray(maxSize, maxValue);
            int[] arr2 = SortTool.copyArray(arr1);
            BubbleSort.bubbleSort(arr1);
            SortTool.comparator(arr2);
            if (!SortTool.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = SortTool.generateRandomArray(maxSize, maxValue);
        SortTool.printArray(arr);
        BubbleSort.bubbleSort(arr);
        SortTool.printArray(arr);
    }
}
