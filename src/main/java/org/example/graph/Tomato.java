package org.example.graph;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Tomato {

    static int x;
    static int y;

    static int[][] edge;

    static int[][] graph;

    static boolean[][] visited;

    static int day;

    static boolean graw;

    static int [] iVal = {-1, 1, 0, 0};
    static int [] jVal = { 0, 0, 1,-1};

    public static void main(String [] args){
//
//        List<List<Integer>> list = new ArrayList<>();
//
//        int [][] ts = {{1,2}, {1,3}, {1,4}, {2,4}, {3,4}, {2,3}};
//
//        for(int i=0; i< 4+1; i++){
//            list.add(new ArrayList<>());
//        }
//
//        log.info("list: {}", list);
//
//        for(int i=0; i<ts.length; i++){
//            list.get(ts[i][0]).add(ts[i][1]);
//            list.get(ts[i][1]).add(ts[i][0]);
//        }
//
//        log.info("list: {}", list);


        try{
            Scanner scanner = new Scanner(System.in);

            String xy = scanner.nextLine();

            x = Integer.parseInt(xy.split(" ")[0]);
            y = Integer.parseInt(xy.split(" ")[1]);

            log.info("x: {}, y: {}", x, y);

            edge = new int[y][x];
            graph = new int[y][x];
            visited = new boolean[y][x];

            int c= 0;
            while( c < y){
                String line = scanner.nextLine();

                edge[c] = Arrays.stream(line.split(" ")).mapToInt(Integer :: parseInt).toArray();
                graph[c] = Arrays.stream(line.split(" ")).mapToInt(Integer :: parseInt).toArray();
                c++;
                log.info("c: {}", c);

            }

            scanner.close();

            Arrays.stream(edge).forEach(e -> log.info("e: {}", e));

            Tomato tomato = new Tomato();

            while(true){
                graw = false;
                tomato.bfs(0);
                if(graw) day++;
//                if(Arrays.stream(visited).allMatch(e -> e.equals(true))) break;

                boolean flag = false;

                log.info("day: {}", day);

                Arrays.stream(edge).forEach(e -> log.info("e: {}", e));

                Arrays.stream(visited).forEach(e -> log.info("e: {}", e));

                loop1 :
                for(boolean[] v : visited){
                    for(boolean j : v){
                        if(!j){
                            flag = false;
                            break loop1;
                        }else{
                            flag = true;
                        }
                    }
                }

                if(flag){
                    break;
                }
            }
        }catch(Exception e){
            log.error(e.getMessage());
        }

    }

    public void bfs(int index){
        for(int i=0; i< edge.length; i++){
            for(int j=0; j< edge[i].length; j++){
                if(edge[i][j] > 0 && ! visited[i][j]){
                    visited[i][j] = true;
                    for(int k=0; k<4; k++){
                        int tI = i + iVal[k];
                        int tJ = j + jVal[k];
//                        log.info("i[{}], j[{}], tI[{}], tJ[{}]", i, j, tI, tJ);
                        if(tI < 0 || tI >= this.y || tJ < 0 || tJ >= this.x )continue;
                        if(graph[tI][tJ] == 0){
                            graph[tI][tJ] = 1;
                            graw = true;
                            log.info(">>>>>");
                            Arrays.stream(graph).forEach(e -> log.info("변경 중 graph: {}", e));
                            log.info("<<<<<");
                        }else if(graph[tI][tJ] == -1){
                            visited[tI][tJ] = true;
                        }
                    }
                }

            }

            log.info("변경 중 day: {}", day);


//            Arrays.stream(edge).forEach(e -> log.info("변경 중 edge: {}", e));
        }
        for(int i=0; i< graph.length; i++){
            edge[i] = graph[i].clone();
        }
    }
}
