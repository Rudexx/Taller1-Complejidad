package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;


public class Ordenamiento {

    public static int [] arreglo;

    public Ordenamiento (int[] arreglo , String opcion) { 
        Ordenamiento.arreglo = arreglo;
        
        switch (opcion) {
		case "Ordenamiento Burbuja":
			 long startTime = System.nanoTime();
			bubbleSort(arreglo);
			long endTime = System.nanoTime();
			System.out.println("Proceso Terminado en: " + (endTime-startTime)/1e6 + " ms");
			
			break;
		case "Ordenamiento de Selecci?n":
			 startTime = System.nanoTime();
			selectionSort(arreglo);
			endTime = System.nanoTime();
			System.out.println("Proceso Terminado en: " + (endTime-startTime)/1e6 + " ms");
			
			break;
		case "Ordenamiento Radix":
			startTime = System.nanoTime();
			radixSort(arreglo, arreglo.length);
			endTime = System.nanoTime();
			System.out.println("Proceso Terminado en: " + (endTime-startTime)/1e6 + " ms");
			break;
			case "Ordenamiento QuickSort":
				startTime = System.nanoTime();
				quicksort(arreglo);
		
				
				endTime = System.nanoTime();
				System.out.println("Proceso Terminado en: " + (endTime-startTime)/1e6 + " ms");
						break;
			case "Ordenamiento MergeSort":
				startTime = System.nanoTime();
				sort();
				endTime = System.nanoTime();
				System.out.println("Proceso Terminado en: " + (endTime-startTime)/1e6 + " ms");
				
			
				break;
			
		default:
			break;
		}
    }
    

    
    	
    
    // Using counting sort to sort the elements in the basis of significant places
    public void countingSort(int array[], int size, int place) {
      int[] output = new int[size + 1];
      int max = array[0];
      for (int i = 1; i < size; i++) {
        if (array[i] > max)
          max = array[i];
      }
      int[] count = new int[max + 1];

      for (int i = 0; i < max; ++i)
        count[i] = 0;

      // Calculate count of elements
      for (int i = 0; i < size; i++)
        count[(array[i] / place) % 10]++;

      // Calculate cumulative count
      for (int i = 1; i < 10; i++)
        count[i] += count[i - 1];

      // Place the elements in sorted order
      for (int i = size - 1; i >= 0; i--) {
        output[count[(array[i] / place) % 10] - 1] = array[i];
        count[(array[i] / place) % 10]--;
      }

      for (int i = 0; i < size; i++)
        array[i] = output[i];
    }

    // Function to get the largest element from an array
    int getMax(int array[], int n) {
      int max = array[0];
      for (int i = 1; i < n; i++)
        if (array[i] > max)
          max = array[i];
      return max;
    }

    // Main function to implement radix sort
   public void radixSort(int array[], int size) {
      // Get maximum element
      int max = getMax(array, size);

      // Apply counting sort to sort elements based on place value.
      for (int place = 1; max / place > 0; place *= 10)
        countingSort(array, size, place);
    }
	
	  public static void bubbleSort(int[] arr) {  
	        int n = arr.length;  
	        int temp = 0;  
	         for(int i=0; i < n; i++){  
	                 for(int j=1; j < (n-i); j++){  
	                          if(arr[j-1] < arr[j]){  
	                                 temp = arr[j-1];  
	                                 arr[j-1] = arr[j];  
	                                 arr[j] = temp;  
	                         }  
	                          
	                 }  
	         }  
	         
	  }
	  
	  /*
	     * Utility method to partition the array into smaller array, and
	     * comparing numbers to rearrange them as per quicksort algorithm.
	     */
	    private static int partition(int[] input, int position, int start, int end) {
	        int l = start;
	        int h = end - 2;
	        int piv = input[position];
	        swap(input, position, end - 1);

	        while (l < h) {
	            if (input[l] < piv) {
	                l++;
	            } else if (input[h] >= piv) {
	                h--;
	            } else {
	                swap(input, l, h);
	            }
	        }
	        int idx = h;
	        if (input[h] < piv) {
	            idx++;
	        }
	        swap(input, end - 1, idx);
	        return idx;
	    }

	    /**
	     * Utility method to swap two numbers in given array
	     *
	     * @param arr - array on which swap will happen
	     * @param i
	     * @param j
	     */
	    private static void swap(int[] arr, int i, int j) {
	        int temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }

	

	  public static void quicksort(int[] numbers) {
	        Stack stack = new Stack();
	        stack.push(0);
	        stack.push(numbers.length);

	        while (!stack.isEmpty()) {
	            int end = (int) stack.pop();
	            int start = (int) stack.pop();
	            if (end - start < 2) {
	                continue;
	            }
	            int p = start + ((end - start) / 2);
	            p = partition(numbers, p, start, end);

	            stack.push(p + 1);
	            stack.push(end);

	            stack.push(start);
	            stack.push(p);

	        }
	    }
	  
	  public static void sort(){
	        int []tempArray = new int[arreglo.length];
	        mergeSort(tempArray,0,arreglo.length-1);
	    }
	 
	    public static void mergeSort(int []tempArray,int lowerIndex,int upperIndex){
	        if(lowerIndex == upperIndex){
	            return;
	        }else{
	            int mid = (lowerIndex+upperIndex)/2;
	            mergeSort(tempArray, lowerIndex, mid);
	            mergeSort(tempArray, mid+1, upperIndex);
	            merge(tempArray,lowerIndex,mid+1,upperIndex);
	        }
	    }
	 
	    public static void merge(int []tempArray,int lowerIndexCursor,int higerIndex,int upperIndex){
	        int tempIndex=0;
	        int lowerIndex = lowerIndexCursor;
	        int midIndex = higerIndex-1;
	        int totalItems = upperIndex-lowerIndex+1;
	        while(lowerIndex <= midIndex && higerIndex <= upperIndex){
	            if(arreglo[lowerIndex] > arreglo[higerIndex]){
	                tempArray[tempIndex++] = arreglo[lowerIndex++];
	            }else{
	                tempArray[tempIndex++] = arreglo[higerIndex++];
	            }
	        }
	 
	        while(lowerIndex <= midIndex){
	            tempArray[tempIndex++] = arreglo[lowerIndex++];
	        }
	 
	        while(higerIndex <= upperIndex){
	            tempArray[tempIndex++] = arreglo[higerIndex++];
	        }
	 
	        for(int i=0;i<totalItems;i++){
	        	arreglo[lowerIndexCursor+i] = tempArray[i];
	        }
	    }
	  
	  
   

	  public static void selectionSort(int[] arr){  
	        for (int i = 0; i < arr.length - 1; i++)  
	        {  
	            int index = i;  
	            for (int j = i + 1; j < arr.length; j++){  
	                if (arr[j] > arr[index]){  
	                    index = j;//searching for lowest index  
	                }  
	            }  
	            int smallerNumber = arr[index];   
	            arr[index] = arr[i];  
	            arr[i] = smallerNumber;  
	        }  
	    }  

    public static void intercambiarNumeros(ArrayList<Integer> a, int i, int j)
    {
        int aux = a.get(i);
        a.set(i, a.get(j));
        a.set(j, aux);
    }


}

