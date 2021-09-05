package co.edu.unbosque.controller;

import java.util.Random;

import javax.swing.JOptionPane;



import co.edu.unbosque.model.Ordenamiento;
import co.edu.unbosque.view.VistaConsola;

public class Controller {

    private VistaConsola v;
    private Ordenamiento o;
    int numerof;

    public Controller (){
        
        v = new VistaConsola();
        
        try {
			int tamano = Integer.parseInt(v.leerDato("Ingrese el tamaño de la matriz"));
			int opcion = v.mostrarOpcion("Desea ingresar manualmente los numeros o aleatoriamente?");
			Object [] o = {"Ordenamiento Burbuja", "Ordenamiento de Selección" , "Ordenamiento Radix", "Ordenamiento QuickSort" , "Ordenamiento MergeSort"};
			String tipo = v.mostrarLista("Elija el tipo de ordenamiento que desea ejecutar", o);
			System.out.println(tipo);
			this.o = new Ordenamiento(llenarMatriz(opcion, tamano) , tipo);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Error: Numero u opcion incorrecta");
		}
        
        
        
       
    }
 
    
    public  int[][] llenarMatriz(int opcion, int tamano) {
    	int[][] matriz = new int[tamano][tamano];
        for(int i=0;i<tamano;i++) {
            for(int j=0;j<tamano;j++) {
            	if(opcion == 0) {
            		 Random r = new Random();
                     double numeroM= r.nextInt(10);
                     matriz[i][j] = (int) numeroM;
            	}else {
            		try {
            		matriz[i][j] = Integer.parseInt(v.leerDato("Ingrese un numero"));
            		}catch(Exception e) {
            			JOptionPane.showMessageDialog(null, "Error: Numero u opcion incorrecta");
            			System.exit(0);
            		}
            	}
               
            }
        }
        return matriz;
    }

}
