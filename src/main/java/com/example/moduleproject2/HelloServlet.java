package com.example.moduleproject2;

import Model.User;
import service.UserService;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/user")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //calling for url value
        doPost(req, resp);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //response.setContentType("text/html");
        //PrintWriter printWriter = response.getWriter();

        User user = new User();
        HttpSession session = request.getSession();

        String page = request.getParameter("page");
        //for user registration
        if(page.equalsIgnoreCase("register")){

            user.setUsername(request.getParameter("username"));
            user.setEmail(request.getParameter("email"));
            user.setAddress(request.getParameter("address"));
            user.setPassword(request.getParameter("password"));


            if(new UserService().insertUser(user)){
                request.setAttribute("status","success");

            }
            else{
                request.setAttribute("status","failed");

            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/register.jsp");
            requestDispatcher.forward(request,response);


        }
        //if login form submitted
        if(page.equalsIgnoreCase("login")){


            String username=request.getParameter("username");
            String password = request.getParameter("password");

            user = new UserService().loginCheck(username,password);

            if(user != null){
                //setting session
                session.setAttribute("id",user.getId());
                session.setAttribute("username",user.getUsername());

                Cookie cookie = new Cookie("username",user.getUsername());
                response.addCookie(cookie);

                response.sendRedirect("pages/home.jsp");
            }
            else{
                request.setAttribute("message","error");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request,response);
            }
        }

        //for login page redirect
        if(page.equalsIgnoreCase("loginpage")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request,response);
        }

        //for login page redirect
        if(page.equalsIgnoreCase("registerpage")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/register.jsp");
            requestDispatcher.forward(request,response);
        }

        //for login page redirect
        if(page.equalsIgnoreCase("logout")){
            session.invalidate();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request,response);
        }

    }


}