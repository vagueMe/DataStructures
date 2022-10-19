package com.atguigu.sort;

import java.util.Arrays;

/**
 * @author hudi
 * @date 2022/10/19 14:59
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int arr[] = {3,9,-1,10,20};
//        int arr[] = {1,2,3,4,5};

        int arr[] = new int[88888];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*88888);
        }


        long l = System.currentTimeMillis();
        sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("耗时:" + (System.currentTimeMillis() - l)/1000);
    }

    /**
     * 冒泡排序: n个元素。
     *          每一轮都从从第一个开始比较。
     *          比较相邻两个数，如果满足条件，发生交换（比较后就已经交换了）。比较了n-1次，将最大的放在最后。
     *          第二轮也从第一个开始比较，因最后一位是最大的无需比较，所以比较了n-2次
     *          。。。 因为最后一个肯定是最小的，所以只需要比较n-1轮。
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr){
        int temp;
        for (int i = 0; i < arr.length-1; i++) {
//            System.out.println("第"+(i+1)+"轮大循环");
            boolean change = false;
            for (int j = 0; j < arr.length -1 - i; j++) {
//                System.out.println("开始比较："+(j+1)+"，比较数："+arr[j]+" <-> "+arr[j+1]);
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    change = true;
                }
            }
//            System.out.println("第"+(i+1)+"轮大循环后的数组："+ Arrays.toString(arr));
            if(!change){
               break;
            }
        }

        return arr;
    }

}
