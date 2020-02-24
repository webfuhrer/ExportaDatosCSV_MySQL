package paqueteexportador;

public class Contacto  implements Constantes{
private  String nombre;
private  String telefono;
private String email;
public Contacto(String nombre, String telefono, String email) {
	super();
	this.nombre= nombre;
	this.telefono = telefono;
	this.email = email;
}
public String getNombre() {
	return nombre;
}
public String getTelefono() {
	return telefono;
}
public String getEmail() {
	return email;
}
public String pasarA_CSV()
	{
		String aux=nombre+separador+email+separador+telefono;
		return aux;
				
	}

}
