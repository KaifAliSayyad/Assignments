<%@ page import="com.main.User" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>

<!DOCTYPE html>
<html>
<head>
    <title>User List</title>
</head>
<body>
    <h2>List of Users</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Password</th>
            </tr>
        </thead>
        <tbody>
            <%
                // Retrieve the map of users from the request attribute
                Integer totalUsers = (Integer) request.getAttribute("totalUsers");

                // Loop through the map and display each user's information
                for (int i = 0 ; i < totalUsers ; i++) {
                    User user = (User) request.getAttribute(i+"");
            %>
                <tr>
                    <td><%= user.getId() %></td> <!-- Display User ID -->
                    <td><%= user.getName() %></td> <!-- Display User Name -->
                    <td><%= user.getPassword() %></td> <!-- Display User Password -->
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
