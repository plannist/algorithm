package org.example.graph;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.ArrayStack;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Boxing {

    static List<List<Integer>> graph = new ArrayList<>();

    static List<List<Integer>> winner = new ArrayList<>();
    static List<List<Integer>> loser =  new ArrayList<>();

    static int[] rank;

    static boolean[] visited;

    public static void main(String [] args){
        int n = 5;
        int [][] edge = {{4,3}, {4,2}, {3,2}, {1,2}, {2,5}};
        Boxing boxing = new Boxing();
        int result = boxing.solution(n, edge);
    }

    public int solution(int n, int[][]edge){

        rank = new int[n+1];
        for(int i=0; i< rank.length; i++){
            rank[i] = 1;
        }

        for(int i=0; i<n+1; i++){
            winner.add(new ArrayList<>());
            loser.add(new ArrayList<>());
        }
        visited = new boolean[n+1];

        for(int i=0; i<edge.length; i++){
            winner.get(edge[i][0]).add(edge[i][1]);
            loser.get(edge[i][1]).add(edge[i][0]);


        }

        log.info("winner: {}", winner);
        log.info("loser: {}", loser);



        log.info("rank: {}", rank);

        return 0;
    }

    public void dfs(int index){


        visited[index] = true;

        log.info("방문노드[{}]", index);






//        for(int i=0; i<graph.get(index).size(); i++){
//            rank[graph.get(index).get(i)] = rank[winner]+1;
//
//            if(visited[graph.get(index).get(i)]){
////                rank[graph.get(index).get(i)] = rank[winner]+1;
//            }else{
//                dfs(graph.get(index).get(i), index);
//            }
//        }

    }
}
