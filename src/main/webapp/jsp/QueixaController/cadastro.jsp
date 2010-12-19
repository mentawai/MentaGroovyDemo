<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="mtw" uri="http://www.mentaframework.org/tags-mtw/" %>    
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Groovy Integration Test</title>

<mtw:inputDateConfig/>
<link rel="stylesheet" type="text/css" href="css/displaytag.css"  />

<style type="text/css">
	body{
		margin-top: 50px;
		margin-right: 30%;
		margin-left: 30%;
	}

	.fieldError{
		color: red;
	}
	
	label{
		display: inline-block;
		padding-right: 6px;
		width: 71px;
	}

</style>

</head>
<body>

<h1> Cadastro de Queixa </h1>
<hr/> 

<!-- List all non-field errors -->
<mtw:outErrors>
	<mtw:loop>
	<h3><mtw:out /></h3>
	</mtw:loop>
</mtw:outErrors>

<!-- List all messages -->
<mtw:outMessages>
	<mtw:loop>
	<h3><mtw:out /></h3>
	</mtw:loop>
</mtw:outMessages>


	<mtw:form action="QueixaController.salvar.mtw">
		<mtw:input name="id" type="hidden" />
		  
		<label>Nome:</label> <mtw:input name="pessoa"/> 
			  <mtw:outError field="pessoa"> <span class="fieldError"><mtw:out /></span></mtw:outError> <br/>
		<label>Data:</label> <mtw:inputDate name="data"/> 
		      <mtw:outError field="data"> <span class="fieldError"><mtw:out /></span></mtw:outError> <br/>
		<label>Resumo:</label>  
		       <mtw:outError field="resumo"> <span class="fieldError"><mtw:out /></span></mtw:outError> <br/> 
		       <mtw:textarea name="resumo" cols="30" rows="10" /> 
	
		<div style="text-align: right;">
			<input type="reset" value="Limpar" />
			<input type="submit" value="Salvar" />
		</div>
	</mtw:form>
	
	
	<h2>Lista de Queixas Cadastradas</h2>
	<hr/>
	
	<display:table name="lista" id="elementoAtual" requestURI="#"  >
		<display:column property="id" /> 
		<display:column property="pessoa" />
		<display:column property="data" format="{0,date, dd/MM/yyyy}" />
		   
		<display:column title="Ações" media="html">
			<a href="QueixaController.editar.mtw?id=${elementoAtual.id}">Editar</a> ||
			<a href="QueixaController.excluir.mtw?id=${elementoAtual.id}">Excluir</a> 
		</display:column>
		
	</display:table>
	
	<br/>
	<div>
		<img alt="mentawai" src="imagens/mentawai.png" />
		<img alt="mentawai" src="imagens/groovy.png" />
	</div>

	
</body>
</html>