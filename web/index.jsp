<%--suppress HtmlUnknownTarget --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ru-RU">
<head>
  <title>Task Test</title>
  <meta charset="UTF-8">
  <style>
    <%@include file='WEB-INF/files/styles.css' %>
  </style>
  <script>
    <%@include file='WEB-INF/files/main.js' %>
  </script>
</head>
<body>
<%@ include file ="WEB-INF/views/header.html" %>
<div style="display: flex">
  <nav>
    <ul>
      <li><a href="${pageContext.request.contextPath}/Contracts">Contracts</a></li>
      <li><a href="${pageContext.request.contextPath}/Users">Users</a></li>
      <li><a href="${pageContext.request.contextPath}/Tariffs">Tariffs</a></li>
    </ul>
  </nav>
  <section style="flex-grow: 1; text-align: center">
    <%@ include file="WEB-INF/views/Selector.jsp" %>
  </section>
</div>
<%@ include file="WEB-INF/views/footer.html" %>
</body>
</html>