<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<jsp:include page="common/head.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  	


<br><br>
<h1>Arriendos</h1>
	<button class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#anadirArriendo">Nuevo Arriendo</button>
		<!-- Modal para Crear Trabajador  -->
		<div class="modal fade" id="anadirArriendo" tabindex="-1" aria-labelledby="anadirArriendoLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="anadirArriendoLabel">Nuevo Arriendo</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <form action="AgregarArriendo.do" method="POST">
		      	<div class="modal-body">
					<div class="form-group row">
			        	<label for="arriendo" class="col-3 col-form-label">Fecha Arriendo</label>
			        	<div class="col-9">
			            	<input type="date" class="form-control ps-2" id="arriendo" name="arriendo" required>
			        	</div>
					</div>
					<br>
					<div class="form-group row">
			        	<label for="devolucion" class="col-3 col-form-label">Fecha Devolucion Deseada</label>
			        	<div class="col-9">
			            	<input type="date" class="form-control ps-2" id="devolucion" name="devolucion" required>
			        	</div>
					</div>
					<br>
					<div class="form-group row">
			        	<label for="real" class="col-3 col-form-label">Fecha Devolucion Real</label>
			        	<div class="col-9">
			            	<input type="date" class="form-control ps-2" id="real" name="real" required>
			        	</div>
					</div>
					<br>
					<div class="form-group row">
			        	<label for="cliente" class="col-3 col-form-label">Cliente Asociado</label>
			        	<div class="col-9">
			            	<select class="form-select" aria-label="multiple select" name="cliente" id="cliente">
				            	<c:forEach var="cliente" items="${clientes}">
				            		<option value="${ cliente.getRut() }">${ cliente.getRut() } - ${ cliente.getNombre() } ${ cliente.getApellido_paterno() } ${ cliente.getApellido_materno() }</option>
					            </c:forEach>
				            </select>
			        	</div>
					</div>
					<br>
					<div class="form-group row">
			        	<label for="trabajador" class="col-3 col-form-label">Trabajador Asociado</label>
			        	<div class="col-9">
			            	<select class="form-select" aria-label="multiple select" name="trabajador" id="trabajador">
				            	<c:forEach var="trabajador" items="${trabajadores}">
				            		<option value="${ trabajador.getRut() }">${ trabajador.getRut() } - ${ trabajador.getNombre() } ${ trabajador.getApellido_paterno() } ${ cliente.getApellido_materno() }</option>
					            </c:forEach>
				            </select>
			        	</div>
					</div>
					<br>					
		      	</div>
		      	<div class="modal-footer">
		        	<button type="submit" class="btn btn-dark">Nuevo Arriendo</button>
		      	</div>
		      </form>		      
		    </div>
		  </div>
		</div> 
		<br><hr>
	<div class="accordion" id="accordionBoletas">
		<c:forEach var="arriendo" items="${arriendos}">
			
			<div class="accordion-item">
			    <h2 class="accordion-header" id="h${ arriendo.getId() }">
			      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target='#b${arriendo.getId() }' aria-expanded="true" aria-controls="b${ arriendo.getId() }">
			        ${ arriendo.getId() } ${ arriendo.getClientes_rut().getApellido_paterno() } ${ arriendo.getClientes_rut().getApellido_materno() }
			        &nbsp;<a href="BorrarArriendo.do?folio=${ arriendo.getId() }" style="color: red;"> <i class="fas fa-trash"></i></a>
			      </button>
			    </h2>
			    <div id="b${ arriendo.getId() }" class="accordion-collapse collapse" aria-labelledby="h${ arriendo.getId() }" data-bs-parent="#accordionBoletas">
			      <div class="accordion-body">
			        <ol class="list-group list-group-numbered">
			          <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">Folio: ${ arriendo.getId() }</div>
					    </div>
					  </li>
					  <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">Valor: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$${ arriendo.getTotal() } CLP<br> Valor IVA: &nbsp;&nbsp;$${ arriendo.getTotalIva() } CLP</div>
					    </div>
					  </li>
					  <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">Fecha Arriendo: ${ arriendo.getFecha_arriendo() }</div>
					    </div>
					  </li>
					  <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">Fecha Devolucion Deseada: ${ arriendo.getFecha_devolucion_deseada() }</div>
					    </div>
					  </li>
					  <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">Fecha Devolucion Real: ${ arriendo.getFecha_devolucion_real() }</div>
					    </div>
					  </li>
					  <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">Cliente: ${ arriendo.getClientes_rut().getNombre() } ${ arriendo.getClientes_rut().getApellido_paterno() } ${ arriendo.getClientes_rut().getApellido_materno() }</div>
					    </div>
					  </li>
					  <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">Trabajador involucrado: ${ arriendo.getTrabajadores_rut().getNombre() } ${ arriendo.getTrabajadores_rut().getApellido_paterno() } ${ arriendo.getTrabajadores_rut().getApellido_materno() }</div>
					    </div>
					  </li>
					  <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">Libros:</div>
						      <c:forEach var="ejemplar" items="${arriendo.getEjemplar()}">
						      		${ ejemplar.getLibros_isbn().getTitulo() } - $${ ejemplar.getPrecio() }<br>
						      </c:forEach>
						      
						      <form action="AnadirEjemplarBoleta.do" method="POST">
								<div class="form-group row" style="display: none;">
						        	<label class="col-12 col-form-label">Ejemplares</label>
						        	<div class="col-12">
						            	<input type="number" class="form-control ps-2" name="id"
						            	value="${ arriendo.getId() }" readonly>
						        	</div>
						        </div>
						      	<div class="form-group row">
						        	<div class="col-12">
						            	<select class="form-select" aria-label="multiple select" name="addEjemplar" id="addEjemplar">
							            	<c:forEach var="ejemplar" items="${ejemplares}">
							            		<option value="${ ejemplar.getNumero_serie() }">${ ejemplar.getNumero_serie() } - ${ ejemplar.getLibros_isbn().getTitulo() }</option>
								            </c:forEach>
							            </select>
						        	</div>
								</div><br>
								<button type="submit" class="btn btn-dark">Añadir libro</button>
							</form>
					    </div>
					    <span class="badge bg-primary rounded-pill">${trabajador.getCantDirecciones() }</span>
					  </li>
					</ol>
			      </div>
			    </div>
			</div>
		</c:forEach>
	</div>


<jsp:include page="common/footer.jsp" />