package com.atguigu.sort;

import java.util.Arrays;

/**
 * @author hudi
 * @date 2022/10/20 11:10
 */
public class SellSort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
//        sortChange(arr);
        sortInsert(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 希尔排序（交换法）：
     *   将总长每次按 n= n/2 组件分组（10，分5组（组中的元素步长5），分2组（组中的元素步长2），分1组（组中的元素步长1）），分组。将每一组的数据进行插入排序。
     *   针对每一组数据都进行插入排序，每组开始都为首位两部分（开始首只有一个，其余为尾部），首为有序，尾为无序。
     *      差用插入排序（但是和之前说的正统插入的步移不一样，这里是用的交换的方式）
     *
     *
     * @param arr
     */
    public static void sortChange(int[] arr){
        int temp;
        for (int gap = arr.length /2 ; gap > 0; gap=gap/2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j-=gap) {
                    if(arr[j] > arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }else{
                        break;
                    }
                }
            }
        }

    }

    public static void sortInsert(int[] arr){
        int temp;
        int index;
        for (int gap = arr.length /2 ; gap > 0; gap=gap/2) {
            for (int i = gap; i < arr.length; i++) {
                if(arr[i] >= arr[i-gap]){
                    continue;
                }
                index = i;
                temp = arr[i];
                for (int j = i - gap; j >= 0; j -= gap) {
                    if(arr[j] > arr[j+gap]){
                        arr[j+gap] = arr[j];
                        index = j;
                    }
                }
                arr[index] = temp;
            }
            System.out.println(Arrays.toString(arr));
        }

    }
}
