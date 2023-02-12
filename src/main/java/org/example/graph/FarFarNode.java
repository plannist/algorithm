package org.example.graph;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class FarFarNode {

    static int [][] graph;
    static boolean [][] visited;

    static List<List<Integer>> list = new ArrayList<>();;
    static boolean [] flag;

    static int max;

    public static void main(String [] args) {
        int[][] ins = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};


        graph = new int[ins.length][ins.length];
        visited = new boolean[ins.length][ins.length];


        flag = new boolean[ins.length + 1];
        for (int i = 0; i < ins.length; i++) {
            list.add(i, new ArrayList<>());
        }

        for (int i = 0; i < ins.length; i++) {
            list.get(ins[i][0]).add(ins[i][1]);
            list.get(ins[i][1]).add(ins[i][0]);
        }

        FarFarNode farFarNode = new FarFarNode();
        for(int i=1; i<list.size(); i++){
            if(!flag[i])
                farFarNode.dfs(i, 0);
        }

        log.info("list: {}", list);

        log.info("max: {}", max);



    }

    public void dfs(int i, int cnt){
        log.info("방문노드: {}", i);
        flag[i] = true;
        if(cnt > max){
            max = cnt;
        }
        for(int k : list.get(i)){
            if(!flag[k]){
                dfs(k, cnt+1);
            }
        }
    }
}
