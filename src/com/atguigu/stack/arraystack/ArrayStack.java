package com.atguigu.stack.arraystack;

/**
 * @author hudi
 * @date 2022/10/14 18:09
 */
public class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull(){
        return top == maxSize -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if(isFull()){
            System.out.println("已经满了");
        }
        this.top++;
        this.stack[top] = value;
    }

    public int pool(){
        if(isEmpty()){
            throw new RuntimeException("没有数据了");
        }
        int temp = this.stack[this.top];
        this.top--;
        return  temp;
    }


}
