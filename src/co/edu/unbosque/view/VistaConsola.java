package co.edu.unbosque.view;



import javax.swing.JOptionPane;

public class VistaConsola {



    public VistaConsola() {

    }

    public String mostrarLista(String mensaje, Object[] opciones) {
    	Object o = JOptionPane.showInputDialog(null,mensaje, "Elegir",JOptionPane.QUESTION_MESSAGE,null,opciones, opciones[0]);
    	return  o.toString();

    }

    public void mostrarInformacion( String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public Integer mostrarOpcion(String mensaje) {
    	String [] options = {  "Automatico", "Manual"};
    	return JOptionPane.showOptionDialog(null,
    			mensaje,
    			"Tipo de Generación de numeros",
    			JOptionPane.YES_NO_OPTION,
    			JOptionPane.QUESTION_MESSAGE,
    			null,     //do not use a custom Icon
    			options,  //the titles of buttons
    			options[0]); //default button title
    }

    public String leerDato(String mensaje) {
    	String opcion = "";
        opcion = JOptionPane.showInputDialog(mensaje);

        return opcion;
    }







}
