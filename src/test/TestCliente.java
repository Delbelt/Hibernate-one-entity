package test;

import negocio.ClienteABM;

public class TestCliente {

	public static void main(String[] args) {
		
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
		
	}

}
