package org.example.graph;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class SafetyArea {

    static int n;

    static int [][] graph;

    static boolean [][] visited;

    static int height = 0;
    static int low = 100;
    static int area = 1;

    static int [] xVal = { 0, 0, 1, -1};
    static int [] yVal = {-1, 1, 0,  0};


    public static void main(String [] args){
        try{
            Scanner scanner = new Scanner(System.in);
            n =  Integer.parseInt(scanner.nextLine());
            graph = new int[n][n];
            visited = new boolean[n][n];

            int cnt = 0;
            while(cnt < n){
                graph[cnt] =  Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
                int tmpMax = Arrays.stream(graph[cnt]).max().getAsInt();
                int tmpLow = Arrays.stream(graph[cnt]).min().getAsInt();
                if(height < tmpMax){
                    height = tmpMax;
                }
                if(low > tmpLow){
                    low = tmpLow;
                }

                cnt++;
            }

            scanner.close();

            Arrays.stream(graph).forEach(e-> log.info("graph: {}", e));
            log.info("height: {}", height);
            log.info("low: {}", low);
            Map<Integer, Integer> map = new HashMap<>();

            if(height == low){
                area = 1;
            }else{
                SafetyArea safetyArea = new SafetyArea();


                for(int i=low+1; i<height; i++){
                    Queue<int[]> q = new LinkedList<>();

                    for(int j=0; j<graph.length; j++){
                        for(int k=0; k<graph[j].length; k++){
                            if(graph[j][k] >= i && !visited[j][k]){
                                q.add(new int [] {j, k});
                                visited[j][k] = true;
                                safetyArea.bfs(i, q);
                                log.info("총몇번들어올까?[{}]", i);
                                Arrays.stream(visited).forEach(e -> log.info("{}", e));
                                map.put(i, map.getOrDefault(i, 0)+1);
                            }
                        }
                    }

                    visited = new boolean[n][n];

                }
            }

            log.info("map: {}", map);
            int max = map.values().stream().max(Comparator.naturalOrder()).orElse(1);
            log.info("max: {}", max);


        }catch(Exception e){
            log.error(e.getMessage(), e);
        }
    }

    public void bfs(int n, Queue<int[]>q){
        log.info("기준높이: {}", n);
        while (!q.isEmpty()){
            int [] area = q.poll();
            for(int i=0; i<4; i++){
                int tmpX = area[0] + xVal[i];
                int tmpY = area[1] + yVal[i];

                if(tmpX < 0 || tmpX > this.n-1 || tmpY < 0 || tmpY > this.n-1 || visited[tmpX][tmpY]){
                    continue;
                }
                if(graph[tmpX][tmpY] >= n){
                    visited[tmpX][tmpY] = true;
                    q.add(new int[] {tmpX, tmpY});
                }

            }
        }
//        area++;
    }
}
