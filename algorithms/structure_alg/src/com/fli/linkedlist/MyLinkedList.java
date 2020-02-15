package com.fli.linkedlist;

import java.util.AbstractSequentialList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

//Ä£·ÂlinkedlistÖØÐ´
public class MyLinkedList<E> extends AbstractSequentialList<E>
				implements List<E>,  Cloneable, java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8104693872989328480L;
	
	
	private transient MyEntry<E> header = new MyEntry<E>(null, null, null);
    private transient int size = 0;
	

    private static class MyEntry<E> {
    	E element;
    	MyEntry<E> next;
    	MyEntry<E> previous;
    	MyEntry(E e, MyEntry<E> previous, MyEntry<E> next){
    		this.element = e;
    		this.next = next;
    		this.previous = previous;
    	}
    }
	

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return this.size;
	}
	
	public boolean add(E e) {
		addBefore(e, header);
		return true;
	}

	public void addBefore(E e, MyEntry<E> entry) {
		MyEntry<E> my = new MyEntry<E>(e, entry.previous, entry);
		entry.previous.next = my;
		entry.previous = my;
		size++;
	}

	
	public void addFirst(E e) {
		addBefore(e, header.next);
	}

	public void addLast(E e) {
		addBefore(e, header);
	}


	public E element() {
		return getFirst();
	}
	
	public E get(int index) {
		return getEntry(index).element;
		
	}
	
	private MyEntry<E> getEntry(int index){
		return entry(index);
	}
	
	private MyEntry<E> entry(int index) {
		 if (index < 0 || index >= size)
	            throw new IndexOutOfBoundsException("Index: "+index+
	                                                ", Size: "+size);
		 MyEntry<E> e = header;
		 if(index<(size>>1)){
			 for(int i=0; i<index; i++){
				 e = e.next;
			 }
		 }else{
			 for(int i=size; i>index; i--){
				 e = e.previous;
			 }
		 }
		 return e;
	}

	public E getFirst() {
		return header.next.element;
	}

	public E getLast() {
		return header.previous.element;
	}


	public E peek() {
		if (size==0)
            return null;
        return getFirst();
	}

	public E peekFirst() {
		if (size==0)
            return null;
        return getFirst();
	}

	public E peekLast() {
		if (size==0)
            return null;
        return getLast();
	}

	public E pop() {
		return removeFirst();
	}


	public E remove() {
		return remove(header.previous);
	}
	
	public E remove(MyEntry<E> e) {
		if (e == header)
		    throw new NoSuchElementException();
		MyEntry<E> last = header.previous;
		E result = header.element;
		last.previous.next = header;
		header.previous = last.next;
		last.previous = null;
		last.next = null;
		size--;
		return result;
	}

	public E removeFirst() {
		return remove(header.next);
	}


	public E removeLast() {
		return remove(header.previous);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(10);
		ll.add(20);
		ll.add(30);
		Iterator<Integer> it = ll.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}


}
