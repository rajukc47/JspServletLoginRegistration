<%
    String username = (String) session.getAttribute("username");
    if(username==null){
        response.sendRedirect("../index.jsp");
    }
%>