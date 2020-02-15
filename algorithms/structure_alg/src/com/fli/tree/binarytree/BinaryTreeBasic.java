package com.fli.tree.binarytree;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

/**
 * ģ��һ���򵥵Ķ�������ʵ�ֲ��ң�ɾ��������Ȼ�������
 * 
 * @author Administrator
 *
 */
public class BinaryTreeBasic {

	
	private Node root;
	
	public BinaryTreeBasic(){
		root = null;
	}
	
	/**
	 * ���ݹؼ���key���ҽڵ㣬û�з���NULL
	 * @param key
	 * @return
	 */
	public Node find(int key){
		Node result = null;
		if(root!=null){
			Node currentNode = root;
			while(currentNode.iData!=key){
				if(key<currentNode.iData){
					currentNode = currentNode.leftChild;
				}else{
					currentNode = currentNode.rightChild;
				}
			}
			result = currentNode;
		}
		return result;
	}
	
	/**
	 * ����һ���ڵ�����������
	 * @param iData
	 * @param dData
	 */
	public void insert(int iData, double dData){
		Node node = new Node(iData, dData);
		if(root==null){
			root = node;
		}else{
			Node currentNode = root;
			while(true){
				Node parentNode = currentNode;
				if(node.iData<currentNode.iData){
					currentNode = currentNode.leftChild;
					if(currentNode==null){
						parentNode.leftChild = node;
						break;
					}
				}else{
					currentNode = currentNode.rightChild;
					if(currentNode==null){
						parentNode.rightChild = node;
						break;
					}
				}
			}
		}
		
	}
	
	/**
	 * ɾ���������е�һ���ڵ�
	 * @param key
	 * @return
	 */
	public boolean delete(int key){
		if(root==null){
			return false;
		}
		Node currentNode = root;
		Node parentNode = root;
		while(currentNode.iData!=key){
			parentNode = currentNode;
			if(key<currentNode.iData){
				currentNode = currentNode.leftChild;
			}else{
				currentNode = currentNode.rightChild;
			}
		}
		if(currentNode == null){
			return false;
		}
		if(currentNode.leftChild==null&&currentNode.rightChild==null){
			if(currentNode==root){
				root = null;
				return true;
			}
			if(parentNode.leftChild==currentNode){
				parentNode.leftChild = null;
			}else{
				parentNode.rightChild = null;
			}
		}
		
		if(currentNode.leftChild==null&&currentNode.rightChild!=null){
			if(currentNode==root){
				root = currentNode.rightChild;
				return true;
			}
			if(parentNode.leftChild==currentNode){
				parentNode.leftChild = currentNode.rightChild;
			}else{
				parentNode.rightChild = currentNode.rightChild;
			}
		}
		
		if(currentNode.leftChild!=null&&currentNode.rightChild==null){
			if(currentNode==root){
				root = currentNode.leftChild;
				return true;
			}
			if(parentNode.leftChild==currentNode){
				parentNode.leftChild = currentNode.leftChild;
			}else{
				parentNode.rightChild = currentNode.leftChild;
			}
		}
		
		if(currentNode.leftChild!=null&&currentNode.rightChild!=null){
			Node successor = getSuccessor(currentNode);
			if(currentNode==root){
				root = successor;
			}else if(parentNode.leftChild==currentNode){
				parentNode.leftChild = successor;
			}else{
				parentNode.rightChild = successor;
			}
			successor.leftChild = currentNode.leftChild;
		}
		currentNode = null;
		return true;
	}
	
	/**
	 * �ҳ�Node�ڵ�ĺ�̽ڵ�
	 * @param node
	 * @return
	 */
	public Node getSuccessor(Node node){
		Node successorParent = node;
		Node successor = node;
		Node currentNode = node.rightChild;
		while(currentNode!=null){
			successorParent = currentNode;
			successor = currentNode;
			currentNode = currentNode.leftChild; 
		}
		
		if(successor!=node.rightChild){
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = node.rightChild;
		}
		return successor;
		
	}
	
	
	/**
	 * ���ݱ������ͱ���������
	 * 1:ǰ��;2:����;3:����
	 * @param traverseType
	 */
	public void traverse(int traverseType){
		switch(traverseType){
			case 1: preOrder(root);
					break;
			case 2: inOrder(root);
					break;
			case 3: postOrder(root);
					break;
			default : preOrder(root);
		}
	}
	
