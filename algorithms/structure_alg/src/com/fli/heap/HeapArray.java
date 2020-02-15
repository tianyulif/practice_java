package com.fli.heap;

/**
 * 构建数组堆结构实现堆排序
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
     * 先插入的放到叶子节点，然后向上比较交换
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
     * 父节点索引 = (子节点索引 - 1)/2
     * 子节点跟父节点比较，父节点>子节点就交换
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
     * 移除最大根节点，并重新构造heap模型
     *
     * @return 根节点
     */
    public Node remove() {
        Node top = nodeArray[0];
        nodeArray[0] = nodeArray[--currentSize];
        trickleDown(0);
        return top;
    }

    /**
     * 左子节点索引 = 父节点索引*2+1
     * 右子节点索引 = 左子节点索引+1
     * 父节点跟左子节点和右子节点大的一个交换
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
     * 新节点大于老节点上移，否则下移
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
