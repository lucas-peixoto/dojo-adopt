<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="partials" tagdir="/WEB-INF/tags/partials" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<partials:header/>

<div class="container my-5">
    <h1>Adopt - Animais por tipo:</h1>

    <c:forEach items="${animaisPorTipo.keySet()}" var="tipo">
        <h3>${tipo}</h3>
        <ul>
            <c:forEach items="${animaisPorTipo.get(tipo)}" var="animal">
                <li>${animal.nome}</li>
            </c:forEach>
        </ul>
    </c:forEach>
</div>

<partials:footer/>