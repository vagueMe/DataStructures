package com.atguigu.sort;

import java.util.Arrays;

/**
 * @author hudi
 * @date 2022/10/19 15:55
 */
public class SelectSort {
    public static void main(String[] args) {
        /*int arr[] = {3,9,-1,10,20};
        sort(arr);
        System.out.println(Arrays.toString(arr));*/

        int arr[] = new int[88888];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*88888);
        }


        long l = System.currentTimeMillis();
        sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("耗时:" + (System.currentTimeMillis() - l)/1000);// 约耗时1-2s

    }

    /**
     * 选择排序法。每轮循环定义一个临时变量坐标。将最小值给的坐标给该变量值(一轮循环结束后，才开始交换)。
     *      第一轮循环，从第一个元素开始，将临时变量与数组元素比较。比较n次，保持临时变量为最小值。
     *          第一轮循环结束后，将最小值给第一个元素(一轮循环结束后，才开始交换)。
     *      第二轮循环，从第二个元素开始，将最小值给临时变量，比较n-1次（第一个最小没必要比较）。
     *      。。。
     *      第n-1轮结束后，第n轮，从n元素开始，即最后一个元素，那就不用比较了
     * @param arr
     */
    public static void sort(int[] arr){
        int index;
        int temp;
        for (int i = 0; i < arr.length-1; i++) {
            index = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    index = j;
                }
            }
            if(i != index){
                temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }
}
