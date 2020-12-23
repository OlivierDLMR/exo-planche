package exo.planche.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Planche {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double nombreDePlanche;
	
	private double surface;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getNombreDePlanche() {
		return nombreDePlanche;
	}

	public void setNombreDePlanche(double nombreDePlanche) {
		this.nombreDePlanche = nombreDePlanche;
	}

	public double getSurface() {
		return surface;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}
	
	

}
