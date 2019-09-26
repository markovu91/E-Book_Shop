/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.*;
import java.sql.*;
import java.util.logging.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author marko
 */

public class EntryServlet extends HttpServlet {

      private String databaseURL, username, password;
 
   @Override
   public void init(ServletConfig config) throws ServletException {
      // Retrieve the database-URL, username, password from webapp init parameters
      super.init(config);
      ServletContext context = config.getServletContext();
      databaseURL = context.getInitParameter("databaseURL");
      username = context.getInitParameter("username");
      password = context.getInitParameter("password");
   }
 
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
 
      Connection conn = null;
      Statement stmt = null;
      try {
         conn = DriverManager.getConnection(databaseURL, username, password);
         stmt = (Statement) conn.createStatement();
         String sqlStr = "SELECT DISTINCT author FROM books WHERE qty > 0";

         ResultSet rset = stmt.executeQuery(sqlStr);
 
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Welcome to Eshop</title>");
         out.println("<style>body {background-image: url('books.jpg')} #form, h2, #links{text-align: center; } #links{display: inline;} \n" +" </style>");
         out.println("</head>");
         out.println("<body>");
         out.println("<h2>Welcome to E-Book Shop</h2>");
         // Begin an HTML form
         out.println("<form method='get' action='search'>");
          out.println("<div id='form'>");
         // A pull-down menu of all the authors with a no-selection option
         out.println("Choose an Author: <select name='author' size='1'>");
         out.println("<option value=''>Select...</option>");  // no-selection
         while (rset.next()) {  // list all the authors
            String author = rset.getString("author");
            out.println("<option value='" + author + "'>" + author + "</option>");
         }
         out.println("</select><br />");
         out.println("<p>OR</p>");
 
         // A text field for entering search word for pattern matching
         out.println("Search \"Title\" or \"Author\": <input type='text' name='search' />");
 
         // Submit and reset buttons
         out.println("<br /><br />");
         out.println("<input type='submit' value='SEARCH' />");
         out.println("<input type='reset' value='CLEAR' />");
         out.println("</form>");
          out.println("</div>");
          out.println("<div id='links'>");
         out.println("<p><a href='ViewOrders'>View Orders</a></p>");
         out.println("<p><a href='ViewServlet'>Products</a></p>");
         out.println("<p><a href='CustomerList'>Customers</a></p>");
         out.println("<p><a href='contact.html'>Contact</a></p>");
         out.println("</div>");
        
         
         
         
         
         
         out.println("</body></html>");
      } catch (SQLException ex) {
         out.println("<h3>Service not available. Please try again later!</h3></body></html>");
         Logger.getLogger(EntryServlet.class.getName()).log(Level.SEVERE, null, ex);
      } finally {
         out.close();
         try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
         } catch (SQLException ex) {
            Logger.getLogger(EntryServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
      }
   }
 
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      doGet(request, response);

}
}
