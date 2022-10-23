package com.atguigu.sort;

import java.util.Arrays;

/**
 * @author hudi
 * @date 2022/10/21 17:48
 */
public class MergetSort {

    public static void main(String[] args) {
//        int[] arr = new int[]{8,4,5,7,1,3,6,2};

        int arr[] = new int[88888];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*88888);
        }


        int[] temp = new int[arr.length];
        long l = System.currentTimeMillis();
        sort(arr,0,arr.length-1,temp);
        System.out.println("耗时:" + (System.currentTimeMillis() - l)/1000);// 约耗时2s
        System.out.println(Arrays.toString(arr));
    }


    public static void sort(int[] arr, int left, int right, int[] temp){

        if(left < right){
            int mid = (left + right)/2; // z中间索引
            // 向左递归分解
            sort(arr,left,mid,temp);
            // 向右递归
            sort(arr,mid+1,right,temp);
            // 在第一次调用这里时，上面的两部，已经吧这个数组分成了 8,4 这两最小单元了，
            // 也就是left , mid ,right 已经分到最里面
            merge(arr,left,mid,right,temp);
        }

    }



    // 合并
    public static void merge(int[] arr, int left, int mid, int right, int[] temp){
        int i = left; // 初始化i ，左边 有序序列的初始索引
        int j = mid + 1; // 初始化j ， 右边有序序列的初始索引
        int t = 0; // 指向temp数组的当前索引

        // 一 先把左右两边（有序）的数据按照规则填充到temp数组。
        // 知道左右两边的有序蓄序列，有一边处理完毕为止。
        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[t] = arr[i];
                i++;
            } else {
                temp[t] = arr[j];
                j++;
            }
            t++;
        }

        // 二 把有剩余数据的一边的数据一次全部填充到temp
        while (i <= mid){
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right){
            temp[t] = arr[j];
            t++;
            j++;
        }


        // 三 将temp里面的元素拷贝到arr
        // 注意，并不是每次都拷贝所有的
        t = 0;
        while (left <= right){
            arr[left] = temp[t];
            left ++;
            t++;
        }

    }
}
