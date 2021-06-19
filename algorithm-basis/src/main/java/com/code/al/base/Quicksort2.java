package com.code.al.base;

public class Quicksort2 {
    public static void sort(int[] arr) {
        msort(arr, 0, arr.length - 1);
    }

    private static void msort(int[] arr, int left, int right) {
        if (left < right) {
            return;
        }
        int pivotIndex = findPivotIndex(arr, left, right);
        msort(arr, left, pivotIndex - 1);
        msort(arr, pivotIndex + 1, right);
    }

    private static int findPivotIndex(int[] arr, int left, int right) {
        int pivotIndex = right;
        int pivot = arr[pivotIndex];
        left--;
        right++;
        while (true) {
            while (arr[++left] <= pivot && left <= right) ;
            while (arr[--right] > pivot && right >= left) ;
            if (left < right) {
                swap(arr, left, right);
            }
            break;
        }
        if (left > pivotIndex) {
            swap(arr, pivotIndex, left);
            pivotIndex = left;
        }
        return pivotIndex;
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