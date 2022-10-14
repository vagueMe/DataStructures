package com.atguigu.linkedlist.single;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author hudi
 * @date 2022/10/11 15:59
 */
public class SingleLinkedList {

    private HeroNode head = new HeroNode(0);

    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if(temp.next == null){
                break;
            } else if (temp.next.value > heroNode.value){
                break;
            } else  if(temp.next.value == heroNode.value){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            System.out.println("已经存在：" + heroNode.value);
            return;
        }
        heroNode.next = temp.next;
        temp.next = heroNode;
    }

    public void update(HeroNode heroNode){
        if(head.next == null || heroNode == null){
            System.out.println("修改失败");
            return;
        }

        HeroNode temp = head.next;
        while (temp != null){
            if(temp.value == heroNode.value){
                temp.name = heroNode.name;
                return;
            } else {
                temp = temp.next;
            }

        }
    }

    public void delete(HeroNode heroNode){
        if(head.next == null || heroNode == null){
            System.out.println("数据为空");
            return;
        }
        // 因为是要删除目标，所以temp不能等于目标，都等于目标了，那就不能操作删除了
        HeroNode temp = head;
        while (temp != null){
            if(temp.next.value == heroNode.value){
                temp.next = temp.next.next;
                return;
            } else {
                temp = temp.next;
            }

        }
    }

    public void endList (HeroNode head){
        List<HeroNode> list = new ArrayList<>();
        HeroNode temp = head.next;
        while (temp != null){
            HeroNode newHero = temp;
            temp = temp.next;
            newHero.next = null;
            list.add(newHero);
        }
        System.out.println("---");
        for (int i = list.size() - 1; i > 0; i--) {
            list.get(i).next = list.get(i-1);
        }
        head.next = list.get(list.size() - 1);
    }

    public void endList2 (HeroNode head){

        HeroNode result = new HeroNode(0);
        HeroNode temp = head.next;
        HeroNode newH = null;
        while (temp != null){
            newH = temp;
            temp = temp.next;
            newH.next =  result.next;
            result.next = newH;
        }
        head.next = result.next;
    }


    public void endList3 (HeroNode head){

        HeroNode result = new HeroNode(0);
        HeroNode temp = head.next;
        HeroNode newH = null;
        while (temp != null){
            newH = temp.next;
            temp.next = result.next;
            result.next = temp;
            temp = newH;

        }
        head.next = result.next;
    }

    public void endPrintf(HeroNode heroNode){
        HeroNode temp = heroNode.next;
        Stack<HeroNode> stack = new Stack<>();
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }

        while (stack.size() > 0){
            System.out.println(stack.pop());
        }


    }

    public static void main(String[] args) {
        HeroNode test  = new HeroNode();
        test.value = 1;
        testMethod(test);
        System.out.println(test.value);
    }

    public static void testMethod(HeroNode test){
        test = new HeroNode();
        test.value = 2;
    }


    public HeroNode mergeHeroNode(HeroNode first, HeroNode second){
        // 1 3 5 7 9
        // 2 4 6 8 10
        HeroNode left = first.next;
        HeroNode right = second.next;
        // 1 5 6 8
        // 2 3 4 7  对于这组数据存在bug
        // 记录上一个节点，用于插入
        HeroNode leftLast = first;
        while (right != null) {
            if (left.value >= right.value) {
                leftLast.next = right;
                HeroNode rightNext = right.next;
                right.next = left;
                right = rightNext;
            } else {
                leftLast = left;
                left = left.next;
            }
            if (left == null) {
                leftLast.next = right;
                break;
            }
        }
        return first;

    }


    public HeroNode mergeHeroNode2(HeroNode first, HeroNode second){
        // 1 3 5 7 9
        // 2 4 6 8 10
        HeroNode left = first.next;
        HeroNode right = second.next;

        // 记录上一个节点，用于插入
        HeroNode last = first;
        while (right != null) {
            if(left.value > right.value){
                last.next = right;
                last = right;
                right = right.next;
                last.next = left;

            } else {
                last =  left;
                left = left.next;
            }
            if (left == null) {
                last.next = right;
                break;
            }
        }
        return first;

    }

    public void list(){
        if(head.next  == null){
            System.out.println("链表我空");
            return;
        }

        HeroNode temp = head.next;
        while (true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }
}
