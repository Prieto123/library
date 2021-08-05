<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<jsp:include page="common/head.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  	
		
		<br>
		<hr>
		<h1>Ejemplares</h1>
		<table class="table table-sm" id="tablaEjemplares">
		  <thead>
		    <tr>
		      <th scope="col" class="bg-danger id">Num. Serie</th>
		      <th scope="col">Precio</th>
		      <th scope="col">Estado</th>
		      <th scope="col">Libro</th>
		      <th scope="col">Acción</th>
		    </tr>
		  </thead>
		  <tbody>
			    <c:forEach var="ejemplar" items="${ejemplares}">
			    	<tr>
			        	<th scope="row" class="bg-danger"><c:out value="${ ejemplar.getNumero_serie() }"/></th>
					    <td><c:out value="${ ejemplar.getPrecio() }"/></td>
					    <td><c:out value="${ ejemplar.getEstados_id().getEstado() }"/></td>
					    <td><c:out value="${ ejemplar.getLibros_isbn().getTitulo() }"/></td>
						<td>
							<a href="AccionEjemplar.do?numero_serie=${ ejemplar.getNumero_serie() }&accion=disponible"><i class="fas fa-check" style="color: green;"></i></a> 
							<a href="AccionEjemplar.do?numero_serie=${ ejemplar.getNumero_serie() }&accion=vendido"><i class="fas fa-shopping-cart" style="color: red;"></i></a> 
							<a href="AccionEjemplar.do?numero_serie=${ ejemplar.getNumero_serie() }&accion=arrendado"><i class="fas fa-trash-restore-alt" style="color: orange;"></i></a> 
							<a href="AccionEjemplar.do?numero_serie=${ ejemplar.getNumero_serie() }&accion=eliminar"><i class="fas fa-trash"></i></a> 
						</td>
				   	</tr>
		        </c:forEach>
		  </tbody>
		</table>
		<button class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#anadirEjemplar">Nuevo Ejemplar</button>
		<!-- Modal para Crear Ejemplares  -->
		<div class="modal fade" id="anadirEjemplar" tabindex="-1" aria-labelledby="anadirEjemplarLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="anadirEjemplarLabel">Agregar Idioma</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <form action="agregarEjemplar.do" method="POST">
		      	<div class="modal-body">
		      		<div class="form-group row">
			        	<label for="num_serie" class="col-2 col-form-label">Nro. Serie</label>
			        	<div class="col-10">
			            	<input type="number" class="form-control ps-2" id="num_serie" name="num_serie"
			            	min="1" max="9999999" required>
			        	</div>
			        </div>
		        	<div class="form-group row">
				    	<label for="addLibro" class="col-2 col-form-label">Libros</label>
				    	<div class="col-10">
				    		<select class="form-select" aria-label="multiple select" name="addLibro" id="addLibro">
				            	<c:forEach var="libro" items="${libros}">
				            		<option value="${ libro.getIsbn() }">${ libro.getIsbn() } - ${ libro.getTitulo() }</option>
					            </c:forEach>
				            </select>
				    	</div>
				    </div>
				    <br>
				    
				    <div class="form-group row">
			        	<label for="precio" class="col-2 col-form-label">Precio</label>
			        	<div class="col-10">
			            	<input type="number" class="form-control ps-2" id="precio" name="precio"
			            	min="1" max="999999" required>
			        	</div>
					</div>
					<br>
					<div class="form-group row">
				    	<label for="estado" class="col-2 col-form-label">Estado</label>
				    	<div class="col-10">
				    		<select class="form-select" aria-label="multiple select" name="estado" id="estado">
				            	<c:forEach var="estado" items="${estados}">
				            		<option value="${ estado.getId() }">${ estado.getEstado() }</option>
					            </c:forEach>
				            </select>
				    	</div>
				    </div>
					
		      	</div>
		      	<div class="modal-footer">
		        	<button type="submit" class="btn btn-dark">Agregar Ejemplar</button>
		      	</div>
		      </form>		      
		    </div>
		  </div>
		</div> 
		
		
		
<jsp:include page="common/footer.jsp" />