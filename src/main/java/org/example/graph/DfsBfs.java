package org.example.graph;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * ** 문제 **
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
 * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
 * 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
 *
 * ** 입력 **
 * 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
 * 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다.
 * 입력으로 주어지는 간선은 양방향이다.
 *
 * ** 출력 **
 * 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
 * */
@Slf4j
public class DfsBfs {

    //4(정점수), 5(간선수), 1(시작노드)
    //1 2
    //1 3
    //1 4
    //2 4
    //3 4


    static int [][] graph = new int[5][5];
    boolean [] visited = new boolean[5];
    static int start = 1;

    public static void main(String [] args){

        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1,2));
        list.add(Arrays.asList(1,3));
        list.add(Arrays.asList(1,4));
        list.add(Arrays.asList(2,4));
        list.add(Arrays.asList(3,4));




        for(List<Integer> ls : list){
            graph[ls.get(0)][ls.get(1)] = 1;
            graph[ls.get(1)][ls.get(0)] = 1;
        }

        DfsBfs dfsBfs = new DfsBfs();

        //로그
        for(int i=0; i< graph.length; i++){
            log.info("graph[{}] : {}", i, graph[i]);
        }
//
//
        for(int i=1; i< graph.length; i++){
            dfsBfs.dfs(i);
        }

        log.info("visited: {}", dfsBfs.visited);


    }

    public void dfs(int i){
        if(!visited[i]){
            log.info("{}", i);
            visited[i] = true;
            for(int j=1; j< graph.length; j++){
                if(graph[i][j] > 0){
                    if(!visited[j]){
                        dfs(j);
                    }
                }
            }
        }
    }


}
