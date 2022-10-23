package com.atguigu.sort;

import java.util.Arrays;

/**
 * @author hudi
 * @date 2022/10/23 17:55
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {53,3,532,748,14,214};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 准备10个通，
     *  第一次去个位数的值，依次放入每个数值的桶里面，最终按顺序，将桶中的数据放回到arr中。
     *  第二次取十位数的值，依次放入每个数值的桶里面，最终按顺序，将桶中的数据放回到arr中。
     *
     *  第n次（arr中最大的那个数的长度），依次放入每个数值的桶里面，最终按顺序，将桶中的数据放回到arr中。
     *
     * @param arr
     */
    public static void sort(int[] arr){

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = max < arr[i] ? arr[i] : max;
        }
        int[][] tong = new int[10][arr.length];
        int[] index = new int[10];
        int temp;
        for (int i = 0; i < (max + "").length(); i++) { // 确定要大循环几次。
            for (int j = 0; j < arr.length; j++) {
                temp = arr[j] / (10^(0+i)) % 10;
                tong[temp][index[temp]] = arr[j];
                index[temp]++;
            }
            temp = 0;
            for (int k = 0; k < 10; k++) {
                for (int l = 0; l < index[k]; l++) {
                    arr[temp] = tong[k][index[l]];
                    temp++;
                }
                index[k] = 0;
            }
        }

    }
}
