<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="partials" tagdir="/WEB-INF/tags/partials" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<partials:header/>

<div class="container my-5">
    <h1>Adopt - Gasto por tipo de animais:</h1>

    <ul>
        <c:forEach items="${animaisGastoPorTipo}" var="animalGastoPorTipo">
            <li>${animalGastoPorTipo.tipo} | ${animalGastoPorTipo.quantidade} | R$ ${animalGastoPorTipo.custoMedioEmReais}</li>
        </c:forEach>
    </ul>

<partials:footer/>