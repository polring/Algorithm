package java.ch05_dfs_bfs;

import java.util.ArrayDeque;
import java.util.Deque;
/**
 * 프로그래머스
 * 그래프 탐색 문제
 * 연결된 요소 개수 찾는 문제
 */

public class network {
    public int solution(int n, int[][] computers) {
       return solutionDFS(n,computers);
    }

    /**
     * 방식 1: DFS (재귀)
     */
    private static int solutionDFS(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, n, computers, visited);
                answer++; // 연결된 한 덩어리(네트워크)를 찾을 때마다 카운트
            }
        }
        return answer;
    }
    
    private static void dfs(int node, int n, int[][] computers, boolean[] visited) {
        visited[node] = true;
        for (int i = 0; i < n; i++) {
            // 연결되어 있고 방문하지 않은 노드 탐색
            if (computers[node][i] == 1 && !visited[i]) {
                dfs(i, n, computers, visited);
            }
        }
    }
    /**
     * 방식 2: BFS (Queue - ArrayDeque 활용)
     */
    private static int solutionBFS(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(computers, visited,n,i);
                answer++; 
            }
        }
        
        return answer;
    }

    
     private static void bfs(int [][] computers,boolean[] visited,int n,int i){
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(i);
        visited[i] = true;
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int v = 0; v < n; v++){
                if(computers[node][v] == 1 && !visited[v]){
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
        
    }
    
}
