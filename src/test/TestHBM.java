package test;

import org.hibernate.Session;

import dao.HibernateUtil;

public class TestHBM {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession(); //Crea la Session
		session.beginTransaction(); //Crea una nueva transacción
		session.close(); //Una vez finalizada la transacción se deberá cerrar la sesión
		System.out.println("OK");
	}
}
