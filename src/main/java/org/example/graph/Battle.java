package org.example.graph;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

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
 * [중요] 나를 기준으로 연결가능한 노드
 * x = -1, +1,  0,  0     <<-- 앞으로 한칸 뒤로한칸 연결가능 함. 하지만 x기준으로 한칸씩 움직일 경우 y는 0으로 고정되어야한다. 반대의 경우도 마찬가지. 한마디로 앞뒤, 위아래로 검사시 xy축 반대축은 제자리로 고정된다.
 * y =  0,  0, -1, +1     <<-- 마찬가지로 -1, +1 연결가능하지만 x가 -1 | +1일때 y는 움직일 수 없으며, y가 -1 | +1일때 x는 움직일 수 없는 경우의수도 넣어준다.
 *
 * */

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

    static int result = 0;

    static int [] validX = new int[] {-1, 1, 0, 0};
    static int [] validY = new int[] {0,0,-1,1};

    int x = 5, y=5;
    public static void main(String [] args){

        System.out.println("ㅎ2");


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
                        result += battle.reBsf(i, j, "W");
                        our += result * result;
                    }else{
                        result += battle.reBsf(i, j, "B");
                        there += result * result;
                    }
                }

            }
        }

        log.info("our: {}, there: {}", our, there);

//        for(int i=0; i<x; i++){
//            for(int j=0; j<y; j++){
//                String target = arrays[i][j];
//                if(!flag[i][j]){
//                    result =1;
//                    if(target.equals("W")){
//                        battle.dfs(i, j, target);
//                        our += result * result;
//                    }else{
//                        battle.dfs(i, j, target);
//                        there += result * result;
//                    }
//                }
//            }
//        }

//        log.info("our: {}, there: {}", our, there);

        for(boolean [] fl : flag){
            log.info("visited: {}", fl);
        }
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

    public void dfs(int i, int j, String target){
        flag[i][j] = true;

        for(int k=0; k<4; k++){
            int xMove = i + validX[k];
            int yMove = j + validY[k];
            if(xMove < 0 || xMove >= x || yMove < 0 || yMove >= y) continue;
            if(!flag[xMove][yMove]){
                if(arrays[xMove][yMove].equals(target)){
                    result++;
                    dfs(xMove, yMove, target);
                }
            }
        }
    }

    public int reBsf(int i, int j, String target){
        int cnt = 0;
        flag[i][j] = true;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});

        while (!q.isEmpty()){
            cnt++;
            int[] temp = q.poll();
            int tempX = temp[0];
            int tempY = temp[1];
            log.info("tempX:{}, tempY:{}", tempX, tempY);

            for(int k=0; k<4; k++){
                int nX = tempX + validX[k];
                int nY = tempY + validY[k];
                if(nX < 0 || nX >= x || nY < 0 || nY >= y) continue;
                if(!flag[nX][nY] && arrays[nX][nY].equals(target)){
                    flag[nX][nY] = true;
                    q.add(new int[] {nX, nY});
                }
            }
        }

        return cnt;

    }


}





















