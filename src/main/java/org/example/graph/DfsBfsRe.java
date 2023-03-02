package org.example.graph;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

@Slf4j
public class DfsBfsRe {

    static int node;

    static int line;

    static int startNode;

    static int [][] graph;

    static boolean [] visited;


    public static void main(String [] args){

        try{


            Scanner scanner = new Scanner(System.in);

            String firstLine = scanner.nextLine();
            node = Integer.parseInt(firstLine.split(" ")[0]);
            line = Integer.parseInt(firstLine.split(" ")[1]);
            startNode = Integer.parseInt(firstLine.split(" ")[2]);

            graph = new int[node+1][node+1];
            visited = new boolean[node+1];

            int cnt = 0;
            while(cnt < line){
                String lineStr = scanner.nextLine();
                if(lineStr == null || lineStr.equals("")){
                    break;
                }
                int i = Integer.parseInt(lineStr.split(" ")[0]);
                int j = Integer.parseInt(lineStr.split(" ")[1]);
                graph[i][j] = 1;
                graph[j][i] = 1;
                cnt++;

            }

            scanner.close();

//            Arrays.stream(graph).forEach(e -> log.info("graph: {}", e));

            DfsBfsRe b = new DfsBfsRe();

            b.dfs(startNode);

            System.out.print("\n");
            visited = new boolean[node+1];

            b.bfs(startNode);

        }catch(Exception e){
            log.info(e.getMessage());
        }

    }

    public void bfs(int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        System.out.print(startNode+" ");
        while(!q.isEmpty()){
            int i = q.poll();
            visited[i] = true;
            for(int j=1; j<graph[i].length; j++){
                if(!visited[j] && graph[i][j] == 1){
                    visited[j] = true;
                    q.add(j);
//                    log.info("{}", j);
                    System.out.print(j+" ");
                }
            }
        }

    }

    public void dfs(int i){
        System.out.print(i+" ");
        visited[i] = true;

        for(int k=1; k<graph[i].length; k++){
            if(!visited[k] && graph[i][k] > 0){
                dfs(k);
            }
        }


    }
}



//public class Main {
//
//    static int node;
//
//    static int line;
//
//    static int startNode;
//
//    static int [][] graph;
//
//    static boolean [] visited;
//
//
//    public static void main(String [] args){
//
//        try{
//
//
//            Scanner scanner = new Scanner(System.in);
//
//            String firstLine = scanner.nextLine();
//            node = Integer.parseInt(firstLine.split(" ")[0]);
//            line = Integer.parseInt(firstLine.split(" ")[1]);
//            startNode = Integer.parseInt(firstLine.split(" ")[2]);
//
//            graph = new int[node+1][node+1];
//            visited = new boolean[node+1];
//
//            int cnt = 0;
//            while(cnt < line){
//                String lineStr = scanner.nextLine();
//                if(lineStr == null || lineStr.equals("")){
//                    break;
//                }
//                int i = Integer.parseInt(lineStr.split(" ")[0]);
//                int j = Integer.parseInt(lineStr.split(" ")[1]);
//                graph[i][j] = 1;
//                graph[j][i] = 1;
//                cnt++;
//
//            }
//
//            scanner.close();
//
//            Main b = new Main();
//
//            b.dfs(startNode);
//
//            System.out.print("\n");
//            visited = new boolean[node+1];
//
//            b.bfs(startNode);
//
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//
//    }
//
//    public void bfs(int s){
//        Queue<Integer> q = new LinkedList<>();
//        q.add(s);
//        System.out.print(startNode+" ");
//        while(!q.isEmpty()){
//            int i = q.poll();
//            visited[i] = true;
//            for(int j=1; j<graph[i].length; j++){
//                if(!visited[j] && graph[i][j] == 1){
//                    visited[j] = true;
//                    q.add(j);
//                    System.out.print(j+" ");
//                }
//            }
//        }
//
//    }
//
//    public void dfs(int i){
//        System.out.print(i+" ");
//        visited[i] = true;
//
//        for(int k=1; k<graph[i].length; k++){
//            if(!visited[k] && graph[i][k] > 0){
//                dfs(k);
//            }
//        }
//
//
//    }
//}