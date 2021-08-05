<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<jsp:include page="common/head.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
	<br><br>
	<h1>Boletas</h1>
	<div class="accordion" id="accordionBoletas">
		<c:forEach var="boleta" items="${boletas}">
			
			<div class="accordion-item">
			    <h2 class="accordion-header" id="h${ boleta.getFolio() }">
			      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target='#b${ boleta.getFolio() }' aria-expanded="true" aria-controls="b${ boleta.getFolio() }">
			        ${ boleta.getFolio() } &nbsp;<a href="BorrarBoleta.do?folio=${ boleta.getFolio() }" style="color: red;"> <i class="fas fa-trash"></i></a>
			      </button>
			    </h2>
			    
			    <div id="b${ boleta.getFolio() }" class="accordion-collapse collapse ${folio == boleta.getFolio() ? 'show' : '' }"  aria-labelledby="h${ boleta.getFolio() }" data-bs-parent="#accordionBoletas">
			      <div class="accordion-body">
			        <ol class="list-group list-group-numbered">
			          <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">Folio: ${ boleta.getFolio() }</div>
					    </div>
					  </li>
					  <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">Fecha: ${ boleta.getFecha_venta() }</div>
					    </div>
					  </li>
					  <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">Cliente: ${ boleta.getCliente_rut().getNombre() } ${ boleta.getCliente_rut().getApellido_paterno() } ${ boleta.getCliente_rut().getApellido_materno() }</div>
					    </div>
					  </li>
					  <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">Trabajador involucrado: ${ boleta.getTrabajadores_rut().getNombre() } ${ boleta.getTrabajadores_rut().getApellido_paterno() } ${ boleta.getTrabajadores_rut().getApellido_materno() }</div>
					    </div>
					  </li>
					  <li class="list-group-item d-flex justify-content-between align-items-start">
					    <div class="ms-2 me-auto">
					      <div class="fw-bold">Mètodo de Pago: ${ boleta.getMetodos_pago_id().getMetodo() }</div>
					    </div>
					  </li>
					</ol>
			      </div>
			    </div>
			</div>
		</c:forEach>
	</div>


<jsp:include page="common/footer.jsp" />