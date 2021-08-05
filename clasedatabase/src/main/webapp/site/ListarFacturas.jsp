<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<jsp:include page="common/head.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

		<br>
        <hr>
		<h1>Facturas</h1>
        <table class="table table-sm" id="tablaLibros">
		  <thead>
		    <tr>
		      <th scope="col" class="bg-danger id">Folio</th>
		      <th scope="col">Fecha Compra</th>
		      <th scope="col">Metodo</th>
		      <th scope="col">Distribuidor</th>
		      <th scope="col">#</th>
		    </tr>
		  </thead>
		  <tbody>
			    <c:forEach var="factura" items="${facturas}">
			    	<tr>
			        	<th scope="row" class="bg-danger"><c:out value="${ factura.getFolio() }"/></th>
					    <td><c:out value="${ factura.getFecha_compra() }"/></td>
					    <td><c:out value="${ factura.getMetodo_pago().getMetodo() }"/></td>
					    <td><c:out value="${ factura.getDistribuidor().getNombre() }"/></td>
						<td><a href="AgregarFactura.do?folio=<c:out value="${ factura.getFolio() }"/>"><i class="fas fa-eye"></i></a> 
							<a href="BorrarLibro.do?isbn=<c:out value="${ factura.getFolio() }"/>" style="color: red;"><i class="fas fa-trash-alt"></i></a></td>
				   	</tr>
		        </c:forEach>
		  </tbody>
		</table>
		<button class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#anadirEjemplar">Nueva Factura</button>
		<!-- Modal para Crear Ejemplares  -->
		<div class="modal fade" id="anadirEjemplar" tabindex="-1" aria-labelledby="anadirEjemplarLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="anadirEjemplarLabel">Nueva Factura</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <form action="AgregarFactura.do" method="POST">
		      	<div class="modal-body">
			        <div class="form-group row">
			        	<label for="fecha" class="col-2 col-form-label">Fecha Compra</label>
			        	<div class="col-10">
			            	<input type="date" class="form-control ps-2" id="fecha" name="fecha" required>
			        	</div>
					</div>
					<br>
					<div class="form-group row">
			        	<label for="hora" class="col-2 col-form-label">Hora Compra</label>
			        	<div class="col-10">
			            	<input type="time" class="form-control ps-2" id="hora" name="hora" required>
			        	</div>
					</div>
					<br>
		        	<div class="form-group row">
				    	<label for="metodo" class="col-2 col-form-label">Metodo Pago</label>
				    	<div class="col-10">
				    		<select class="form-select" aria-label="multiple select" name="metodo" id="metodo">
				            	<c:forEach var="metodo" items="${metodos}">
				            		<option value="${ metodo.getId() }">${ metodo.getMetodo() }</option>
					            </c:forEach>
				            </select>
				    	</div>
				    </div>
				    <br>
					<div class="form-group row">
				    	<label for="distribuidor" class="col-2 col-form-label">Distribuidor</label>
				    	<div class="col-10">
				    		<select class="form-select" aria-label="multiple select" name="distribuidor" id="distribuidor">
				            	<c:forEach var="d" items="${distribuidores}">
				            		<option value="${ d.getRut() }">${ d.getNombre() }</option>
					            </c:forEach>
				            </select>
				    	</div>
				    </div>
		      	</div>
		      	<div class="modal-footer">
		        	<button type="submit" class="btn btn-dark">Nueva Factura</button>
		      	</div>
		      </form>		      
		    </div>
		  </div>
		</div> 
		
<jsp:include page="common/footer.jsp" />