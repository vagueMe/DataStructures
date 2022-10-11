package com.atguigu.linkedlist.single;

/**
 * @author hudi
 * @date 2022/10/11 15:59
 */
public class HeroNode {
    public int value ;
    public HeroNode next;

    public HeroNode(int value ){
        this.value = value;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "value=" + value +
                '}';
    }
}
