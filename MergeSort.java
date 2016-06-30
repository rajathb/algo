

package test.algo;
public class MergeSort {
	
	public static void main(String[] args) {
		int [] input = {21,13,78,52,7};
		printArray("Input:",input);
		mergeSort(input);
		printArray("Output:",input);

	}

	private static void mergeSort(int[] aInput) {
		int inputLength = aInput.length;
		partitionAndMerge(aInput,inputLength);
		
	}

	private static void partitionAndMerge(int[] aInput, int aInputLength) {
		if(aInputLength <= 1){
			return;
		}
		//find mid of array
		int mid = aInputLength/2;
		
		//create two arrays to hold left and right splits
		int [] leftPartition = new int[mid];
		int [] rightPartition = new int[aInputLength - mid];
		for(int i = 0;i<mid;i++){
			leftPartition[i] = aInput[i];
		}
		for(int i = mid;i<aInputLength;i++){
			rightPartition[i-mid] = aInput[i];
		}
		
		//recursively partition left and right array
		partitionAndMerge(leftPartition,leftPartition.length);
		partitionAndMerge(rightPartition,rightPartition.length);
		merge(leftPartition,rightPartition,aInput);
	}

	private static void merge(int[] aLeftPartition, int[] aRightPartition, int[] aInput) {
		int leftSize = aLeftPartition.length;
		int rightSize = aRightPartition.length;
		int i = 0; //to iterate left partition
		int j = 0; //to iterate right partition
		int k = 0; //to iterate the original array
		
		while(i < leftSize && j < rightSize){
			if(aLeftPartition[i] < aRightPartition[j]){
				aInput[k] = aLeftPartition[i];
				i++;
			}
			else{
				aInput[k] = aRightPartition[j];
				j++;
			}
			k++;
		}
		
		//handle the cases when one of the partitions exhaust first
		while(i < leftSize){
			aInput[k] = aLeftPartition[i];
			i++;
			k++;
		}
		while(j < rightSize){
			aInput[k] = aRightPartition[j];
			j++;
			k++;
		}
		
	}

	private static void printArray(String aString, int[] aInput) {
		System.out.print(aString);
		for(int i : aInput)
			System.out.print(i+",");
		
	}

}
