package exo.planche.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exo.planche.Entity.Planche;
import exo.planche.Infra.PlancheDao;

@Service
public class PlancheServiceImpl implements PlancheService {
	
	@Autowired
	PlancheDao dao;
	
	public void calculerNombrePlanche(double surface) {
		
		Planche planche = new Planche();
		planche.setNombreDePlanche(Calcul.calculerNombreDePlanche(surface));
		planche.setSurface(surface);
		
		dao.create(planche);
		
		
	}

}
