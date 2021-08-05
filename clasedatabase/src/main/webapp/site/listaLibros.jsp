<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<jsp:include page="common/head.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<br>
        <hr>
		<h1>Libros</h1>
        <table class="table table-sm" id="tablaLibros">
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
						<td><a href="DetalleLibro.do?isbn=<c:out value="${ libro.getIsbn() }"/>"><i class="fas fa-eye"></i></a> 
							<a href="BorrarLibro.do?isbn=<c:out value="${ libro.getIsbn() }"/>" style="color: red;"><i class="fas fa-trash-alt"></i></a></td>
				   	</tr>
		        </c:forEach>
		  </tbody>
		</table>
		<a href="CrearLibro.do" class="btn btn-dark">Crear Libro</a>
		
<jsp:include page="common/footer.jsp" />