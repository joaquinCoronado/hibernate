package net.tecgurus.hibernate.models;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import net.tecgurus.hibernate.model.Maestro;
import net.tecgurus.hibernate.model.Maestro_;
import net.tecgurus.hibernate.util.HibernateUtil;

public class CriteriaPersonalizado {

	public static void main(String[] args) {
		
		//Crear una sesion con hibernate.
		Session session = HibernateUtil.getSessionFactory().openSession();
		//Inicia transacción.
		session.beginTransaction();
		
		//---------------------------------------------------------
		// Inician las operaciones de la transacción. 
		//---------------------------------------------------------
			CriteriaBuilder cBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Maestro> criteria = cBuilder.createQuery(Maestro.class);
		
			//Definimos el tipo de entidad que regresara la consulta. 
			Root<Maestro> root = criteria.from(Maestro.class);
			
			//Contruimos la consulta. 
			criteria.select(root)
					.where(cBuilder.and(
									//cBuilder.equal(root.get(Maestro_.nombre), "diego"),
									cBuilder.lessThan(root.get(Maestro_.idMaestro), 60),
									cBuilder.like(root.get(Maestro_.nombre), "%r%")
								)
							).orderBy(cBuilder.asc(root.get(Maestro_.nombre)));
			

			//Ejecutamos la consulta. 
			List<Maestro> maestros = session.createQuery(criteria).getResultList();
			
			for (Maestro maestro : maestros) {
				System.out.println(maestro);
			}
			
		//---------------------------------------------------------
		// Terminan las operaciones de la transacción.
		//---------------------------------------------------------
		
			
		//Se ejecutan las sentencias de la transacción. 
		session.getTransaction().commit();
		//Se cierra la sesión de hibernate. 
		session.close();
	}

}
