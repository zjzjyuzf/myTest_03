package com.yuzf.Interview.test;

import java.util.Arrays;

/*
	分享一道今日某条的面试真题： 
	实现一个方法，入参是一个正整数，返回值是该整数最近的大于自身的数字相同的整数。 
	比如： 
	入参23541，返回24135      
	入参24135，返回24153 
	入参24153，返回24315 
	这道题隐藏着一个规律： 
	有限位的整数，顺序的情况最小，逆序的情况最大。 23541   	数组从最大索引位开始往前就等于倒序操作
	所以对于给定参数，先找到它从个位开始的逆序范围边界，
	然后把边界之前的一个数字，替换成逆序当中刚好大于它的数字，
	再把范围内的若干数字重新变为顺序。 
	听起来听绕的，小灰的实现代码如下，
	参数使用数组便于交换元素： 
*/

public class NearestNumberTest {

	// 主流程，返回最近一个大于自身的相同数字组成的整数。
	public static int[] findNearestNumber(int[] numbers) {
		// 拷贝入参，避免直接修改入参
		int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
		int index = findTransferPoint(numbersCopy);
		// 如果数字置换边界是0，说明整个数组已经逆序，无法得到更大的相同数字组成的整数，返回自身
		if (index == 0) {
			return numbersCopy;
		}
		exchangeHead(numbersCopy, index);
		reverse(numbersCopy, index);
		return numbersCopy;
	}

	// 获取逆序的最后一位，数字置换的边界
	private static int findTransferPoint(int[] numbers) {
		for (int i = numbers.length - 1; i > 0; i--) {

			if (numbers[i] > numbers[i - 1]) {
				// 23541 235  返回 2

				return i;
			}
		}
		return 0;
	}

	// 置换边界的前一位与逆序部分刚好大于它的数字交换位置
	private static int[] exchangeHead(int[] numbers, int index) {
		int head = numbers[index - 1];   //3
		for (int i = numbers.length - 1; i > 0; i--) {
			if (head < numbers[i]) {
				numbers[index - 1] = numbers[i];   
				numbers[i] = head;
				break;
			}
		}
		return numbers;    //24531
	}

	// 逆序部分转为顺序
	private static int[] reverse(int[] num, int index) {
		for (int i = index, j = num.length - 1; i < j; i++, j--) { // i->2 j->4
			int temp = num[i];   
			num[i] = num[j];
			num[j] = temp;
		}
		return num;   //24135
	}

	// 输出数组
	private static void outputNumbers(int[] numbers) {
		for (int i : numbers) {
			System.out.print(i);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] numbers = { 2, 3, 5, 4, 1 };
		for (int i = 0; i < 5; i++) {
			numbers = findNearestNumber(numbers);
			outputNumbers(numbers);
		}
	}

}
