

package test.algo;
public class QuickSortWithPartition {
	public static void main(String[] args) {
		int [] input = {6,5,4,3,2,1};
		printArray("Input:",input);
		quickSort(input,0,input.length-1);

		printArray("Output:",input);
	}

	private static void quickSort(int [] input,int b,int e){
		if(b<e){
			int part = partition(input,b,e);
			quickSort(input,b,part-1);
			quickSort(input,part+1,e);
		}
	}
	//partition algorithm. pick the pivot, run a loop from being to end-1. if a[i] is > pivot, increment i and swap elements
	// at i and j. finally return the element at i+1;
	private static int partition(int[] aInput, int begin, int end) {
		int i = begin-1;
		//let the partition element (the so called pivot) be the end element
		int partitionElement = aInput[end];
		for(int j=begin;j < end;j++){
			if(aInput[j] < partitionElement){
				i++;
				swap(aInput,i,j);
			}
		}
		// Now any number to the left of i is < pivot and anything to right of i is > pivot

		//swap the pivot with the i+1.
		swap(aInput,i+1,end);
		return i+1;
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
