package pl.javastart.weekop.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        if (req.getUserPrincipal()!=null){
            resp.sendRedirect(req.getContextPath()+"/");
        } else {
            resp.sendError(403);
        }
    }
}
