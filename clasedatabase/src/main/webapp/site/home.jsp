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
        
        <table class="table table-sm">
		  <thead>
		    <tr>
		      <th scope="col" class="bg-danger id">ISBN</th>
		      <th scope="col">Título</th>
		      <th scope="col">Páginas</th>
		      <th scope="col">Año</th>
		      <th scope="col"></th>
		    </tr>
		  </thead>
		  <tbody>
			    <c:forEach var="libro" items="${libros}">
			    	<tr>
			        	<th scope="row" class="bg-danger"><c:out value="${ libro.getIsbn() }"/></th>
					    <td><c:out value="${ libro.getTitulo() }"/></td>
					    <td><c:out value="${ libro.getPaginas() }"/></td>
					    <td><c:out value="${ libro.getAno_publicado() }"/></td>
						<td>Ver</td>
				   	</tr>
		        </c:forEach>
		  </tbody>
		</table>
		<a href="CrearLibro.do" class="btn btn-dark">Crear Libro</a>
                  
<jsp:include page="common/footer.jsp" />
                                   