<%@ page import="com.example.model.UserInfo" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        h1 {
            color: #333;
        }
        p {
            color: #555;
            font-size: 16px;
            margin: 10px 0;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
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
    <div class="container">
        <h1>Welcome</h1>

        <%
        // Retrieve user information from the session
        String loggedInUser = (String) session.getAttribute("loggedInUser");
        UserInfo user = (UserInfo) session.getAttribute("userObject");
        
        if (loggedInUser != null && user != null) {
        %>
        <p>Name: <%= user.getName() %></p>
        <p>Username: <%= user.getUsername() %></p>
        <p>Role: <%= user.getRole() %></p>
        <% } else { %>
        <p>You are not logged in.</p>
        <% } %>
        
        <%
        if (user.getRoleInt() == 0) {
        %>
        <p><a href="restricted.jsp">Restricted Web Page</a></p>
              <%
        }
        %>

        <!-- Add any other content you want to display on the welcome page -->

        <p><a href="Logout">Logout</a></p>
    </div>
</body>
</html>
