<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>    
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>사원 등록</title>

<!-- Bootstrap core CSS -->
<link href="/resources/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/resources/signin.css" rel="stylesheet">
</head>

<body class="text-center">
	<form class="form-signin" action="/emp/login" method="post">
		<img class="mb-4" src="/resources/bootstrap-solid.svg" alt="" width="72" height="72">
		
		<input type="text" id="id" class="form-control" placeholder="ID" required name="id">
		<input type="password" id="pwd" class="form-control" placeholder="PASSWORD" required name="pwd">
		<input type="text" id="lvl" class="form-control" placeholder="LVL" required name="lvl">
	    <input type="text" id="empno" class="form-control" placeholder="EMPNO" required name="empno">
		<input type="text" id="ename" class="form-control" placeholder="E-NAME" required name="ename">
		<input type="text" id="job" class="form-control" placeholder="JOB" required name="job">
		<input type="text" id="mgr" class="form-control" placeholder="MGR" required name="lvl">
		<input type="date" id="hiredate" class="form-control" placeholder="HIRE-DATE" required name="hiredate">
	    <input type="text" id="sal" class="form-control" placeholder="SAL" required name="sal">
	   	<input type="text" id="comm" class="form-control" placeholder="COMMISSION" required name="comm">
	   
	   	<select name="deptNO" id="deptNO">
	   	<option>부서 선택</option>
	   	<c:forEach items="${deptList}" var="d">
	   	<option value="${d.DEPTNO}">${d.DNAME}</option>
        </c:forEach>
	   	</select>
	   	
 <!--  <select>
   <option>DEPTNO</option>
      <c:forEach items="${deptList}" var="d" >
         <option value="${d.DEPTNO}">${d.DEPTNO}</option>
      </c:forEach>
   </select>
    --> 


		<button class="btn btn-lg btn-primary btn-block" type="button" id="signinBtn">사원 등록</button>
		<p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
	</form>
</body>
</html>
    