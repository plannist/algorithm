package org.example.graph;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FarFarNode {

    static int [][] graph;
    static boolean [][] visitied;

    public static void main(String [] args){
        int [][] ins = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};


        graph    = new int[ins.length][ins.length];
        visitied = new boolean[ins.length][ins.length];

        for(int i=0; i<ins.length; i++){
            for(int j=0; j<ins[i].length; j++){
                graph[ins[i][0]][ins[i][1]] = 1;
                graph[ins[i][1]][ins[i][0]] = 1;
            }
        }

        for(int[] ls : graph){
            log.info("ls: {}", ls);
        }

        FarFarNode farFarNode = new FarFarNode();
        farFarNode.dfs(1, 0);


    }

    public void dfs(int n, int sum){
        for(int k =1; k< graph[n].length; k++){
            visitied[n][k] = true;
            if(graph[n][k] > 0){
                dfs(k, sum+1);
            }


        }
    }
}
