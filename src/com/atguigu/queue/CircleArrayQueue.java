package com.atguigu.queue;

/**
 * @author hudi
 * @date 2022/10/10 18:18
 */
public class CircleArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    // 判断队列是否满了
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加元素到队列
    public boolean addQueue(int a) {
        if (isFull()) {
            throw new RuntimeException("队列已经满了");
        }
        arr[rear] = a;
        rear = (rear + 1) % maxSize;
        return true;
    }

    // 获取队列的数据
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("已经没有元素了");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    // 显示队列所有的数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }

    }

    // 显示队列的头数据

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("已经没有元素了");
        }
        return arr[rear];
    }

    public void list() {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i , arr[i]);
        }
    }

    private int size() {
        return (rear + maxSize - front) % maxSize;
    }
}
