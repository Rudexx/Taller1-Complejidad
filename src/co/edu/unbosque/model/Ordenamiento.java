package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Vector;


public class Ordenamiento {

    public static int [] arreglo;

    public Ordenamiento (int[] arreglo , String opcion) { 
        Ordenamiento.arreglo = arreglo;
        
        switch (opcion) {
		case "Ordenamiento Burbuja":
			bubbleSort(arreglo);
			System.out.println("Proceso Terminado");
			
			break;
		case "Ordenamiento de Selección":
			selectionSort(arreglo);
			System.out.println("Proceso Terminado");
			
			break;
		case "Ordenamiento Radix":
			radixSort(arreglo, arreglo.length);
			System.out.println("Proceso Terminado");
			
			break;
			case "Ordenamiento QuickSort":
				quickSort(arreglo, 0, arreglo.length-1);
				System.out.println("Proceso Terminado");
			
						break;
			case "Ordenamiento MergeSort":
				sort();
				System.out.println("Proceso Terminado");
			
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
	  
	  // method to find the partition position
	  static int partition(int array[], int low, int high) {
	    
	    // choose the rightmost element as pivot
	    int pivot = array[high];
	    
	    // pointer for greater element
	    int i = (low - 1);

	    // traverse through all elements
	    // compare each element with pivot
	    for (int j = low; j < high; j++) {
	      if (array[j] >= pivot) {

	        // if element smaller than pivot is found
	        // swap it with the greater element pointed by i
	        i++;

	        // swapping element at i with element at j
	        int temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	      }

	    }

	    // swapt the pivot element with the greater element specified by i
	    int temp = array[i + 1];
	    array[i + 1] = array[high];
	    array[high] = temp;

	    // return the position from where partition is done
	    return (i + 1);
	  }

	  static void quickSort(int array[], int low, int high) {
	    if (low < high) {

	      // find pivot element such that
	      // elements smaller than pivot are on the left
	      // elements greater than pivot are on the right
	      int pi = partition(array, low, high);
	      
	      // recursive call on the left of pivot
	      quickSort(array, low, pi - 1);

	      // recursive call on the right of pivot
	      quickSort(array, pi + 1, high);
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

