package com.fli.sortsimple.sort;

import java.util.Arrays;

public class SortSimpleReflect{
	
	
	public static <T> void swap(T[] arr,int i,int j){
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	//ð������ �����Ƚϣ�Ȼ�󽻻�,Ч����ͱȽϴ����࣬����������
	public static <T extends Comparable<T>> void bubbleSort(T[] arr){
		if(arr==null)
			return;
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr.length-i-1; j++){
				if(arr[j].compareTo(arr[j+1])>0){
					swap(arr,j,j+1);
				}
			}
		}
	}
	
	//ѡ������ ���Ѿ�ѡ������Ƚϣ�Ȼ�󽻻����Ƚϴ�����ð�ݲ�࣬����������
	public static <T extends Comparable<T>>  void selectSort(T[] arr){
		if(arr==null)
			return;
		for(int i=0; i<arr.length-1; i++){
			T min = arr[i];
			for(int j=i+1; j<arr.length; j++){
				if(arr[j].compareTo(min)<0){
					swap(arr,j,i);
					min = arr[j];
				}
			}
		}
	}
	
	//�������� ����������������뵽�Ѿ�����õĶ������棬���ڲ������������£��Ƚϴ��������
	public static <T extends Comparable<T>> void insertSort(T[] arr){
		if(arr==null)
			return;
		for(int i=1; i<arr.length; i++){
			int j = i - 1;
			T temp = arr[i];
			while(j>=0&&arr[j].compareTo(temp)>0){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p1 = new Person(15,"jack");
		Person p2 = new Person(15,"iac");
		Person p3 = new Person(16,"hello");
		Person p4 = new Person(13,"tom");
		Person p5 = new Person(12,"pearl");
		Person[] arr = new Person[5];
		arr[0] = p1;
		arr[1] = p2;
		arr[2] = p3;
		arr[3] = p4;
		arr[4] = p5;
		//SortSimple.bubbleSort(arr);
		SortSimpleReflect.insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	

}
