<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<jsp:include page="common/head.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
	<br><br><br>
	<div class="accordion" id="accordionClientes">
		<c:forEach var="cliente" items="${clientes}">
			
			<div class="accordion-item">
			    <h2 class="accordion-header" id="h${ cliente.getRut() }">
			      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target='#b${ cliente.getRut() }' aria-expanded="true" aria-controls="b${ cliente.getRut() }">
			        ${ cliente.getNombre() } ${ cliente.getApellido_paterno() }
			      </button>
			    </h2>
			    <div id="b${ cliente.getRut() }" class="accordion-collapse collapse" aria-labelledby="h${ cliente.getRut() }" data-bs-parent="#accordionClientes">
			      <div class="accordion-body">
			        <ol class="list-group list-group-numbered">
			          <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">RUT: ${ cliente.getRut() }-${ cliente.getNumero_verificador() }</div>
					    </div>
					  </li>
					  <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">Nombre: ${ cliente.getNombre() }</div>
					    </div>
					  </li>
					  <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">Apellido Paterno: ${ cliente.getApellido_paterno() }</div>
					    </div>
					  </li>
					  <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">Apellido Materno: ${ cliente.getApellido_materno() }</div>
					    </div>
					  </li>
					  <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">Correos: </div>
						      <c:forEach var="correo" items="${cliente.getCorreos()}">
						      		${ correo.getDireccion() }<br>
						      </c:forEach>
					    </div>
					    <span class="badge bg-primary rounded-pill">${cliente.getCantCorreos() }</span>
					  </li>
					  <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">Direcciones: <a href="BorrarDireccion.do?rut=${ cliente.getRut() }" style="color: red;"><i class="fas fa-trash"></i></a></div>
						      <c:forEach var="direccion" items="${cliente.getDirecciones()}">
						      		${ direccion.getDireccion() }<br>
						      </c:forEach>
						      
						      <form action="ClienteDireccion.do" method="POST">
								<div class="form-group row" style="display: none;">
						        	<label class="col-12 col-form-label">Direccion</label>
						        	<div class="col-12">
						            	<input type="number" class="form-control ps-2" name="rut"
						            	value="${ cliente.getRut() }" readonly>
						        	</div>
						        </div>
						      	<div class="form-group row">
						        	<label for="direccion" class="col-12 col-form-label">Nueva Direccion</label>
						        	<div class="col-12">
						            	<input type="text" class="form-control ps-2" name="direccion">
						        	</div>
								</div><br>
								<button type="submit" class="btn btn-dark">Agregar Direccion</button>
							</form>
					    </div>
					    <span class="badge bg-primary rounded-pill">${cliente.getCantDirecciones() }</span>
					  </li>
					  <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">Telefonos: </div>
						    <c:forEach var="telefono" items="${cliente.getTelefonos()}">
						    	+56 ${ telefono.getNumero() }<br>
						    </c:forEach>
						    
							<form action="ClienteTelefono.do" method="POST">
								<div class="form-group row" style="display: none;">
						        	<label class="col-12 col-form-label">RUT</label>
						        	<div class="col-12">
						            	<input type="number" class="form-control ps-2" name="rut"
						            	value="${ cliente.getRut() }" readonly>
						        	</div>
						        </div>
						      	<div class="form-group row">
						        	<label for="telefono" class="col-12 col-form-label">Nuevo Telefono</label>
						        	<div class="col-12">
						            	<input type="number" class="form-control ps-2" name="telefono"
						            	min="900000000" max="999999999">
						        	</div>
								</div><br>
								<button type="submit" class="btn btn-dark">Agregar Telefono</button>
							</form>
					    </div>
					    <span class="badge bg-primary rounded-pill">${cliente.getCantTelefonos() }</span>
					  </li>
					</ol>
			      </div>
			    </div>
			</div>
		</c:forEach>
	</div>


<jsp:include page="common/footer.jsp" />