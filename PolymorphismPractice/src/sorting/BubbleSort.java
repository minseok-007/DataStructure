package sorting;

import java.util.ArrayList;
import java.util.Random;

public class BubbleSort {
	
	public static int swap_time =0;
	
	public static void print_arr(int [] arr) {
		for (int temp: arr) {
			System.out.print(temp +" ");
		}
		System.out.println("swap:" + swap_time);
		
	}

	public static void main(String[] args) {
		int arr [] = {1 , 8, 7, 6 ,4, 3, 9, 10 };
		//print_arr(arr);
		/*
		BubbleSort(arr);
		System.out.println();
		print_arr(arr);
		System.out.println();
		SelectionSort(arr);
		print_arr(arr);
		
		System.out.println();
		InsertionSort(arr);
		print_arr(arr);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		for (int temp:arr) {
			arr2.add(temp);
		}
		MergeSort(arr2);
		System.out.println(arr2);
		
		
		insertionSort(arr);
		for (int temp: arr) {
			System.out.print(temp +" ");
		}
		*/
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		for (int temp:arr) {
			arr2.add(temp);		
		}
			arr2=QuickSort(arr2);
			for (int temp: arr2) {
				System.out.print(temp+" ");
		}
	
	}
	
	static void Swap(int [] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2]= temp;
		swap_time++;
	}
	static void BubbleSort(int [] arr) {
		swap_time=0;
		for (int i=0; i<arr.length; i++) {
			for (int j=1; j<arr.length-i; j++) {
				if (arr[j-1]>arr[j]) {
					Swap(arr, j-1, j);
				}
			}
		}
	}
	
	static void ShakerSort(int [] arr) {
		//-> 해볼거면 해보기
	}
	
	public static void SelectionSort(int [] arr) {
		swap_time=0;
		for (int cursor=0; cursor<arr.length; cursor++) {
			int min_idx=cursor;
			int min_value= Integer.MAX_VALUE;
			for (int walker = cursor; walker<arr.length; walker++) {
				if (arr[walker]<min_value) {
					min_idx=walker;
					min_value=arr[walker];
				}
			}
			Swap(arr, cursor, min_idx);
		}
	}
	
	public static void insert(int [] arr, int src_idx, int dst_idx) 
	{
		int temp = arr[src_idx];
		for (int i= dst_idx; i<src_idx;i ++) {
			Swap(arr,i,i+1);
		}
		arr[dst_idx] = temp;
	}
	
	
	public static int fib(int n) {
		if (n==1) {
			return 1;
		}
		if (n==2) {
			return 1;
		}
		else {
			return fib(n-1)+ fib (n-2);
		}
	}
	
	public static ArrayList MergeSort(ArrayList<Integer> src) {
		if (src.size()==1) {
			return src;
		}
		ArrayList<Integer> prev = new ArrayList<Integer>();
		for (int i=0; i<src.size()/2; i++) 
		{
			prev.add(src.get(i));
		}
		prev = MergeSort(prev);
		ArrayList<Integer> next = new ArrayList<Integer>();
		for (int i=src.size()/2; i<src.size(); i++ ) {
			next.add(src.get(i));
		}
		next=MergeSort(next);
		ArrayList<Integer> result = new ArrayList <Integer>();
		
		int j=0;
		for (int i=0; i<prev.size() ;i++) {
			while (j<next.size()&& prev.get(i)>next.get(j)) {
				result.add(next.get(j));
				j++;
			}
			result.add(prev.get(i));=
		}
		for (; j<src.size()/2; j++) {
			result.add(next.get(j));
		}
		System.out.println(result);

		return result;
	}
	
	public static void insertionSort (int [] arr) {
		for (int i=1; i< arr.length; i++) {
			int temp = arr[i];
			int j=i;
			while (j>0 && arr[j-1]>temp) {
				arr[j] = arr[j-1];
				j--;
			}
			arr[j]=temp;
		}
	}
	public static ArrayList<Integer> QuickSort (ArrayList<Integer> arr) {
		
		if (arr.size()==1 || arr.size()==0) {
			return arr;
		}
		Random generator = new Random();
		int pivot = generator.nextInt(arr.size());
		ArrayList<Integer> prev_list = new ArrayList <Integer>();
		ArrayList<Integer> next_list = new ArrayList <Integer>();
		
		for (int i=0; i<pivot; i++) 
		{
			if (arr.get(i)>arr.get(pivot)) {
				next_list.add(arr.get(i));
			}
			else {
				prev_list.add(arr.get(i));
			}
		}
		for (int i = pivot+1; i<arr.size(); i++) {
			if (arr.get(i)>arr.get(pivot)) {
				next_list.add(arr.get(i));
			}
			else {
				prev_list.add(arr.get(i));
			}
		}
		System.out.print(prev_list);
		System.out.print(" "+arr.get(pivot)+ " " );
		System.out.println(next_list);
		 prev_list = QuickSort(prev_list);
		 next_list = QuickSort(next_list);
		 ArrayList <Integer> result_list = prev_list;
		 result_list.add(arr.get(pivot));
		 for (int temp: next_list) {
			 result_list.add(temp);
		 }
		return result_list;
	}
	
}	
