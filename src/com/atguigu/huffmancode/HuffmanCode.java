package com.atguigu.huffmancode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hudi
 * @date 2022/11/3 15:45
 */
public class HuffmanCode {
    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        byte[] bytes = str.getBytes();
        System.out.println("bytes = " + bytes);
        List<Node> nodes = getNodes(bytes);
        System.out.println("nodes = " + nodes);

    }

    private static List<Node> getNodes(byte[] bytes){

        List<Node> nodes = new ArrayList<>();
        Map<Byte,Integer> map = new HashMap<>();
        for (byte aByte : bytes) {
            Integer integer = map.get(aByte);
            if(integer == null){
                integer = 1;
            } else {
                integer = integer +1;
            }
            map.put(aByte,integer);
        }
        for (Map.Entry<Byte, Integer> mdata : map.entrySet()) {
            nodes.add(new Node(mdata.getKey(),mdata.getValue()));
        }
        return nodes;
    }
}

class Node implements Comparable<Node>{
    byte data;
    int weight; // 字符出现的次数
    Node left;
    Node right;

    public Node(byte data, int weight){
        this.data = data;
        this.weight = weight;
    }


    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }
}