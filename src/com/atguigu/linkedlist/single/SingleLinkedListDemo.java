package com.atguigu.linkedlist.single;

/**
 * @author hudi
 * @date 2022/10/11 16:00
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
//        SingleLinkedList demo = new SingleLinkedList();
//        demo.add(new HeroNode(1));
//        demo.add(new HeroNode(2));
//        demo.add(new HeroNode(3));
//        demo.list();

        SingleLinkedList demo = new SingleLinkedList();
        demo.addByOrder(new HeroNode(1));
        demo.addByOrder(new HeroNode(3));
        demo.addByOrder(new HeroNode(5));
        demo.addByOrder(new HeroNode(7));
        demo.addByOrder(new HeroNode(9));
        demo.addByOrder(new HeroNode(6));
        demo.endList2(demo.getHead());
//        demo.update(new HeroNode(6,"名称"));
//
//        demo.delete(new HeroNode(9 ));
        demo.list();
    }
}
