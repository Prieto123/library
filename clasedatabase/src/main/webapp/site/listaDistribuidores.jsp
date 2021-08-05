<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<jsp:include page="common/head.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  	
		
		<br>
		<hr>
		<h1>Distribuidores</h1>
		<table class="table table-sm" id="tablaEjemplares">
		  <thead>
		    <tr>
		      <th scope="col" class="bg-danger id">Rut</th>
		      <th scope="col">Nombre</th>
		      <th scope="col">Año</th>
		      <th scope="col">Telefono</th>
		      <th scope="col">Dirección</th>
		      <th scope="col">#</th>
		    </tr>
		  </thead>
		  <tbody>
	  		<c:forEach var="dis" items="${distribuidores}">
		    	<tr>
		        	<th scope="row" class="bg-danger"><c:out value="${ dis.getRut() }-${dis.getNumero_verificador() }"/></th>
				    <td><c:out value="${ dis.getNombre() }"/></td>
				    <td><c:out value="${ dis.getAno_antiguedad() }"/></td>
				    <td><c:out value="${ dis.getTelefono().getNumero() }"/></td>
				    <td><c:out value="${ dis.getDireccion().getDireccion() }"/></td>
					<td>
						<a href="DetalleDistribuidor.do?rut=${ dis.getRut() }"><i class="fas fa-pencil-alt"></i></a>
						<a href="BorrarDistribuidor.do?rut=${ dis.getRut() }"><i class="fas fa-trash"></i></a> 
					</td>
			   	</tr>
	        </c:forEach>
			    
		  </tbody>
		</table>
		<button class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#anadirEjemplar">Nuevo Distribuidor</button>
		<!-- Modal para Crear Ejemplares  -->
		<div class="modal fade" id="anadirEjemplar" tabindex="-1" aria-labelledby="anadirEjemplarLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="anadirEjemplarLabel">Nuevo Distribuidor</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <form action="ListarDistribuidores.do" method="POST">
		      	<div class="modal-body">
		      		<div class="form-group row">
			        	<label for="rut" class="col-3 col-form-label">Rut</label>
			        	<div class="col-9">
			            	<input type="number" class="form-control ps-2" id="rut" name="rut"
			            	min="1000000" max="99999999" required>
			        	</div>
			        </div>
			        <br>
			        <div class="form-group row">
			        	<label for="verificador" class="col-3 col-form-label">Numero Verificador</label>
			        	<div class="col-9">
			            	<input type="number" class="form-control ps-2" id="verificador" name="verificador"
			            	min="1" max="9" required>
			        	</div>
			        </div>
			        <br>
			        <div class="form-group row">
			        	<label for="nombre" class="col-3 col-form-label">Nombre</label>
			        	<div class="col-9">
			            	<input type="text" class="form-control ps-2" id="nombre" name="nombre" required>
			        	</div>
			        </div>
			        <br>
			        <div class="form-group row">
			        	<label for="fecha" class="col-3 col-form-label">Año Contrato</label>
			        	<div class="col-9">
			            	<input type="number" class="form-control ps-2" id="fecha" name="fecha" min="2000" max="2021" required>
			        	</div>
			        </div>
			        <br>
			        <div class="form-group row">
			        	<label for="telefono" class="col-3 col-form-label">Telefono</label>
			        	<div class="col-9">
			            	<input type="number" class="form-control ps-2" id="telefono" name="telefono"
			            	min="900000000" max="999999999" required>
			        	</div>
			        </div>
			        <br>
			        <div class="form-group row">
			        	<label for="direccion" class="col-3 col-form-label">Direccion</label>
			        	<div class="col-9">
			            	<input type="text" class="form-control ps-2" id="direccion" name="direccion" required>
			        	</div>
			        </div>
			        
		      	</div>
		      	<div class="modal-footer">
		        	<button type="submit" class="btn btn-dark">Agregar Distribuidor</button>
		      	</div>
		      </form>		      
		    </div>
		  </div>
		</div> 
		
		
		
<jsp:include page="common/footer.jsp" />