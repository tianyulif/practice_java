package com.fli.graph;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * 简单图
 * 图包含顶点和边：G=(V,E)
 * 无向图表示：
 * 顶点集合：V(G)={V1,V2,V3,V4,V5}
 * 边集合：E(G)={(V1,V2),(V1,V4),(V3,V4),(V3,V5)}
 * 有向图表示：
 * V(G)={V1，V2，V3}
 * E(G)={<V1，V2>，<V2，V3>，<V3，V1>，<V1，V3>}
 * 
 * 
 * @author Administrator
 *
 */
public class Graph {
	
	//最大节点数量
	private final int MAX_VERTS = 20;
	//节点列表
	private Vertex vertexList[];
	//邻接矩阵表示图
	private int adjMat[][];
	//目前节点数量
	private int nVerts;
	
	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		for(int i=0; i<MAX_VERTS;i++){
			for(int j=0; j<MAX_VERTS;j++){
				adjMat[i][j] = 0;
			}
		}
		nVerts = 0;
	}
	
	public void addVertex(char lab){
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	public void addEdge(int i, int j){
		adjMat[i][j] = 1;
	}
	
	public int getAdjUnvisitedVertex(int i){
		for(int j=0; j<nVerts; j++){
			if(adjMat[i][j]==1&&!vertexList[j].wasVisited){
				return j;
			}
		}
		return -1;
	}
	
	public void setVertexListUnvisitedFalse(){
		for(int j=0; j<nVerts; j++){
			vertexList[j].setWasVisited(false);
		}
	}
	
	/**
	 * 深度优先访问
	 */
	public void dfs(){
		vertexList[0].wasVisited = true;
		System.out.print(vertexList[0]);
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		while(!stack.isEmpty()){
			int v = getAdjUnvisitedVertex(stack.peek());
			if(v!=-1){
				vertexList[v].wasVisited = true;
				System.out.print(vertexList[v]);
				stack.push(v);
			}else{
				stack.pop();
			}
		}
		setVertexListUnvisitedFalse();
	}
	
	/**
	 * 最小生成树
	 */
	public void mst(){
		vertexList[0].wasVisited = true;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		while(!stack.isEmpty()){
			int currentVertex = stack.peek();
			int v = getAdjUnvisitedVertex(currentVertex);
			if(v!=-1){
				vertexList[v].wasVisited = true;
				stack.push(v);
				System.out.print(vertexList[currentVertex]);
				System.out.print(vertexList[v]);
				System.out.print("  ");
			}else{
				stack.pop();
			}
		}
		setVertexListUnvisitedFalse();
	}
	
	/**
	 * 宽度优先访问
	 */
	public void bfs(){
		vertexList[0].wasVisited = true;
		System.out.print(vertexList[0]);
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		queue.push(0);
		int v2;
		while(!queue.isEmpty()){
			int v1 = queue.remove();
			while((v2=getAdjUnvisitedVertex(v1))!=-1){
				vertexList[v2].wasVisited = true;
				System.out.print(vertexList[v2]);
				queue.push(v2);
			}
		}
		setVertexListUnvisitedFalse();
	}
	
	/**
	 * 拓扑排序
	 */
	public void topologicalSort(){
		int origin_nVerts = nVerts;
		char[] sortVertexList = new char[MAX_VERTS];
		while(nVerts>0){
			int currentVertex = noSuccessors();
			if(currentVertex==-1){
				System.out.println("Error: Graph has cycles");
				return;
			}
			sortVertexList[nVerts-1] =  vertexList[currentVertex].getLabel();
			deleteVertex(currentVertex);
			//System.out.println("displayAdjMat:");
			//displayAdjMat();
		}
		System.out.println("topologicalSort:");
		for(int i=0; i<origin_nVerts; i++){
			System.out.print(sortVertexList[i]+" ");
		}
		System.out.println();
	}
	
	public void displayAdjMat(){
		for(int i=0; i<nVerts; i++){
			for(int j=0; j<nVerts; j++){
				System.out.print(adjMat[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 找到没有后继节点
	 * @return
	 */
	public int noSuccessors(){
		boolean isEdge;
		for(int i=0; i<nVerts; i++){
			isEdge = false;
			for(int j=0; j<nVerts; j++){
				if(adjMat[i][j]>0){
					isEdge = true;
					break;
				}
			}
			if(!isEdge){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 删除图中节点
	 * @param deleteVertex
	 */
	public void deleteVertex(int deleteVertex){
		//不是最后一个节点
		if(deleteVertex!=nVerts-1){
			for(int i=deleteVertex; i<nVerts-1;i++){
				vertexList[i] = vertexList[i+1];
			}
			
			for(int j=deleteVertex; j<nVerts-1;j++){
				moveRowUp(j,nVerts);
			}
			
			for(int k=deleteVertex; k<nVerts-1;k++){
				moveColLeft(k,nVerts-1);
			}
		}
		nVerts--;
	}
	
	public void moveRowUp(int row, int length){
		for(int i=0; i<length; i++){
			adjMat[row][i] = adjMat[row+1][i];
		}
	}
	
	public void moveColLeft(int col, int length){
		for(int i=0; i<length; i++){
			adjMat[i][col] = adjMat[i][col+1];
		}
	}
	
	public class Vertex{
		private char label;
		private boolean wasVisited;
		
		public Vertex(char lab){
			this.label = lab;
			this.wasVisited = false;
		}

		public char getLabel() {
			return label;
		}

		public void setLabel(char label) {
			this.label = label;
		}

		public boolean isWasVisited() {
			return wasVisited;
		}

		public void setWasVisited(boolean wasVisited) {
			this.wasVisited = wasVisited;
		}
		
		@Override
		public String toString() {
			return label+"-->";
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph g = new Graph();
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(0, 3);
		g.addEdge(3, 4);
		//g.addEdge(1, 3);
		//g.addEdge(2, 3);
		//g.addEdge(2, 4);
		g.dfs(); //A-->B-->C-->D-->E-->
		System.out.println();
		g.bfs(); //A-->B-->D-->E-->C-->
		System.out.println();
		g.mst(); //A-->B-->  B-->C-->  C-->D-->  D-->E-->  
		g.topologicalSort();
		Graph gg = new Graph();
		gg.addVertex('A');
		gg.addVertex('B');
		gg.addVertex('C');
		gg.addVertex('D');
		gg.addVertex('E');
		gg.addVertex('F');
		gg.addVertex('G');
		gg.addVertex('H');
		gg.addEdge(0, 3);
		gg.addEdge(0, 4);
		gg.addEdge(1, 4);
		gg.addEdge(2, 5);
		gg.addEdge(3, 6);
		gg.addEdge(4, 6);
		gg.addEdge(5, 7);
		gg.addEdge(6, 7);
		gg.topologicalSort();
		
		
	}

}
