<%-- <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
        }

        .login-container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
            text-align: left; /* Align text to the left */
        }

        .login-container h1 {
            font-size: 24px;
            margin-bottom: 10px;
            color: #007bff; /* Blue color for the header */
            text-align: center;
        }

        .login-container label {
            display: block; /* Place label and input on separate lines */
            font-weight: bold; /* Make labels bold */
            margin-bottom: 5px;
        }

        .login-container input[type="text"],
        .login-container input[type="password"] {
            width: 50%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        .login-container input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        .login-container input[type="submit"]:hover {
            background-color: #0056b3; /* Darker blue on hover */
        }

        .error-message {
            color: #ff0000; /* Red color for error messages */
            margin-top: 10px;
        }
    </style>
    <script type="text/javascript">
    // Disable the back button in the browser
    history.pushState(null, null, location.href);
    window.onpopstate = function () {
        history.go(1);
    };
</script>
</head>
<body>
    <div class="login-container">
        <h1>Login</h1>
        <form action="LoginServlet" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
<br>
            <input type="submit" value="Login">
        </form>

        <!-- Error message (displayed when login fails) -->
        <div class="error-message">
            ${errorMessage} <!-- Display error message using JSP expression -->
        </div>
    </div>
</body>
</html>
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="messages" />
<!DOCTYPE html>


<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><fmt:message key="login.header" /></title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
        }

        .login-container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
            text-align: left; /* Align text to the left */
        }

        .login-container h1 {
            font-size: 24px;
            margin-bottom: 10px;
            color: #007bff; /* Blue color for the header */
            text-align: center;
        }

        .login-container label {
            display: block; /* Place label and input on separate lines */
            font-weight: bold; /* Make labels bold */
            margin-bottom: 5px;
        }

        .login-container input[type="text"],
        .login-container input[type="password"] {
            width: 50%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        .login-container input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        .login-container input[type="submit"]:hover {
            background-color: #0056b3; /* Darker blue on hover */
        }

        .error-message {
            color: #ff0000; /* Red color for error messages */
            margin-top: 10px;
        }

        .language-selection {
            margin-top: 20px;
        }

        .language-selection a {
            text-decoration: none;
            margin-right: 20px;
            font-weight: bold;
            color: #007bff;
        }
    </style>
    <script type="text/javascript">
    // Disable the back button in the browser
    history.pushState(null, null, location.href);
    window.onpopstate = function () {
        history.go(1);
    };
</script>
</head>
<body>
    <div class="login-container">
        
        <form action="LoginServlet" method="post">
        
        <h1><fmt:message key="login.header" /></h1>
            <label for="username"><fmt:message key="login.username" />:</label>
            <input type="text" id="username" name="username" required>

            <label for="password"><fmt:message key="login.password" />:</label>
            <input type="password" id="password" name="password" required>
<br>
            <input type="submit" value="<fmt:message key="login.submit" />">
        </form>

        <!-- Error message (displayed when login fails) -->
        <div class="error-message">
            ${errorMessage} <!-- Display error message using JSP expression -->
        </div>

        <!-- Language selection links -->
        <div class="language-selection">
            <a href="LoginServlet?lang=en">English</a>
            <a href="LoginServlet?lang=zh_CN">中文</a>
        </div>
    </div>
</body>
</html>

 