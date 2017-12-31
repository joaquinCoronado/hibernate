package net.tecgurus.hibernate.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.IdentifierLoadAccess;
import org.hibernate.Session;
import org.hibernate.query.Query;

import net.tecgurus.hibernate.model.Maestro;
import net.tecgurus.hibernate.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		
		//Se crea una sesión con hibernate.
		Session session = HibernateUtil.getSessionFactory().openSession();
		//Se inicia una transacción. 
		session.beginTransaction();
		
		//Crear objeto de Maestro.
		Maestro objMaestro = new Maestro(24,"nuevo");
		
		//Se ejecuta un INSERT.
		//session.save(objMaestro);
		
		//Se ejecuta un DELETE.
		//session.delete(objMaestro);
		
		//Se ejecuta un UPDATE.
		//session.update(objMaestro);
		
		
		//------------------
		// #### SELECT ####
		//------------------
		
//		//Se busca un elemento por ID.
//		IdentifierLoadAccess identifier = session.byId(Maestro.class); 	
//		Maestro objMaestroLoad = (Maestro) identifier.load(15);
//		System.out.println(objMaestroLoad);
		
		
//		//***********HQL***************
//		//Se crea la consulta. 
//		@SuppressWarnings("unchecked")
//		Query<Maestro> query = session.createQuery("from Maestro where nombre = :nombre");
//		
//		//Se agregan los parámetros de la consulta. 
//		query.setParameter("nombre", "diego");
//		
//		//Se obtienen los resultados de la consulta. 
//		List<Maestro> maestros = query.getResultList();
//		
//		//Se muestran los resultados de la consulta y  el tamaño de la lista. 
//		System.out.println(maestros.size());
//		for (Maestro maestro : maestros) {
//			System.out.println(maestro);
//		}

		
//		//********CRITERIA**************
//		//Se crea el manejador de criterios. 
//		CriteriaBuilder builder = session.getCriteriaBuilder();
//		
//		//Se espesifica la clase mapeada para la consulta con criterios. 
//		CriteriaQuery<Maestro> criteria = builder.createQuery(Maestro.class);
//		
//		//Se crea una raíz para la consulta. 
//		Root<Maestro> root  = criteria.from(Maestro.class);
//		
//		//Se carga un select al criterio. 
//		criteria.select(root);
//		
//		//Se ejecuta el query con criterios y se obtiene el resultado. 
//		List<Maestro> maestros = session.createQuery(criteria).getResultList();
//		
//		//Se muestra la información resultante. 
//		for (Maestro maestro : maestros) {
//			System.out.println(maestro);
//		}
		
		
		//session.getTransaction().rollback();
		session.getTransaction().commit();
		session.close();
	}

}
