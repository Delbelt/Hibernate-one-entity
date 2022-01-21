package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	
	ClienteDao dao = new ClienteDao(); //Se instancia el objeto DAO para poder usar sus metodos

	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) throws Exception
	{		
		if(dao.traer(dni) != null) throw new Exception("El dni " + dni + " ya se encuentra registrado");
		
		return dao.agregar(new Cliente(apellido, nombre, dni, fechaDeNacimiento));
	}

	public void modificar(Cliente cliente) throws Exception
	{		
		Cliente objeto = dao.traerId(cliente.getIdCliente());
		
		if(objeto != null && objeto.getIdCliente() != dao.traer(cliente.getDni()).getIdCliente())
		throw new Exception("No se puede actualizar el cliente debido a que ese dni " + cliente.getDni() + " ya se encuentra registrado");
		
		dao.actualizar(cliente);
	}

	public void eliminarId(long idCliente) throws Exception
	{
		if(dao.traerId(idCliente) == null) 
		throw new Exception("Error: No se puede borrar el cliente, no existe");
		
		Cliente objeto = dao.traerId(idCliente);

		dao.eliminar(objeto);
	}
	
	public void eliminar(int dni) throws Exception
	{
		if(dao.traer(dni) == null) 
		throw new Exception("Error: No se puede borrar el cliente, no existe");

		dao.eliminar(dao.traer(dni));
	}
	
	public Cliente traerId(long idCliente) //OJO con el nombre si no se modifica siempre devuelve Null por el parametro
	{		
		return dao.traerId(idCliente);
	}

	public Cliente traer(int dni)
	{
		return dao.traer(dni);
	}
	
	public List<Cliente> traer()
	{
		return dao.traer();
	}
}
