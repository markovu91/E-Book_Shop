/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ProductDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marko
 */
@WebServlet(name = "DeleteCustServlet", urlPatterns = {"/DeleteCustServlet"})
public class DeleteCustServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sid=request.getParameter("id"); 
        String name=request.getParameter("name"); 
        int id=Integer.parseInt(sid);  
        ProductDao.deleteCust(id,name);  
        response.sendRedirect("CustomerList");  
    }


}
