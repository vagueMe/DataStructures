package com.atguigu.queue;

/**
 * @author hudi
 * @date 2022-10-09 22:23
 */
public class ArrayQueueDemo {

}

class ArrayQueue {

    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    // 判断队列是否满了
    public boolean isFull(){
        return rear == maxSize-1;
    }

    // 判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }

    // 添加元素到队列
    public boolean addQueue(int a){
        if(isFull()){
            throw new RuntimeException("队列已经满了");
        }
        rear++;
        arr[rear] = a;
        return true;
    }

    // 获取队列的数据
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("已经没有元素了");
        }
        front++;
        return arr[front];
    }

    // 显示队列所有的数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d \n",i,arr[i]);
        }
    }

    // 显示队列的头数据

    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("已经没有元素了");
        }
        return arr[rear+1];
    }



}
