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
        <!--<form action="CrearLibro.do" method="POST">
            <div class="form-group row">
                <label for="ISBN" class="col-2 col-form-label">ISBN</label>
                <div class="col-10">
                    <input type="number" class="form-control-plaintext" id="ISBN" name="isbn"
                        placeholder="9780340951453" min="1000000000000" max="9999999999999">
                </div>
            </div>
            <div class="form-group row">
                <label for="titulo" class="col-2 col-form-label">Título</label>
                <div class="col-10">
                    <input type="text" class="form-control-plaintext" id="titulo" name="titulo"
                        placeholder="EJEMPLO: La polilla del baúl">
                </div>
            </div>
            <div class="form-group row">
                <label for="paginas" class="col-2 col-form-label">Páginas</label>
                <div class="col-10">
                    <input type="number" class="form-control-plaintext" id="paginas" name="paginas"
                        placeholder="123" min="1" max="9999">
                </div>
            </div>
            <div class="form-group row">
                <label for="ano" class="col-2 col-form-label">Año</label>
                <div class="col-10">
                    <input type="number" class="form-control-plaintext" id="ano" name="ano"
                        placeholder="1973" min="868" max="2021">
                </div>
            </div>
            <label for="editorial" class="col-2 col-form-label">Editorial</label>
            <select class="form-select bg-transparent" multiple aria-label="multiple select" name="editorial" id="editorial">
            	<c:forEach var="editorial" items="${editoriales}">
	                <option value="<c:out value="${ editorial.getId() }"/>"><c:out value="${ editorial.getEditorial() }"/></option>
	            </c:forEach>
            </select>
            <br>
            <button class="btn btn-dark">Crear</button>
        </form>-->
        
        <form id="formulario" class="paddines" action="CrearLibro.do" method="POST">

	        <div class="form-group row">
	            <label for="ISBN" class="col-2 col-form-label">ISBN</label>
	            <div class="col-10">
	
	                <input type="number" oninput="if( this.value.length > 13 )  this.value = this.value.slice(0,13)" class="form-control-plaintext" min="1000000000000" max="9999999999999" id="ISBN" name="isbn" d="validationCustom03">
	
	                <br>
	                <small class="padeoMensaje"></small>
	
	            </div>
	
	        </div>
	        <div class="form-group row">
	            <label for="titulo" class="col-2 col-form-label">Título</label>
	            <div class="col-10">
	                <input type="text" class="form-control-plaintext" id="titulo" name="titulo" placeholder="EJEMPLO: La polilla del baúl">
	                <br>
	
	                <small class="padeoMensaje"></small>
	            </div>
	        </div>
	        <div class="form-group row">
	            <label for="paginas" class="col-2 col-form-label">Páginas</label>
	            <div class="col-10">
	                <input type="number" oninput="if( this.value.length > 4 )  this.value = this.value.slice(0,4)" class="form-control-plaintext" id="paginas" name="paginas" placeholder="123" min="1" max="9999">
	                <br>
	                <small class="padeoMensaje"></small>
	            </div>
	        </div>
	        <div class="form-group row">
	            <label for="ano" class="col-2 col-form-label">Año</label>
	            <div class="col-10">
	                <input type="number" oninput="if( this.value.length > 4 )  this.value = this.value.slice(0,4)" class="form-control-plaintext" id="ano" name="ano" placeholder="1973" min="868" max="2021">
	                <br>
	                <small class="padeoMensaje"></small>
	
	            </div>
	        </div>
	        <label for="editorial" class="col-2 col-form-label">Editorial</label>
	        	<select class="form-select bg-transparent" multiple aria-label="multiple select" name="editorial" id="editorial" required>
	              
	            	<c:forEach var="editorial" items="${editoriales}">
		                <option value="<c:out value="${ editorial.getId() }"/>"><c:out value="${ editorial.getEditorial() }"/></option>
		            </c:forEach>
	           
	            </select>
	            <br>
	        <div class="row">
	        	<button onclick="validarCrearLibro()" class="btn btn-dark">Crear</button>
	        </div>
	        
	
	        
	
	
	    </form>
	    <script src="site/assets/js/validacionCrearLibro.js"></script>
	    
                  
<jsp:include page="common/footer.jsp" />