package com.atguigu.recursion;

/**
 * @author hudi
 * @date 2022/10/18 11:08
 */
public class MiGong {
    public static void main(String[] args) {
        /*int[][] map = new int[8][7];
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

        for (int i = 0; i < map.length; i++) {
            for (int i1 = 0; i1 < map[i].length; i1++) {
                System.out.print(map[i][i1]+ " ");
            }
            System.out.println();
        }*/

        int[][] map = new int[10][8];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(i==0 || j == 0 || i == 9 || j == 7){
                    map[i][j] = 1;
                }
            }
            System.out.println();
        }




        map[1][3] = 1;map[1][4] = 1;map[1][5] = 1;
        map[2][2] = 1;map[2][6] = 1;
        map[3][2] = 1;map[3][3] = 1;map[3][4] = 1;map[3][6] = 1;
        map[4][6] = 1;
        map[5][2] = 1;map[5][4] = 1;map[5][5] = 1;
        map[6][2] = 1;map[6][4] = 1;map[6][5] = 1;
        map[7][3] = 1;

        for (int i = 0; i < map.length; i++) {
            for (int i1 = 0; i1 < map[i].length; i1++) {
                System.out.print(map[i][i1]+ " ");
            }
            System.out.println();
        }

        System.out.println("===========");
        setWay(map,4,3);

        for (int i = 0; i < map.length; i++) {
            for (int i1 = 0; i1 < map[i].length; i1++) {
                System.out.print(map[i][i1]+ " ");
            }
            System.out.println();
        }

    }

    /**
     *  使用递归回溯给小球找路
     *     约定：当map[i][j] = 0 表示该点没有走过，当为1表示是墙，当为3表示通过可以走，当为3表示改点已经走过，但是走不通。
     *      走迷宫的策略为 优先下-右-上-左。如果走不通在回溯。
     *      如果能到 map[6][5]表示通路找到。
     * @param map 标识地图
     * @param i 开始的坐标
     * @param j 开始的坐标
     * @return
     */
    public static boolean setWay(int[][] map, int i, int j ){
        if(map[8][6] == 2){
            return true;
        } else {
            if(map[i][j] == 0){ //表示没有走过。
                map[i][j] = 2; //假定可以走
                if(setWay(map,i+1,j)){ //向下
                    return true;
                } else if (setWay(map,i,j+1)){ //向右
                    return true;
                } else if (setWay(map,i-1,j)){ //向上
                    return true;
                } else if (setWay(map,i,j-1)){ //向左
                    return true;
                } else {
                    // 这个坐标点四方，要么是墙1，要么已经走过2，要么也是个死局点3。所以这个点也是个死局，就返回false。
                    // 而我这个点，也只是走过的点2的某一个分支的路线。所以这个分支是死局，上一个点就从新换一个分支走。
                    //
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }


    }
}