	/**
	 * ǰ��
	 * @param localRoot
	 */
	public void preOrder(Node localRoot){
		if(localRoot!=null){
			System.out.print(localRoot.iData+"  ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
		
	}
	
	/**
	 * ����
	 * @param localRoot
	 */
	public void inOrder(Node localRoot){
		if(localRoot!=null){
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.iData+"  ");
			inOrder(localRoot.rightChild);
		}
	}
	
	/**
	 * ����
	 * @param localRoot
	 */
	public void postOrder(Node localRoot){
		if(localRoot!=null){
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.iData+"  ");
		}
	}
	
	/**
	 * ��������չʾ
	 */
	public void displayTree(){
		Queue<Node> q =  new ArrayDeque<Node>();
		q.add(root);
		Queue<Node> queue = new ArrayDeque<Node>();
		int count = highTree(root);
		printBlank(count);
		while(!q.isEmpty()){
			Node currentNode = q.poll();
			System.out.print(currentNode.iData+"---");
			if(currentNode.leftChild!=null){
				queue.add(currentNode.leftChild);
			}
			if(currentNode.rightChild!=null){
				queue.add(currentNode.rightChild);
			}
			if(q.isEmpty()){
				count--;
				System.out.println("");
				while(!queue.isEmpty()){
					q.add(queue.poll());
				}
				printBlank(count);
			}
		}
	}
	
	public void printBlank(int t){
		for(int i=0;i<t;i++){
			System.out.print("  ");
		}
	}
	
	/**
	 * �������ĸ߶�
	 * @param node
	 * @return
	 */
	public int highTree(Node node){
		int result = 0;
		int left = 0;
		int right = 0;
		if(node==null){
			return result;
		}
		left = highTree(node.leftChild);
		right = highTree(node.rightChild);
		result = left>right?left:right+1;
		return result;
	}
	
	/**
	 * �Ƚ��������Ƿ����
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean isEqual(Node root1,Node root2){
		boolean flag = false;
		if(root1==root2){
			flag = true;
		}else{
			while(root1!=null&&root2!=null&&root1.iData==root2.iData){
				if(isEqual(root1.leftChild,root2.leftChild)){
					if(isEqual(root1.rightChild,root2.rightChild)){
						flag = true;
					}
				}
			}
		}
		return flag;
		
	}
	
	/**
	 * ��������չʾû�пո�
	 */
	public void displayTreeS(){
		Queue<Node> q =  new ArrayDeque<Node>();
		q.add(root);
		Queue<Node> queue = new ArrayDeque<Node>();
		while(!q.isEmpty()){
			Node currentNode = q.poll();
			System.out.print(currentNode.iData+"---");
			if(currentNode.leftChild!=null){
				queue.add(currentNode.leftChild);
			}
			if(currentNode.rightChild!=null){
				queue.add(currentNode.rightChild);
			}
			if(q.isEmpty()){
				System.out.println("");
				while(!queue.isEmpty()){
					q.add(queue.poll());
				}
				System.out.print("---");
			}
		}
	}
	
	
	/**
	 * ���Ľڵ�
	 * iData��key,dDate��ֵ
	 * leftChild��rightChild�ֱ�Ϊ���Һ��ӽڵ�
	 * @author Administrator
	 *
	 */
	static final class Node{
		//key
		public int iData; 
		public double dData;
		public Node leftChild;
		public Node rightChild;
		
		/**
		 * ��ʼ���ڵ㣬���Һ���Ϊ��
		 * @param iData
		 * @param dData
		 */
		public Node(int iData, double dData){
			this.dData = dData;
			this.iData = iData;
		}
		
		@Override
		public String toString() {
			return " {iDate:"+iData+",dData:"+dData+",leftChild:"+leftChild+",rightChild:"+rightChild+"} ";
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeBasic bb = new BinaryTreeBasic();
		bb.insert(50, 1.5);
		bb.insert(25, 2.5);
		bb.insert(75, 3.5);
		bb.insert(12, 4.5);
		bb.displayTree();
		bb.delete(25);
		bb.displayTree();
		/*bb.insert(37, 5.5);
		bb.insert(43, 6.5);
		bb.insert(30, 7.5);
		bb.insert(33, 8.5);
		bb.insert(87, 9.5);
		bb.insert(93, 10.5);
		bb.insert(97, 11.5);
		Node node = bb.find(50);
		System.out.println(node);
		System.out.println(bb.highTree(node));
		System.out.println("--------preOder-------");
		bb.traverse(1);
		System.out.println("--------inOder-------");
		bb.traverse(2);
		System.out.println("--------postOder-------");
		bb.traverse(3);
		System.out.println("-----------------------");
		bb.displayTreeS();
		bb.delete(37);
		bb.delete(33);
		bb.delete(93);
		bb.displayTree();*/
	}

}
