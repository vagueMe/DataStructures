package com.atguigu.linkedlist.circle;

/**
 * @author hudi
 * @date 2022/10/14 15:33
 */
public class CirlceNode {
    public int val;
    public String name;
    public CirlceNode prev;
    public CirlceNode next;

    public CirlceNode(int val){
        this.val = val;
    }


    @Override
    public String toString() {
        return "CirlceNode{" +
                "val=" + val +
                '}';
    }
}
