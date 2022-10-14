package com.atguigu.linkedlist.circle;

/**
 * @author hudi
 * @date 2022/10/11 15:59
 */
public class CirlceLinkedList {

    public CirlceNode head = new CirlceNode(0);

    public CirlceLinkedList addNode(CirlceNode newNode){

        if(head.next == null){
            newNode.prev = newNode;
            newNode.next = newNode;
            head.next = newNode;
            return this;
        }
        CirlceNode temp = head.next;

        CirlceNode up = temp.prev;
        up.next = newNode;
        newNode.prev = up;

        temp.prev = newNode;
        newNode.next = temp;
        return this;

    }

    public void list(CirlceNode newNode){
        CirlceNode temp = newNode;
        while (true){
            System.out.println(newNode);
            if(temp == newNode.next){
                break;
            }
            newNode = newNode.next;
        }

    }

    public void showTime(int title, int begin, int num){

        for (int i = 0; i < title; i++) {
            this.addNode(new CirlceNode(i+1));
        }

        CirlceNode temp = this.head.next;
        while (true){
            if(temp.val == begin){
                this.head.next = temp;
                break;
            }
            temp = temp.next;
        }

        temp = this.head.next;

        int count = 1;
        while (true){
            if(count == num){
                // 移除元素
                System.out.println(temp);
                if(temp.next == temp){
                    break;
                }
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                temp = temp.next;
                // 计时器归为
                count = 1;
            } else {
                count++;
                temp = temp.next;
            }

        }




    }


}
