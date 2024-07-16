package ec.edu.ups.ppw64.demo64.business;

import java.util.List;

import ec.edu.ups.ppw64.demo64.dao.UniversidadDAO;
import ec.edu.ups.ppw64.demo64.model.Universidad;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionUniversidad {
	
private int ultimoCodigo = 0;
	
	@Inject
	private UniversidadDAO daoUniversidad;

	public void guardarUniversidad(Universidad universidad) {
		if (universidad.getCodigo() == 0) {
			universidad.setCodigo(++ultimoCodigo);
        }
		
		Universidad cli = daoUniversidad.read(universidad.getCodigo());
		if (cli != null){
			daoUniversidad.update(universidad);
		}else {
			daoUniversidad.insert(universidad);
		}
	}
	
	public void actualizarUniversidad(Universidad universidad) throws Exception {
		Universidad cli = daoUniversidad.read(universidad.getCodigo());
		if (cli != null){
			daoUniversidad.update(universidad);
		}else {
			throw new Exception("Producto no existe");
		}
	}
	
	public Universidad getUniversidadPorNombre(String nombre) throws Exception {
	    if(nombre.isEmpty()) {
	        throw new Exception("El nombre de la Universidad no puede estar vacío");
	    }
	    
	    return daoUniversidad.getProductoPorNombre(nombre);
	}
	
	public void borrarUniversidad(int codigo){
		
		daoUniversidad.remove(codigo);
	}
	
	public List<Universidad> getUniversidades(){
		return daoUniversidad.getAll();
	}
}
