<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<div id="center">
	<h1>User Detail Page</h1>
	<h2>${userdetail.id }</h2>
	<h2>${userdetail.pwd }</h2>
	<h2>${userdetail.name }</h2>
	<h3><a href="userdelete?id=${userdetail.id }">Delete</a></h3>
	<h3><a href="userupdate?id=${userdetail.id }">Update</a></h3>
</div>