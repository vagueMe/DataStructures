package com.atguigu.queue;

import java.util.Scanner;

/**
 * @author hudi
 * @date 2022/10/10 17:54
 */
public class CircleArrayQueueDemo {

    public static void main(String[] args) {

        CircleArrayQueue queue = new CircleArrayQueue(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s: 显示列队");
            System.out.println("e: 退出列队");
            System.out.println("a: 添加数据到列队");
            System.out.println("g: 从列队取出元素");
            System.out.println("h: 查看列队头的数据");
            System.out.println("l: 列出列队头的数据");

            key = scanner.next().charAt(0);

            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    try {
                        System.out.println("请输入一个数");
                        int value = scanner.nextInt();
                        queue.addQueue(value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("列队头的数据是%d", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'l':
                        queue.list();
                    break;
                default:
                    break;

            }
        }
    }

}


