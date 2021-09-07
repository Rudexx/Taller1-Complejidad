package co.edu.unbosque.view;



import javax.swing.JOptionPane;

public class VistaConsola {


	/**
	 * Es el metodo contructor de la clase
	 */
    public VistaConsola() {

    }
    /**
	 * Este metodo es para desplegar una lista con una serie de opciones predefinidas
	 * @param mensaje Es el mensaje que aparecera explicandole al usuario la funcion de su eleccion
	 * @param opciones Este arreglo contiene las opciones que contentra el mensaje
	 * @return este metodo retornara la opcion elegida por el usuario
	 */
    public String mostrarLista(String mensaje, Object[] opciones) {
    	Object o = JOptionPane.showInputDialog(null,mensaje, "Elegir",JOptionPane.QUESTION_MESSAGE,null,opciones, opciones[0]);
    	return  o.toString();

    }
    /**
	 * Este metodo es para mostrar un mensaje al usuario
	 */
    public void mostrarInformacion( String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    /**
	 * Este metodo es para desplegar una lista con una serie de opciones predefinidas
	 * @param mensaje Es el mensaje que aparecera explicandole al usuario la funcion de su eleccion
	 * @return Este metodo retornara la opcion elegida por el usuario
	 */
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
    /**
	 * Este metodo es para que el usuario pueda escribir el numero de datos
	 * @param mensaje Es el mensaje que se le mostrara al usuario pidiendole el numero de datos
	 * @return Se devolvera el numero de datos ingresado por el usuario.
	 */
    public String leerDato(String mensaje) {
    	String opcion = "";
        opcion = JOptionPane.showInputDialog(mensaje);

        return opcion;
    }







}
