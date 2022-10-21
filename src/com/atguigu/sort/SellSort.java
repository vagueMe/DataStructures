package com.atguigu.sort;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author hudi
 * @date 2022/10/20 11:10
 */
public class SellSort {

    public static String JsonToObjTest(String src) {
        String jsonStr = "";
        try {
            File jsonFile = new File(src);
            FileReader fileReader = new FileReader(jsonFile);

            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr ;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // 如果json文件在项目中，可以用此路径格式
//         String src ="src/main/resources/doc/weightnotes_approval.json";
        String src ="D:/test/arrJson.json"; //这里从本地读了个8w个的数字数组。new的话出错，说文件太长。
        String json =JsonToObjTest(src);
        List<Integer> integers = JSON.parseArray(json, Integer.class);

//        int[] arr = {8,9,1,7,2,3,5,4,6,0};
////        sortChange(arr);
//        sortInsert(arr);
//        System.out.println(Arrays.toString(arr));

//        int arr[] = new int[80000];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) (Math.random()*88888);
//        }

        Integer[] arr = integers.toArray(new Integer[integers.size()]);
        System.out.println(Arrays.toString(arr));
        long l = System.currentTimeMillis();
        sortChange(arr); // 加上break时，耗时0s,当没有break那段时，耗时11s。...
//        sortInsert(arr); // 加上continue 耗时 3，不加时耗时6s。
        System.out.println("耗时:" + (System.currentTimeMillis() - l)/1000);// 约耗时1-2s
        System.out.println(Arrays.toString(arr));



    }

    /**
     * 希尔排序（交换法）：
     *   将总长每次按 n= n/2 组件分组（10，分5组（组中的元素步长5），分2组（组中的元素步长2），分1组（组中的元素步长1）），分组。将每一组的数据进行插入排序。
     *   针对每一组数据都进行插入排序，每组开始都为首位两部分（开始首只有一个，其余为尾部），首为有序，尾为无序。
     *      差用插入排序（但是和之前说的正统插入的步移不一样，这里是用的交换的方式）
     *      这里就很巧妙=====
     *      之前的插入法，都在一个数组里面，所以都是顺序的递减比较下去。但是这里因为用了分组，比如分成了2组。
     *      是1,3,5,7这几个下标一组，2,4,6,8这几个下标一组。变成了2组。
     *      当i=1是是在第一组里面循环j递减插入法。当i=2是在第二组里面循环J递减插入法。
     *      当i=3变成在第一组里面循环j递减插入法，当i=4变成第二组里面循环j递减插入法。就这样来回的在第一组和第二组之间各自循环j插入
     *
     *
     * @param arr
     */
    public static void sortChange(Integer[] arr){
        int temp;
        for (int gap = arr.length /2 ; gap > 0; gap=gap/2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j-=gap) {
                    if(arr[j] > arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    } else {
                        break;
                    }
                }
            }
        }

    }



    /**
     * 希尔排序（移位法）：
     *
     * @param arr
     */
    public static void sortInsert(Integer[] arr){
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
                    if(arr[j] > temp){
                        arr[j+gap] = arr[j];
                        index = j;
                    }
                }
                arr[index] = temp;
            }
        }

    }
}
