<!DOCTYPE html>
<html lang="en">
<head>
  
<title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
  <spring:url value="/resources/js" var="js"/>
  <spring:url value="/resources/jquery" var="jq"/>
  <spring:url value="/resources/css" var="css"/>
  <spring:url value="/resources/images" var="img"/>

  <meta name="viewport" content="width=device-width,initial-scale=1">
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <script type="text/javascript" src="${jq}/jquery.dataTables.js"></script> 
  <link href="${css}/dataTables.bootstrap.css">

</head>
<body>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Menswear</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="adminpage">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Supplier <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Manage Supplier</a></li>

        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Product <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="${contextPath }/admin/adminprod">Manage Product</a></li>
      
    </ul>
    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Category <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="${contextPath }/admin/admincat">Manage Category</a></li>
    
    
      
      <li><a href="${contextPath}/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav>
  
