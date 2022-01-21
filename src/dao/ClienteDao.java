package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;

public class ClienteDao {	

	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException
	{		
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}	

	private void manejaExcepcion(HibernateException he) throws HibernateException
	{		
		tx.rollback();//en caso de fallar vuelve a la configurar previa a la transaccion
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	// C R U D //
	
	public int agregar(Cliente objeto)
	{	
		int id = 0;

		try 
		{
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString()); //Guarda en Id el dato del objeto salvado
			tx.commit();
		}
		
		catch (HibernateException he) 
		{
			manejaExcepcion(he);
			throw he;
		}
		
		finally 
		{
			session.close();
		}
		
		return id;
	}

	public void actualizar(Cliente objeto) throws HibernateException
	{		
		try 
		{
			iniciaOperacion();
			session.update(objeto); 
			tx.commit();
		} 
		
		catch (HibernateException he) 
		{
			manejaExcepcion(he);
			throw he;
		} 
		
		finally 
		{
			session.close();
		}
	}

	public void eliminar(Cliente objeto) throws HibernateException
	{		
		try 
		{			
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} 
		
		catch (HibernateException he) 
		{
			manejaExcepcion(he);
			throw he;
		} 
		
		finally 
		{
			session.close();
		}
	}

	public Cliente traerId(long idCliente) throws HibernateException
	{
		
		Cliente objeto = null;
		
		try 
		{
			iniciaOperacion();
			objeto = (Cliente) session.get(Cliente.class, idCliente); //Permite leer/obtener un único objeto de la BD a partir de su clave primaria.
		} 
		
		finally 		
		{
			session.close();
		}
		
		return objeto;
	}	

	public Cliente traer(int dni) throws HibernateException
	{
		Cliente objeto = null;
		
		try
		{
			iniciaOperacion();			
			objeto = (Cliente) session.createQuery("from Cliente c where c.dni=" + dni).uniqueResult(); 
			//createQuery se utiliza para crear un HQL(Hibernate Query Languaje - Lenguaje de consulta)
			//from Cliente = es la CLASE Cliente y NO la tabla de BD cliente
			//dni = NOMBRE DEL ATRIBUTO de la CLASE
		}
		
		finally
		{
			session.close();
		}
		
		return objeto;
	}

	//Anotacion para garantizarle al IDE que la accion que se va a aplicar en la lista es correcta y no va a contener otro objeto.
	//Debido a que se esta usando una lista Generica List<T> y el IDE no sabe si lo que se va a hacer es correcto antes de ejecutar.
	@SuppressWarnings("unchecked")
	public List<Cliente> traer() throws HibernateException {
		
		List<Cliente> lista = null;
		
		try 
		{		
			iniciaOperacion();
			lista = session.createQuery("from Cliente c order by c.apellido asc, c.nombre asc").list();		
		} 
		
		finally 
		{
			session.close();
		}
		
		return lista;
	}	
	
}
