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

<h1>Tutores cadastrados:</h1>

<br/>
<br/>

<table>
    <thead>
        <tr>
            <td>Id</td>
            <td>Foto</td>
            <td>Nome</td>
            <td>CPF</td>
            <td>#</td>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${tutores}" var="tutor">
            <tr>
                <td>${tutor.id}</td>
                <td><img src="${tutor.fotoURL}" alt="${tutor.nome}"></td>
                <td>${tutor.nome}</td>
                <td>${tutor.cpf}</td>
                <td>
                    <a href="/tutor/perfil/${tutor.id}" class="btn btn-success">Ver perfil</a>
                    <a href="/adocao/${tutor.id}" class="btn btn-primary">Adotar animal</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<partials:footer/>