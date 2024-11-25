package modelo;

/**
*<h2>Clase ExceptionPoliza</h2>
*Clase que se encarga del manejo de las excepciones del proyecto de manera personalizada<br><br>
*@Project Poliza de Seguros
*@Date 21/11/2024
*@Author Jos� Carlos Ascencio Navarro
*@DesarrolladoEn UACM San Lorenzo Tezonco
*@version 1.0.0
**/


public class ExceptionPoliza extends Exception{
	private static final long serialVersionUID = 1L;
	private String motivo;
	private int id;
	
	public ExceptionPoliza(String mensaje){
		super(mensaje);
	}
	
	public ExceptionPoliza(int codError) {
		super(codigoExcepcion(codError));
	}	
	
	public ExceptionPoliza(String mensaje, int id) {
		this(mensaje);
		this.id=id;
	}
	
	public ExceptionPoliza(String mensaje, String motivo) {
		this(mensaje);
		this.motivo=motivo;
	}
	
	public ExceptionPoliza(String mensaje, String motivo, int id) {
		this(mensaje, motivo);
		this.id=id;
	}
	
	public String dameMotivo() {
		return motivo;
	}
	
	public int dameId() {
		return id;
	}
	
	/**
	 * <p><b>codigoExcepcion() : Metodo que retorna un mensaje dado un codigo de excepcion</b></p>
	 * @param codigoExcepcion : Es un codigo entero que hace referencia a una excepcion
	 * @return Regresa el mensaje apropiado para las excepciones dado un codigo entero
	*/
	private static String codigoExcepcion(int codigoExcepcion) {
		String mensaje="";
		switch(codigoExcepcion) {
			//302 Found: Se encontr� exitosamente
			case 302: mensaje="El elemento ya existe ^_^!";
				break;
			//404 NOT FOUND: No se han inicializado los atributos, as� que no puede regresarlos o no existe.
			case 404: mensaje="No se pudo encontrar =(\nSeguramente aun NO has ingresado nada XD";
				break;
			//206 Partial Content
			case 206: mensaje="Estas intentando agregar un elemento con contenido incompleto ^_^!\nPor favor completalo y vuelve a intentarlo =)";
				break;
			//204 No Content
			case 204: mensaje="Operaci\u00f3n Inv\u00e1lida\nEl elemento esta VACIO o es NULO";
				break;
			//416 Range Not Satisfiable: Se introdujo un n�mero menor o igual a 0 o mayor al requerido.
			case 416: mensaje="El valor introducido es un valor Inv\u00e1lido :(\nInt\u00e9ntelo Nuevamente =)";
				break;
			//507 Insufficient Storage: Se excedio el limite de espacio.
			case 507: mensaje="No es posible realizar la acci\u00f3n.\nEl elemento que intentas agregar excede el limite de elementos que puedes agregar =(";
				break;
			//Default: Error no controlado
			default: mensaje="Error Desconocido =(";
				break;
		}
		return mensaje;
	}
	
}
