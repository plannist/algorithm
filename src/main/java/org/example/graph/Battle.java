package org.example.graph;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

@Slf4j
public class Battle {

    /**
     * 5 5
     * W B W W W
     * W W W W W
     * B B B B B
     * B B B W W
     * W W W W W
     * */

    static String[][] arrays;
    static boolean[][] flag;

    static int [] validX = new int[] {-1, 1, 0, 0};
    static int [] validY = new int[] {0,0,-1,1};
    public static void main(String [] args){

        System.out.println("ㅎ2");
        // array[0][0] : {array[1][0]}
        // array[0][1] : null
        // array[0][2] : {array[0][3], array[1][2]}
        // ......
        /**
         * 인접한 노드에 같은 편과 자기 자신의 숫자가 필요하다.
         * [x][y] x가 0일때 : x와 x+1 검사 필요하다.
         * [x][y] x가 0 보다 크고 x.length-1 보다 작을때 : x와 x-1, x+1 검사 필요 하다.
         * [x][y] x가 x.length - 1 일때 x와 , x-1 검사 필요하다.
         * {0, -1, 1}
         *
         *
         * [x][y] y가 0일때 : y 와 y +1 검사 필요하다.
         * [x][y] y가 0보다 크고 y.length-1 보다 작을때 : y 와 y-1, y+1 검사 필요하다.
         * [x][y] y가 y.length-1 일때 : y와 y-1 검사 필요하다.
         *
         *
         * */

        int x = 5, y=5;
        arrays = new String[x][y];
        flag = new boolean[x][y];
        arrays[0] = new String [] {"W", "B", "W", "W", "W"};
        arrays[1] = new String [] {"W", "W", "W", "W", "W"};
        arrays[2] = new String [] {"B", "B", "B", "B", "B"};
        arrays[3] = new String [] {"B", "B", "B", "W", "W"};
        arrays[4] = new String [] {"W", "W", "W", "W", "W"};

//        for(boolean [] fl : flag){
//            log.info("visited: {}", fl);
//        }

        Battle battle = new Battle();
        int our = 0, there = 0;
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                if(!flag[i][j]){
                    int result = 0;
                    if(arrays[i][j].equals("W")){
                        result += battle.bfs(i, j, "W");
                        our += result * result;
                    }else{
                        result += battle.bfs(i, j, "B");
                        there += result * result;
                    }
                }

            }
        }

        log.info("our: {}, there: {}", our, there);

//        for(boolean [] fl : flag){
//            log.info("visited: {}", fl);
//        }


    }

    public int bfs(int i, int j, String str){
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        flag[i][j] = true;


        while (!q.isEmpty()){
            int x = q.peek()[0];
            int y = q.peek()[1];
            log.info("x:{}, y:{}", x, y);
            q.poll();
            cnt ++;
            for(int k=0; k< 4; k++){
                int xVal = x + validX[k];
                int yVal = y + validY[k];
                log.info("xVal: {}, yVal:{}, cnt:{}", xVal, yVal, cnt);
                if(xVal < 0 || xVal >= 5 || yVal < 0 || yVal >= 5 || flag[xVal][yVal]) continue;

                if(arrays[xVal][yVal].equals(str)){
                    q.add(new int[]{xVal, yVal});
                    flag[xVal][yVal] = true;
                }

            }
        }


        return cnt;

    }


}





















