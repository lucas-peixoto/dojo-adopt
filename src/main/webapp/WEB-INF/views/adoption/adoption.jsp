<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="partials" tagdir="/WEB-INF/tags/partials" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<partials:header/>

<style>
    table img {
        width: auto;
        height: 100px;
    }
</style>

<div class="container my-5">
    <h1>Adopt - adotar Animal:</h1>

    <img class="img-fluid" src="${tutor.fotoURL}" alt="${tutor.nome}">
    <p>Nome: ${tutor.nome}</p>
    <p>CPF: ${tutor.cpf}</p>

    <hr>

    <p>Deseja adotar qual animal?</p>

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
            <c:forEach items="${animaisDisponiveis}" var="animal">
                <tr>
                    <td><img src="${animal.fotoURL}" alt="${animal.nome}"></td>
                    <td>${animal.id}</td>
                    <td>${animal.nome}</td>
                    <td>${animal.animalPorte}</td>
                    <td>${animal.animalTipo}</td>
                    <td>${animal.idade} anos</td>
                    <td>
                        <form action="/adocao/tutor/${tutor.id}/animal/${animal.id}" method="post">
                            <button class="btn btn-primary" type="button" onclick="confirm('Deseja realmente adotar esse animal?') ? this.parentElement.submit() : ''">Adotar</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<partials:footer/>