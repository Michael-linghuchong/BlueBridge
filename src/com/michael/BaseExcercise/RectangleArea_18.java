package com.michael.BaseExcercise;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

/*
试题 基础练习 矩形面积交
     
资源限制
时间限制：1.0s   内存限制：512.0MB
问题描述
　　平面上有两个矩形，它们的边平行于直角坐标系的X轴或Y轴。对于每个矩形，我们给出它的一对相对顶点的坐标，请你编程算出两个矩形的交的面积。
输入格式
　　输入仅包含两行，每行描述一个矩形。
　　在每行中，给出矩形的一对相对顶点的坐标，每个点的坐标都用两个绝对值不超过10^7的实数表示。
输出格式
　　输出仅包含一个实数，为交的面积，保留到小数后两位。
样例输入
1 1 3 3
2 2 4 4
样例输出
1.00
 */

/*
 这道题不考虑包含
 */
public class RectangleArea_18 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		HashMap<String, Double> m=new HashMap<>();
		m.put("ax1", sc.nextDouble());
		m.put("ay1", sc.nextDouble());
		m.put("ax2", sc.nextDouble());
		m.put("ay2", sc.nextDouble());
		m.put("bx1", sc.nextDouble());
		m.put("by1", sc.nextDouble());
		m.put("bx2", sc.nextDouble());
		m.put("by2", sc.nextDouble());
		sc.close();
		DecimalFormat fm=new DecimalFormat("0.00");
		
		//1、求出每个矩形的长、宽
		double alength=Math.abs(m.get("ax2")-m.get("ax1"));
		double awidth=Math.abs(m.get("ay2")-m.get("ay1"));
		double blength=Math.abs(m.get("bx2")-m.get("bx1"));
		double bwidth=Math.abs(m.get("by2")-m.get("by1"));
		
		//2、求得两个矩形最大的x与最小的x相减   最大的y与最小的y相减
		double dislength=Math.abs(max(m.get("bx1"), m.get("bx2"),m.get("ax1"), m.get("ax2"))-min(m.get("bx1"), m.get("bx2"),m.get("ax1"), m.get("ax2")));
		double diswidth=Math.abs(max(m.get("by1"), m.get("by2"),m.get("ay1"), m.get("ay2"))-min(m.get("by1"), m.get("by2"),m.get("ay1"), m.get("ay2")));
		
		//3、如果距离小于两个矩形长度的和，那肯定就有交的地方 ，那么交的长度就是   两个矩形长度的和-距离
		if(dislength<(alength+blength) && diswidth<(awidth+bwidth)){
			double length=(alength+blength)-dislength;
			double width=(awidth+bwidth)-diswidth;
			double area=length*width;
			System.out.println(fm.format(area));
		}else{
			System.out.println(fm.format(0));
		}
	}
	
	static double max(double a,double b,double c,double d){
		return Math.max(Math.max(a, b),Math.max(c, d));
	}
	static double min(double a,double b,double c,double d){
		return Math.min(Math.min(a, b),Math.min(c, d));
	}
}
























