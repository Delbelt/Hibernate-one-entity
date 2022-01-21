package test;

import java.time.LocalDate;

import datos.Cliente;
import negocio.ClienteABM;

public class TestClienteCRUD {

	public static void main(String[] args) {
		
		ClienteABM sistema = new ClienteABM();
		
		//Test *******************************
		
		try {			
				System.out.println("");
				
				System.out.println("Test 1: Modificar Cliente");				
				Cliente objeto = sistema.traerId(11);
				
				objeto.setApellido("Martina");
				objeto.setNombre("Velez");
				
				sistema.modificar(objeto);
				
				System.out.println(sistema.traerId(11));
				
				System.out.println("OK");				
			}
		
			catch(Exception e) 
			{
				System.out.println("Exception: "+e.getMessage());
			}

		
		//Test *******************************
		
		try {			
				System.out.println("");
				
				System.out.println("Test 3: Mostrar Cliente Actualizado");				
				System.out.println(sistema.traerId(11));
				System.out.println("OK");				
			}
		
			catch(Exception e) 
			{
				System.out.println("Exception: "+e.getMessage());
			}
		
		//Test *******************************
		
		try {			
				System.out.println("");
				
				System.out.println("Test 4: Agregar Cliente y mostrarlo");				
				sistema.agregar("Apellido", "Nombre", 2020, LocalDate.of(1999, 9, 9));
				System.out.println(sistema.traer(2020));
				
				System.out.println("OK");				
			}
		
			catch(Exception e) 
			{
				System.out.println("Exception: "+e.getMessage());
			}
		
		//Test *******************************
		
		try {			
				System.out.println("");
				
				System.out.println("Test 5: Eliminar cliente Agregado");
				sistema.eliminar(2020);				
				System.out.println("OK");				
			}
		
			catch(Exception e) 
			{
				System.out.println("Exception: "+e.getMessage());
			}
	}

}
