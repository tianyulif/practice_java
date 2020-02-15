package com.fli.sortadvanced.sort;

import java.util.Arrays;


public class SortAdvanced {
	
	//交换数组位置
	public static <T> void swap(T[] arr,int i,int j){
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	//划分
	public static <T extends Comparable<T>> int partitionIt(int left, int right, T pivot, T[] arr){
		int leftPtr = left - 1;
		int rightPtr = right + 1;
		while(true){
			while(leftPtr<right&&arr[++leftPtr].compareTo(pivot)<0);
			while(rightPtr>left&&arr[--rightPtr].compareTo(pivot)>0);
			if(leftPtr>rightPtr){
				break;
			}else{
				swap(arr, leftPtr, rightPtr);
			}
		}
		System.out.println("leftPtr="+leftPtr+"---rightPtr="+rightPtr);
		return leftPtr;
	}
	
	//间隔插入排序
	public static <T extends Comparable<T>> void insertSort(T[] arr){
		if(arr == null)
			return;
		
		for(int i=0; i<arr.length-1; i++){
				int j=i;
				T temp = arr[j+1];
				while(j>=0&&temp.compareTo(arr[j])<0){
					arr[j+1] = arr[j];
					j = j - 1;
				}
				arr[j+1] = temp;
		}
		
	}
	
	public static <T extends Comparable<T>> T medianOf3(T[] arr, int left, int right){
		int center = (left + right)/2;
		if(arr[left].compareTo(arr[center])>0){
			SortAdvanced.swap(arr, left, center);
		}
		if(arr[left].compareTo(arr[right])>0){
			SortAdvanced.swap(arr, left, right);
		}
		if(arr[center].compareTo(arr[right])>0){
			SortAdvanced.swap(arr, center, right);
		}
		//put pivot on right ???
		SortAdvanced.swap(arr, center, right-1);
		return arr[right-1];
	}
	
	public static  void shellSort001(int[] arr){
		if(arr == null)
			return;
		int h = arr.length/2;
		/*while(h<=arr.length/3){
			h = h * 3 +1;
		}*/
		
		while(h>0){
			for(int i=h;i<arr.length;i++){
				int j=i;
				int temp = arr[j];
				while(j>h-1&&arr[j-h]>temp){
					arr[j] = arr[j-h];
					j = j - h;
				}
				arr[j] = temp;
			}
			
			h = h/2;
		}
		
	}
	
	public static <T extends Comparable<T>> void quickSort(T[] arr, int left, int right){
		if(arr == null)
			return;
		if(right-left<=0){
			return;
		}else{
			T pivot = medianOf3(arr, left, right);
			int partition = SortAdvanced.partitionIt(left, right, pivot, arr);
			quickSort(arr, left, partition-1);
			quickSort(arr, partition+1, right);
		}
	}
	
	
	
	public static <T extends Comparable<T>> void shellSort(T[] arr){
		if(arr == null)
			return;
		int h = 1;
		
		while(h<=arr.length/3){
			h = 3 * h + 1;
		}
		
		while(h>0){
			for(int i=h; i<arr.length; i++){
				T temp = arr[i];
				int j=i;
				while(j>h-1&&arr[j-h].compareTo(temp)>0){
					arr[j] = arr[j-h];
					j = j - h;
				}
				arr[j] = temp;
				System.out.println(Arrays.toString(arr));
			}
			h = (h-1)/3;
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer arr[] = {3,2,55,24,5,30,8,4,16,12,30,19,6,1,7,23,43,56,17};
		//int arr[] = {3,2,55,24,5,8,4,16,12,19,6,1,7,23,43,56,17};
		//SortAdvanced.shellSort001(arr)
		//SortAdvanced.partitionIt(0, arr.length-1, 30, arr);
		SortAdvanced.quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
		
		
	}

}
