package com.atguigu.sort;

import java.util.Arrays;

/**
 * @author hudi
 * @date 2022/10/19 17:04
 */
public class InsertSort {
    public static void main(String[] args) {
        int arr[] = {-6,-9,3,9,-1,10,-2,4,8};
        sort(arr);
        System.out.println(Arrays.toString(arr));

//        int arr[] = new int[88888];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) (Math.random()*88888);
//        }
//
//
//        long l = System.currentTimeMillis();
//        sort(arr);
//        System.out.println(Arrays.toString(arr));
//        System.out.println("耗时:" + (System.currentTimeMillis() - l)/1000);// 约耗时2s


    }

    /**
     * 插入排序: 将一个数组看为首位两部分（开始首只有一个，尾有n-1个），首为有序，尾为无序。
     *          定义了临时变量，和临时坐标。循环从第二个元素开始，将该元素的坐标和值给与临时变量。
     *          当进行第k个元素时，临时变量为k的值，k的坐标，前k+1已经是有序的。将临时变量和第k-1个递减比较。
     *          如果临时变量比k-1的小，将第数组 arr[k] = k-1的值
     *          （这里比较巧妙，前一个值更大，则前一应该往后挪，a[k]原本的值在临时变量中，k位置的值变成的数组的前一个，实现前一个后挪，
     *           此时数组中k位置和他的以前一个是相同的，如此临时变量再去和前前一个比较，发现交换，则前一个的值就会变成前前一个的值。实现了数组后移。
     *           ）
     *
     *
     *      第一轮循环，从第二个开始，第二个元素和第一个元素比较，找到合适的位置插入(比较条件触发，则会对元素)，相应元素后移到第二个的位置。
     *      第二轮循环，从第3个开始，第三个与前两个依次比较，找到合适的位置插入(比较条件触发，则会对元素)，相应元素后移到第三个的位置。
     *      。。。
     *      第n轮循环，从第n个开始，第n个元素与前面的N-1个比较，找到合适的位置插入。相应的元素后移到n个的位置
     * @param arr
     */
    public static void sort(int[] arr){

        int index;
        int temp ;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] >= arr[i-1]){
                continue;
            }
            index = i;
            temp = arr[i];
            for (int j = i-1; j >= 0; j--) {
                if(temp < arr[j]){
                    arr[j+1] = arr[j];
                    index = j;
                }
            }
            arr[index] = temp;
        }
    }
}
