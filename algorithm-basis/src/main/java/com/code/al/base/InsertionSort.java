package com.code.al.base;

import static com.code.al.base.common.SortTool.swap;

/**
 * InsertionSort
 *
 * desc：插入排序
 * 1 时间复杂度 O(N^2)，最优的复杂度O(N)(有序)，额外空间复杂度 O(1)
 * 2 稳定性：稳定
 *
 */
public class InsertionSort {
   public static void insertionSort(int[] arr){
       if (arr == null || arr.length < 2){
           return;
       }

       // 未排序的序列（0 位置认为已排序）
       for (int i = 1; i < arr.length;i ++){
           // 依次和已排序的比较
           for (int j = i -1;j >= 0 && arr[j] > arr[j+1];j--){
               swap(arr,j,j+1);
           }
       }
   }
}
