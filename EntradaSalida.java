package paqueteexportador;

import java.util.Scanner;

public class EntradaSalida {
public static final int SALIR=3;
public static final int CSV2MYSQL=1;	
public static final int MYSQL2CSV=2;
public static int mostrarMenu()
	{
		int opcion=0 ;
		System.out.println(CSV2MYSQL+" Pasar de CSV a MySQL");
		System.out.println(MYSQL2CSV+" Pasar de MySQL a CSV");
		System.out.println(SALIR+" Salir");
		opcion=(new Scanner(System.in)).nextInt();
		return opcion;
	}
}
