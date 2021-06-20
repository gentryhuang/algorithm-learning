package com.code.al.base.sort.quick;

public class Quicksort2 {
    public static void sort(int[] arr) {
        msort(arr, 0, arr.length - 1);
    }

    private static void msort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = findPivotIndex(arr, left, right);
            msort(arr, left, pivotIndex - 1);
            msort(arr, pivotIndex + 1, right);
        }

    }

    private static int findPivotIndex(int[] arr, int left, int right) {
        int pivot = arr[right];
        int less = left-1;
        int more = right;
        while (left < more) {
            if(arr[left] < pivot){
                swap(arr,++less,left++);
            }else if(arr[left] >= pivot){
                swap(arr,left,--more);
            }else {
                left++;
            }
        }
        swap(arr,more,right);

        return more;
    }

    private static void swap(int[] arr, int left, int right) {
        int tem = arr[left];
        arr[left] = arr[right];
        arr[right] = tem;
    }


    public static void main(String[] args) {
        int[] integers = {2, 1, 4, 7, 9, 23, 4, 5, 6, 8, 2, 1};
        int[] integers2 = {2};
        sort(integers);
        for (int i = 0; i < integers.length; i++) {
            System.out.print(integers[i] + ",");
        }
        System.out.println("");
        sort(integers2);
        for (int i = 0; i < integers2.length; i++) {
            System.out.print(integers2[i] + ",");
        }
    }
}