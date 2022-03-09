<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="partials" tagdir="/WEB-INF/tags/partials" %>

<partials:header/>

<div class="container my-5">
    <h1>Cadastrar Tutor:</h1>

    <br/>
    <br/>

    <form:form modelAttribute="tutorCreateDTO" method="post" action="/tutor/create">

        <label class="form-label">Nome:</label>
        <form:input cssClass="form-control" path="nome"/>
        <form:errors path="nome" cssClass="text-danger"/>

        <br/>
        <br/>

        <label class="form-label">CPF:</label>
        <form:input cssClass="form-control" type="text" path="cpf"/>
        <form:errors path="cpf" cssClass="text-danger"/>

        <br/>
        <br/>

        <label class="form-label">Foto (URL):</label>
        <form:input cssClass="form-control" path="fotoURL"/>
        <form:errors path="fotoURL" cssClass="text-danger"/>

        <br/>
        <br/>

        <label class="form-label">Data de nascimento:</label>
        <form:input cssClass="form-control" type="date" path="dataNascimento"/>
        <form:errors path="dataNascimento" cssClass="text-danger"/>

        <br/>
        <br/>

        <label class="form-label">Remuneração:</label>
        <form:input cssClass="form-control" type="number" path="remuneracao"/>
        <form:errors path="remuneracao" cssClass="text-danger"/>

        <br/>
        <br/>

        <label class="form-label">Tipo de Moradia:</label>
        <form:select cssClass="form-control" path="moradia" items="${moradias}"/>
        <form:errors path="moradia" cssClass="text-danger"/>

        <br/>
        <br/>

        <form:button class="btn btn-primary">Cadastrar</form:button>

    </form:form>
</div>

<partials:footer/>