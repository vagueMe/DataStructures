package com.atguigu.linkedlist.single;

import java.util.ArrayList;
import java.util.List;

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
        while (temp != null){
            HeroNode newH = temp;
            temp = temp.next;
            newH.next =  result.next;
            result.next = newH;
        }
        head.next = result.next;
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
