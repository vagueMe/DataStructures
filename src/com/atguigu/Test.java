package com.atguigu;

/**
 * @author hudi
 * @date 2022/10/18 15:04
 */
public class Test {

    public static void main(String[] args) {
        String[][] temp = new String[3][3];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                temp[i][j] = i +","+j;
            }
        }

        for (int i = 0; i < temp.length; i++) {
            for (int i1 = 0; i1 < temp[i].length; i1++) {
                System.out.print(temp[i][i1]+ " ");
            }
            System.out.println();
        }
    }
}
