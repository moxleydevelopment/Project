package Business;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author donyamoxley
 */
@WebServlet(urlPatterns = {"/PatientLoginServletDB"})
public class PatientLoginServletDB extends HttpServlet {
    
    static final String DBPATH = "C:\\Users\\Timothy\\Desktop\\Fall 2020\\Capstone Class\\NewProj\\Project\\src\\main\\resources\\ChiropractorOfficeDB.accdb";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        String id, password;
        
        try (PrintWriter out = response.getWriter()) {
           
            id = request.getParameter("customerId"); 
            password =  request.getParameter("password");
            
            if(!"".equals(id) && !"".equals(password)){
                Patient p1 = new Patient();
                p1.selectDB(id);
                HttpSession ses1;
                if(!password.equals(p1.getPwd())){
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet LoginServlet</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Invalid Login"
                        +  p1.getPwd()  + "</h1>");
                    out.println("</body>");
                    out.println("</html>"); 
                }else{
                    
                    ses1 = request.getSession();
                    ses1.setAttribute("p1", p1);
                    RequestDispatcher rd = request.getRequestDispatcher("/patients/patient.jsp");
                    rd.forward(request, response);
                }
                
            }else{
               out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet LoginServlet</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Invalid Login Else" + "</h1>");
                out.println("</body>");
                out.println("</html>"); 
            }
           
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PatientLoginServletDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PatientLoginServletDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PatientLoginServletDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PatientLoginServletDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
