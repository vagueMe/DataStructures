package com.atguigu.linkedlist.single;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author hudi
 * @date 2022/10/11 15:59
 */
public class SingleLinkedList {

    private ListNode head = new ListNode(0);

    public void add(ListNode heroNode){
        ListNode temp = head;
        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addByOrder(ListNode heroNode){
        ListNode temp = head;
        boolean flag = false;
        while (true){
            if(temp.next == null){
                break;
            } else if (temp.next.val > heroNode.val){
                break;
            } else  if(temp.next.val == heroNode.val){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            System.out.println("已经存在：" + heroNode.val);
            return;
        }
        heroNode.next = temp.next;
        temp.next = heroNode;
    }

    public void update(ListNode heroNode){
        if(head.next == null || heroNode == null){
            System.out.println("修改失败");
            return;
        }

        ListNode temp = head.next;
        while (temp != null){
            if(temp.val == heroNode.val){
                temp.name = heroNode.name;
                return;
            } else {
                temp = temp.next;
            }

        }
    }

    public void delete(ListNode heroNode){
        if(head.next == null || heroNode == null){
            System.out.println("数据为空");
            return;
        }
        // 因为是要删除目标，所以temp不能等于目标，都等于目标了，那就不能操作删除了
        ListNode temp = head;
        while (temp != null){
            if(temp.next.val == heroNode.val){
                temp.next = temp.next.next;
                return;
            } else {
                temp = temp.next;
            }

        }
    }

    public void endList (ListNode head){
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head.next;
        while (temp != null){
            ListNode newHero = temp;
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

    public void endList2 (ListNode head){

        ListNode result = new ListNode(0);
        ListNode temp = head.next;
        ListNode newH = null;
        while (temp != null){
            newH = temp;
            temp = temp.next;
            newH.next =  result.next;
            result.next = newH;
        }
        head.next = result.next;
    }


    public void endList3 (ListNode head){

        ListNode result = new ListNode(0);
        ListNode temp = head.next;
        ListNode newH = null;
        while (temp != null){
            newH = temp.next;
            temp.next = result.next;
            result.next = temp;
            temp = newH;

        }
        head.next = result.next;
    }

    public void endPrintf(ListNode heroNode){
        ListNode temp = heroNode.next;
        Stack<ListNode> stack = new Stack<>();
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }

        while (stack.size() > 0){
            System.out.println(stack.pop());
        }


    }

    public static void main(String[] args) {
        ListNode test  = new ListNode();
        test.val = 1;
        testMethod(test);
        System.out.println(test.val);
    }

    public static void testMethod(ListNode test){
        test = new ListNode();
        test.val = 2;
    }


    public ListNode mergeHeroNode(ListNode first, ListNode second){
        // 1 3 5 7 9
        // 2 4 6 8 10
        ListNode left = first.next;
        ListNode right = second.next;
        // 1 5 6 8
        // 2 3 4 7  对于这组数据存在bug
        // 记录上一个节点，用于插入
        ListNode leftLast = first;
        while (right != null) {
            if (left.val >= right.val) {
                leftLast.next = right;
                ListNode rightNext = right.next;
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


    public ListNode mergeHeroNode2(ListNode first, ListNode second){
        // 1 3 5 7 9
        // 2 4 6 8 10
        ListNode left = first.next;
        ListNode right = second.next;

        // 记录上一个节点，用于插入
        ListNode last = first;
        while (right != null) {
            if(left.val > right.val){
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

        ListNode temp = head.next;
        while (true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }
}
