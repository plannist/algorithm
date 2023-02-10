package org.example.graph;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Cabbage {

    static int x = 10;
    static int y = 8;

//    static int x = 10;
//    static int y = 10;


    static int cnt = 0;
    static int [][] graph;
    static boolean [][] visited;

    static int [] xMap = { 0, -1, 1, 0};
    static int [] yMap = {-1,  0, 0, 1};

    public static void main(String [] args){
        try{
            List<List<Integer>> list = new ArrayList<>();
            list.add(Arrays.asList(0,0));
            list.add(Arrays.asList(1,0));
            list.add(Arrays.asList(1,1));
            list.add(Arrays.asList(4,2));
            list.add(Arrays.asList(4,3));
            list.add(Arrays.asList(4,5));
            list.add(Arrays.asList(2,4));
            list.add(Arrays.asList(3,4));
            list.add(Arrays.asList(7,4));
            list.add(Arrays.asList(8,4));
            list.add(Arrays.asList(9,4));
            list.add(Arrays.asList(7,5));
            list.add(Arrays.asList(8,5));
            list.add(Arrays.asList(9,5));
            list.add(Arrays.asList(7,6));
            list.add(Arrays.asList(8,6));
            list.add(Arrays.asList(9,6));

            graph = new int[x][y];
            visited = new boolean[x][y];

            for(List<Integer> ls : list){
                graph[ls.get(0)][ls.get(1)] = 1;
            }

            for(int[] is : graph){
                log.info("graph : {}", is);
            }

            Cabbage cabbage = new Cabbage();

            for(int i=0; i< graph.length; i++){
                for(int j=0; j< graph[i].length; j++){
                    if(!visited[i][j])
//                        cabbage.bfs(i, j);
                        cabbage.dfs(i, j, 0);
                }
            }

            for(boolean[] bl : visited){
                log.info("bl: {}", bl);
            }

            log.info("cabbage Cnt: {}", cnt);



        }catch(Exception e){
            log.error(e.getMessage(), e);
        }

    }

    public void dfs(int x, int y, int idx){
        if(graph[x][y] > 0 && !visited[x][y] && idx == 0)
            cnt++;

        visited[x][y] = true;

        if(graph[x][y] > 0){
            for(int k=0; k<4; k++){
                int tempX = x + xMap[k];
                int tempY = y + yMap[k];
                if(tempX < 0 || tempX >= this.x || tempY < 0 || tempY >= this.y || visited[tempX][tempY] || graph[tempX][tempY] < 1) continue;

                dfs(tempX, tempY, idx+1);

            }
        }
    }



    public void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        if(graph[x][y] > 0 && !visited[x][y])
            cnt++;

        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] array = q.poll();
            int qx = array[0]; //x축 기준
            int qy = array[1]; //y축 기준
            if(graph[qx][qy] > 0){
                log.info(">>>>>>>>>");
                for(int k=0; k<4; k++){ //검색할 범위
                    int tempX = qx + xMap[k];
                    int tempY = qy + yMap[k];
                    log.info("tempX [{}] tempY [{}]", tempX, tempY);
                    if(tempX < 0 || tempX >= this.x || tempY < 0 || tempY >= this.y) continue;
                    log.info("1차 통과: {}, {}", graph[tempX][tempY], visited[tempX][tempY]);
                    if(!visited[tempX][tempY] && graph[tempX][tempY] == 1){
                        log.info("q에 들어갈 :{}", graph[tempX][tempY]);
                        visited[tempX][tempY] = true;
                        q.add(new int[]{tempX, tempY});
                    }



                }
                log.info("<<<<<<<<<");
            }


        }

    }
}
