<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="partials" tagdir="/WEB-INF/tags/partials" %>

<partials:header/>

<style>
    table {
        border-collapse: collapse;
        width: 100%;
    }

    th, td {
        padding: 8px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    img {
        width: auto;
        height: 100px;
    }
</style>

<h1>Animais cadastrados:</h1>

<br/>
<br/>

<table>
    <thead>
        <tr>
            <td>Foto</td>
            <td>Id</td>
            <td>Nome</td>
            <td>Porte</td>
            <td>Tipo</td>
            <td>Idade</td>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${animals}" var="animal">
            <tr>
                <td><img src="${animal.fotoURL}" alt="${animal.nome}"></td>
                <td>${animal.id}</td>
                <td>${animal.nome}</td>
                <td>${animal.animalPorte}</td>
                <td>${animal.animalTipo}</td>
                <td>${animal.idade} anos</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<partials:footer/>