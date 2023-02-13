import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Slf4j
public class FarFarNode{

    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean [] visited;
    public static int cnt=0;
    public static void main(String [] args){
        int node = 6;
        int [][] edge = {{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}};
        FarFarNode farFarNode = new FarFarNode();
        int result = farFarNode.solution(node, edge);
        log.info("result: {}", result);
    }

    public int solution(int node, int[][] edge){

        //그래프 초기화
        for(int i=0; i<node+1; i++){
            graph.add(new ArrayList<>());
        }
        //방문기록 초기화
        visited = new boolean[node+1];

        //인접 리스트 생성 >> 바둑판 모양일때는 인접 행렬 유리, 트리 모양일때는 인접 리스트 유리
        for(int i=0; i< edge.length; i++){
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }

        log.info("graph: {}", graph);

        FarFarNode farFarNode = new FarFarNode();
        farFarNode.bfs(1);


        return cnt;
    }

    public void bfs(int index){
        visited[index] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(index);

        while(true){
            Queue<Integer> temp = new LinkedList<>();

            while (!q.isEmpty()){
                int n = q.poll();
                for(int i=0; i<graph.get(n).size(); i++){
                    if(!visited[graph.get(n).get(i)]){
                        visited[graph.get(n).get(i)] = true;
                        temp.add(graph.get(n).get(i));
                    }
                }
            }

            if(temp.isEmpty()) break;
            q.addAll(temp);
            cnt = temp.size();

        }

    }
}