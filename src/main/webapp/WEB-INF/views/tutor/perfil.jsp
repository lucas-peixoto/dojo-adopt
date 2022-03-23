<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="partials" tagdir="/WEB-INF/tags/partials" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<partials:header/>

<div class="container my-5">
    <img class="img-fluid" src="${tutor.fotoURL}" alt="${tutor.nome}">
    <p>Nome: ${tutor.nome}</p>
    <p>CPF: ${tutor.cpf}</p>
    <p>Remuneração: ${tutor.remuneracao}</p>
    <p>Gasto mensal: ${tutor.gastoMensal}</p>

    <hr>

    <p>Animais adotados:</p>

    <table class="table">
        <thead>
        <tr>
            <td>Foto</td>
            <td>Id</td>
            <td>Nome</td>
            <td>Porte</td>
            <td>Tipo</td>
            <td>Idade</td>
            <td>#</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${tutor.animais}" var="animal">
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
</div>

<partials:footer/>