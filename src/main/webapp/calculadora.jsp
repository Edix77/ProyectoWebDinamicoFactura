<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<title>Factura</title>
</head>
<body>
	<div class="container ">
		<div class="row">
			<div class="col-8 justify-content-center">
				<img
					src="https://blog.desafiolatam.com/wp-content/uploads/2019/02/desafio-latam-logo-orizontal.png"
					alt="logo empresa" tittle="Logo de academia Desafio Latam"
					style="width: 120px; height: 30px; margin-top: 10%; margin-left: 10%;">
			</div>
			<div class="col-4 lh-1 mt-5">
				<p class="text mb-1 fw-bold text-end">Generador Factura 2022</p>
				<p class="text mb-1 fw-bold text-end">Competition Part Ltda.</p>
				<p class="text mb-1 text-end">Año 2022 Marzo.</p>
			</div>
		</div>


	</div>
	<form action="factura" method="post">
		<div class="container mt-5 pt-5">
			<div class="row g-3 ">
				<div class="col-md-4 ">
					<label class="form-label ">Nombre Completo</label> <input
						type="text" class="form-control" name="nombre">
				</div>
				<div class="col-md-4 ">
					<label class="form-label ">Empresa</label> <input type="text"
						class="form-control " name="empresa">
				</div>
				<div class="col-md-4 ">
					<label class="form-label ">Rut</label> <input type="text"
						class="form-control " name="rut">
				</div>
				<div class="col-md-4 ">
					<label class="form-label ">Dirección</label> <input type="text"
						class="form-control " name="direccion">
				</div>
				<div class="col-md-4 ">
					<label class="form-label ">Ciudad</label> <input type="text"
						class="form-control " name="ciudad">
				</div>
				<div class="col-md-4 ">
					<label class="form-label ">País</label> <input type="text"
						class="form-control " name="pais">
				</div>
			</div>
		</div>
		<div class="container mt-5 ">
			<input type="hidden" name="listaProductos" value="${listaProductos}">
			<table class="table table-dark table-hover table-striped">
				<thead>
					<tr>
						<th scope="col">ITEM</th>
						<th scope="col">DESCRIPCION</th>
						<th scope="col">VALOR UNIDAD</th>
						<th scope="col">CANTIDAD</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="producto" items="${listaProductos}">
						<tr>
							<td><c:out value="${producto.producto}"></c:out></td>
							<td><c:out value="${producto.descripcion}"></c:out></td>
							<td><c:out value="${producto.valorUnitario}"></c:out></td>
							<td><input type="number" class="form-control "
								id="${producto.item}" name="${producto.item}"
								placeholder="Ingrese cantidad " min="0" max="9999" value="0"></td>
						</tr>
						<input type="hidden" name="${producto.item}VU"
							value="${producto.valorUnitario}">
						<input type="hidden" name="${producto.item}VU"
							value="${producto.descripcion}">

					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="container d-flex justify-content-end">
			<div class="row">
				<div class="col-md-12 text-right">
					<button type="submit" class="btn btn-success">Genera
						Factura</button>
					<button type="submit" class="btn btn-secondary ml-2">Limpiar</button>
				</div>
			</div>
		</div>
	</form>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js "
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p "
		crossorigin="anonymous "></script>

</body>
</html>