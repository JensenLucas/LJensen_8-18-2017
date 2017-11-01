/*Lucas Jensen
* 11/1/2017
* arrays lab 3
*/

import java.util.*;
public class ArraysLab3 {
	public static void main(String[] args) {
		int[] a1 = {5, 10, 15, 20, 25, 30, 35, 40};
		int[] a2 = {7, 14, 21, 28, 35, 42, 49, 56};
		int appendNum = 200;
		int removeIdx = 5;
		
		int[] sumArr = sum(a1, a2);
		int[] appendArr = append(a1, appendNum);
		int[] removeArr = remove(a2, removeIdx);
		int sumOfEvens = sumEven(appendArr);
		rotateRight(a1);
		
		System.out.println(Arrays.toString(sumArr));
		System.out.println(Arrays.toString(appendArr));
		System.out.println(Arrays.toString(removeArr));
		System.out.println(sumOfEvens);
		System.out.println(Arrays.toString(a1));
	}
	
	public static int[] sum(int[] arr1, int[] arr2) {
		int[] arr3 = new int[arr1.length];
		for(int i=0; i<arr1.length; i++) {
			arr3[i] = arr1[i] + arr2[i];
		}
		return arr3;
	}
	
	public static int[] append(int[] arr, int num) {
		int[] arr2 = new int[(arr.length)+1];
		for(int i=0; i < arr.length; i++) {
			arr2[i] = arr[i];
		}
		arr2[arr.length] = num;
		return arr2;
	}
	
	public static int[] remove(int[] arr, int idx) {
		int[] arr2 = new int[arr.length-1];
		int check = 0;
		for(int i=0; i < arr.length; i++) {
			if(i == idx) {
				check = 1;
			}else{
				arr2[i - check] = arr[i];
			}
		}
		return arr2;
	}
	
	public static int sumEven(int[] arr) {
		int sum = 0;
		for(int i=0; i<arr.length; i+=2) {
			sum += arr[i];
		}
		return(sum);
	}
	
	public static void rotateRight(int[] arr) {
		int temp = arr[arr.length-1];
		for(int i = arr.length-1; i > 0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = temp;
	}
}