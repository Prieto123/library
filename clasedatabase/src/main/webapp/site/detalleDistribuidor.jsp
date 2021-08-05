<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<jsp:include page="common/head.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

                                    <!-- Page-body start -->

		<!--<form action="Home.do" method="POST">
			<input type="text" name="nombrePersona" placeholder="Nombre">
			<input type="text" name="apellidosPersona" placeholder="Apellidos">
			<input type="text" name="rut" placeholder="Rut">
			<input type="date" name="fecha" placeholder="Fecha Nacimiento">
			<input type="text" name="foto" placeholder="Foto">
			<input type="text" name="direccion" placeholder="Direccion">
			<input type="number" name="ciudad" placeholder="Id Ciudad">
			
			<button>holi</button>
		</form>-->     	
		
		<br>
		<hr>
		<div id="titulo">
			<h1>${distribuidor.getNombre()}</h1>
		</div>
		<div class="row">
		
			<div class="col-12">
			 	<form action="DetalleDistribuidor.do" method="POST">
					
				    <div class="form-group row">
		                <label for="rut" class="col-3 col-form-label">Rut</label>
		                <div class="col-6">
		                    <input type="number" class="form-control-plaintext ps-2" id="rut" name="rut"
		                        value="${ distribuidor.getRut() }" min="1000000" max="99999999" readonly>
		                </div>
		                <div class="col-1">
		                    -
		                </div>
		                <div class="col-2">
		                    <input type="number" class="form-control-plaintext ps-2" id="verificador" name="verificador"
		                        value="${ distribuidor.getNumero_verificador() }" min="1" max="9" readonly>
		                </div>
		            </div>
		            <div class="form-group row">
				    	<label for="nombre" class="col-3 col-form-label">Nombre</label>
				    	<div class="col-9">
				    		<input type="text" id="disabledTextInput" class="form-control-plaintext ps-2" value="${distribuidor.getNombre()}" name="nombre">
				    	</div>
				    </div>
		            <div class="form-group row">
		                <label for="fecha" class="col-3 col-form-label">Año contrato</label>
		                <div class="col-9">
		                    <input type="number" class="form-control-plaintext ps-2" id="fecha" name="fecha"
		                        value="${ distribuidor.getAno_antiguedad() }" min="2000" max="2021">
		                </div>
		            </div>
					<div class="form-group row">
		                <label for="telefono" class="col-3 col-form-label">Telefono</label>
		                <div class="col-9">
		                    <input type="number" class="form-control-plaintext ps-2" id="telefono" name="telefono"
		                        value="${ distribuidor.getTelefono().getNumero() }" min="900000000" max="999999999">
		                </div>
		            </div>
		            
		            <div class="form-group row">
		                <label for="direccion" class="col-3 col-form-label">Direccion</label>
		                <div class="col-9">
		                    <input type="text" class="form-control-plaintext ps-2" id="direccion" name="direccion"
		                        value="${ distribuidor.getDireccion().getDireccion() }">
		                </div>
		            </div>
		            
		            <button class="btn btn-dark btn-block">Editar</button>
		    	</form>
			</div>
			
		</div>
<jsp:include page="common/footer.jsp" />