package com.atguigu.sort;

import java.util.Arrays;

/**
 * @author hudi
 * @date 2022/10/21 15:27
 */
public class QuickSort {

    public static void main(String[] args) {

//        int[] arr = {-9,78,0,23,-567,70,-1,900,4561};
        int[] arr = {8,6,8,7,9,4,5,6,7,8,9};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序算法，思想是在数组中寻找一个中间点，然后从left 开始，寻找一个比中间数大的值，在从右边right寻找一个比中间数小的值。进行交换。
     *  这样一次下来，中间数的左边都是比中间数小的，右边都是比中间数大的。
     *  在用递归，将左边left - r的的数进行以上思路的循环。将右边l-right的数进行以上思路的循环，
     *
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void sort(int[] arr, int left, int right){

        int l = left;
        int r = right;
        int pivot = arr[(left+right)/2];
        int  temp;
        while (l < r){

            while (arr[l] < pivot){
                l +=1;
            }
            while (arr[r] > pivot){
                r -=1;
            }

            if(l >= r){
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            System.out.println(l + "  "+ r );
            // 又一种情况存在 6,6,6  a[l] = a[r] = 中间值。如果没有下面这句，交换后还是6,6,6。就会陷入死循环的无限交换。
            // 而下面，就让l右移，r左移，逐渐岔开，跳出循环。
            if(arr[l] == pivot){
                r -=1;
            }
            if(arr[r] == pivot){
                l +=1;
            }

//            if(l > r){
//                System.out.println("11");
//            }

        }

        // 这里的作用，可以理解为l和r都集中在了中间数上，这时候，让l右移，r左移。这样中间数就被独立出来，不会带入递归里面的循环。
        if(l==r){
            l += 1;
            r -= 1;
        }
//        else {
//            System.out.println("这轮不相等");
//        }

        if(left < r){
            sort(arr,left,r);
        }
        if(right > l){
            sort(arr,l,right);
        }

    }
}
