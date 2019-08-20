<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-md-3">
                <div class="card">
                    <div class="card-header">
                        <h2>Cliente</h2>
                    </div>
                    <div class="card-body">
                        <form action="Controlador?menu=Cliente" method="POST" >
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Nombre" name="nombre" value="${cliente.getNombre()}" >
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="DNI" name="dni" value="${cliente.getDni()}">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Ciudad" name="ciudad" value="${cliente.getDireccion()}">
                            </div>
                            <div class="form-group col-md-5">
                                <button type="submit" class="btn btn-outline-info" name="accion" value="nuevoCliente">Agregar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h2>Lista Cliente</h2>
                    </div>
                    <div class="card-body">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Codigo</th>
                                    <th>Nombre</th>
                                    <th>DNI</th>
                                    <th>Ciudad</th>
                                    <th>Accion</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${listaCliente}">
                                    <tr>
                                        <td>${list.getIdCliente()}</td>
                                        <td>${list.getNombre()}</td>
                                        <td>${list.getDni()}</td>
                                        <td>${list.getDireccion()}</td>
                                        <td>
                                            <a href="Controlador?menu=Cliente&accion=editar&id=${list.getIdCliente()}" class="btn btn-warning">Editar</a>
                                            <a href="Controlador?menu=Cliente&accion=eliminar&id=${list.getIdCliente()}" class="btn btn-danger">Eliminar</a>
                                        </td>
                                    </tr>
                                </c:forEach> 
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
                            <div class="card" style="margin-top: 10px;">
                                <div class="card-header col-md-12">
                                    <h2>Historial</h2>
                                </div>
                                    <div class="card-body">
                                        <form action="Controlador?menu=Cliente" method="POST" class="form-inline">
                                            <div class="form-group mx-sm-3">
                                                <input type="text" name="dni" class="form-control" placeholder="DNI">
                                            </div>
                                            <button type="submit" class="btn btn-outline-info" style="margin-left: 10px;" name="accion" value="buscarCliente">Buscar</button>
                                        </form>
                                        <table class="table table-hover" style="margin-top: 10px;">
                                            <thead>
                                                <tr>
                                                    <th>Codigo</th>
                                                    <th>Nombre</th>
                                                    <th>DNI</th>
                                                    <th>Ciudad</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                            </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
