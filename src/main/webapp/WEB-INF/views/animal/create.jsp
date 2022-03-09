<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="partials" tagdir="/WEB-INF/tags/partials" %>

<partials:header/>

<div class="container my-5">
    <h1>Cadastrar Animal:</h1>

    <form:form modelAttribute="animalCreateDTO" method="post" action="/animal/create">

        <label class="form-label">Nome:</label>
        <form:input cssClass="form-control" path="nome"/>
        <form:errors cssClass="text-danger" path="nome"/>

        <br/>
        <br/>

        <label class="form-label">Custo Mensal:</label>
        <form:input type="number" cssClass="form-control" path="custoMensal"/>
        <form:errors cssClass="text-danger" path="custoMensal"/>

        <br/>
        <br/>

        <label class="form-label">Data de nascimento:</label>
        <form:input type="date" cssClass="form-control" path="dataNascimento"/>
        <form:errors cssClass="text-danger" path="dataNascimento"/>

        <br/>
        <br/>

        <label class="form-label">Tipo do Animal:</label>
        <form:select cssClass="form-control" path="animalTipo" items="${animalTipo}"/>
        <form:errors cssClass="text-danger" path="animalTipo"/>

        <br/>
        <br/>

        <label class="form-label">Porte do Animal:</label>
        <form:select cssClass="form-control" path="animalPorte" items="${animalPorte}"/>
        <form:errors cssClass="text-danger" path="animalPorte"/>

        <br/>
        <br/>

        <label class="form-label">Foto do Animal (URL):</label>
        <form:input cssClass="form-control" path="fotoURL"/>
        <form:errors cssClass="text-danger" path="fotoURL"/>

        <br/>
        <br/>

        <form:button class="btn btn-primary">Cadastrar</form:button>

    </form:form>
</div>

<partials:footer/>