
package test.algo;
public class QuickSort {

	public static void main(String[] args) {
		int [] input = {6,5,4,3,2,1};
		printArray("Input:",input);
		sort(input,0,input.length-1);
		printArray("Output:",input);
	}



	private static void sort(int[] aInput, int low, int high) {
		int left = low;
		int right = high;
		int pivot = (low+high)/2;
		while(left < right){
			while(aInput[left] < aInput[pivot])
				left++;
			while(aInput[right] > aInput[pivot])
				right--;
			if(left <= right){
				swap(aInput,left,right);
				left++;
				right--;
			}
			if(low < right)
				sort(aInput,low,right);
			if(high > left)
				sort(aInput,left,high);
		}

	}

	private static void swap(int[] aInput, int aLeft, int aRight) {
		int temp = aInput[aLeft];
		aInput[aLeft] = aInput[aRight];
		aInput[aRight] = temp;

	}
	private static void printArray(String aString, int[] aInput) {
		System.out.print(aString);
		for(int i : aInput)
			System.out.print(i+",");

	}

}
