/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import doa.ServeurImpl;
import entities.Serveur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author khk
 */
@WebServlet(name = "ServeurServlet", urlPatterns = {"/Serveur"})
public class ServeurServlet extends HttpServlet {

    private ServeurImpl serveur_dao;

    @Override
    public void init() throws ServletException {
        serveur_dao = new ServeurImpl();
    }
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServeurServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServeurServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        if(request.getParameter("page") != null){
            
            String page = request.getParameter("page").toString();
           switch(page){
               case "liste":
                   List<Serveur> serveurs = serveur_dao.liste();
                   request.setAttribute("serveurs", serveurs);
                   request.getRequestDispatcher("serveur/liste.jsp").forward(request, response);
                   break;
               case "add":
                   request.getRequestDispatcher("serveur/add.jsp").forward(request, response);
                   break;
               default:
                   break;
           } 
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
        if(request.getParameter("valider") != null){
            String nomserv = request.getParameter("nomserv").toString();
            String adripserv = request.getParameter("adripserv").toString();
            Serveur serv = new Serveur();
            serv.setNomServ(nomserv);
            serv.setAdripServ(adripserv);
            int ok = serveur_dao.add(serv);
            request.setAttribute("message", ok);
            request.getRequestDispatcher("serveur/add.jsp").forward(request, response);
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
