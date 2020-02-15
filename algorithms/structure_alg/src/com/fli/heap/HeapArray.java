package com.fli.heap;

/**
 * ��������ѽṹʵ�ֶ�����
 *
 * @author Administrator
 */
public class HeapArray {
    private Node[] nodeArray;
    private int currentSize;
    private int maxSize;

    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * �Ȳ���ķŵ�Ҷ�ӽڵ㣬Ȼ�����ϱȽϽ���
     *
     * @param key
     * @return
     */
    public boolean insert(int key) {
        Node n = new Node(key);
        if (isEmpty()) {
            nodeArray[0] = n;
            currentSize++;
            return true;
        } else {
            if (currentSize >= maxSize) {
                return false;
            }
            nodeArray[currentSize] = n;
            trickleUp(currentSize++);
        }
        return true;
    }

    /**
     * ���ڵ����� = (�ӽڵ����� - 1)/2
     * �ӽڵ�����ڵ�Ƚϣ����ڵ�>�ӽڵ�ͽ���
     *
     * @param index
     */
    public void trickleUp(int index) {
        int pIndex = (index - 1) / 2;
        Node bottom = nodeArray[index];
        while (index > 0 && nodeArray[pIndex].getKey() < bottom.getKey()) {
            nodeArray[index] = nodeArray[pIndex];
            index = pIndex;
            pIndex = (pIndex - 1) / 2;
        }
        nodeArray[index] = bottom;
    }

    /**
     * �Ƴ������ڵ㣬�����¹���heapģ��
     *
     * @return ���ڵ�
     */
    public Node remove() {
        Node top = nodeArray[0];
        nodeArray[0] = nodeArray[--currentSize];
        trickleDown(0);
        return top;
    }

    /**
     * ���ӽڵ����� = ���ڵ�����*2+1
     * ���ӽڵ����� = ���ӽڵ�����+1
     * ���ڵ�����ӽڵ�����ӽڵ���һ������
     *
     * @param index
     */
    public void trickleDown(int index) {
        int largeIndex = index;
        Node top = nodeArray[index];
        while (index < currentSize / 2) {
            int leftChild = index * 2 + 1;
            int rightChild = leftChild + 1;
            largeIndex = leftChild;
            if (rightChild < currentSize) {
                if (nodeArray[rightChild].getKey() > nodeArray[leftChild].getKey()) {
                    largeIndex = rightChild;
                }
            }
            if (top.getKey() < nodeArray[largeIndex].getKey()) {
                nodeArray[index] = nodeArray[largeIndex];
                index = largeIndex;
            } else {
                break;
            }

        }
        nodeArray[index] = top;
    }

    /**
     * �½ڵ�����Ͻڵ����ƣ���������
     *
     * @param index
     * @param newKey
     * @return
     */
    public Node change(int index, int newKey) {
        if (index >= currentSize) {
            return null;
        }
        Node oldNode = nodeArray[index];
        Node node = new Node(newKey);
        nodeArray[index] = node;
        if (newKey > oldNode.getKey()) {
            trickleUp(index);
        } else {
            trickleDown(index);
        }
        return oldNode;
    }


    public HeapArray(int maxSize) {
        this.currentSize = 0;
        this.maxSize = maxSize;
        nodeArray = new Node[maxSize];
    }

    private class Node {
        int key;

        Node(int key) {
            this.key = key;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        HeapArray ha = new HeapArray(20);
        ha.insert(15);
        ha.insert(21);
        ha.insert(34);
        ha.insert(5);
        ha.insert(9);
        ha.insert(27);
        ha.insert(31);
        ha.insert(41);
        ha.insert(11);
        ha.insert(14);
        ha.insert(25);
        ha.insert(20);
        ha.insert(18);
        for (int k = 0; k < ha.currentSize; k++) {
            System.out.print(ha.nodeArray[k].getKey() + ",");
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.print(ha.remove().getKey() + ",");
        }
		/*for(int i=0;i<13;i++){
			System.out.println(ha.remove().getKey()+",");
			for(int k=0;k<ha.currentSize;k++){
				System.out.print(ha.nodeArray[k].getKey()+",");
			}
			System.out.println();
		}*/
    }

}
