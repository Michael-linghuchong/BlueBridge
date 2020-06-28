package com.michael.BaseExcercise;

import java.util.Scanner;

/*
资源限制
时间限制：1.0s   内存限制：512.0MB
问题描述
　　给定一个长度为n的数列，将这个数列按从小到大的顺序排列。1<=n<=200
输入格式
　　第一行为一个整数n。
　　第二行包含n个整数，为待排序的数，每个整数的绝对值小于10000。
输出格式
　　输出一行，按从小到大的顺序输出排序后的数列。
样例输入
5
8 3 6 4 9
样例输出
3 4 6 8 9
 */
public class SequenceSort_13 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		sc.close();
		quickSort(arr,0,arr.length-1);
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}
	
	/*
	 * 其实可以直接使用Arrays.sort() 
	 * 底层是DualPivotQuicksort.sort(a, 0, a.length - 1, null, 0, 0);使用的
	 * 是双中值快速排序，所以比单中值的快速排序还要快
	 */
	
	static void quickSort(int[] arr,int left,int right){
		int l=left;
		int r=right;
		int piovt=arr[(left+right)/2];//中间值
		int temp=0;//临时变量
		while(l<r){
			while(arr[l]<piovt){
				l++;
			}
			while(arr[r]>piovt){
				r--;
			}
			
			if(l>=r){
				break;
			}
			
			temp=arr[l];
			arr[l]=arr[r];
			arr[r]=temp;
			
			if(arr[l]==piovt){
				r--;
			}
			
			if(arr[r]==piovt){
				l++;
			}
		}
		
		if(l==r){
			l++;
			r--;
		}
		
		if(left<r){
			quickSort(arr, left, r);
		}
		
		if(right>l){
			quickSort(arr, l, right);
		}
		
		
	}
}


















