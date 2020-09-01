package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
// 프림 알고리즘이용
/*
5
0  5 10  8  7 
5  0  5  3  6 
10 5  0  1  3 
8  3  1  0  1 
7  6  3  1  0
==>10

7
0 32 31 0 0 60 51
32 0 21 0 0 0 0
31 21 0 0 46 0 25
0 0 0 0 34 18 0
0 0 46 34 0 40 51
60 0 0 18 40 0 0
51 0 25 0 51 0 0
==>175
 */


// 최초 시작 정점은 첫번째 정점으로
// 모든 정점의 최소 간선 비용을 미리 계산하지 않고 정점을 하나씩 선택하면서 계산
// 선택되지 않은 정점의 최소 간선 비용을 모두 Integer.MAX_VALEU 로 설정하여 선택된 정점과의 비교에서 불리하게 설정
// 정점이 선택되면 해당 정점으로 부터 갈수 있는 간선 중 최소 비용 간선을 찾아서 연결된 정점의 최소 간선 비용을 계산 ( 반복문 이후 선택됨 )
public class PrimTest{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine().trim()); // 정점 갯수
        int[][] input = new int[cnt][cnt];
        boolean[] visited = new boolean[cnt]; // 정점 방문 여부
        int[] minEdge = new int[cnt]; // 정점 기준 최소 간선 비용
        
        StringTokenizer st;
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cnt; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
            minEdge[i] = Integer.MAX_VALUE;	
        }// i노드에서 j노드까지의 비용을 모두 배열에 저장
        
        int minVertex = 0; // 최소 비용 연결 정점
        int min = 0; // 최소 비용
        int result = 0;
        
        minEdge[0] = 0; // 0 번째 정점의 최소 간선 비용은 0
        
        // cnt 만큼의 정점을 찾아간다.
		for(int c = 0 ; c< cnt; c++){
			
			// 매번 정점 선택 전에 초기화
			minVertex = 0;
            min = Integer.MAX_VALUE;

            // 간선 비용이 최소인 c 번째 정점을 찾고 비용을 계산한다. ( 방문하지 않았고, 간선 비용이 최소인 i )
			// i번째 정점에서 가장 작은 비용의 간선이 minEdge[i]. 현재 진행 기준으로 가장 작은 간선비용을 가진 정점이 minVertex
            // 간선 비용이 최소인 정점(minVertex) 를 찾는다.
            // 처음 시작할 때는 0정점만 0 나머지는 Integer.MAX_VALUE 이므로 시작 정점이 선택됨
            for(int i=0; i<cnt; ++i) { 
            	if(!visited[i] && minEdge[i] < min) { // 이미 방문한 정점 제외, min 반복문에서  항상 Integer.MAX_VALUE 로 초기화
            		min = minEdge[i];
            		minVertex = i;
            	}
            }
            
            System.out.println(minVertex);
            
            // 비용 계산 및 최소 간선 비용 정점 방문 처리
            result += min;
            visited[minVertex] = true;
            
            // 선택된 정점(minVertex)의 간선을 대상으로 최소 간선 비용을 계산한다. 
            // 최소 간선 비용으로 연결되는 다음 정점 i 의 최소 간선 비용을 계산하여 minEdge[i] 에 저장
            // 아직 선택되지 않은 정점 x minEdge[x] = Integer.MAX_VALUE
            for (int i = 0; i < cnt; i++) { 
                if (!visited[i] && input[minVertex][i] != 0 && input[minVertex][i] < minEdge[i] ) {
                	minEdge[i] = input[minVertex][i];
                }
            }
        }
        System.out.println(result);
    }
}// end class
