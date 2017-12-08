<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SUCESSO</title>
</head>
<style>
body {
	font-family: "calibri", Garamond;
}
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333333;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #111111;
}

select[multiple] {
    width: 7em;
}

.button {
	font-size: 16px;
	background-color: #333333;
    text-align: center;
    border: none;
    color: white;
    text-decoration: none;
    display: inline-block;
    cursor: pointer;
}

.button.button-large {
	padding: 12px 30px;
}

.button.button-small {
	padding: 5px 15px;
}

.button:hover, .button-small:hover {
	background-color: grey;
}

.button:active, .button-small:active {
	background-color: lightgrey;
}

.container {
	width: 70%;
	margin: auto;
}
.container table {
    margin-top: 30px;
}

.action-buttons {
	margin-left: 20px;
}

table {
	width: 100%;
	text-align: center;
}

table tr {
	background-color: #c6c3c2;
}
table tr:first-child {
	background-color: lightgrey;
}

.row {
	width: 100%;
	display: inline-block;
	margin: 10px 0 10px 0
} 

form input, textarea {
	float: right;
	margin-right:50%;
	border:1px solid black;
	border-radius: 5px;
	height: 25px;
}

form button {
	margin-top: 60px;
}
.error {
    border: 4px solid #9b001c;
}
</style>
<body>
	<div class="container">
		<h1>${tipo} ${nome}, ${mensagem}!</h1>
		<a href="${retorna}">Voltar para loja</a>
	</div>
</body>
</html>