<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<jsp:include page="common/head.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  	
        
		
		<br>
        <hr>
		
		<div class="row mt-2">
			<div class="col-lg-6 col-sm-12">
				<a class="btn-block XD" href="ListarLibros.do">
					<div class="card text-center bg-transparent">
					    <div class="card-body">
					      	<h5 class="card-title">Libros</h5>
					      	<p class="card-text" style="font-size: 3rem;">${ libros } l</p>
					    </div>
					</div>
				</a>
				<br>
			</div>
			<div class="col-lg-6 col-sm-12">
				<a class="btn-block XD" href="ListaEjemplares.do">
					<div class="card text-center bg-transparent">
					    <div class="card-body">
					      	<h5 class="card-title">Ejemplares</h5>
					      	<p class="card-text" style="font-size: 3rem;">${ ejemplares } e</p>
					    </div>
					</div>
				</a>
				<br>
			</div>
			<div class="col-lg-6 col-sm-12">
				<a class="btn-block XD" href="DetalleClientes.do">
					<div class="card text-center bg-transparent">
					    <div class="card-body">
					      	<h5 class="card-title">Clientes</h5>
					      	<p class="card-text" style="font-size: 3rem;">${ clientes } c</p>
					    </div>
					</div>
				</a>
				<br>
			</div>
			<div class="col-lg-6 col-sm-12">
				<a class="btn-block XD" href="DetalleTrabajadores.do">
					<div class="card text-center bg-transparent">
					    <div class="card-body">
					      	<h5 class="card-title">Trabajadores</h5>
					      	<p class="card-text" style="font-size: 3rem;">${ trabajadores } t</p>
					    </div>
					</div>
				</a>
				<br>
			</div>
			<div class="col-lg-6 col-sm-12">
				<a class="btn-block XD" href="DetalleBoletas.do">
					<div class="card text-center bg-transparent">
					    <div class="card-body">
					      	<h5 class="card-title">Boletas</h5>
					      	<p class="card-text" style="font-size: 3rem;">${ boletas } b</p>
					    </div>
					</div>
				</a>
				<br>
			</div>
			<div class="col-lg-6 col-sm-12">
				<a class="btn-block XD" href="DetalleArriendo.do">
					<div class="card text-center bg-transparent">
					    <div class="card-body">
					      	<h5 class="card-title">Arriendos</h5>
					      	<p class="card-text" style="font-size: 3rem;">${ arriendos } a</p>
					    </div>
					</div>
				</a>
				<br>
			</div>
			<div class="col-lg-6 col-sm-12">
				<a class="btn-block XD" href="ListarDistribuidores.do">
					<div class="card text-center bg-transparent">
					    <div class="card-body">
					      	<h5 class="card-title">Distribuidores</h5>
					      	<p class="card-text" style="font-size: 3rem;">${ distribuidores } d</p>
					    </div>
					</div>
				</a>
				<br>
			</div>
			<div class="col-lg-6 col-sm-12">
				<a class="btn-block XD" href="ListarFacturas.do">
					<div class="card text-center bg-transparent">
					    <div class="card-body">
					      	<h5 class="card-title">Facturas</h5>
					      	<p class="card-text" style="font-size: 3rem;">${ facturas } f</p>
					    </div>
					</div>
				</a>
				<br>
			</div>
		</div>
		
                  
<jsp:include page="common/footer.jsp" />
                                   