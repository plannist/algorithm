package org.example.graph;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

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
//                farFarNode.dfs(i, 0);
                farFarNode.bfs(i);
        }

        log.info("list: {}", list);

        log.info("max: {}", max);
    }

    public void bfs(int i){
        flag[i] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);

        while (!q.isEmpty()){
            int k = q.poll();
            log.info("방문노드:{}, max: {}", k, max);
            for(int n =0; n<list.get(k).size(); n++){
                if(!flag[list.get(k).get(n)]){
                    flag[list.get(k).get(n)] = true;
                    q.add(list.get(k).get(n));
                }
            }
            max++;

        }
    }

    //dfs로 풀수 없는 이유는  1번과의 거리 체크 불가능함.
    //ex) 1 > 3 > 6 > 3 > 4 > 2 > 5  에서 6번노드까지 최단거리측정했고 2번 움직였지만 다시 1번 노드를 방문하지않고 3번에서 분기 되어 이동하므로
    public void dfs(int i, int cnt){
        log.info("방문노드: {}, cnt: {}", i, cnt);
        flag[i] = true;
        if(cnt > max){
            max = cnt;
        }
        for(int k : list.get(i)){
            if(!flag[k]){
                dfs(k, cnt + 1);
            }
        }
    }
}
