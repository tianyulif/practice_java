package com.fli.sortsimple.sort;

import java.util.Arrays;

public class SortSimple {
	
	
	public static void swap(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	//ð������ �����Ƚϣ�Ȼ�󽻻�
	public static void bubbleSort(int[] arr){
		if(arr==null)
			return;
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr.length-i-1; j++){
				if(arr[j]>arr[j+1]){
					swap(arr,j,j+1);
				}
			}
		}
	}
	
	//ѡ������ ���Ѿ�ѡ������Ƚϣ�Ȼ�󽻻�
	public static void selectSort(int[] arr){
		if(arr==null)
			return;
		for(int i=0; i<arr.length-1; i++){
			int min = arr[i];
			for(int j=i+1; j<arr.length; j++){
				if(arr[j]<min){
					swap(arr,j,i);
					min = arr[j];
				}
			}
		}
	}
	
	//�������� ����������������뵽�Ѿ�����õĶ�������
	public static void insertSort(int[] arr){
		if(arr==null)
			return;
		for(int i=1; i<arr.length; i++){
			int j = i - 1;
			int temp = arr[i];
			while(j>=0&&arr[j]>temp){
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
		int arr[] = {3,2,5,8,4,6,1,7};
		//SortSimple.bubbleSort(arr);
		SortSimple.insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
