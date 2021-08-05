<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<jsp:include page="common/head.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<br><br>
	<h1>Trabajadores</h1>
	<button class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#anadirEjemplar">Nuevo Trabajador</button>
		<!-- Modal para Crear Trabajador  -->
		<div class="modal fade" id="anadirEjemplar" tabindex="-1" aria-labelledby="anadirEjemplarLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="anadirEjemplarLabel">Nuevo Trabajador</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <form action="agregarTrabajador.do" method="POST">
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
			        	<label for="verificador" class="col-3 col-form-label">Num. Verificador</label>
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
			        	<label for="apellidop" class="col-3 col-form-label">Apellido P.</label>
			        	<div class="col-9">
			            	<input type="text" class="form-control ps-2" id="apellidop" name="apellidop" required>
			        	</div>
					</div>
					<br>
					
					<div class="form-group row">
			        	<label for="apellidom" class="col-3 col-form-label">Apellido M.</label>
			        	<div class="col-9">
			            	<input type="text" class="form-control ps-2" id="apellidom" name="apellidom" required>
			        	</div>
					</div>
					<br>
					
					<div class="form-group row">
			        	<label for="contrato" class="col-3 col-form-label">Fecha Contrato</label>
			        	<div class="col-9">
			            	<input type="date" class="form-control ps-2" id="contrato" name="contrato" required>
			        	</div>
					</div>
					<br>
					
		      	</div>
		      	<div class="modal-footer">
		        	<button type="submit" class="btn btn-dark">Nuevo Trabajador</button>
		      	</div>
		      </form>		      
		    </div>
		  </div>
		</div> 
		<br><hr>
	<div class="accordion" id="accordionClientes">
		<c:forEach var="trabajador" items="${trabajadores}">
			
			<div class="accordion-item">
			    <h2 class="accordion-header" id="h${ trabajador.getRut() }">
			      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target='#b${ trabajador.getRut() }' aria-expanded="true" aria-controls="b${ trabajador.getRut() }">
			        ${ trabajador.getNombre() } ${ trabajador.getApellido_paterno() }&nbsp;<a href="BorrarTrabajador.do?rut=${ trabajador.getRut() }"><i class="fas fa-trash" style="color: red;"></i></a>
			      </button>
			    </h2>
			    <div id="b${ trabajador.getRut() }" class="accordion-collapse collapse" aria-labelledby="h${ trabajador.getRut() }" data-bs-parent="#accordionClientes">
			      <div class="accordion-body">
			        <ol class="list-group list-group-numbered">
			          <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">RUT: ${ trabajador.getRut() }-${ trabajador.getNumero_verificador() }</div>
					    </div>
					  </li>
					  <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">Nombre: ${ trabajador.getNombre() }</div>
					    </div>
					  </li>
					  <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">Apellido Paterno: ${ trabajador.getApellido_paterno() }</div>
					    </div>
					  </li>
					  <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">Apellido Materno: ${ trabajador.getApellido_materno() }</div>
					    </div>
					  </li>
					  <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">Fecha Contrato: ${ trabajador.getFecha_contrato() }</div>
					    </div>
					  </li>
					  <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">Correos: </div>
						      <c:forEach var="correo" items="${trabajador.getCorreos()}">
						      		${ correo.getDireccion() }<br>
						      </c:forEach>
					    </div>
					    <span class="badge bg-primary rounded-pill">${trabajador.getCantCorreos() }</span>
					  </li>
					  <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">Direcciones: <a href="BorrarDireccionTrabajador.do?rut=${ trabajador.getRut() }" style="color: red;"><i class="fas fa-trash"></i></a></div>
						      <c:forEach var="direccion" items="${trabajador.getDirecciones()}">
						      		${ direccion.getDireccion() }<br>
						      </c:forEach>
						      
						      <form action="TrabajadorDireccion.do" method="POST">
								<div class="form-group row" style="display: none;">
						        	<label class="col-12 col-form-label">Direccion</label>
						        	<div class="col-12">
						            	<input type="number" class="form-control ps-2" name="rut"
						            	value="${ trabajador.getRut() }" readonly>
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
					    <span class="badge bg-primary rounded-pill">${trabajador.getCantDirecciones() }</span>
					  </li>
					  <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">Telefonos: </div>
						    <c:forEach var="telefono" items="${trabajador.getTelefonos()}">
						    	+56 ${ telefono.getNumero() }<br>
						    </c:forEach>
						    
							<form action="TrabajadorTelefono.do" method="POST">
								<div class="form-group row" style="display: none;">
						        	<label class="col-12 col-form-label">RUT</label>
						        	<div class="col-12">
						            	<input type="number" class="form-control ps-2" name="rut"
						            	value="${ trabajador.getRut() }" readonly>
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
					    <span class="badge bg-primary rounded-pill">${trabajador.getCantTelefonos() }</span>
					  </li>
					</ol>
			      </div>
			    </div>
			</div>
		</c:forEach>
	</div>
	
	


<jsp:include page="common/footer.jsp" />