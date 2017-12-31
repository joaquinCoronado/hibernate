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
		
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//Crear objeto de Maestro.
		Maestro objMaestro = new Maestro(24,"nuevo");
		objMaestro.setNombre("Jesica");  //insert into maestro (nombre) values (?)
		
		//Salvar el maestro.
		//session.save(objMaestro);
		//session.delete(objMaestro);
		//session.update(objMaestro);
		
//		IdentifierLoadAccess identifier = session.byId(Maestro.class); 	
//		Maestro objMaestroLoad = (Maestro) identifier.load(15);
//		System.out.println(objMaestroLoad);
		
		
//		CONSULTAS CON HQL
//		@SuppressWarnings("unchecked")
//		Query<Maestro> query = session.createQuery("from Maestro where nombre = :nombre");
//		query.setParameter("nombre", "diego");
//		List<Maestro> maestros = query.getResultList();
//		System.out.println(maestros.size());
//		for (Maestro maestro : maestros) {
//			System.out.println(maestro);
//		}

		
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Maestro> criteria = builder.createQuery(Maestro.class);
		
		Root<Maestro> root  = criteria.from(Maestro.class);
		
		criteria.select(root);
		
		List<Maestro> maestros = session.createQuery(criteria).getResultList();
		for (Maestro maestro : maestros) {
			System.out.println(maestro);
		}
		
		
		//session.getTransaction().rollback();
		session.getTransaction().commit();
		session.close();
	}

}
