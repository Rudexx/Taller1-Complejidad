package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class Ordenamiento {

    public int [][] matriz;
    private int  tamano;

    public Ordenamiento (int[][] matriz , String opcion) { 
        this.matriz = matriz;
        this.tamano= matriz.length;
    }
    
	public static void intercambiar(int []a, int i, int j)
	{
		 int aux = a[i];
		 a[i] = a[j];
		 a[j]= aux ;
	}
	
	  public static void bubbleSort(int[] arr) {  
	        int n = arr.length;  
	        int temp = 0;  
	         for(int i=0; i < n; i++){  
	                 for(int j=1; j < (n-i); j++){  
	                          if(arr[j-1] > arr[j]){  
	                                 temp = arr[j-1];  
	                                 arr[j-1] = arr[j];  
	                                 arr[j] = temp;  
	                         }  
	                          
	                 }  
	         }  
	  }
	  
	  public static void quicksort(int A[], int izq, int der) {

		  int pivote=A[izq]; // tomamos primer elemento como pivote
		  int i=izq;         // i realiza la búsqueda de izquierda a derecha
		  int j=der;         // j realiza la búsqueda de derecha a izquierda
		  int aux;
		 
		  while(i < j){                          // mientras no se crucen las búsquedas                                   
		     while(A[i] <= pivote && i < j) i++; // busca elemento mayor que pivote
		     while(A[j] > pivote) j--;           // busca elemento menor que pivote
		     if (i < j) {                        // si no se han cruzado                      
		         aux= A[i];                      // los intercambia
		         A[i]=A[j];
		         A[j]=aux;
		     }
		   }
		   
		   A[izq]=A[j];      // se coloca el pivote en su lugar de forma que tendremos                                    
		   A[j]=pivote;      // los menores a su izquierda y los mayores a su derecha
		   
		   if(izq < j-1)
		      quicksort(A,izq,j-1);          // ordenamos subarray izquierdo
		   if(j+1 < der)
		      quicksort(A,j+1,der);          // ordenamos subarray derecho
		   
		}
	  
	  public static void mergesort(int A[],int izq, int der){
		    if (izq < der){
		            int m=(izq+der)/2;
		            mergesort(A,izq, m);
		            mergesort(A,m+1, der);                                                                                
		            merge(A,izq, m, der);                                                                                 
		    }
		}
	  
	  public static void merge(int A[],int izq, int m, int der){
		   int i, j, k;
		   int [] B = new int[A.length]; //array auxiliar
		   for (i=izq; i<=der; i++)      //copia ambas mitades en el array auxiliar                                       
		        B[i]=A[i];

		   i=izq; j=m+1; k=izq;
		     
		   while (i<=m && j<=der) //copia el siguiente elemento más grande                                      
		          if (B[i]<=B[j])
		              A[k++]=B[i++];
		          else
		              A[k++]=B[j++];
		        
		   while (i<=m)         //copia los elementos que quedan de la
		         A[k++]=B[i++]; //primera mitad (si los hay)
		}
	  
	  
   

    public ArrayList<Integer> ordenamientoSeleccion(ArrayList<Integer> primos){

        int index, i, j, n;
        n = primos.size();
        for (i = 0; i < n-1; i++)
        {
            index = i;
            for (j = i+1; j < n; j++)
                if (primos.get(j) > primos.get(index))
                    index = j;
            if (i != index)
                intercambiarNumeros(primos, i, index);
        }

        return primos;

    }

    public static void intercambiarNumeros(ArrayList<Integer> a, int i, int j)
    {
        int aux = a.get(i);
        a.set(i, a.get(j));
        a.set(j, aux);
    }
////////////getter-setter/////////////////

    public int[][] getMatriz() {
        return matriz;
    }
    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
        
       
    }

}

