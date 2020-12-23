package exo.planche.Infra;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import exo.planche.Entity.Planche;

@Repository
public class PlancheDaoImpl implements PlancheDao {
	
	public void create(Planche planche) {
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(planche);
		session.getTransaction().commit();
		session.close();
		
	}

}
