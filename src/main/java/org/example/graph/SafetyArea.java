package org.example.graph;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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

            if(height == low){
                area = 1;
            }else{
                SafetyArea safetyArea = new SafetyArea();
                for(int i=low+1; i<height; i++){
                    Queue<int[]> q = new LinkedList<>();
                    for(int j=0; j<graph.length; j++){
                        for(int k=0; k<graph[j].length; k++){
                            if(graph[j][k] >= i){
                                q.add(new int [] {j, k});
                            }
                        }
                    }
                    safetyArea.bfs(i, q);

                }
            }


        }catch(Exception e){
            log.error(e.getMessage());
        }
    }

    public void bfs(int n, Queue<int[]>q){

        while (!q.isEmpty()){

        }
    }
}
