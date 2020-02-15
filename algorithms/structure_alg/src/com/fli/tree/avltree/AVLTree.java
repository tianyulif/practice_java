package com.fli.tree.avltree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.TreeMap;



public class AVLTree <E extends Comparable<E>> {

	
	
	private Node<E> root;
	
	public AVLTree(){
		root = null;
	}
	
	/**
	 * ���ݹؼ���key���ҽڵ㣬û�з���NULL
	 * @param key
	 * @return
	 */
	public Node<E> find(E key){
		Node<E> result = null;
		if(root!=null){
			Node<E> currentNode = root;
			while(currentNode.key.compareTo(key)==0){
				if(currentNode.key.compareTo(key)>0){
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
	public void insert(E key){
		Node<E> node = new Node<E>(key);
		node.balanceFactor = 0;
		if(root==null){
			root = node;
		}else{
			Node<E> currentNode = root;
			while(true){
				Node<E> parentNode = currentNode;
				if(node.key.compareTo(currentNode.key)<0){
					currentNode = currentNode.leftChild;
					if(currentNode==null){
						parentNode.leftChild = node;
						node.parent = parentNode;
						currentNode = node;
						break;
					}
				}else{
					currentNode = currentNode.rightChild;
					if(currentNode==null){
						parentNode.rightChild = node;
						node.parent = parentNode;
						currentNode = node;
						break;
					}
				}
			}
			//displayTree();
			fix(currentNode);
		}
		
	}
	
	public void fix(Node<E> currentNode){
		while(currentNode!=null){
			Node<E> p = currentNode;
			p.balanceFactor = highTree(p.leftChild) - highTree(p.rightChild);
			System.out.println("bbbbbalanceFactor:"+p.balanceFactor+",key:"+p.key);
			currentNode = currentNode.parent;
			if(p.balanceFactor>1){
				int leftL = 0;
				int leftR = 0;
				if(p.leftChild!=null){
					leftL = highTree(p.leftChild.leftChild);
					leftR = highTree(p.leftChild.rightChild);
				}
				System.out.println("balanceFactor:"+p.balanceFactor+",key:"+p.key+"---left.left:"+leftL+",--right.right:"+leftR);
				if(leftL>leftR){
					RRRotate(p);
				}else{
					LRRotate(p);
				}
				break;
					
			}else if(p.balanceFactor<-1){
				int rightR = 0;
				int rightL = 0;
				if(p.rightChild!=null){
					rightR = highTree(p.rightChild.rightChild);
					rightL = highTree(p.rightChild.leftChild);
				}
				System.out.println("balanceFactor:"+p.balanceFactor+",key:"+p.key+"---right.right:"+rightR+",--right.left:"+rightL);
				if(rightR>rightL){
					LLRotate(p);
				}else{
					RLRotate(p);
				}
				break;
			}
		}
	}
	
	
	
	/**
	 * �������ӵ��������¼ӽڵ�
	 * @param node ��С��ת������ N(key,balanceFactor)
	 * ������ת֮��N�Ƶ�NL������������NL��������NLR��ΪN��������(N>NLR>NL)
	 * 
	 * ���磺��תǰ    N(10,2)      ��ת��       NL(8,0)
	 *               /   \               /     \
	 *           NL(8,1) NR(12,0)    NLL(6,0)  N(10,0)
	 *            /    \             /          /    \  
	 *        NLL(6,1) NLR(9,0)   NLLL(4,0) NLR(9,0) NR(12,0) 
	 *          /
	 *      NLLL(4,0)
	 */
	public void RRRotate(Node<E> node){
		if(node==null){
			return;
		}
		Node<E> top = node.leftChild;
		if(node.parent==null){
			root = top;
			top.parent = null;
		}else{
			top.parent = node.parent;
			if(node.parent.leftChild == node){
				node.parent.leftChild = top;
			}else{
				node.parent.rightChild = top;
			}
		}
		node.leftChild = top.rightChild;
		if(top.rightChild!=null){
			top.rightChild.parent = node.leftChild;
		}
		top.rightChild = node;
		node.parent = top;
	}
	
	/**
	 * ���ң����ӵ��������¼ӽڵ�
	 * @param node ��С��ת������ N(key,balanceFactor)
	 * ������ת֮��N�Ƶ�NL������������NL��������NLR��ΪN��������(N>NLR>NL)
	 * 
	 * ���磺��תǰ    N(10,2)    ������(NL) N(10,2)     ������,����RRRotate
	 *               /   \               /     \
	 *           NL(7,-1) NR(12,0)     NLR(9,2)  NR(12,0)
	 *            /    \              /       
	 *        NLL(6,0) NLR(9,1)    NL(7,0) 
	 *                  /          /     \
	 *             NLLR(8,0)    NLL(6,0)  NLLR(8,0)
	 */
	public void LRRotate(Node<E> node){
		if(node==null){
			return;
		}
		Node<E> temp = node.leftChild;
		LLRotate(temp);
		RRRotate(node);
	}
	
	
	/**
	 * ���ң��Һ��ӵ��������¼ӽڵ�
	 * @param node ��С��ת������ N(key,balanceFactor)
	 * ������ת֮��N�Ƶ�NR������������NR��������NRL��ΪN��������(NL>N>NRL>)
	 * 
	 * ���磺��תǰ    N(10,-2)             ��ת��        NR(12,0)
	 *               /    \                      /       \
	 *         NL(8,0) NR(12,-1)              N(10,0)  NRR(14,-1)
	 *                   /    \               /      \       \  
	 *              NRL(11,0) NRR(14,-1)  NL(8,0) NRL(11,0) NRRR(15,0) 
	 *                          \ 
	 *                          NRRR(15,0)
	 */
	public void LLRotate(Node<E> node){
		if(node==null){
			return;
		}
		Node<E> top = node.rightChild;
		if(node.parent==null){
			root = top;
			top.parent = null;
		}else{
			top.parent = node.parent;
			if(node.parent.leftChild == node){
				node.parent.leftChild = top;
			}else{
				node.parent.rightChild = top;
			}
			
		}
		node.rightChild = top.leftChild;
		if(top.leftChild!=null){
			top.leftChild.parent = node;
		}
		top.leftChild = node;
		node.parent = top;
	}
	
	
	/**
	 * �����Һ��ӵ��������¼ӽڵ�
	 * @param node ��С��ת������ N(key,balanceFactor)
	 * ������ת֮��N�Ƶ�NR������������NR��������NRL��ΪN��������(NL>N>NRL>)
	 * 
	 * ���磺��תǰ    N(10,-2)           ������(NR) N(10,-2)       ������(N) LLRotate(N)
	 *               /    \                      /       \
	 *         NL(8,0) NR(13,1)              N(8,0)  NRL(12,-1)
	 *                   /    \                      /      \  
	 *              NRL(12,1) NRR(14,0)       NRLL(11,0) NR(13,-1) 
	 *                /                                      \
	 *            NRLL(11,0)                                NRR(14,0) 
	 */
	public void RLRotate(Node<E> node){
		if(node==null){
			return;
		}
		RRRotate(node.rightChild);
		LLRotate(node);
	}
	
	
	
	
	/**
	 * ɾ���������е�һ���ڵ�
	 * @param key
	 * @return
	 */
	public boolean delete(E key){
		if(root==null){
			return false;
		}
		Node<E> currentNode = root;
		Node<E> parentNode = root;
		while(currentNode.key.compareTo(key)!=0){
			parentNode = currentNode;
			if(currentNode.key.compareTo(key)>0){
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
		
		Node<E> temp = currentNode.parent;
		if(currentNode.leftChild!=null&&currentNode.rightChild!=null){
			Node<E> successor = getSuccessor(currentNode);
			temp = successor.parent;
			if(currentNode==root){
				root = successor;
			}else if(parentNode.leftChild==currentNode){
				parentNode.leftChild = successor;
			}else{
				parentNode.rightChild = successor;
			}
			successor.leftChild = currentNode.leftChild;
		}
		currentNode.parent = null;
		fix(temp);
		currentNode = null;
		return true;
	}
	
	/**
	 * �ҳ�Node�ڵ�ĺ�̽ڵ�
	 * @param node
	 * @return
	 */
	public Node<E> getSuccessor(Node<E> node){
		Node<E> successorParent = node;
		Node<E> successor = node;
		Node<E> currentNode = node.rightChild;
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
	public void preOrder(Node<E> localRoot){
		if(localRoot!=null){
			System.out.print(localRoot.key+"  ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
		
	}
	
	/**
	 * ����
	 * @param localRoot
	 */
	public void inOrder(Node<E> localRoot){
		if(localRoot!=null){
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.key+"  ");
			inOrder(localRoot.rightChild);
		}
	}
	
	/**
	 * ����
	 * @param localRoot
	 */
	public void postOrder(Node<E> localRoot){
		if(localRoot!=null){
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.key+"  ");
		}
	}
	
	/**
	 * ��������չʾ
	 */
	public void displayTree(){
		Queue<Node<E>> q =  new ArrayDeque<Node<E>>();
		q.add(root);
		Queue<Node<E>> queue = new ArrayDeque<Node<E>>();
		int count = highTree(root);
		printBlank(count);
		while(!q.isEmpty()){
			Node<E> currentNode = q.poll();
			System.out.print(currentNode.key+","+currentNode.balanceFactor+"---");
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
	public int highTree(Node<E> node){
		if(node==null){
			return 0;
		}
		int left = highTree(node.leftChild);
		int right = highTree(node.rightChild);
		return Math.max(left, right) + 1;
	}
	
	/**
	 * �Ƚ��������Ƿ����
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean isEqual(Node<E> root1,Node<E> root2){
		boolean flag = false;
		if(root1==root2){
			flag = true;
		}else{
			while(root1!=null&&root2!=null&&root1.key.compareTo(root2.key)==0){
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
		Queue<Node<E>> q =  new ArrayDeque<Node<E>>();
		q.add(root);
		Queue<Node<E>> queue = new ArrayDeque<Node<E>>();
		while(!q.isEmpty()){
			Node<E> currentNode = q.poll();
			System.out.print(currentNode.key+","+currentNode.balanceFactor+"---");
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
	static final class Node<E extends Comparable<E>>{
		//key
		public E key;
		//ƽ������=�������ĸ߶�-�������ĸ߶�
		int balanceFactor;
		public Node<E> leftChild;
		public Node<E> rightChild;
		public Node<E> parent;
		
		/**
		 * ��ʼ���ڵ㣬���Һ���Ϊ��
		 * @param iData
		 * @param dData
		 */
		public Node(E k){
			this.key = k;
		}
		
		@Override
		public String toString() {
			return " {key:"+key+",leftChild:"+leftChild+",rightChild:"+rightChild+"} ";
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*AVLTree<Integer> bb = new AVLTree<Integer>();
		bb.insert(10);
		bb.insert(8);
		bb.insert(12);
		bb.insert(6);
		bb.insert(9);
		bb.insert(4);
		bb.displayTree();
		AVLTree<Integer> bbrr = new AVLTree<Integer>();
		bbrr.insert(10);
		bbrr.insert(8);
		bbrr.insert(12);
		bbrr.insert(11);
		bbrr.insert(14);
		bbrr.insert(15);
		bbrr.displayTree();
		AVLTree<Integer> bblr = new AVLTree<Integer>();
		bblr.insert(10);
		bblr.insert(7);
		bblr.insert(12);
		bblr.insert(6);
		bblr.insert(9);
		bblr.insert(8);
		bblr.displayTreeS();
		AVLTree<Integer> bbrl = new AVLTree<Integer>();
		bbrl.insert(10);
		bbrl.insert(8);
		bbrl.insert(13);
		bbrl.insert(12);
		bbrl.insert(14);
		bbrl.insert(11);
		bbrl.insert(15);
		bbrl.insert(16);
		bbrl.insert(7);
		bbrl.insert(6);
		bbrl.displayTree();
		AVLTree<Integer> aa = new AVLTree<Integer>();
		for(int i=10;i>1;i--){
			aa.insert(i);
		}
		aa.displayTree();
		aa.delete(4);
		aa.delete(6);
		aa.displayTree();
		aa.delete(9);
		aa.displayTree();*/
		
		TreeMap<Integer, Double> tm = new TreeMap<Integer, Double>();
		tm.put(10,0.1);
		tm.put(8,0.2);
		tm.put(12,0.3);
		tm.put(19,0.3);
		tm.put(14,0.3);
		tm.put(15,0.3);
		tm.put(18,0.3);
		System.out.println(tm.ceilingEntry(16).getKey());
		System.out.println(tm.floorEntry(13).getKey());
		
		
	}

}
