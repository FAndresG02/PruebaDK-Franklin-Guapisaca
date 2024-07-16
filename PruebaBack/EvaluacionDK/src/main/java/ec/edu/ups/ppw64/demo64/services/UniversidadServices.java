package ec.edu.ups.ppw64.demo64.services;

import java.util.List;

import ec.edu.ups.ppw64.demo64.business.GestionUniversidad;
import ec.edu.ups.ppw64.demo64.model.Universidad;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("universidad")
public class UniversidadServices {
	
	@Inject
	private GestionUniversidad gUniversidad;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear (Universidad universidad) {
		try{
			gUniversidad.guardarUniversidad(universidad);;
			ErrorMessage error = new ErrorMessage(1, "ok");
			return Response.status(Response.Status.CREATED).entity(error).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
			
		}
	}
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Universidad universidad) {
		try{
			gUniversidad.actualizarUniversidad(universidad);;
			return Response.ok(universidad).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response borrar(@QueryParam("id") int codigo) {
	    try {
	    	gUniversidad.borrarUniversidad(codigo);;
	        return Response.ok("Producto Eliminado").build();
	    } catch (Exception e) {
	        ErrorMessage error = new ErrorMessage(99, "Error al eliminar la Universidad: " + e.getMessage());
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity(error)
	                .build();
	    }
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getUniversidades(){
		List<Universidad> universidad = gUniversidad.getUniversidades();
		if(universidad.size()>0)
			return Response.ok(universidad).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran Universidades");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
	}
	
}
