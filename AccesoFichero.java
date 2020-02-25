package paqueteexportador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AccesoFichero implements Constantes{

public static ArrayList<Contacto> recuperarContactos()
	{
		ArrayList<Contacto> lista_contactos=new ArrayList();
		
		try {
			FileReader fr=new FileReader(ruta);
			BufferedReader br=new BufferedReader(fr);
			String linea=br.readLine();
			while(linea!=null)
			{
				String[] datos=linea.split(separador);
				//String aux=nombre+separador+email+separador+telefono;
				Contacto c=new Contacto(datos[0], datos[2], datos[1]);
				lista_contactos.add(c);
				linea=br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista_contactos;
	}

public static int grabarContactos(ArrayList contactos) {
	int n_inserciones=0 ;
	FileWriter fw=null;
	try {
		 fw=new FileWriter(ruta);
		for (Object object : contactos) {
			Contacto c=(Contacto) object;
			String linea=c.pasarA_CSV();
			fw.write(linea);
			n_inserciones++;
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// TODO Auto-generated method stub
	return n_inserciones;
}
}
