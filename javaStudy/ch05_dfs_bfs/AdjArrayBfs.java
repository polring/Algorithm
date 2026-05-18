package javaStudy.ch05_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AdjArrayBfs {
    public static void main(String[] args) throws IOException {
        int[][] adjArray = input();
        int length = adjArray.length;
        bfs(adjArray,1,length);
    }

    /**
     * 노드의 개수와 인접행렬을 입력받는 함수
     */
    private static int[][] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        int[][] adjList = new  int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                adjList[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return adjList;
    }

    /**
     * bfs를 실행하는 함수
     */
    private static  void bfs(int[][] adjArray,int i,int n){
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(i);
        visited[i]= true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            System.out.println(current);
            for(int j = 0; j < n;j++) {
                if (!visited[j] && adjArray[current][j] == 1) {
                    queue.offer(j);
                    visited[j] = true;
                }
            }
        }


    }
}
