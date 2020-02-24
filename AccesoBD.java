package paqueteexportador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class AccesoBD implements Constantes{
private static Connection c=null;
private static Statement stmt=null;

public static void conectar()
	{
	Properties p=new Properties();
	p.put("user", usuario);
	p.put("password", passwd);
	
		try {
			c=DriverManager.getConnection(url_bd, p);
			stmt=c.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
public static int grabarContactos(ArrayList<Contacto> lista)
{
	int n_insertados=0;
	
	for (Contacto contacto : lista) {
		String sql="INSERT INTO t_contactos (nombre, email, telefono) "
				+ "VALUES ('"+contacto.getNombre()+
				"', '"+contacto.getEmail()+"', '"+contacto.getTelefono()+"')";
		try {
			stmt.executeUpdate(sql);
			n_insertados++;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	return n_insertados;	
}
public static ArrayList recuperarContactos(Object object) {
	// TODO Auto-generated method stub
	String sql="SELECT nombre, email, telefono FROM t_contactos";
	ArrayList lista=new ArrayList();
	try {
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			String nombre=rs.getString("nombre");
			String email=rs.getString("email");
			String telefono=rs.getString("telefono");
			Contacto c=new Contacto(nombre, telefono, email);
			lista.add(c);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return lista;
}














}
