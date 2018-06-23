<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Please Login</title>
</head>
<body>
    <c:url value="/login" var="loginUrl"/>
    <form name="f" action="${loginUrl}" method="post">
    	<input type="hidden" name="${_csrf.parameterName}" value = "${_csrf.token}">
        <fieldset>
            <legend>Please Login</legend>	
            <c:if test="${param.error != null}">
                <div class="alert alert-error">
                    Invalid username and password.
                </div>
            </c:if>
            <c:if test="${param.logout != null}">
                <div class="alert alert-success">
                    You have been logged out.
                </div>
            </c:if>
            <label for="username">Username</label>
            <input type="text" id="username" name="username" value="${username}"/>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
            <div class="form-actions">
                <button type="submit" class="btn">Login</button>
            </div>
        </fieldset>
    </form>
</body>
</html>