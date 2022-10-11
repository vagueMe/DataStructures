package com.atguigu.linkedlist.single;

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
        }
        heroNode.next = temp.next;
        // todo
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
        System.out.println("结束");
    }

}
