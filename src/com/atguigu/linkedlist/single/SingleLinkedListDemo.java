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

//        SingleLinkedList demo = new SingleLinkedList();
//        demo.addByOrder(new HeroNode(1));
//        demo.addByOrder(new HeroNode(3));
//        demo.addByOrder(new HeroNode(5));
//        demo.addByOrder(new HeroNode(7));
//        demo.addByOrder(new HeroNode(9));
//
//        SingleLinkedList demo2 = new SingleLinkedList();
//        demo2.addByOrder(new HeroNode(2));
//        demo2.addByOrder(new HeroNode(6));
//        demo2.addByOrder(new HeroNode(8));
//        demo2.addByOrder(new HeroNode(10));


        SingleLinkedList demo = new SingleLinkedList();
        demo.addByOrder(new ListNode(1));
        demo.addByOrder(new ListNode(2));
        demo.addByOrder(new ListNode(4));

        SingleLinkedList demo2 = new SingleLinkedList();
        demo2.addByOrder(new ListNode(1));
        demo2.addByOrder(new ListNode(3));
        demo2.addByOrder(new ListNode(4));


//        demo.mergeHeroNode(demo.getHead(),demo2.getHead());
        demo.mergeHeroNode2(demo.getHead(),demo2.getHead());

//        demo.endPrintf(demo.getHead());

//        demo.endList2(demo.getHead());
//        demo.update(new HeroNode(6,"名称"));
//
//        demo.delete(new HeroNode(9 ));
        demo.list();
    }
}
