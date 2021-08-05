<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<jsp:include page="common/head.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<br>
		<hr>
		<div id="titulo">
			<h1>Factura n°${factura.getFolio()}</h1>
		</div>
		<div class="row">
		
			<div class="col-6">
			 	<form action="DetalleDistribuidor.do" method="POST">
					
				    <div class="form-group row">
		                <label for="rut" class="col-3 col-form-label">Folio</label>
		                <div class="col-9">
		                    <input type="number" class="form-control-plaintext ps-2" id="rut" name="rut"
		                        value="${ factura.getFolio() }" min="1000000" max="99999999" readonly>
		                </div>
		            </div>
		            <div class="form-group row">
				    	<label for="nombre" class="col-3 col-form-label">Fecha</label>
				    	<div class="col-9">
				    		<input type="text" id="disabledTextInput" class="form-control-plaintext ps-2" value="${factura.getFecha_compra()}" name="nombre">
				    	</div>
				    </div>
		            <div class="form-group row">
		                <label for="metodo" class="col-form-label">Metodo</label>
			            <select class="form-select bg-transparent" aria-label="multiple select" name="metodo" id="metodo">
			            	<c:forEach var="metodo" items="${metodos}">
			            		<c:choose>
								    <c:when test="${metodo.getId() == factura.getMetodo_pago().getId()}">
								        <option selected value="<c:out value="${ metodo.getId() }"/>"><c:out value="${ metodo.getMetodo() }"/></option>
								    </c:when>    
								    <c:otherwise>
								        <option value="<c:out value="${ metodo.getId() }"/>"><c:out value="${ metodo.getMetodo() }"/></option>
								    </c:otherwise>
								</c:choose>
				            </c:forEach>
			            </select>
		            </div>
		            
		            <div class="form-group row">
		                <label for="distribuidor" class="col-form-label">Distribuidor</label>
			            <select class="form-select bg-transparent" aria-label="multiple select" name="distribuidor" id="distribuidor">
			            	<c:forEach var="d" items="${distribuidores}">
			            		<c:choose>
								    <c:when test="${d.getRut() == factura.getDistribuidor().getRut()}">
								        <option selected value="<c:out value="${ d.getRut() }"/>"><c:out value="${ d.getNombre() }"/></option>
								    </c:when>    
								    <c:otherwise>
								        <option value="<c:out value="${ d.getRut() }"/>"><c:out value="${ d.getNombre() }"/></option>
								    </c:otherwise>
								</c:choose>
				            </c:forEach>
			            </select>
		            </div>
		            
		            <button class="btn btn-dark btn-block">Editar</button>
		    	</form>
			</div>
			<div class="col-6">
				<h3>Ejemplares</h3>
				<div class="list-group">
					<c:forEach var="ejemplar" items="${factura.getEjemplares()}">
						<a href="#" class="list-group-item list-group-item-action bg-transparent"><c:out value="${ ejemplar.getLibros_isbn().getTitulo() }"/> - $${ ejemplar.getPrecio() }</a>
			    	</c:forEach>
			    	<button class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#agregarEjemplar">Agregar Compra</button>
			    </div>
			    <br>
			    <h3>Info Compras:</h3>
			    <h6>Costo: $${factura.getCosto() }</h6>
			    <h6>Costo IVA: $${factura.getCostoIVA() }</h6>
			</div>
		</div>
		
		<!-- Modal para Agregar Autor-->
		<div class="modal fade" id="agregarEjemplar" tabindex="-1" aria-labelledby="agregarEjemplarLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="agregarEjemplarLabel">Agregar Compra</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <form action="AgregarCompra.do" method="POST">
		      	<div class="modal-body">
		      		<div class="form-group row">
			    		<label for="folio" class="col-2 col-form-label">Folio</label>
			        	<div class="col-10">
			                    <input type="number" class="form-control ps-2" id="folio" name="folio"
			                        value="${ factura.getFolio() }" min="1" max="99999999" readonly>
			        	</div>
			        </div><br>
		        	<div class="form-group row">
				    	<label for="addEjemplar" class="col-2 col-form-label">Ejemplares</label>
				    	<div class="col-10">
				    		<select class="form-select" aria-label="multiple select" name="addEjemplar" id="addEjemplar">
				            	<c:forEach var="ejemplar" items="${ejemplares}">
				            		<option value="<c:out value="${ ejemplar.getNumero_serie() }"/>">${ ejemplar.getNumero_serie() } - ${ ejemplar.getLibros_isbn().getTitulo() }</option>
					            </c:forEach>
				            </select>
				    	</div>
				    </div>
		      	</div>
		      	<div class="modal-footer">
		        	<button type="submit" class="btn btn-dark">Agregar Compra</button>
		      	</div>
		      </form>
		    </div>
		  </div>
		</div>
		
<jsp:include page="common/footer.jsp" />