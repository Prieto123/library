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
			<h1>${titulo}</h1>
		</div>
		<div class="row">
		
			<div class="col-6">
			 	<form action="DetalleLibro.do" method="POST">
					<div class="form-group row">
				    	<label for="titulo" class="col-2 col-form-label">Título</label>
				    	<div class="col-10">
				    		<input type="text" id="disabledTextInput" class="form-control-plaintext ps-2" value="${titulo}" name="titulo">
				    	</div>
				    </div>
				    <div class="form-group row">
		                <label for="ISBN" class="col-2 col-form-label">ISBN</label>
		                <div class="col-10">
		                    <input type="number" class="form-control-plaintext ps-2" id="ISBN" name="isbn"
		                        value="${ isbn }" min="1000000000000" max="9999999999999">
		                </div>
		            </div>
		            <div class="form-group row">
		                <label for="paginas" class="col-2 col-form-label">Págs</label>
		                <div class="col-10">
		                    <input type="number" class="form-control-plaintext ps-2" id="paginas" name="paginas"
		                        value="${ paginas }" min="1" max="4000">
		                </div>
		            </div>
					<div class="form-group row">
		                <label for="ano" class="col-2 col-form-label">Año</label>
		                <div class="col-10">
		                    <input type="number" class="form-control-plaintext ps-2" id="ano" name="ano"
		                        value="${ ano_publicado }" min="868" max="2021">
		                </div>
		            </div>
		            <label for="editorial" class="col-2 col-form-label">Editorial</label>
		            <select class="form-select bg-transparent" aria-label="multiple select" name="editorial" id="editorial">
		            	<c:forEach var="editorial" items="${editoriales}">
		            		<c:choose>
							    <c:when test="${editorial.getId() == ed.getId()}">
							        <option selected value="<c:out value="${ editorial.getId() }"/>"><c:out value="${ editorial.getEditorial() }"/></option>
							    </c:when>    
							    <c:otherwise>
							        <option value="<c:out value="${ editorial.getId() }"/>"><c:out value="${ editorial.getEditorial() }"/></option>
							    </c:otherwise>
							</c:choose>
			            </c:forEach>
		            </select><br>
		            <button class="btn btn-dark btn-block">Editar</button>
		    	</form>
			</div>
			<div class="col-6">
				<h3>Autores</h3>
				<div class="list-group">
					<c:forEach var="autor" items="${autores}">
						<a href="#" class="list-group-item list-group-item-action bg-transparent"><c:out value="${ autor.getNombre() }"/> <c:out value="${ autor.getApellido_paterno() }"/></a>
			    	</c:forEach>
			    	<button class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#crearActor">Agregar Autor</button>
			    </div>
			    <br>
			    <h3>Categorias</h3>
				<div class="list-group">
					<c:forEach var="categoria" items="${categorias}">
						<a href="#" class="list-group-item list-group-item-action bg-transparent"><c:out value="${ categoria.getNombre() }"/></a>
			    	</c:forEach>
			    	<button class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#crearCategoria">Agregar Categoria</button>
			    </div>
			    <br>
			    <h3>Idiomas</h3>
				<div class="list-group">
					<c:forEach var="idioma" items="${idiomas}">
						<a href="#" class="list-group-item list-group-item-action bg-transparent"><c:out value="${ idioma.getNombre() }"/></a>
			    	</c:forEach>
			    	<button class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#crearIdioma">Agregar Idioma</button>
			    </div>
			</div>
			
		</div>
		
		<!-- Modal para Agregar Autor-->
		<div class="modal fade" id="crearActor" tabindex="-1" aria-labelledby="crearActorLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="crearActorLabel">Agregar Actor</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <form action="AgregarActor.do" method="POST">
		      	<div class="modal-body">
		      		<div class="form-group row">
			    		<label for="ISBN3" class="col-2 col-form-label">ISBN</label>
			        	<div class="col-10">
			                    <input type="number" class="form-control ps-2" id="ISBN3" name="isbn3"
			                        value="${ isbn }" min="1000000000000" max="9999999999999" readonly>
			        	</div>
			        </div><br>
		        	<div class="form-group row">
				    	<label for="addActor" class="col-2 col-form-label">Actores</label>
				    	<div class="col-10">
				    		<select class="form-select" aria-label="multiple select" name="addAutor" id="addAutor">
				            	<c:forEach var="autor" items="${listaAutores}">
				            		<option value="<c:out value="${ autor.getId() }"/>">${ autor.getId() } - ${ autor.getNombre() } ${ autor.getApellido_paterno() }</option>
					            </c:forEach>
				            </select>
				    	</div>
				    </div>
		      	</div>
		      	<div class="modal-footer">
		        	<button type="submit" class="btn btn-dark">Agregar Actor</button>
		      	</div>
		      </form>
		      <form action="CrearActor.do" method="POST">
		      	<div class="modal-body" style="display: none;">
		      		<div class="form-group row">
				    	<label for="titulo2" class="col-2 col-form-label">Título</label>
				    	<div class="col-10">
				    		<input type="text" id="disabledTextInput" class="form-control-plaintext ps-2" value="${titulo}" name="titulo2">
				    	</div>
				    </div>
		      		<div class="form-group row">
		                <label for="paginas2" class="col-2 col-form-label">Págs</label>
		                <div class="col-10">
		                    <input type="number" class="form-control-plaintext ps-2" id="paginas2" name="paginas2"
		                        value="${ paginas }" min="1" max="4000">
		                </div>
		            </div>
					<div class="form-group row">
		                <label for="ano2" class="col-2 col-form-label">Año</label>
		                <div class="col-10">
		                    <input type="number" class="form-control-plaintext ps-2" id="ano2" name="ano2"
		                        value="${ ano_publicado }" min="868" max="2021">
		                </div>
		            </div>
		            <label for="editorial2" class="col-2 col-form-label">Editorial</label>
		            <select class="form-select bg-transparent" aria-label="multiple select" name="editorial2" id="editorial2">
		            	<c:forEach var="editorial" items="${editoriales}">
		            		<c:choose>
							    <c:when test="${editorial.getId() == ed.getId()}">
							        <option selected value="<c:out value="${ editorial.getId() }"/>"><c:out value="${ editorial.getEditorial() }"/></option>
							    </c:when>    
							    <c:otherwise>
							        <option value="<c:out value="${ editorial.getId() }"/>"><c:out value="${ editorial.getEditorial() }"/></option>
							    </c:otherwise>
							</c:choose>
			            </c:forEach>
		            </select>
		      	</div>
		      	<div class="modal-body">
		      		<div class="form-group row">
			        	<label for="ISBN2" class="col-2 col-form-label">ISBN</label>
			                <div class="col-10">
			                    <input type="number" class="form-control ps-2" id="ISBN2" name="isbn2"
			                        value="${ isbn }" min="1000000000000" max="9999999999999" readonly>
			                </div>
			            </div>
			            <br>
			        	<div class="form-group row">
					    	<label for="nombreAutor" class="col-2 col-form-label">Nombre</label>
					    	<div class="col-10">
					    		<input type="text" id="disabledTextInput" class="form-control ps-2" name="nombreAutor">
					    	</div>
					    </div>
					    <br>
					    <div class="form-group row">
					    	<label for="apellidoAutor" class="col-2 col-form-label">Apellido</label>
					    	<div class="col-10">
					    		<input type="text" id="disabledTextInput" class="form-control ps-2" name="apellidoAutor">
					    	</div>
					    </div>
				      	<div class="modal-footer">
				        	<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
				        	<button type="submit" class="btn btn-dark">Crear Autor</button>
				      	</div>
					</div>
		      </form>
		      
		    </div>
		  </div>
		</div>
		
		<!-- Modal para Crear Categoría-->
		<div class="modal fade" id="crearCategoria" tabindex="-1" aria-labelledby="crearCategoriaLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="crearCategoriaLabel">Agregar Categoría</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <form action="AgregarCategoria.do" method="POST">
		      	<div class="modal-body">
		      		<div class="form-group row" style="display: none;">
			        	<label for="ISBN3" class="col-2 col-form-label">ISBN</label>
			        	<div class="col-10">
			            	<input type="number" class="form-control ps-2" id="ISBN3" name="isbn"
			            	value="${ isbn }" min="1000000000000" max="9999999999999" readonly>
			        	</div>
			        </div>
		        	<div class="form-group row">
				    	<label for="addCategoria" class="col-2 col-form-label">Categorias</label>
				    	<div class="col-10">
				    		<select class="form-select" aria-label="multiple select" name="addCategoria" id="addCategoria">
				            	<c:forEach var="categoria" items="${listaCategorias}">
				            		<option value="<c:out value="${ categoria.getId() }"/>">${ categoria.getId() } - ${ categoria.getNombre() }</option>
					            </c:forEach>
				            </select>
				    	</div>
				    </div>
		      	</div>
		      	<div class="modal-footer">
		        	<button type="submit" class="btn btn-dark">Agregar Categoría</button>
		      	</div>
		      </form>
		      <form action="CrearCategoria.do" method="POST">
		      	<div class="modal-body">
		      		<div class="form-group row">
			        	<label for="ISBN4" class="col-2 col-form-label">ISBN</label>
			                <div class="col-10">
			                    <input type="number" class="form-control ps-2" id="ISBN4" name="isbn"
			                        value="${ isbn }" min="1000000000000" max="9999999999999" readonly>
			                </div>
			            </div>
			            <br>
			        	<div class="form-group row">
					    	<label for="nombreCategoria" class="col-2 col-form-label">Nombre</label>
					    	<div class="col-10">
					    		<input type="text" id="disabledTextInput" class="form-control ps-2" name="nombreCategoria">
					    	</div>
					    </div>
				      	<div class="modal-footer">
				        	<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
				        	<button type="submit" class="btn btn-dark">Crear Categoría</button>
				      	</div>
					</div>
		      </form>
		      
		    </div>
		  </div>
		</div>
		
		<!-- Modal para Crear Idiomas -->
		<div class="modal fade" id="crearIdioma" tabindex="-1" aria-labelledby="crearIdiomaLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="crearCategoriaLabel">Agregar Idioma</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <form action="AgregarIdioma.do" method="POST">
		      	<div class="modal-body">
		      		<div class="form-group row" style="display: none;">
			        	<label for="ISBN5" class="col-2 col-form-label">ISBN</label>
			        	<div class="col-10">
			            	<input type="number" class="form-control ps-2" id="ISBN5" name="isbn"
			            	value="${ isbn }" min="1000000000000" max="9999999999999" readonly>
			        	</div>
			        </div>
		        	<div class="form-group row">
				    	<label for="addIdioma" class="col-2 col-form-label">Idiomas</label>
				    	<div class="col-10">
				    		<select class="form-select" aria-label="multiple select" name="addIdioma" id="addIdioma">
				            	<c:forEach var="idioma" items="${listaIdiomas}">
				            		<option value="<c:out value="${ idioma.getId() }"/>">${ idioma.getId() } - ${ idioma.getNombre() }</option>
					            </c:forEach>
				            </select>
				    	</div>
				    </div>
		      	</div>
		      	<div class="modal-footer">
		        	<button type="submit" class="btn btn-dark">Agregar Idioma</button>
		      	</div>
		      </form>
		      <form action="CrearIdioma.do" method="POST">
		      	<div class="modal-body">
		      		<div class="form-group row">
			        	<label for="ISBN6" class="col-2 col-form-label">ISBN</label>
			                <div class="col-10">
			                    <input type="number" class="form-control ps-2" id="ISBN6" name="isbn"
			                        value="${ isbn }" min="1000000000000" max="9999999999999" readonly>
			                </div>
			            </div>
			            <br>
			        	<div class="form-group row">
					    	<label for="nombreIdioma" class="col-2 col-form-label">Idioma</label>
					    	<div class="col-10">
					    		<input type="text" id="disabledTextInput" class="form-control ps-2" name="nombreIdioma">
					    	</div>
					    </div>
				      	<div class="modal-footer">
				        	<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
				        	<button type="submit" class="btn btn-dark">Crear Idioma</button>
				      	</div>
					</div>
		      </form>
		      
		    </div>
		  </div>
		</div>
		
		