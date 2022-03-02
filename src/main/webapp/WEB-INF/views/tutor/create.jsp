<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<h1>Cadastrar Tutor:</h1>

<br/>
<br/>

<form:form modelAttribute="tutorCreateDTO" method="post" action="/tutor/create">

    <label>Nome:</label>
    <form:input path="nome"/>
    <form:errors path="nome" cssStyle="color: red"/>

    <br/>
    <br/>

    <label>CPF:</label>
    <form:input type="text" path="cpf"/>
    <form:errors path="cpf" cssStyle="color: red"/>

    <br/>
    <br/>

    <label>Foto (URL):</label>
    <form:input path="fotoURL"/>
    <form:errors path="fotoURL" cssStyle="color: red"/>

    <br/>
    <br/>

    <label>Data de nascimento:</label>
    <form:input type="date" path="dataNascimento"/>
    <form:errors path="dataNascimento" cssStyle="color: red"/>

    <br/>
    <br/>

    <label>Remuneração:</label>
    <form:input type="number" path="remuneracao"/>
    <form:errors path="remuneracao" cssStyle="color: red"/>

    <br/>
    <br/>

    <label>Tipo de Moradia:</label>
    <form:select path="moradia" items="${moradias}"/>
    <form:errors path="moradia" cssStyle="color: red"/>

    <br/>
    <br/>

    <form:button>Cadastrar</form:button>

</form:form>