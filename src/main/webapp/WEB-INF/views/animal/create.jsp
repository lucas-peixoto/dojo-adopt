<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<h1>Cadastrar Animal:</h1>

<br/>
<br/>

<form:form modelAttribute="animalCreateDTO" method="post" action="/animal/create">

    <label>Nome:</label>
    <form:input path="nome"/>
    <form:errors path="nome" cssStyle="color: red"/>

    <br/>
    <br/>

    <label>Custo Mensal:</label>
    <form:input type="number" path="custoMensal"/>
    <form:errors path="custoMensal" cssStyle="color: red"/>

    <br/>
    <br/>

    <label>Data de nascimento:</label>
    <form:input type="date" path="dataNascimento"/>
    <form:errors path="dataNascimento" cssStyle="color: red"/>

    <br/>
    <br/>

    <label>Tipo do Animal:</label>
    <form:select path="animalTipo" items="${animalTipo}"/>
    <form:errors path="animalTipo" cssStyle="color: red"/>

    <br/>
    <br/>

    <label>Porte do Animal:</label>
    <form:select path="animalPorte" items="${animalPorte}"/>
    <form:errors path="animalPorte" cssStyle="color: red"/>

    <br/>
    <br/>

    <label>Foto do Animal (URL):</label>
    <form:input path="fotoURL"/>
    <form:errors path="fotoURL" cssStyle="color: red"/>

    <br/>
    <br/>

    <form:button>Cadastrar</form:button>

</form:form>