package com.atguigu.linkedlist.single;

/**
 * @author hudi
 * @date 2022/10/11 15:59
 */
public class ListNode {
    public int val;
    public String name;
    public ListNode next;

    public ListNode( ){
    }


    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val, String name ){
        this.val = val;
        this.name = name;
    }


    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                "name=" + name +
                '}';
    }
}
