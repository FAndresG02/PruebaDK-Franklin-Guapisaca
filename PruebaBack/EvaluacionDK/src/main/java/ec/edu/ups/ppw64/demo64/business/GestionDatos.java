package ec.edu.ups.ppw64.demo64.business;

import java.util.Date;
import java.util.List;

import ec.edu.ups.ppw64.demo64.dao.UniversidadDAO;
import ec.edu.ups.ppw64.demo64.model.Universidad;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {

	@Inject
	private UniversidadDAO daoUniversidad;
	
	@PostConstruct
	public void init() {
		System.out.println("iniciando");
		
		Universidad producto = new Universidad();
		producto.setCodigo(1);
		producto.setUbicacion("Calle Vieja 12-30 y Elia Liut. Cuenca, Ecuador");;
		producto.setDescripcion("La Universidad Politécnica Salesiana tiene un carácter nacional.");
		producto.setNombre("UPS");
		
		daoUniversidad.insert(producto);
		
		
	}
}
