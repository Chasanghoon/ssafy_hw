package com.ssafy.Algorithm_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 크루스칼 알고리즘 - 그리디
 * 1. 모든 간선들의 가중치를 오름차순으로 정렬
 * 2. 가중치가 가장 적은 간선을 선택하며 트리를 증가
 * 3. 사이클이 존재하면 다음 가중치가 낮은 간선 선택
 * 4. n-1개의 간선이 선택될 때까지 2번을 반복		=> 핵심: union에 성공한 가중치: N-1
 */
public class Solution_D4_3124_최소스패닝트리_최종 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static class Edge implements Comparable<Edge>{	// 판단의 기준 정보를 결과를 주기만 하자
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;	// 간선의 부호가 모두 같을 때
			//return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int[] parents;	//부모원소를 관리(트리처럼 사용)
	
	private static void make() {
		parents = new int[V+1];
		//모든 원소를 자신을 대표자로 만듬
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	//a가 속한 집합의 대표자 찾기
	private static int find(int a) {
		if(a==parents[a]) return a;	//자신이 대표자
		return parents[a] = find(parents[a]);	// 자신이 속한 집합의 대표자를 자신의 부모로 : path compression
	}
	
	//두 원소를 하나의 집합으로 합치기(대표자를 이용해서 합침)
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;	//이미 같은 집합으로 합치지 않음
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	static int V, E;
	static Edge[] edgeList;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//input = new BufferedReader(new StringReader(src));
		int tc = Integer.parseInt(input.readLine());
		
		for (int i = 1; i <= tc; i++) {

			tokens = new StringTokenizer(input.readLine());
			V = Integer.parseInt(tokens.nextToken());
			E = Integer.parseInt(tokens.nextToken());
			
			
			//간선 리스트 작성
			edgeList = new Edge[E];
			
			for (int k = 0; k < E; k++) {
				tokens = new StringTokenizer(input.readLine());
				int start = Integer.parseInt(tokens.nextToken());
				int end = Integer.parseInt(tokens.nextToken());
				int weight = Integer.parseInt(tokens.nextToken());
				edgeList[k] = new Edge(start, end, weight);
			}
			
			Arrays.sort(edgeList); 	//오름차순 정렬
			
			make();	// 모든 정점을 각각의 집합으로 만들고 출발
			
			//간선 하나씩 시도하며 트리 만들기
			int cnt = 0;
            long result = 0;
			for (Edge edge : edgeList) {
				if(union(edge.start, edge.end)) {
					result += edge.weight;
					if(++cnt == V-1) break;	// 신장트리 완성
				}
			}
			System.out.println("#"+ i + " " + result);
		}
	}

	public static String src = 
			"1\r\n" + 
			"3 3\r\n" + 
			"1 2 1\r\n" + 
			"2 3 2\r\n" + 
			"1 3 3";
}