package com.atguigu.recursion;

/**
 * @author hudi
 * @date 2022/10/18 17:46
 */
public class Queen8 {

    int max = 8;
    int[] arr = new int[max];
    int count = 0;
    int judeCount = 0;
    public Queen8(){

    }

    public static void main(String[] args) {

        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println(queen8.count);

    }

    private void check(int n){
        if(n == 8) {
            // n从0开始的，当判断n=8就说已经在方第九个了，前面的8个都已经摆放好了
            count++;
            print();
        } else {
            for (int i = 0; i < max; i++) {
                arr[n] = i;
                if(jude(n)){ // 没有冲突，继续放置下一个
                    check(n+1);
                }
            }
        }
    }


    /**
     * 当放置第n个皇后后，就去检测该皇后是否和前面已经摆放的皇后冲突
     */
    private boolean jude(int n){
        judeCount++;
        for (int i = 0; i < n; i++) {
            if(arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n]-arr[i])){
                return false;
            }
        }
        return true;
    }

    private void print(){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + "");
        }
        System.out.println();
    }



}
