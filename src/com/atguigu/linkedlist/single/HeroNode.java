package com.atguigu.linkedlist.single;

/**
 * @author hudi
 * @date 2022/10/11 15:59
 */
public class HeroNode {
    public int value ;
    public String name;
    public HeroNode next;

    public HeroNode( ){
    }


    public HeroNode(int value ){
        this.value = value;
    }

    public HeroNode(int value, String name ){
        this.value = value;
        this.name = name;
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "value=" + value +
                "name=" + name +
                '}';
    }
}
