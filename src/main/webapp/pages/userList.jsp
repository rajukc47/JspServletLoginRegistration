<%@ include file = "inc/sessCheck.jsp" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <%@ include file = "inc/top.jsp" %>

</head>
<body>
<div class="container">
    <div class="wrapper">

        <%@ include file = "inc/nav.jsp" %>

        <h1>User List</h1>
        <table border="1">
            <tr>
                <th>SN</th>
                <th>Username</th>
                <th>Email</th>
                <th>Address</th>
                <th>#</th>
            </tr>
            <tr>
                <td>1</td>
                <td>Raju</td>
                <td>raju</td>
                <td>raju</td>
                <td>Edit | Delete</td>

            </tr>
        </table>

    </div>
</div>

</body>
</html>
