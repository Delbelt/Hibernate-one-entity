package test;

import java.time.LocalDate;
import java.util.logging.Level;

import negocio.ClienteABM;

public class TestCliente {

	public static void main(String[] args) {
		
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF); //Desactiva los mensajes en consola de Hibernate
		
		ClienteABM sistema = new ClienteABM();
		
		//Test *******************************
		
		try {			
				System.out.println("");
				
				System.out.println("Test 1: Traer Cliente por dni");
				System.out.println(sistema.traer(4444));
				System.out.println("OK");				
			}
		
			catch(Exception e) 
			{
				System.out.println("Exception: "+e.getMessage());
			}
		
		//Test *******************************
		
		try {			
				System.out.println("");
				
				System.out.println("Test 2: Traer Cliente por id");
				System.out.println(sistema.traerId(3));
				System.out.println("OK");				
			}
		
			catch(Exception e) 
			{
				System.out.println("Exception: "+e.getMessage());
			}
		
		//Test *******************************
		
		try {			
				System.out.println("");
				
				System.out.println("Test 3: Traer todos los clientes");
				System.out.println(sistema.traer());
				System.out.println("OK");				
			}
		
			catch(Exception e) 
			{
				System.out.println("Exception: "+e.getMessage());
			}
		
		//Test *******************************
		
		try {			
				System.out.println("");
				
				System.out.println("Test 4: Traer Clientes con el apellido 'Perez'");
				System.out.println(sistema.traer("Perez"));
				System.out.println("OK");				
			}
		
			catch(Exception e) 
			{
				System.out.println("Exception: "+e.getMessage());
			}
		
		//Test *******************************
		
		try {			
				System.out.println("");
				
				System.out.println("Test 5: Traer Clientes entre dos fechas de Nacimiento");
				
				LocalDate desde = LocalDate.of(1990, 1, 25);
				LocalDate hasta = LocalDate.of(1990, 6, 10);
				
				System.out.println(sistema.traer(desde, hasta));
				System.out.println("OK");				
			}
		
			catch(Exception e) 
			{
				System.out.println("Exception: "+e.getMessage());
			}
		
	}

}
