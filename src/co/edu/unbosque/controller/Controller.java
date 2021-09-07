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
			int tamano = Integer.parseInt(v.leerDato("Ingrese el tamaño de el arreglo"));
			int opcion = v.mostrarOpcion("Desea ingresar manualmente los numeros o automaticamente?");
			Object [] o = {"Ordenamiento Burbuja", "Ordenamiento de Selección" , "Ordenamiento Radix", "Ordenamiento QuickSort" , "Ordenamiento MergeSort"};
			Object[] casos = {"Peor Caso", "Mejor Caso", "Caso Promedio"};
			String caso = "";
			if(opcion == 0){
				caso = v.mostrarLista("Que tipo de caso desea ejecutar", casos);
			}
			String tipo = v.mostrarLista("Elija el tipo de ordenamiento que desea ejecutar", o);
			this.o = new Ordenamiento(llenarMatriz(opcion, tamano, caso) , tipo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error: Numero u opcion incorrecta");
		}
        
        
        
       
    }
 
	 /**
	 * Este metodo sirve para llenar el arreglo
 	 * @param opcion opcion para llenar el arreglo
	 * @param tamano tamaño del arreglo
	 * @param tipocaso tipo del caso que se quiere usar
	 * @return matriz
	 */
    public  int[] llenarMatriz(int opcion, int tamano, String tipocaso) {
    	int[] matriz = new int[tamano];
    	int contador = tamano;
        for(int i=0;i<tamano;i++) {
            	if(opcion == 0) {
            		if(tipocaso.equalsIgnoreCase("Peor Caso")) {
                        matriz[i] = (int) i;
            		}else if(tipocaso.equalsIgnoreCase("Mejor Caso")) {
            			matriz[i] = contador;
            			contador--;
            		}else {
            		 Random r = new Random();
                     double numeroM= r.nextInt(20);
                     matriz[i] = (int) numeroM;
            		}
            	}else {
            		try {
            		matriz[i] = Integer.parseInt(v.leerDato("Ingrese un numero"));
            		}catch(Exception e) {
            			JOptionPane.showMessageDialog(null, "Error: Numero u opcion incorrecta");
            			System.exit(0);
            		}
            	}
               
            }
        
        return matriz;
    }

}
