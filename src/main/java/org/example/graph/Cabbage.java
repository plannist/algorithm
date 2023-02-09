package org.example.graph;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class Cabbage {

    static int x = 10;
    static int y = 8;
    int count = 17;
    static int [][] graph;
    static boolean [][] visited;

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
        }catch(Exception e){
            log.error(e.getMessage(), e);
        }



    }
}
